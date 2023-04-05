
import Page from '../../components/Page/Page';
import FormContainer from "../../components/Containers/FormContainer/FormContainer";
// @ts-ignore
import logo from '../../resources/img/logo.svg';
// @ts-ignore
import signIn from '../../resources/img/signIn.svg';

// @ts-ignore
import pageStyle from '../../components/Page/Page.module.css';

import Input from '../../components/FormInput/FormInput';
import Button from "../../components/Buttons/FormButton/FormButton";
import ButtonContainer from "../../components/Containers/FormContainer/ButtonContainer/ButtonContainer";
import TitleContainer from "../../components/Containers/FormContainer/TitleContainer/TitleContainer";
// @ts-ignore
import style from './Login.module.css';
import {Link} from "react-router-dom";
function Login() {

    return (
        <Page>
            <img src={logo} className={pageStyle.logo} alt={'RouteMasterz'}/>

            <FormContainer>
                <TitleContainer>
                    Login
                </TitleContainer>
                <Input text="email@example.com" />
                <Input text="password" />
                <div id={style.emptyDiv}></div>

                <ButtonContainer>
                    <Button  src={signIn} iconHeight={"60px"} iconWidth={"60px"}/>
                    <Link to='/register'>
                        <Button text="Register" />
                    </Link>
                </ButtonContainer>
            </FormContainer>
        </Page>
    );
}

export default Login;