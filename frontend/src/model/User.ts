export interface IAuthLoginRequest {
    username: string;
    password: string;
}

export interface IAuthResponse {
    username: string;
    message: string;
    jwt: string;
    status: boolean;
}

export interface IRegister {
    username: string;
    password: string;
    roleRequest: string;
}
