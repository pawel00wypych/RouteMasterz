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
import style from "./WorkInfo.module.css";
import WorkerContainer from "../../../components/Containers/WorkerContainer/WorkerContainer";
import RouteContainer from "../../../components/Containers/RouteContainer/RouteContainer";


function WorkInfo() {

    return (
        <Page>
            <MainContainer>
                <TopBar/>
                <MidContainer>
                    <div id={accountStyle.emptyDiv}>
                        <img src={logo} className={accountStyle.logo} alt={''}/>
                    </div>
                    <CustomContainer className={style.user}>
                        <WorkerContainer workerInfo={" Will Smith\n will@email.com"}
                                         residence={"Warsaw"}
                                         truckInfo={"MAN TGS 18.460"}/>
                        <RouteContainer></RouteContainer>
                    </CustomContainer>
                </MidContainer>
            </MainContainer>
        </Page>
    );
}

export default WorkInfo;