
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
import {Link} from "react-router-dom";
// @ts-ignore
import inputStyle from '../../components/FormInput/FormInput.module.css';
function Login() {

    return (
        <Page>
            <img src={logo} className={pageStyle.logo} alt={'RouteMasterz'}/>

            <FormContainer>
                <TitleContainer>
                    Login
                </TitleContainer>
                <Input className={inputStyle.input} text="email@example.com" />
                <Input className={inputStyle.input} text="password" />
                <div id={style.emptyDiv}></div>

                <ButtonContainer>
                    <Button className={buttonStyle.formButton}  src={signIn} iconHeight={"60px"} iconWidth={"60px"}/>
                    <Link to='/register'>
                        <Button className={buttonStyle.formButton} text="Register" />
                    </Link>
                </ButtonContainer>
            </FormContainer>
        </Page>
    );
}

export default Login;