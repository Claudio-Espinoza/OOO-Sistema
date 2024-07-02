<script setup lang="ts">
import { ref } from 'vue';
import { useRouter } from 'vue-router';
import LoggerService from '@/service/LoggerService.ts'
import { IRegister } from '@/model/User';


const router = useRouter();
const service = new LoggerService()

function changeView() {
    router.push("/")
}

const email = ref('');
const password = ref('');
const error = ref(false);
const succes = ref(false);

const handleSubmit = () => {
    console.log('Email:', email.value);
    console.log('Password:', password.value);
    const registerRequest: IRegister = {
        username: email.value,
        password: password.value,
        roleRequest: 'ADMINISTRADOR'
    };

    service.registerUser(registerRequest).then((response) => {
        console.log(response);
        if (typeof response?.jwt === 'string' && response.jwt.length > 4) {
            error.value = false
            succes.value = true
        } else {
            error.value = true
        }

    }).catch((error) => {
        console.error(error);
    });
};
</script>

<template>
    <form class="form" @submit.prevent="handleSubmit">
        <div class="form-div">
            <label class="form-title" for="email">Nombre:</label>
            <input class="form-input" id="email" type="text" v-model="email" required>
        </div>
        <div class="form-div">
            <label class="form-title" for="password">Contraseña:</label>
            <input class="form-input" id="password" type="password" v-model="password" required>
        </div>
        <small v-if="error">Logeo erroneo</small>
        <small v-if="succes">Registro exitoso</small>

        <div class="form-div--alternative">
            <button class="form-button" type="submit">Login</button>
            <button class="form-button" @click="changeView()">Volver</button>
        </div>

    </form>

</template>

<style scoped>
small {
    margin-bottom: 5%;
}

.form {
    width: 30vw;
    height: 60vh;
    box-sizing: border-box;
    padding: 10%;

    display: flex;
    align-items: center;
    justify-content: space-around;
    flex-direction: column;
}

.form-div {
    width: 95%;
    height: 30%;
}

.form-div--alternative {
    display: flex;
    flex-direction: row-reverse;
    gap: 20%;
    align-content: space-around;
    justify-content: center;
}

.form-button {
    width: 10vw;
    height: 6vh;
    border: var(--borde);
    background: none;
    border-radius: 0.5vw;
}

.form-button:hover {
    transform: scale(1.05);
}

.form-button:active {
    background-color: var(--color-morado);
    transform: scale(0.95);
}


.form-input {
    border: var(--borde);
    border-radius: 0.2vw;
    width: 100%;
    height: 40%;
    box-sizing: border-box;
}

.form-title {
    font-size: 1.1rem;
    margin-bottom: 2%;
}
</style>
