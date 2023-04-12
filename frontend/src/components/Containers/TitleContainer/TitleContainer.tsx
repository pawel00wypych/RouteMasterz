import {Component, HTMLAttributes} from 'react';

// @ts-ignore
import style from './TitleContainer.module.css'

export interface TitleContainerProps extends HTMLAttributes<HTMLDivElement> {
    shadows?: boolean,
    width?: string,
    height?: string,
    className?: string;
}

export default class TitleContainer extends Component<TitleContainerProps> {

    private static defaultProps: TitleContainerProps = {
        shadows: true,
    };
    render() {
        return (
            <div className={style.titleContainer}
                 style={{ width: this.props.width, height: this.props.height }}>
                {this.props.children}
            </div>
        );
    }
}