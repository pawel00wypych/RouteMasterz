// @ts-ignore
import style from './Page.module.css';
import {Component, HTMLAttributes} from "react";

interface PageProps {
    title?: string;
    sidebar?: boolean;
    topbar?: boolean;
    titlebar?: boolean;
    user?: boolean;
    content?: boolean;
    background?: boolean;
    contentClassName?: string;
    children?: HTMLAttributes<HTMLDivElement>['children'];
}

export default class Page extends Component<PageProps> {
    private static defaultProps: PageProps = {
        title: '',
        sidebar: true,
        topbar: true,
        titlebar: true,
        user: true,
        content: true,
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