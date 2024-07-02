<script setup lang="ts">
import { useRouter } from 'vue-router';
import { useCounterStore } from '@/storage/UseStorage.ts';
import { computed } from 'vue'

const store = useCounterStore();
const nombre = computed(() => store.nombreGuardado);
const sesion = computed(() => store.sesion);


const router = useRouter();

function changeView() {
    router.push("/sesion")
}

</script>

<template>
    <header class="card-container">
        <div class="card-text">
            <p class="card-text--user" v-if="sesion === false">Desconocido</p>
            <p class="card-text--user" v-if="sesion === true">{{ nombre }}</p>
            <small class="card-text--logger" @click="changeView()" v-if="sesion === false">Iniciar sesion</small>
            <small class="card-text--logger" @click=" store.cambiarEstadoSesion('')"
                v-if="sesion === true">Salir</small>

        </div>
        <img class="img" src="/src/assets/icon/user.png" alt="">
    </header>

</template>

<style scoped>
.card-container {
    width: 19%;
    height: 100%;

    display: flex;
    border-left: var(--borde);
    padding-left: 2%;

    align-items: center;
    justify-content: end;
}

.card-text {
    margin-right: 5%;
    width: 100%;
    height: 100%;

    display: flex;

    flex-direction: column;
    align-items: end;
    justify-content: center;
}

.card-text--user {
    font-size: 1rem;
    font-weight: 700;
    color: var(--font-color);
    margin: 0;
    padding: 0;
}

.img {
    width: auto;
    height: 95%;
}

.card-text--logger {
    font-size: 0.8rem;
    font-weight: 400;
    color: var(--color-morado);
    cursor: pointer;

    margin: 0;
    padding: 0;
}

.card-text--logger:hover {
    transform: scale(1.05)
}

.card-text--logger:active {
    transform: scale(1)
}
</style>
