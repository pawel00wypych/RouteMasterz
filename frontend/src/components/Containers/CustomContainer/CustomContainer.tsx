import {Component, HTMLAttributes} from 'react';

export interface FormContainerProps extends HTMLAttributes<HTMLDivElement> {
    shadows?: boolean,
    width?: string,
    height?: string,
    className?: string;
}

class CustomContainer extends Component<FormContainerProps> {

    private static defaultProps: FormContainerProps = {
        shadows: true,
    };
    render() {
        return (
            <div className={this.props.className}
                 style={{ width: this.props.width, height: this.props.height }}>
                {this.props.children}
            </div>
        );
    }
}

export default CustomContainer;