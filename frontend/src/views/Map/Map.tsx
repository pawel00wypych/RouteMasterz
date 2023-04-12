import Page from '../../components/Page/Page';
import TopBar from "../../components/TopBar/TopBar";
import MainContainer from "../../components/Containers/MainContainer/MainContainer";
import MidContainer from "../../components/Containers/MidContainer/MidContainer";
import CustomContainer from "../../components/Containers/CustomContainer/CustomContainer";

// @ts-ignore
import cityMap from "../../resources/img/cityMap.svg";
// @ts-ignore
import style from "./Map.module.css";

import {Component, HTMLAttributes} from "react";

interface MapProps {
    title?: string;
    background?: boolean;
    contentClassName?: string;
    children?: HTMLAttributes<HTMLDivElement>['children'];
}
export default class Map extends Component<MapProps> {
    private static defaultProps: MapProps = {
        title: '',
        background: false,
        contentClassName: '',
    };
    render()
    {
        return (
            <Page>
                <MainContainer>
                    <TopBar/>
                    <MidContainer>
                        <CustomContainer className={style.mapBox}>
                            <img className={style.mapSrc} src={cityMap} alt={""}/>
                        </CustomContainer>
                        <CustomContainer className={style.mapRightPulpit}>
                        </CustomContainer>
                    </MidContainer>
                </MainContainer>
            </Page>
        );
    }
}