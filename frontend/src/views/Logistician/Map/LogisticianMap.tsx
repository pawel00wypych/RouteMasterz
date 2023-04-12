
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

function LogisticianMap() {

    return (
        <Page>
            <MainContainer>
                <TopBar/>
                <MidContainer>
                    <CustomContainer className={style.mapBox}>
                        <img className={style.mapSrc} src={cityMap} alt={""}/>
                    </CustomContainer>
                    <CustomContainer className={style.mapRightPulpit}>
                        <FormInput className={inputStyle.mapSearch} text={"plac Defilad 1, 00-901 Warszawa"}></FormInput>
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
                                iconWidth={"60px"}/>
                    </CustomContainer>
                </MidContainer>
            </MainContainer>
        </Page>
    );
}

export default LogisticianMap;
