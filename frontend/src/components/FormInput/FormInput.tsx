import {ChangeEvent, Component, createRef, RefObject} from 'react';

// @ts-ignore
import style from './FormInput.module.css';


export interface FormInputProps {
    text?: string;
    width?: string;
    height?: string;
    onClick?: () => void;
    className?: string;
    id?: string;
    useRef?: RefObject<HTMLInputElement>;
    value?: string;
    onChange?: (e: ChangeEvent<HTMLInputElement>) => void;

}
export interface InputState {
    message: string;
}

export default class FormInput extends Component<FormInputProps, InputState> {
    private inputRef!: RefObject<HTMLInputElement>;

    constructor(props: FormInputProps) {
        super(props);

        this.state = {
            message: '',
        };

        if (this.props.useRef === undefined) this.inputRef = createRef();
        else this.inputRef = this.props.useRef;
    };

    render() {
        return (
            <input height={this.props.height}
                   width={this.props.width}
                   ref={this.props.useRef}
                   placeholder={this.props.text}
                   className={this.props.className}
                   onClick={this.props.onClick}
                   type='text' id={this.props.id}
                   onChange={this.props.onChange}/>
        );
    }
}