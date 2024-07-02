import axios from 'axios';
import { IAuthLoginRequest, IAuthResponse, IRegister } from '@/model/User';

class LoggerService {
    private API_URL = 'http://localhost:8080';

    async loginUser(
        userRequest: IAuthLoginRequest
    ): Promise<IAuthResponse | null> {
        try {
            const response = await axios.post<IAuthResponse>(
                `${this.API_URL}/auth/log-in`,
                userRequest
            );
            return response.data;
        } catch (error) {
            console.error('Error al intentar iniciar sesión:', error);
            return null;
        }
    }


    async registerUser(
        userRequest: IRegister
    ): Promise<IAuthResponse | null> {
        try {
            const response = await axios.post<IAuthResponse>(
                `${this.API_URL}/auth/sign-up`,
                userRequest
            );
            return response.data;
        } catch (error) {
            console.error('Error al intentar registrar el usuario:', error);
            return null;
        }
    }
}

export default LoggerService;
