import {Component, HTMLAttributes} from 'react';

// @ts-ignore
import style from "./Icon.module.css";


export interface ButtonContainerProps extends HTMLAttributes<HTMLDivElement> {
    src?: string
    shadows?: boolean,
    width?: string,
    height?: string,
    className?: string;
}

export default class Icon extends Component<ButtonContainerProps> {

    private static defaultProps: ButtonContainerProps = {
        shadows: false,
    };
    render() {
        return (
            <img className={style.icon} src={this.props.src} width={this.props.width} height={this.props.height} alt={''} />
        );
    }
}