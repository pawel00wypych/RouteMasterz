import React, {useState, useRef} from "react";
// @ts-ignore
import style from './WorkerContainer.module.css'
// @ts-ignore
import truck from "../../../resources/img/truck.svg";
// @ts-ignore
import house from "../../../resources/img/house.svg";
// @ts-ignore
import worker from "../../../resources/img/worker.svg";
// @ts-ignore
import buttonStyle from "../../Buttons/FormButton.module.css";
import Button from "../../Buttons/FormButton";
// @ts-ignore
import inputStyle from "../../FormInput/FormInput.module.css";
import FormInput from "../../FormInput/FormInput";

const setRoleUrl = `${process.env.REACT_APP_BACKEND_URL}/app/admin/changeUserRole`;
const setCompanyUrl = `${process.env.REACT_APP_BACKEND_URL}/app/admin/changeUserCompany`;

interface User {
    userEntityId: number;
    name: string;
    surname: string;
    email: string;
    phoneNumber: number;
    role: string;
}

interface CustomContainerProps {
    users: User[];
}

function WorkerContainer({ users }: CustomContainerProps) {
    const [selectedUserId, setSelectedUserId] = useState<number | null>(null);

    const handleUserSelection = (userId: number) => {
        {console.log("handleUserSelection: "+userId);}
        setSelectedUserId(userId);
    };

    const newCompany = useRef<HTMLInputElement>(null);
    const newRole = useRef<HTMLInputElement>(null);

    async function setRoleRequest() {

        console.log("setRoleRequest selectedUserId: "+selectedUserId);

        const body = {
            userId: selectedUserId,
            newRole: newRole.current?.value,
        };

        console.log("setRoleRequest body: "+body);

        const requestOptions = {
            method: 'POST',
            headers: {
                'Authorization': "Bearer " + sessionStorage.getItem("userToken"),
                'Content-Type': 'application/json',
                'Access-Control-Allow-Origin': '*',
                'Access-Control-Allow-Credentials': 'true'
            },
            body: JSON.stringify(body),
        };

        try {
            const response = await fetch(setRoleUrl, requestOptions);
            if (!response.ok) throw response;

        } catch (err) {
            if (err instanceof Response) {
                const message = await err.text();
                if (err.headers.get('Content-Type')?.includes('text/plain')) {
                    alert(`Error: ${message}`);
                } else {
                    alert('Error: Connection error. Please try again later.');
                }
            }
        }
    };

    async function setCompanyRequest() {

        console.log("setCompanyRequest selectedUserId: "+selectedUserId);

        const body = {
            userId: selectedUserId,
            company: newCompany.current?.value,
        };
        console.log("setCompanyRequest body: "+body);

        const requestOptions = {
            method: 'POST',
            headers: {
                'Authorization': "Bearer " + sessionStorage.getItem("userToken"),
                'Content-Type': 'application/json',
                'Access-Control-Allow-Origin': '*',
                'Access-Control-Allow-Credentials': 'true'
            },
            body: JSON.stringify(body),
        };

        try {
            const response = await fetch(setCompanyUrl, requestOptions);
            if (!response.ok) throw response;

        } catch (err) {
            if (err instanceof Response) {
                const message = await err.text();
                if (err.headers.get('Content-Type')?.includes('text/plain')) {
                    alert(`Error: ${message}`);
                } else {
                    alert('Error: Connection error. Please try again later.');
                }
            }
        }
    };

    return (
        <div className={style.mainContainer}>
                {users.map((user) => (
                    <div className={style.subContainer}
                         key={user.userEntityId}
                         onClick={() => handleUserSelection(user.userEntityId)}>
                        <div className={style.icon}>
                            <img src={worker} alt="Worker Icon" />
                        </div>
                        <div>
                            {user.name} {user.surname} {user.userEntityId} {user.email} {user.phoneNumber} {user.role}
                        </div>
                        <input
                            type="radio"
                            className={buttonStyle.radioButton}
                            name="selected user"
                            checked={selectedUserId === user.userEntityId}
                            readOnly
                        />
                    </div>

                ))}
            <FormInput useRef={newRole} className={inputStyle.input} text={"new role"}/>
            <FormInput useRef={newCompany} className={inputStyle.input} text={"new company"}/>
            <Button className={buttonStyle.accountButton}
                    onClick={setRoleRequest}
                    text={"Set new role"}
                    width={'10em'}/>
            <Button className={buttonStyle.accountButton}
                    onClick={setCompanyRequest}
                    text={"Set new company"}
                    width={'10em'}/>
        </div>

        );

}

export default WorkerContainer;