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
import style from "./LogisticianTrucks.module.css";
import FormInput from "../../../components/FormInput/FormInput";
// @ts-ignore
import inputStyle from "../../../components/FormInput/FormInput.module.css";
import Button from "../../../components/Buttons/FormButton";
// @ts-ignore
import buttonStyle from "../../../components/Buttons/FormButton.module.css";
import DayContainer from "../../../components/Containers/DayContainer/DayContainer";
import ButtonContainer from "../../../components/Containers/ButtonContainer/ButtonContainer";

function LogisticianTrucks() {

    return (
        <Page>
            <MainContainer>
                <TopBar/>
                <MidContainer>
                    <CustomContainer className={style.user}>

                    </CustomContainer>
                    <CustomContainer className={style.setRoutes}>
                        <div id={style.employee}>
                            Will Smith  will@email.com
                        </div>
                        <DayContainer day={"09.04"} text={"new route"}/>
                        <DayContainer day={"10.04"} text={"new route"}/>
                        <DayContainer day={"11.04"} text={"new route"}/>
                        <DayContainer day={"12.04"} text={"new route"}/>
                        <DayContainer day={"13.04"} text={"new route"}/>
                        <ButtonContainer className={style.button}>Add Routes</ButtonContainer>
                    </CustomContainer>
                </MidContainer>

            </MainContainer>
        </Page>
    );
}

export default LogisticianTrucks;