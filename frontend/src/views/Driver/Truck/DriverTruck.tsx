
import CustomContainer from "../../../components/Containers/CustomContainer/CustomContainer";
import Button from "../../../components/Buttons/FormButton";

// @ts-ignore
import cityMap from "../../../resources/img/cityMap.svg";
// @ts-ignore
import accountStyle from "../../Account/Account.module.css";
// @ts-ignore
import style from "./DriverTruck.module.css";
import FormInput from "../../../components/FormInput/FormInput";
// @ts-ignore
import inputStyle from '../../../components/FormInput/FormInput.module.css';
// @ts-ignore
import buttonStyle from "../../../components/Buttons/FormButton.module.css"

// @ts-ignore
import save from "../../../resources/img/save.svg";
// @ts-ignore
import add from "../../../resources/img/plus.svg";
import MainContainer from "../../../components/Containers/MainContainer/MainContainer";
import TopBar from "../../../components/TopBar/TopBar";
import MidContainer from "../../../components/Containers/MidContainer/MidContainer";
import Page from "../../../components/Page/Page";
// @ts-ignore
import logo from "../../../resources/img/logo.svg";

function DriverTruck() {

    return (
        <Page>
            <MainContainer>
                <TopBar/>
                <MidContainer>
                    <div id={accountStyle.emptyDiv}>
                        <img src={logo} className={accountStyle.logo} alt={''}/>
                    </div>
                    <CustomContainer className={style.user}>
                        <CustomContainer className={style.leftContainer}>
                            <div className={style.textDiv}>Truck Name</div>
                            <div className={style.textDiv}>Payload Capacity [tons]</div>
                            <div className={style.textDiv}>Engine</div>
                            <div className={style.textDiv}>Fuel Tank [liters]</div>
                            <div className={style.textDiv}>Fuel Usage [liters/100km]</div>
                        </CustomContainer>
                        <CustomContainer className={style.rightContainer}>
                            <FormInput className={inputStyle.truckInput} text={"new name"}/>
                            <FormInput className={inputStyle.truckInput} text={"20"}/>
                            <FormInput className={inputStyle.truckInput} text={"engine"}/>
                            <FormInput className={inputStyle.truckInput} text={"480"}/>
                            <FormInput className={inputStyle.truckInput} text={"35"}/>
                            <Button className={buttonStyle.accountButton} text={"Save"}/>
                        </CustomContainer>
                    </CustomContainer>
                </MidContainer>
            </MainContainer>
        </Page>
    );
}

export default DriverTruck;
