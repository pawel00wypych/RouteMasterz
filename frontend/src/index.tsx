import './index.css';

import React from 'react';
import ReactDOM from 'react-dom/client';
import { createBrowserRouter, RouterProvider } from 'react-router-dom';

import Login from './views/Login/Login';
import Register from "./views/Register/Register";
import LogisticianMap from "./views/Logistician/Map/LogisticianMap";
import DriverMap from "./views/Driver/Map/DriverMap";
import Account from "./views/Account/Account";
import DriverTruck from "./views/Driver/Truck/DriverTruck";
import LogisticianTrucks from "./views/Logistician/Trucks/LogisticianTrucks";


const router = createBrowserRouter([
    {
        path: '/',
        element: <Login />,
        errorElement: <div>404</div>,
    },
    {
        path: '/register',
        element: <Register />,
        errorElement: <div>404</div>,
    },
    {
        path: '/logistician/map',
        element: <LogisticianMap />,
        errorElement: <div>404</div>,
    },
    {
        path: '/driver/map',
        element: <DriverMap />,
        errorElement: <div>404</div>,
    },
    {
        path: '/account',
        element: <Account />,
        errorElement: <div>404</div>,
    },
    {
        path: '/driver/truck',
        element: <DriverTruck />,
        errorElement: <div>404</div>,
    },
    {
        path: '/logistician/trucks',
        element: <LogisticianTrucks />,
        errorElement: <div>404</div>,
    },
]);

let root = ReactDOM.createRoot(document.getElementById('root') as HTMLElement);

root.render(
    <React.StrictMode>
        <RouterProvider router={router} />
    </React.StrictMode>,
);

