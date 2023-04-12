import {Component, HTMLAttributes} from 'react';

// @ts-ignore
import style from './TopBarContainer.module.css'

export interface TopBarContainerProps extends HTMLAttributes<HTMLDivElement> {
    shadows?: boolean,
    width?: string,
    height?: string,
    className?: string;
}

class TopBarContainer extends Component<TopBarContainerProps> {

    private static defaultProps: TopBarContainerProps = {
        shadows: true,
    };
    render() {
        return (
            <div className={style.topBarContainer}
                 style={{ width: this.props.width, height: this.props.height }}>
                {this.props.children}
            </div>
        );
    }
}

export default TopBarContainer;