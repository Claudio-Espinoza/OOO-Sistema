<script setup lang="ts">
import { ref } from 'vue'
import FormLogin from '@/components/molecules/FormLogin.vue';
import FormRegister from '@/components/molecules/FormRegister.vue';

let habilitador = ref(true)
let statusOne = ref('active')
let statusTwo = ref('false')



function activarButon() {
    habilitador.value = !habilitador.value

    if (statusOne.value === 'active') {
        statusOne.value = 'false'
    } else {
        statusOne.value = 'active'
    }

    if (statusTwo.value === 'active') {
        statusTwo.value = 'false'
    } else {
        statusTwo.value = 'active'
    }

}

</script>

<template>
    <main class="container-logger">
        <nav class="logger-nav">
            <button :class="'logger-button-' + statusOne" @click="activarButon()">Iniciar Sesión</button>
            <button :class="'logger-button-' + statusTwo" @click="activarButon()">Registrar Sesión</button>
        </nav>

        <section class="form" v-if="statusOne === 'active'">
            <FormLogin />
        </section>

        <section class="form" v-if="statusTwo === 'active'">
            <FormRegister />
        </section>
    </main>
</template>

<style scoped>
.form {
    border: var(--borde);
    border-radius: 0.7vw;

    display: flex;
    align-items: center;
    justify-content: center;
    flex-direction: column;
}

.container-logger {
    width: 100%;
    height: 100vh;
    display: flex;
    align-items: center;
    justify-content: center;
    flex-direction: column;
    gap: 4vh;
}

.logger-button-false {
    background: none;
    border: var(--borde);
    border-radius: 0.7vw;
    font-size: 1.2vw;
    font-weight: 300;
    color: var(--font-color);
    width: 40%;
    height: 8vh;
}

.logger-button-false:hover {
    transform: scale(1.05);
}

.logger-button-false:active {
    transform: scale(1);
}

.logger-button-active {
    background: var(--color-morado);
    border: 0.4vh solid var(--borde);
    border-radius: 0.7vw;

    color: #fff;
    font-size: 1.2vw;
    font-weight: 600;
    width: 40%;
    height: 8vh;
}

.logger-button-active:hover {
    transform: scale(1.05);
}

.logger-button-active:active {
    transform: scale(1);
}

.logger-nav {
    display: flex;
    align-items: center;
    justify-content: center;
    gap: 3vw;
    width: 30vw;
}
</style>