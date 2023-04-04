
import Page from '../../components/Page/Page';
import FormContainer from "../../components/Containers/FormContainer/FormContainer";
// @ts-ignore
import logo from '../../resources/img/logo.svg';
// @ts-ignore
import pageStyle from '../../components/Page/Page.module.css';

import Input from '../../components/FormInput/FormInput';
import Button from "../../components/Buttons/FormButton/FormButton";
import ButtonContainer from "../../components/Containers/FormContainer/ButtonContainer/ButtonContainer";
import TitleContainer from "../../components/Containers/FormContainer/TitleContainer/TitleContainer";
function Login() {

    return (
        <Page>
            <img src={logo} className={pageStyle.logo} alt={'RouteMasterz'}/>

            <FormContainer width={'40vw'} height={'90vh'}>
                <TitleContainer>
                    Login
                </TitleContainer>
                <Input text="email@example.com" />
                <Input text="password" />
                <ButtonContainer>
                    <Button text="Login" />
                    <Button text="Register" />
                </ButtonContainer>
            </FormContainer>
        </Page>
    );
}

export default Login;