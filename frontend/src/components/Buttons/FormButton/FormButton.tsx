import { Component } from 'react';

// @ts-ignore
import style from './FormButton.module.css';


export interface InputProps {
    text: string;
    width?: string;
    onClick?: () => void;
    className?: string;
    id?: string;
}

export default class Button extends Component<InputProps> {
    render() {
        return (
            <button className={[style.formButton].join(' ')} onClick={this.props.onClick} id={this.props.id}>
                {this.props.text}
            </button>
        );
    }
}