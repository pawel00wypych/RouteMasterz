import './index.css';

import React from 'react';
import ReactDOM from 'react-dom/client';
import { createBrowserRouter, RouterProvider } from 'react-router-dom';

import Login from './views/Login/Login';

const router = createBrowserRouter([
    {
        path: '/',
        element: <Login />,
        errorElement: <div>404</div>,
    },
]);

let root = ReactDOM.createRoot(document.getElementById('root') as HTMLElement);

root.render(
    <React.StrictMode>
        <RouterProvider router={router} />
    </React.StrictMode>,
);

