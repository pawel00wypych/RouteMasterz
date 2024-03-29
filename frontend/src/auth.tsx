import { NavigateFunction } from 'react-router-dom';

const loginUrl = `${process.env.REACT_APP_BACKEND_URL}/auth/login`;
const logoutUrl = `${process.env.REACT_APP_BACKEND_URL}/auth/logout`;
const fetchUserUrl = `${process.env.REACT_APP_BACKEND_URL}/app/user`;


interface UserState {
    username: string;
    sessionStart: Date;
    role: Role;
}

export enum Role {
    ADMIN,
    DRIVER,
    LOGISTICIAN,
}

interface User {
    email: string;
    role: Role;
    createdAt: string;
}

export class InvalidSessionError extends Error {
    constructor() {
        super('Invalid session');
    }
}

export const removeSesionData = () => {
    console.log("remove session data: "+sessionStorage);
    sessionStorage.removeItem('userToken');
    sessionStorage.removeItem('USERSTATE');
};

export const logout = async () => {
    const requestOptions = {
        method: 'POST',
        headers: {
            'Authorization': "Bearer " + sessionStorage.getItem("userToken"),
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': '*',
            'Access-Control-Allow-Credentials': 'true'
        }
    };
    try {
        const response = await fetch(logoutUrl, requestOptions)
        if (response.ok) {
            removeSesionData();

            document.location.href = '/';
        }
    } catch (err) {
        console.log("conn error");
    }
};

export const validateUserState = (userState: UserState): userState is UserState => {
    if (typeof userState !== 'object') return false;
    if (typeof userState.username !== 'string') return false;
    if (typeof userState.sessionStart !== 'string') return false;
    if (typeof userState.role !== 'number') return false;
    console.log("validateUserState - userState.role: "+userState.role.toString());

    const date = new Date(userState.sessionStart);
    if (isNaN(date.getTime())) return false;

    userState.sessionStart = date;
    return true;
};

export const getUserstate = (): UserState | null => {
    const rawSession = sessionStorage.getItem('USERSTATE');
    if (rawSession === null) return null;

    console.log("rawSession:  "+rawSession);

    try {
        const userState = JSON.parse(rawSession);
        console.log("userState:  "+userState);

        if (!validateUserState(userState)) return null;

        return userState;
    } catch (err) {
        console.log("getUserState error "+err);
        removeSesionData();
        return null;
    }
};

export const setUserState = (username: string, role: Role): void => {
    const userState: UserState = {
        username: username,
        sessionStart: new Date(),
        role,
    };

    sessionStorage.setItem('USERSTATE', JSON.stringify(userState));
};

export const isLoggedIn = (): boolean => {
    if (sessionStorage.getItem("userToken") !== undefined
        && sessionStorage.getItem("userToken") != 'undefined'
        && sessionStorage.getItem("userToken"))
        return true;
    else
        return false;
};

export const isAdmin = (): boolean => {
    if (!isLoggedIn()) return false;

    const userState = getUserstate();
    if (userState === null) return false;

    return userState.role === Role.ADMIN;
};

export const isLogistician = (): boolean => {
    if (!isLoggedIn()) return false;

    const userState = getUserstate();
    if (userState === null) return false;

    return userState.role === Role.LOGISTICIAN;
};

export const isDriver = (): boolean => {
    if (!isLoggedIn()) return false;

    const userState = getUserstate();
    if (userState === null) return false;

    return userState.role === Role.DRIVER;
};

export const login = async (email: string, password: string, navigate: NavigateFunction): Promise<string | void> => {

    const body = {
        email: email,
        password: password
    };
    const requestOptions = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': '*',
            'Access-Control-Allow-Credentials': 'true'
        },
        body: JSON.stringify(body),
    };

    try {
        const response = await fetch(loginUrl, requestOptions)
            .then((response) => response.json())
            .then((body) => {
                console.log(body);
                sessionStorage.setItem("userToken", body.token);
                console.log("login sess-store-token: "+sessionStorage.getItem("userToken"));
                updateUserState();
                navigate("/account");
            });

    } catch (err) { }
};

export const validateUser = (user: User): user is User => {
    if (typeof user !== 'object') return false;
    if (typeof user.email !== 'string') return false;
    if (typeof user.role !== 'string') return false;

    switch (user.role) {
        case Role[Role['DRIVER']] as unknown as Role: user.role = Role.DRIVER; break;
        case Role[Role['ADMIN']] as unknown as Role: user.role = Role.ADMIN; break;
        case Role[Role['LOGISTICIAN']] as unknown as Role: user.role = Role.LOGISTICIAN; break;
        default: return false;
    }


    return true;
};

export const fetchUser = async (): Promise<User | null> => {
    const body = {
        token: sessionStorage.getItem("userToken")
    };
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
        const resp = await fetch(fetchUserUrl, requestOptions);
        if (resp.status !== 200) return null;

        const user = await resp.json();
        if (!validateUser(user)) return null;

        return user;
    } catch (err) {
        console.log("fetchUser error "+ err);
    }

    return null;
};

export const updateUserState = async (): Promise<void> => {
    const user = await fetchUser();
    if (user === null) return removeSesionData();
    console.log("updateUserState user:"+user);
    setUserState(user.email, user.role);
};