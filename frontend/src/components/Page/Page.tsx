// @ts-ignore
import style from './Page.module.css';
import {Component, HTMLAttributes} from "react";

interface PageProps {
    title?: string;
    background?: boolean;
    contentClassName?: string;
    children?: HTMLAttributes<HTMLDivElement>['children'];
}

export default class Page extends Component<PageProps> {
    private static defaultProps: PageProps = {
        title: '',
        background: false,
        contentClassName: '',
    };

    render() {
        return (
            <div className={style.app}>
                {this.props.children}
            </div>

        );
    }
}