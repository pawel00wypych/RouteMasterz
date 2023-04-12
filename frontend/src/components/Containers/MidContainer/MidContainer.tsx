import {Component, HTMLAttributes} from 'react';

// @ts-ignore
import style from './MidContainer.module.css'

export interface MidContainerContainerProps extends HTMLAttributes<HTMLDivElement> {
    shadows?: boolean,
    width?: string,
    height?: string,
    className?: string;
}

class MidContainer extends Component<MidContainerContainerProps> {

    private static defaultProps: MidContainerContainerProps = {
        shadows: true,
    };
    render() {
        return (
            <div className={style.midContainer}
                 style={{ width: this.props.width, height: this.props.height }}>
                {this.props.children}
            </div>
        );
    }
}

export default MidContainer;