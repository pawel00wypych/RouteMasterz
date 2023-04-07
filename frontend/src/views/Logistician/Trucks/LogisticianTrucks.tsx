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

function LogisticianTrucks() {

    return (
        <Page>
            <MainContainer>
                <TopBar/>
                <MidContainer>
                    <CustomContainer className={style.user}>
                        <CustomContainer className={style.leftContainer}>
                        </CustomContainer>
                        <CustomContainer className={style.rightContainer}>
                        </CustomContainer>
                    </CustomContainer>
                    <CustomContainer className={style.setRoutes}>

                    </CustomContainer>
                </MidContainer>

            </MainContainer>
        </Page>
    );
}

export default LogisticianTrucks;