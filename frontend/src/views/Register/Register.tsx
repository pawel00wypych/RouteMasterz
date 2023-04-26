import Page from '../../components/Page/Page';
import FormContainer from "../../components/Containers/FormContainer/FormContainer";
// @ts-ignore
import logo from '../../resources/img/logo.svg';
// @ts-ignore
import signUp from '../../resources/img/signUp.svg';
// @ts-ignore
import pageStyle from '../../components/Page/Page.module.css';

import Input from '../../components/FormInput/FormInput';
import Button from "../../components/Buttons/FormButton";
import ButtonContainer from "../../components/Containers/ButtonContainer/ButtonContainer";
import TitleContainer from "../../components/Containers/TitleContainer/TitleContainer";
import { Link, useNavigate } from 'react-router-dom';
import { useRef, useState } from 'react';
// @ts-ignore
import buttonStyle from "../../components/Buttons/FormButton.module.css";
// @ts-ignore
import inputStyle from '../../components/FormInput/FormInput.module.css';


const fetchUrl = `${process.env.REACT_APP_BACKEND_URL}/auth/register`;

function Register() {

    const navigate = useNavigate();
    const name = useRef<HTMLInputElement>(null);
    const residence = useRef<HTMLInputElement>(null);
    const surname = useRef<HTMLInputElement>(null);
    const email = useRef<HTMLInputElement>(null);
    const password = useRef<HTMLInputElement>(null);
    const passwordConfirmation = useRef<HTMLInputElement>(null);

    async function sendRegisterRequest() {

        const body = {
            email: email.current?.value,
            password: password.current?.value,
            passwordConfirmation: passwordConfirmation.current?.value,
            name: name.current?.value,
            surname: surname.current?.value,
            residence: residence.current?.value,
        };

        const requestOptions = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Access-Control-Allow-Origin': '*',
                'Access-Control-Allow-Credentials': 'true'
            },
            body: JSON.stringify(body),

        };

        try {
            const response = await fetch(fetchUrl, requestOptions);
            if (!response.ok) throw response;

            navigate('/');
            alert('Registration successful! Please log in to continue.');
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
            <img src={logo} className={pageStyle.logo} alt={'RouteMasterz'}/>

            <FormContainer>
                <TitleContainer>
                    Register
                </TitleContainer>
                <Input useRef={email} className={inputStyle.input} text="email@example.com" />
                <Input useRef={password} className={inputStyle.input} text="password" />
                <Input useRef={passwordConfirmation} className={inputStyle.input} text="password confirmation" />
                <Input useRef={name} className={inputStyle.input} text="name" />
                <Input useRef={surname} className={inputStyle.input} text="surname" />
                <Input useRef={residence} className={inputStyle.input} text="residence" />
                <ButtonContainer>
                    <Button className={buttonStyle.formButton} onClick={sendRegisterRequest} src={signUp} iconHeight={"110px"} iconWidth={"110px"}/>
                    <Link to='/'>
                        <Button className={buttonStyle.formButton} text="Login" />
                    </Link>
                </ButtonContainer>
            </FormContainer>
        </Page>
    );
}

export default Register;