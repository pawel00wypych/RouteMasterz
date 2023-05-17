
import CustomContainer from "../../../components/Containers/CustomContainer/CustomContainer";
import Button from "../../../components/Buttons/FormButton";

// @ts-ignore
import cityMap from "../../../resources/img/cityMap.svg";
// @ts-ignore
import style from "../../Map/Map.module.css";
import FormInput from "../../../components/FormInput/FormInput";
// @ts-ignore
import inputStyle from '../../../components/FormInput/FormInput.module.css';
// @ts-ignore
import buttonStyle from "../../../components/Buttons/FormButton.module.css"

// @ts-ignore
import save from "../../../resources/img/save.svg";
// @ts-ignore
import add from "../../../resources/img/plus.svg";
// @ts-ignore
import del from "../../../resources/img/delete.svg";
import Map from "../../Map/Map";
import MainContainer from "../../../components/Containers/MainContainer/MainContainer";
import TopBar from "../../../components/TopBar/TopBar";
import MidContainer from "../../../components/Containers/MidContainer/MidContainer";
import Page from "../../../components/Page/Page";
// @ts-ignore
import { geosearch } from 'leaflet-geosearch';
import { useEffect, useState} from "react";
import {useLinkedList} from "../../../components/LinkedList";

function LogisticianMap() {

    const [coords, setCorrds] = useState({
        latitude: 39.7837304,
        longitude: -100.4458825
    });

    //used to reload chosen component
    const [seed, setSeed] = useState(1);
    const reset = () => {
        setSeed(Math.random());
    }

    const [routeName, setRouteName] = useState("");

    const [display_name, setName] = useState("");

    const [lastAdded, setLastAdded] = useState<{ [key: string]: string }>({
        country: '',
        street: '',
        city: '',
        state: '',
        postalcode: '',
        hour: '',
    });

    const [address, setAddress] = useState<{ [key: string]: string }>({
        country: '',
        street: '',
        city: '',
        state: '',
        postalcode: '',
        hour: '',
    });
    const [checkpoints, setCheckpoints] = useState<{ [key: string]: string }[]>([]);

    const {insert, remove, toArray} = useLinkedList<typeof address>();


    function error() {
        alert('Sorry, no position available.');
    }
    const options = {
        enableHighAccuracy: true,
        maximumAge: 30000,
        timeout: 27000
    };

    const handleDataReceived = (lat: number, lng: number) => {
        console.log("lat: " + lat);
        console.log("lng: " + lng);
        setCorrds({
            latitude: lat,
            longitude: lng
        });

        getAddressFromCoordinates(lat, lng, setAddress);
    };

    function getAddressFromCoordinates(latitude: number, longitude: number, setAddress: React.Dispatch<React.SetStateAction<{ [key: string]: string }>>) {
        const url = `https://nominatim.openstreetmap.org/reverse?format=jsonv2&lat=${latitude}&lon=${longitude}`;

        fetch(url)
            .then((response) => {
                if (response.ok) {
                    return response.json();
                }
                throw new Error('Something went wrong');
            })
            .then((data) => {
                setName(data.display_name);
                const {country, road, city, state, postcode} = data.address;
                setAddress({
                    country: country || '',
                    street: road || '',
                    city: city || '',
                    state: state || '',
                    postalcode: postcode || '',
                    hour: '',
                });
            })
            .catch((error) => {
                console.error('Error:', error);
            });
    }

    function getCurrentCityName( position: geosearch.Position){
        setCorrds({
            latitude: position.coords.latitude,
            longitude: position.coords.longitude
        });


        let url="https://nominatim.openstreetmap.org/reverse?format=jsonv2"+
            "&lat="+coords.latitude+"&lon="+coords.longitude;

        fetch(url, {
            method: "GET",
            mode: 'cors',
            headers: {
                "Access-Control-Allow-Origin": "https://o2cj2q.csb.app"
            }
        })
            .then((response) => response.json())
            .then((data) => setName( data.display_name));
    }

    useEffect(() => {
        navigator.geolocation.getCurrentPosition(

            getCurrentCityName,
            error,
            options

        );
    }, []);


    //separete the entred string
    function update(field: string) {
        return (e: React.ChangeEvent<HTMLInputElement>) => {
            const value = e.currentTarget.value;
            setAddress((address) => ({ ...address, [field]: value }));
        };
    }

    function updateName() {
        return (e: React.ChangeEvent<HTMLInputElement>) => {
            const value = e.currentTarget.value;
            setRouteName(value);
        };
    }

    function removeLastCheckpoint(e: React.MouseEvent<HTMLButtonElement, MouseEvent>) {
        console.log("remove");
        e.preventDefault();
        remove(lastAdded);
        const checkpoints = toArray();
        setCheckpoints(checkpoints);
        setLastAdded(checkpoints[checkpoints.length - 1]);
        reset();
    }

    function addCheckpoint(e: React.MouseEvent<HTMLButtonElement, MouseEvent>) {
        e.preventDefault();
        let url = `https://nominatim.openstreetmap.org/search?
                    street=${address.street}
                    &city=${address.city}
                    &state=${address.state}
                    &country=${address.country}
                    &postalcode=${address.postalcode}&format=json`;

        fetch(url, {
            method: "POST",
            mode: "cors",
            headers: {
                "Access-Control-Allow-Origin": "https://o2cj2q.csb.app"
            }
        })
            .then((response ) => {
                if( response.ok){
                    return response.json();
                }
                throw new Error('Something went wrong');
            })
            .then(
                (data) => {
                    setName(data[0].display_name);
                    setCorrds({
                        latitude: data[0].lat,
                        longitude: data[0].lon
                    });
                    insert(address);
                    const checkpoints = toArray();
                    console.log(checkpoints);
                    setCheckpoints(checkpoints);
                    setLastAdded(address);
                }

            ).catch((error) => {
            alert("Error in your input; unable to find the position");
            return;
        });


        setAddress({
            country: '',
            street: '',
            city: '',
            state: '',
            postalcode: '',
            hour: ''
        });
        reset();
    }

    function submitHandler(e: React.MouseEvent<HTMLButtonElement, MouseEvent>) {
        e.preventDefault();

        const data = {
            checkpoints: toArray(),
            routeName: routeName,
        };

        console.log(data);
        const jsonData = JSON.stringify(data);
        console.log(jsonData);

        const headers = {
            'Content-Type': 'application/json',
        };

        fetch('/your-api-endpoint', {
            method: 'POST',
            headers: headers,
            body: jsonData,
        })
            .then((response) => {
                if (response.ok) {
                    setCheckpoints([]);
                    setRouteName('');
                    setAddress({
                        country: '',
                        street: '',
                        city: '',
                        state: '',
                        postalcode: '',
                        hour: ''
                    });
                    reset();
                } else {
                    throw new Error('save route error ' + error.valueOf());
                }
            })
            .catch((error) => {
                throw new Error(error.valueOf());
            });

    }

    return (
        <Page>
            <MainContainer>
                <TopBar/>
                <MidContainer>
                    <Map coords={coords}
                         display_name={display_name}
                         onDataReceived={handleDataReceived}/>
                    <CustomContainer key={seed} className={style.mapRightPulpit}>
                        <FormInput className={inputStyle.mapSearch}
                                   text={address.country ? address.country :"Country"}
                                   value={address.country}
                                   onChange={update("country")}></FormInput>
                        <FormInput className={inputStyle.mapSearch}
                                   text={address.street ? address.street :"Street"}
                                   value={address.street}
                                   onChange={update("street")}></FormInput>
                        <FormInput className={inputStyle.mapSearch}
                                   text={address.state ? address.state :"State"}
                                   value={address.state}
                                   onChange={update("state")}></FormInput>
                        <FormInput className={inputStyle.mapSearch}
                                       text={address.city ? address.city :"City"}
                                       value={address.city}
                                       onChange={update("city")}></FormInput>
                        <FormInput className={inputStyle.mapSearch}
                                       text={address.postalcode ? address.postalcode :"Zip Code"}
                                       value={address.postalcode}
                                       onChange={update("postalcode")}></FormInput>
                        <CustomContainer className={style.addedPoints}>
                            <CustomContainer className={style.addPoint}>
                                <FormInput className={inputStyle.chooseHour}
                                           text={address.hour ? address.hour :"14:30"}
                                           value={address.hour}
                                           onChange={update("hour")}></FormInput>
                                <Button className={buttonStyle.addPoint}
                                        src={add}
                                        iconHeight={"40px"}
                                        iconWidth={"40px"}
                                        onClick={(e) => addCheckpoint(e)}/>
                                <Button className={buttonStyle.addPoint}
                                        src={del}
                                        iconHeight={"40px"}
                                        iconWidth={"40px"}
                                        onClick={(e) => removeLastCheckpoint(e)}/>
                            </CustomContainer>
                            <div className={style.addedCheckpoints}>
                                <ul>
                                    {toArray().map((checkpoint, index) => (
                                        <li key={index}>
                                            Country: {checkpoint.country}, Street: {checkpoint.street}, City: {checkpoint.city}, State: {checkpoint.state}, Postal Code: {checkpoint.postalcode}, Hour: {checkpoint.hour}
                                        </li>
                                    ))}
                                </ul>
                            </div>
                        </CustomContainer>
                        <FormInput className={inputStyle.mapSearch}
                                   text={routeName? routeName:"route name"}
                                   value={routeName}
                                   onChange={updateName()} ></FormInput>
                        <Button className={buttonStyle.saveRouteButton}
                                src={save}
                                iconHeight={"60px"}
                                iconWidth={"60px"}
                                onClick={(e) => submitHandler(e)}/>
                    </CustomContainer>
                </MidContainer>
            </MainContainer>
        </Page>
    );
}

export default LogisticianMap;
