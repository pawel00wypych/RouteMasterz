import Page from "../../components/Page/Page";
import MainContainer from "../../components/Containers/MainContainer/MainContainer";
import TopBar from "../../components/TopBar/TopBar";
import MidContainer from "../../components/Containers/MidContainer/MidContainer";
// @ts-ignore
import accountStyle from "../Account/Account.module.css";
// @ts-ignore
import logo from "../../resources/img/logo.svg";

import CustomContainer from "../../components/Containers/CustomContainer/CustomContainer";
// @ts-ignore
import style from "./Admin.module.css";
import WorkerContainer from "../../components/Containers/WorkerContainer/WorkerContainer";
import React, { useState, useEffect } from "react";
const fetchAdminUsersUrl = `${process.env.REACT_APP_BACKEND_URL}/app/admin/showAllUsers`;

function Admin() {

    const [users, setUsers] = useState([]);

    useEffect(() => {

        const fetchUsers = async () => {

            const requestOptions = {
                method: 'GET',
                headers: {
                    'Authorization': "Bearer " + sessionStorage.getItem("userToken"),
                    'Content-Type': 'application/json',
                    'Access-Control-Allow-Origin': '*',
                    'Access-Control-Allow-Credentials': 'true'
                },
            };

            try {
                const resp = await fetch(fetchAdminUsersUrl, requestOptions)
                    .then((response) => response.json())
                    .then((data) => {
                        console.log("data: " + data);
                        setUsers(data);
                    });
            } catch (err) {
                console.log("show all non admin users error " + err);
            }
        }

        fetchUsers();
    }, []);


    return (
        <Page>
            <MainContainer>
                <TopBar/>
                <MidContainer>
                    <div id={accountStyle.emptyDiv}>
                        <img src={logo} className={accountStyle.logo} alt={''}/>
                    </div>
                    <CustomContainer className={style.user}>
                        <WorkerContainer users={users}></WorkerContainer>
                    </CustomContainer>
                </MidContainer>
            </MainContainer>
        </Page>
    );
}

export default Admin;