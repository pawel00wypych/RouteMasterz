// @ts-ignore
import {Component, HTMLAttributes} from "react";
import { Link, NavLink } from 'react-router-dom';
import TopBarContainer from "../Containers/TopBarContainer/TopBarContainer";
// @ts-ignore
import topBarContainerStyle from "../Containers/TopBarContainer/TopBarContainer.module.css";
import Button from "../Buttons/FormButton";
// @ts-ignore
import buttonStyle from "../Buttons/FormButton.module.css";
// @ts-ignore
import style from "./TopBar.module.css";
// @ts-ignore
import pin from "../../resources/img/pin.svg";
// @ts-ignore
import list from "../../resources/img/list.svg";
// @ts-ignore
import truck from "../../resources/img/truck.svg";
// @ts-ignore
import user from "../../resources/img/human.svg";
// @ts-ignore
import logout from "../../resources/img/logout.svg";


export interface TopBarProps {
    className?: string;
}

export interface TopBarState {
    active: boolean;
}

interface PageProps {
    title?: string;
    background?: boolean;
    contentClassName?: string;
    children?: HTMLAttributes<HTMLDivElement>['children'];
}

export default class TopBar extends Component<TopBarProps, TopBarState> {
    private static defaultProps: PageProps = {
        title: '',
        background: false,
        contentClassName: '',
    };

    render() {
        return (
            <TopBarContainer className={topBarContainerStyle}>
                <NavLink to='/'>
                    <Button className={buttonStyle.topBarButton}
                            src={pin}
                            iconHeight={"60px"}
                            iconWidth={"60px"}/>
                </NavLink>
                <NavLink to='/'>
                    <Button className={buttonStyle.topBarButton}
                            src={list}
                            iconHeight={"60px"}
                            iconWidth={"60px"}/>
                </NavLink>
                <NavLink to='/'>
                    <Button className={buttonStyle.topBarButton}
                            src={truck}
                            iconHeight={"60px"}
                            iconWidth={"60px"}/>
                </NavLink>
                <div id={style.emptyDiv}/>
                <NavLink to='/'>
                    <Button className={buttonStyle.topBarButton}
                            src={user}
                            iconHeight={"60px"}
                            iconWidth={"60px"}/>
                </NavLink>
                <NavLink to='/'>
                    <Button className={buttonStyle.topBarButton}
                            src={logout}
                            iconHeight={"60px"}
                            iconWidth={"60px"}/>
                </NavLink>
            </TopBarContainer>

        );
    }
}