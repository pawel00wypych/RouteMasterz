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
import WorkInfo from "./views/Driver/WorkInfo/WorkInfo";
import Staff from "./views/Logistician/Staff/Staff";
import Admin from "./views/Admin/Admin";
import RestrictedRoute from "./components/RestrictedRoute/RestrictedRoute";
import { isLoggedIn, isAdmin, isLogistician, isDriver } from './auth';

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
        element: <RestrictedRoute
            condition={isLogistician}
            component={<LogisticianMap/>}
            invalidComponent={<Login/>}
        />,
        errorElement: <div>404</div>,
    },
    {
        path: '/driver/map',
        element:
            <RestrictedRoute
                condition={isDriver}
                component={<DriverMap/>}
                invalidComponent={<Login/>}
            />,
        errorElement: <div>404</div>,
    },
    {
        path: '/account',
        element:
            <RestrictedRoute
                condition={isLoggedIn}
                component={<Account/>}
                invalidComponent={<Login/>}
            />,
        errorElement: <div>404</div>,
    },
    {
        path: '/driver/trucks',
        element:
            <RestrictedRoute
                condition={isDriver}
                component={<DriverTruck/>}
                invalidComponent={<Login/>}
            />,
        errorElement: <div>404</div>,
    },
    {
        path: '/driver/staff',
        element:
            <RestrictedRoute
                condition={isDriver}
                component={<WorkInfo />}
                invalidComponent={<Login/>}
            />,
        errorElement: <div>404</div>,
    },
    {
        path: '/logistician/trucks',
        element:
            <RestrictedRoute
                condition={isLogistician}
                component={<LogisticianTrucks/>}
                invalidComponent={<Login/>}
            />,
        errorElement: <div>404</div>,
    },
    {
        path: '/logistician/staff',
        element:
            <RestrictedRoute
                condition={isLogistician}
                component={<Staff />}
                invalidComponent={<Login/>}
            />,
        errorElement: <div>404</div>,
    },
    {
        path: '/admin',
        element:
            <RestrictedRoute
                condition={isAdmin}
                component={<Admin />}
                invalidComponent={<Login/>}
            />,
        errorElement: <div>404</div>,
    },
]);

let root = ReactDOM.createRoot(document.getElementById('root') as HTMLElement);

root.render(
    <React.StrictMode>
        <RouterProvider router={router} />
    </React.StrictMode>,
);

