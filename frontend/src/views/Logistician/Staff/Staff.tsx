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
import WorkerContainer from "../../../components/Containers/WorkerContainer/WorkerContainer";
import RouteContainer from "../../../components/Containers/RouteContainer/RouteContainer";


function Staff() {

    return (
        <Page>
            <MainContainer>
                <TopBar/>
                <MidContainer>
                    <CustomContainer className={style.routes}>

                    </CustomContainer>
                    <CustomContainer className={style.user}>

                        <RouteContainer></RouteContainer>
                    </CustomContainer>
                </MidContainer>
            </MainContainer>
        </Page>
    );
}

export default Staff;