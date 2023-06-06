import Page from "../../../components/Page/Page";
import MainContainer from "../../../components/Containers/MainContainer/MainContainer";
import TopBar from "../../../components/TopBar/TopBar";
import MidContainer from "../../../components/Containers/MidContainer/MidContainer";
// @ts-ignore
import accountStyle from "../../Account/Account.module.css";
// @ts-ignore
import logo from "../../../resources/img/logo.svg";
import CustomContainer from "../../../components/Containers/CustomContainer/CustomContainer";
// @ts-ignore
import style from "./Staff.module.css";
import RouteContainer from "../../../components/Containers/RouteContainer/RouteContainer";
import {useEffect, useState} from "react";
const logisticianRoutesUrl = `${process.env.REACT_APP_BACKEND_URL}/app/logistician/showRoutes`;


function Staff() {
    const [routes, setRoutes] = useState([]);

    useEffect(() => {

        const fetchRoutes = async () => {
            const body = {
                token: sessionStorage.getItem("userToken"),
            };
            const requestOptions = {
                method: 'POST',
                headers: {
                    'Authorization': "Bearer " + sessionStorage.getItem("userToken"),
                    'Content-Type': 'application/json',
                    'Access-Control-Allow-Origin': '*',
                    'Access-Control-Allow-Credentials': 'true'
                },
                body: JSON.stringify(body),
            };

            try {
                const resp = await fetch(logisticianRoutesUrl, requestOptions)
                    .then((response) => response.json())
                    .then((data) => {
                        console.log("data: " + data);
                        setRoutes(data);
                    });
            } catch (err) {
                console.log("show all routes error: " + err);
            }
        }

        fetchRoutes();
    }, []);

    return (
        <Page>
            <MainContainer>
                <TopBar/>
                <MidContainer>
                    <CustomContainer className={style.routes}>
                        <RouteContainer routes={routes}></RouteContainer>
                    </CustomContainer>
                    <CustomContainer className={style.user} width={"50em"}>


                    </CustomContainer>
                </MidContainer>
            </MainContainer>
        </Page>
    );
}

export default Staff;