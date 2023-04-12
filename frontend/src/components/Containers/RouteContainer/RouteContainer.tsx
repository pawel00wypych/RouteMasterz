import {Component, HTMLAttributes} from 'react';

// @ts-ignore
import style from './RouteContainer.module.css'
// @ts-ignore
import truck from "../../../resources/img/truck.svg";
// @ts-ignore
import house from "../../../resources/img/house.svg";
// @ts-ignore
import worker from "../../../resources/img/worker.svg";

export interface RouteContainerProps extends HTMLAttributes<HTMLDivElement> {
    shadows?: boolean,
    workerInfo?: string,
    residence?: string,
    truckInfo?: string,
    width?: string,
    height?: string,
    className?: string;
}

class RouteContainer extends Component<RouteContainerProps> {

    private static defaultProps: RouteContainerProps = {
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

export default RouteContainer;