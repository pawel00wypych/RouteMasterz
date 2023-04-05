import {Component, HTMLAttributes} from 'react';

// @ts-ignore
import style from './ButtonConainer.module.css'

export interface ButtonContainerProps extends HTMLAttributes<HTMLDivElement> {
    shadows?: boolean,
    width?: string,
    height?: string,
    className?: string;
}

export default class ButtonContainer extends Component<ButtonContainerProps> {

    private static defaultProps: ButtonContainerProps = {
        shadows: true,
    };
    render() {
        return (
            <div className={style.buttonContainer}
                 style={{ width: this.props.width, height: this.props.height }}>
                {this.props.children}
            </div>
        );
    }
}