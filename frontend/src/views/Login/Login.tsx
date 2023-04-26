
import Page from '../../components/Page/Page';
import FormContainer from "../../components/Containers/FormContainer/FormContainer";
// @ts-ignore
import logo from '../../resources/img/logo.svg';
// @ts-ignore
import signIn from '../../resources/img/signIn.svg';

// @ts-ignore
import pageStyle from '../../components/Page/Page.module.css';

import Input from '../../components/FormInput/FormInput';
import Button from "../../components/Buttons/FormButton";
import ButtonContainer from "../../components/Containers/ButtonContainer/ButtonContainer";
import TitleContainer from "../../components/Containers/TitleContainer/TitleContainer";
// @ts-ignore
import buttonStyle from "../../components/Buttons/FormButton.module.css"
// @ts-ignore
import style from './Login.module.css';
import { login as apiLogin } from '../../auth';
import { Link, useNavigate } from 'react-router-dom';
import { useRef } from 'react';
// @ts-ignore
import inputStyle from '../../components/FormInput/FormInput.module.css';

function Login() {
    const email = useRef<HTMLInputElement>(null);
    const password = useRef<HTMLInputElement>(null);

    const navigate = useNavigate();

    async function sendLoginRequest() {
        if (!password.current?.value || !email.current?.value)
            return;
        else {
            const resp = await apiLogin(email.current?.value, password.current?.value, navigate);
            if (resp !== undefined) alert(`Error: ${resp}`);
        }
    }

        return (
            <Page>
                <img src={logo} className={pageStyle.logo} alt={'RouteMasterz'}/>

                <FormContainer>
                    <TitleContainer>
                        Login
                    </TitleContainer>
                    <Input useRef={email} className={inputStyle.input} text="email@example.com"/>
                    <Input useRef={password} className={inputStyle.input} text="password"/>
                    <div id={style.emptyDiv}></div>

                    <ButtonContainer>
                        <Button className={buttonStyle.formButton} onClick={sendLoginRequest} src={signIn}
                                iconHeight={"60px"} iconWidth={"60px"}/>
                        <Link to='/register'>
                            <Button className={buttonStyle.formButton} text="Register"/>
                        </Link>
                    </ButtonContainer>
                </FormContainer>
            </Page>
        );

}

export default Login;