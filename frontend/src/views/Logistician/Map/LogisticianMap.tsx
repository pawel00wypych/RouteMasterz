
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
import Map from "../../Map/Map";
import MainContainer from "../../../components/Containers/MainContainer/MainContainer";
import TopBar from "../../../components/TopBar/TopBar";
import MidContainer from "../../../components/Containers/MidContainer/MidContainer";
import Page from "../../../components/Page/Page";
// @ts-ignore
import { geosearch } from 'leaflet-geosearch';
import { useEffect, useState } from "react";

function LogisticianMap() {
    const [coords, setCorrds] = useState({
        latitude: 39.7837304,
        longitude: -100.4458825
    });

    const [display_name, setName] = useState("");

    const [address, setAddress] = useState<{ [key: string]: string }>({
        country: '',
        street: '',
        city: '',
        state: '',
        postalcode: '',
    });

    function error() {
        alert('Sorry, no position available.');
    }
    const options = {
        enableHighAccuracy: true,
        maximumAge: 30000,
        timeout: 27000
    };

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

    function submitHandler(e: React.MouseEvent<HTMLButtonElement, MouseEvent>) {

        e.preventDefault();
        console.log(address);

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
                }

            ).catch((error) => {
            alert("Error in your input; unable to find the position");
        });
    }


    return (
        <Page>
            <MainContainer>
                <TopBar/>
                <MidContainer>
                    <Map coords={coords} display_name={display_name}/>
                    <CustomContainer className={style.mapRightPulpit}>
                        <FormInput className={inputStyle.mapSearch}
                                   text={"Country"}
                                   value={address.country}
                                   onChange={update("country")}></FormInput>
                        <FormInput className={inputStyle.mapSearch}
                                   text={"Street"}
                                   value={address.street}
                                   onChange={update("street")}></FormInput>
                        <FormInput className={inputStyle.mapSearch}
                                       text={"City"}
                                       value={address.city}
                                       onChange={update("city")}></FormInput>
                        <FormInput className={inputStyle.mapSearch}
                                       text={"Zip Code"}
                                       value={address.postalcode}
                                       onChange={update("postalcode")}></FormInput>

                        <CustomContainer className={style.addedPoints}>
                            <CustomContainer className={style.addPoint}>
                                <FormInput className={inputStyle.chooseHour} text={"14:30"}></FormInput>
                                <Button className={buttonStyle.addPoint}
                                        src={add}
                                        iconHeight={"40px"}
                                        iconWidth={"40px"}/>
                            </CustomContainer>
                        </CustomContainer>
                        <FormInput className={inputStyle.mapSearch} text={"route name"}></FormInput>
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
