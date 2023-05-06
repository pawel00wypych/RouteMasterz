import Page from '../../components/Page/Page';
import TopBar from "../../components/TopBar/TopBar";
import MainContainer from "../../components/Containers/MainContainer/MainContainer";
import MidContainer from "../../components/Containers/MidContainer/MidContainer";
import CustomContainer from "../../components/Containers/CustomContainer/CustomContainer";
// @ts-ignore
import icon from "../../resources/img/pin.svg";

// @ts-ignore
import cityMap from "../../resources/img/cityMap.svg";
// @ts-ignore
import style from "./Map.module.css";

import {Component, HTMLAttributes} from "react";
// @ts-ignore
import { MapContainer, TileLayer, Marker, Popup, useMap } from "react-leaflet";
import React from "react";
import "leaflet/dist/leaflet.css";
// @ts-ignore
import L from "leaflet";

interface MapProps {
    coords?: {};
    display_name?: string;
    children?: HTMLAttributes<HTMLDivElement>['children'];
}

export default function Map({coords, display_name }: MapProps) {

    // @ts-ignore
    let longitude = coords.longitude;
    // @ts-ignore
    let latitude = coords.latitude;

    console.log(latitude);
    console.log(longitude);

    const customIcon = new L.Icon({
        iconUrl: icon,
        iconSize: [25, 35],
        iconAnchor: [5, 30]
    });

    function MapView() {
        let map = useMap();
        map.setView([latitude, longitude], map.getZoom());

        return null;
    }

        return (
                        <MapContainer
                            className={style.mapBox}
                            center={[latitude, longitude]}
                            zoom={5}
                            scrollWheelZoom={true}>
                            <TileLayer
                                attribution='&copy; <a href="http://osm.org/copyright">OpenStreetMap</a>
                                contributors'
                                url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
                            />
                            <Marker position={[latitude, longitude]}>
                                <Popup>{display_name}</Popup>
                            </Marker>
                            <MapView />
                        </MapContainer>
        );
}