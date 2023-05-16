// @ts-ignore
import icon from "../../resources/img/pin-red.svg";

// @ts-ignore
import cityMap from "../../resources/img/cityMap.svg";
// @ts-ignore
import style from "./Map.module.css";

import {Component, HTMLAttributes} from "react";
// @ts-ignore
import { MapContainer, TileLayer, Marker, Popup, useMap, useMapEvents } from "react-leaflet";
import React from "react";
import "leaflet/dist/leaflet.css";
// @ts-ignore
import L from "leaflet";

interface MapProps {
    coords?: {
        latitude: number;
        longitude: number;
    };
    display_name?: string;
    children?: HTMLAttributes<HTMLDivElement>['children'];
    onDataReceived: (lat: number, lng: number) => void;
}

export default function Map({coords, display_name, onDataReceived}: MapProps) {

    // @ts-ignore
    let longitude = coords.longitude;
    // @ts-ignore
    let latitude = coords.latitude;



    const customIcon = new L.Icon({
        iconUrl: icon,
        iconSize: [35, 40],
        iconAnchor: [5, 30]
    });

    function MapView() {
        let map = useMap();
        map.setView([latitude, longitude], map.getZoom());

        return null;
    }

    function GetCoordinates() {
        const map = useMapEvents({
            click: (e) => {
                latitude = e.latlng.lat;
                longitude = e.latlng.lng;
                console.log(latitude);
                console.log(longitude);
                onDataReceived(latitude, longitude);
            }
        });

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
                            <GetCoordinates />
                            <Marker icon={customIcon} position={[latitude, longitude]}>
                                <Popup>{display_name}</Popup>
                            </Marker>
                            <MapView />

                        </MapContainer>
        );
}