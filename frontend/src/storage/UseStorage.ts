import { defineStore } from 'pinia';
import {ref} from 'vue';
import UserService from '@/service/UserService';

export const useCounterStore = defineStore('counterStore', () => {
    const sesion = ref(false);
    const nombreGuardado = ref('');
    const rol = ref('');

    const cambiarEstadoSesion = async (nombre: string) => {
        sesion.value = !sesion.value;
        nombreGuardado.value = nombre;
        console.log(sesion.value, nombreGuardado.value);
        await fetchUserRole(nombre);
    };


    const fetchUserRole = async (nombreUsuario: string) => {
        const userRequest = { nombreUsuario };
        const response = await UserService.getRol(userRequest);
        console.log(response)

        if (response) {
            rol.value = response as string
        }
    };

    return { nombreGuardado, sesion, rol, cambiarEstadoSesion, fetchUserRole };
});
