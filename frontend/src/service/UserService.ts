import axios from "axios";

interface IRolRequest {
    nombreUsuario: string;
}

interface IAuthResponse {
    rol: string;
}

class UserService {
    private static API_URL = 'http://localhost:8080';


    static async getRol(userRequest: IRolRequest): Promise<IAuthResponse | null> {
        try {
            const response = await axios.get(`${this.API_URL}/user/obtener-rol`, {
                params: {
                    nombreUsuario: userRequest.nombreUsuario
                }
            });
            console.log(response.data)
            return response.data;
        } catch (error) {
            console.error('Error al obtener el rol del usuario:', error);
            return null;
        }
    }
}

export default UserService;
