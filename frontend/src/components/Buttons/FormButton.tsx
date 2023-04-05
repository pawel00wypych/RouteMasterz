import { Component } from 'react';

// @ts-ignore
import style from './FormButton.module.css';
import Icon from "../Icons/Icon";
export interface InputProps {
    src?: string;
    text?: string;
    width?: string;
    height?: string;
    iconHeight?: string;
    iconWidth?: string;
    onClick?: () => void;
    className?: string;
    id?: string;
}

export default class Button extends Component<InputProps> {


    private static defaultProps: InputProps = {
        src: ""
    };
    render() {
        return (
            <button className={[this.props.className].join(' ')} onClick={this.props.onClick} id={this.props.id}>
                <Icon src={this.props.src} width={this.props.iconWidth} height={this.props.iconHeight}/>
                {this.props.text}
            </button>

        );
    }
}