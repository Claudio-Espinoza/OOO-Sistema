import { defineStore } from 'pinia'
import { ref } from 'vue'

export const useCounterStore = defineStore('storeId', () => {
    const sesion = ref(false)
    const nombreGuardado = ref('')

    const cambiarEstadoSesion = (nombre: string) => {
        sesion.value = !sesion.value
        nombreGuardado.value = nombre
        console.log(sesion)
    }


    return { nombreGuardado, sesion, cambiarEstadoSesion }
})


