import {Component, HTMLAttributes} from 'react';

// @ts-ignore
import style from './WorkerContainer.module.css'
import Icon from "../../Icons/Icon";
// @ts-ignore
import truck from "../../../resources/img/truck.svg";
// @ts-ignore
import house from "../../../resources/img/house.svg";
// @ts-ignore
import worker from "../../../resources/img/worker.svg";

export interface WorkerContainerProps extends HTMLAttributes<HTMLDivElement> {
    shadows?: boolean,
    workerInfo?: string,
    residence?: string,
    truckInfo?: string,
    width?: string,
    height?: string,
    className?: string;
}

class WorkerContainer extends Component<WorkerContainerProps> {

    private static defaultProps: WorkerContainerProps = {
        shadows: true,
    };
    render() {
        return (
            <div className={style.mainContainer}
                 style={{ width: this.props.width, height: this.props.height }}>
                {this.props.children}
                <div className={style.subContainer}>
                    <div className={style.icon}>
                        <img src={worker}/>
                    </div>
                    {this.props.workerInfo}
                </div>
                <div className={style.subContainer}>
                    <div className={style.icon}>
                        <img src={house}/>
                    </div>
                    {this.props.residence}
                </div>
                <div className={style.subContainer}>
                    <div className={style.icon}>
                        <img src={truck}/>
                    </div>
                    {this.props.truckInfo}
                </div>
            </div>
        );
    }
}

export default WorkerContainer;