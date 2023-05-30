
import CustomContainer from "../../components/Containers/CustomContainer/CustomContainer";
import Button from "../../components/Buttons/FormButton";

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
import {Role} from "../../auth";
import {useEffect,useState, useRef} from "react";

const savePasswordUrl = `${process.env.REACT_APP_BACKEND_URL}/app/account/setNewPassword`;
const savePhoneUrl = `${process.env.REACT_APP_BACKEND_URL}/app/account/setNewPhone`;
const getUserDetailsUrl = `${process.env.REACT_APP_BACKEND_URL}/app/account/getUserDetails`;
const getUserUrl = `${process.env.REACT_APP_BACKEND_URL}/app/user`;

interface UserDetails {
    name: string;
    surname: string;
    residence: string;
    company: string;
    phoneNumber: number;
    profilePhotoSource: string;
    createdAt: string;
}

interface User {
    email: string;
    role: Role;
    createdAt: string;
}

function Account() {

    const [userDetails, setUserDetails] = useState<UserDetails | null>(null);
    const [user, setUser] = useState<User | null>(null);

    useEffect(() => {

        const body = {
            token: sessionStorage.getItem("userToken"),
        };

        const requestOptions = {
            method: 'POST',
            headers: {
                'Authorization': "Bearer " + sessionStorage.getItem("userToken"),
                'Content-Type': 'application/json',
                'Access-Control-Allow-Origin': '*',
                'Access-Control-Allow-Credentials': 'true'
            },
            body: JSON.stringify(body),
        };

        async function fetchUserDetails() {

            try {
                const response = await fetch(getUserDetailsUrl, requestOptions);
                if (!response.ok) throw response;

                const data = await response.json();
                console.log("fetchUserDetails: "+data);
                setUserDetails(data);
            } catch (err) {
                if (err instanceof Response) {
                    const message = await err.text();
                    if (err.headers.get('Content-Type')?.includes('text/plain')) {
                        alert(`Error: ${message}`);
                    } else {
                        alert('Error: Connection error. Please try again later.');
                    }
                }
            }
        }

        async function fetchUser() {

            try {
                const response = await fetch(getUserUrl, requestOptions);
                if (!response.ok) throw response;

                const data = await response.json();
                console.log("fetchUser: "+data);
                setUser(data);
            } catch (err) {
                if (err instanceof Response) {
                    const message = await err.text();
                    if (err.headers.get('Content-Type')?.includes('text/plain')) {
                        alert(`Error: ${message}`);
                    } else {
                        alert('Error: Connection error. Please try again later.');
                    }
                }
            }
        }

        fetchUserDetails();
        fetchUser();
    }, []);

    const oldPassword = useRef<HTMLInputElement>(null);
    const newPassword = useRef<HTMLInputElement>(null);
    const passwordConfirmation = useRef<HTMLInputElement>(null);
    const phoneNumber = useRef<HTMLInputElement>(null);

    async function setPhoneRequest() {

        const body = {
            token: sessionStorage.getItem("userToken"),
            phoneNumber: phoneNumber.current?.value
        };

        const requestOptions = {
            method: 'POST',
            headers: {
                'Authorization': "Bearer " + sessionStorage.getItem("userToken"),
                'Content-Type': 'application/json',
                'Access-Control-Allow-Origin': '*',
                'Access-Control-Allow-Credentials': 'true'
            },
            body: JSON.stringify(body),
        };

        try {
            const response = await fetch(savePhoneUrl, requestOptions);
            if (!response.ok) throw response;

            alert('Phone number changed successfully.');
        } catch (err) {
            if (err instanceof Response) {
                const message = await err.text();
                if (err.headers.get('Content-Type')?.includes('text/plain')) {
                    alert(`Error: ${message}`);
                } else {
                    alert('Error: Connection error. Please try again later.');
                }
            }
        }
    };

    async function setPasswordRequest() {

        const body = {
            token: sessionStorage.getItem("userToken"),
            oldPassword: oldPassword.current?.value,
            newPassword: newPassword.current?.value,
            confirmPassword: passwordConfirmation.current?.value,
        };

        const requestOptions = {
            method: 'POST',
            headers: {
                'Authorization': "Bearer " + sessionStorage.getItem("userToken"),
                'Content-Type': 'application/json',
                'Access-Control-Allow-Origin': '*',
                'Access-Control-Allow-Credentials': 'true'
            },
            body: JSON.stringify(body),
        };

        try {
            const response = await fetch(savePasswordUrl, requestOptions);
            if (!response.ok) throw response;

            alert('Password changed successfully.');
        } catch (err) {
            if (err instanceof Response) {
                const message = await err.text();
                if (err.headers.get('Content-Type')?.includes('text/plain')) {
                    alert(`Error: ${message}`);
                } else {
                    alert('Error: Connection error. Please try again later.');
                }
            }
        }
    };

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
                                <div className={style.userInfoText}>{userDetails?.name} {" "} {userDetails?.surname}</div>
                                <div className={style.userInfoText}>{"Company: "} {userDetails?.company}</div>
                                <div className={style.userInfoText}>{user?.email}</div>
                                <div className={style.userInfoText}> {userDetails?.phoneNumber}</div>
                                <div className={style.userInfoText}>{userDetails?.residence}</div>
                            </CustomContainer>
                        </CustomContainer>
                        <CustomContainer className={style.bottomContainer}>
                            <CustomContainer className={style.inputContainer}>
                                <FormInput useRef={phoneNumber} className={inputStyle.input} text={"111222333"}/>
                                <FormInput useRef={oldPassword} className={inputStyle.input} text={"old password"}/>
                                <FormInput useRef={newPassword} className={inputStyle.input} text={"new password"}/>
                                <FormInput useRef={passwordConfirmation} className={inputStyle.input} text={"confirm new password"}/>
                            </CustomContainer>
                            <CustomContainer className={style.buttonContainer}>
                                <Button className={buttonStyle.accountButton}
                                        onClick={setPhoneRequest}
                                        text={"Set Phone"}/>
                                <div  id={style.emptyButtonDiv}/>
                                <Button className={buttonStyle.accountButton}
                                        onClick={setPasswordRequest}
                                        text={"Set Password"}/>
                            </CustomContainer>
                        </CustomContainer>
                    </CustomContainer>
                </MidContainer>
            </MainContainer>
        </Page>
    );
}

export default Account;
