
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
import {Link} from "react-router-dom";
// @ts-ignore
import buttonStyle from "../../components/Buttons/FormButton.module.css";
// @ts-ignore
import inputStyle from '../../components/FormInput/FormInput.module.css';

function Register() {

    return (
        <Page>
            <img src={logo} className={pageStyle.logo} alt={'RouteMasterz'}/>

            <FormContainer>
                <TitleContainer>
                    Register
                </TitleContainer>
                <Input className={inputStyle.input} text="email@example.com" />
                <Input className={inputStyle.input} text="password" />
                <Input className={inputStyle.input} text="password confirmation" />
                <Input className={inputStyle.input} text="full name" />
                <ButtonContainer>
                    <Button className={buttonStyle.formButton} src={signUp} iconHeight={"110px"} iconWidth={"110px"}/>
                    <Link to='/'>
                        <Button className={buttonStyle.formButton} text="Login" />
                    </Link>
                </ButtonContainer>
            </FormContainer>
        </Page>
    );
}

export default Register;