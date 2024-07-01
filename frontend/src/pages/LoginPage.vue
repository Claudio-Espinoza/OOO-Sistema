<script setup lang="ts">
import { ref } from 'vue'

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



    </main>
</template>

<style scoped>
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
    border: 0.4vh solid var(--background-color);
    border-radius: 0.7vw;
    font-size: 1.2vw;
    font-weight: 300;
    color: var(--color-verde);
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
    background: var(--color-verde);
    border: 0.4vh solid var(--color-verde);
    border-radius: 0.7vw;

    color: var(--color-background);
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