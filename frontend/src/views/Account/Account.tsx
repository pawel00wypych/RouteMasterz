
import CustomContainer from "../../components/Containers/CustomContainer/CustomContainer";
import Button from "../../components/Buttons/FormButton";

// @ts-ignore
import cityMap from "../../resources/img/cityMap.svg";
import FormInput from "../../components/FormInput/FormInput";
// @ts-ignore
import inputStyle from '../../components/FormInput/FormInput.module.css';
// @ts-ignore
import buttonStyle from "../../components/Buttons/FormButton.module.css"

// @ts-ignore
import save from "../../resources/img/save.svg";
// @ts-ignore
import add from "../../resources/img/plus.svg";
import MainContainer from "../../components/Containers/MainContainer/MainContainer";
import TopBar from "../../components/TopBar/TopBar";
import MidContainer from "../../components/Containers/MidContainer/MidContainer";
import Page from "../../components/Page/Page";
// @ts-ignore
import style from "./Account.module.css";
// @ts-ignore
import logo from "../../resources/img/logo.svg";
// @ts-ignore
import face from "../../resources/img/face.svg";


// @ts-ignore
import pageStyle from "../../components/Page/Page.module.css";
function DriverMap() {

    return (
        <Page>
            <MainContainer>
                <TopBar/>
                <MidContainer>
                    <div id={style.emptyDiv}>
                        <img src={logo} className={style.logo} alt={''}/>
                    </div>
                    <CustomContainer className={style.user}>
                        <CustomContainer className={style.userContainer}>
                            <img src={face} className={style.photo} alt={''}/>
                            <CustomContainer className={style.userInfo}>
                                John Doe
                            </CustomContainer>
                        </CustomContainer>
                        <CustomContainer className={style.bottomContainer}>
                            <CustomContainer className={style.inputContainer}>
                                <FormInput className={inputStyle.input} text={"111222333"}/>
                                <FormInput className={inputStyle.input} text={"password"}/>
                                <FormInput className={inputStyle.input} text={"confirm password"}/>
                            </CustomContainer>
                            <CustomContainer className={style.buttonContainer}>
                                <Button className={buttonStyle.accountButton} text={"Set Phone"}/>
                                <div  id={style.emptyButtonDiv}/>
                                <Button className={buttonStyle.accountButton} text={"Set Password"}/>
                            </CustomContainer>
                        </CustomContainer>
                    </CustomContainer>
                </MidContainer>
            </MainContainer>
        </Page>
    );
}

export default DriverMap;
