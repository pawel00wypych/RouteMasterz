import {Component, HTMLAttributes} from 'react';

// @ts-ignore
import style from './MainContainer.module.css'

export interface MainContainerProps extends HTMLAttributes<HTMLDivElement> {
    shadows?: boolean,
    width?: string,
    height?: string,
    className?: string;
}

class MainContainer extends Component<MainContainerProps> {

    private static defaultProps: MainContainerProps = {
        shadows: true,
    };
    render() {
        return (
            <div className={style.mainContainer}
                 style={{ width: this.props.width, height: this.props.height }}>
                {this.props.children}
            </div>
        );
    }
}

export default MainContainer;