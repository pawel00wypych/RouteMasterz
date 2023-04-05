
import Page from '../../components/Page/Page';
import FormContainer from "../../components/Containers/FormContainer/FormContainer";
// @ts-ignore
import logo from '../../resources/img/logo.svg';
// @ts-ignore
import signUp from '../../resources/img/signUp.svg';
// @ts-ignore
import pageStyle from '../../components/Page/Page.module.css';

import Input from '../../components/FormInput/FormInput';
import Button from "../../components/Buttons/FormButton/FormButton";
import ButtonContainer from "../../components/Containers/FormContainer/ButtonContainer/ButtonContainer";
import TitleContainer from "../../components/Containers/FormContainer/TitleContainer/TitleContainer";
import {Link} from "react-router-dom";
function Register() {

    return (
        <Page>
            <img src={logo} className={pageStyle.logo} alt={'RouteMasterz'}/>

            <FormContainer>
                <TitleContainer>
                    Register
                </TitleContainer>
                <Input text="email@example.com" />
                <Input text="password" />
                <Input text="password confirmation" />
                <Input text="full name" />
                <ButtonContainer>
                    <Button src={signUp} iconHeight={"110px"} iconWidth={"110px"}/>
                    <Link to='/'>
                        <Button text="Login" />
                    </Link>
                </ButtonContainer>
            </FormContainer>
        </Page>
    );
}

export default Register;