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
import logoutIcon from "../../resources/img/logout.svg";
import { logout, getUserstate, Role} from "../../auth";

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

function createURL(role: Role | undefined, dest: string): string {
    console.log("role: "+role);
    console.log("dest: "+dest);
    console.log("userstate: "+getUserstate());

    switch (role) {
        case Role.ADMIN:
            return "/admin";
        case Role.DRIVER:
            return "/driver/"+dest;
        case Role.LOGISTICIAN:
            return "/logistician/"+dest;
        default:
            return "/";
    }

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
                    <Button className={buttonStyle.topBarButton}
                                src={pin}
                                iconHeight={"60px"}
                                iconWidth={"60px"}
                                onClick={() => { window.location.replace(createURL(getUserstate()?.role, "map"))}}
                               />
                    <Button className={buttonStyle.topBarButton}
                                src={list}
                                iconHeight={"60px"}
                                iconWidth={"60px"}
                                onClick={() => { window.location.replace(createURL(getUserstate()?.role, "staff"))}}
                            />
                    <Button className={buttonStyle.topBarButton}
                            src={truck}
                            iconHeight={"60px"}
                            iconWidth={"60px"}
                            onClick={() => { window.location.replace(createURL(getUserstate()?.role, "trucks"))}}
                            />
                    <div id={style.emptyDiv}/>
                    <NavLink to='/account'>
                        <Button className={buttonStyle.topBarButton}
                                src={user}
                                iconHeight={"60px"}
                                iconWidth={"60px"}/>
                    </NavLink>
                    <NavLink to='/'>
                        <Button className={buttonStyle.topBarButton}
                                src={logoutIcon}
                                iconHeight={"60px"}
                                iconWidth={"60px"}
                                onClick={logout}/>
                    </NavLink>
                </TopBarContainer>

            );
        }
    }