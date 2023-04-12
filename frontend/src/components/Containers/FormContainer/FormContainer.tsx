import {Component, HTMLAttributes} from 'react';

// @ts-ignore
import style from './FormContainer.module.css'

export interface FormContainerProps extends HTMLAttributes<HTMLDivElement> {
    shadows?: boolean,
    width?: string,
    height?: string,
    className?: string;
}

class FormContainer extends Component<FormContainerProps> {

    private static defaultProps: FormContainerProps = {
        shadows: true,
    };
    render() {
        return (
            <div className={style.formContainer}
                 style={{ width: this.props.width, height: this.props.height }}>
                {this.props.children}
            </div>
        );
    }
}

export default FormContainer;