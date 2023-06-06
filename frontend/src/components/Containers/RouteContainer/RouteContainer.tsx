import React, {Component, HTMLAttributes} from 'react';

// @ts-ignore
import style from './RouteContainer.module.css'
// @ts-ignore
import truck from "../../../resources/img/truck.svg";
// @ts-ignore
import house from "../../../resources/img/house.svg";
// @ts-ignore
import routeIcon from "../../../resources/img/route.svg";
// @ts-ignore
import pinIcon from "../../../resources/img/whitePin.svg";

// @ts-ignore
import buttonStyle from "../../Buttons/FormButton.module.css";

interface Checkpoint {
    id: number;
    country: string;
    street: string;
    city: string;
    state: string;
    postalcode: string;
    hour: string;
}

interface Route {
    id: number;
    name: string;
    checkpoints: Checkpoint[];
}

interface CustomContainerProps {
    routes: Route[];
}

function RouteContainer({ routes }: CustomContainerProps) {


    return (
        <div className={style.mainContainer}>
            {routes.map((route) => (
                <div
                     key={route.id}>
                    <div className={style.routeIcon}>
                        <img src={routeIcon} alt="route icon" />
                    </div>
                    {route.name}
                    {route.checkpoints.map((checkpoint) => (
                    <div key={checkpoint.id}>
                        <div className={style.routeIcon}>
                            <img src={pinIcon} alt="pin icon" />
                        </div>
                        <div className={style.basic}>
                        {checkpoint.country} {checkpoint.street} {checkpoint.city} {checkpoint.state} {checkpoint.postalcode}
                        </div>
                        <div>
                            {checkpoint.hour}
                        </div>
                    </div>

                    ))}
                </div>
            ))}

        </div>
    );

}

export default RouteContainer;