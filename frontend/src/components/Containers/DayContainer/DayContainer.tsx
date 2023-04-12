import {Component, HTMLAttributes} from 'react';

// @ts-ignore
import style from './DayContainer.module.css'
import CustomContainer from "../CustomContainer/CustomContainer";

export interface DayContainerProps extends HTMLAttributes<HTMLDivElement> {
    shadows?: boolean,
    text?: string,
    day?: string,
    width?: string,
    height?: string,
    className?: string;
}

class DayContainer extends Component<DayContainerProps> {

    private static defaultProps: DayContainerProps = {
        shadows: true,
    };
    render() {
        return (
            <CustomContainer className={style.setDayContainer}>
                <CustomContainer className={style.day}>
                    {this.props.day}
                </CustomContainer>
                <CustomContainer className={style.route}>
                    {this.props.text}
                </CustomContainer>
            </CustomContainer>
        );
    }
}

export default DayContainer;