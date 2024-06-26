<script setup lang="ts">
import MainLayout from '../layouts/MainLayout.vue';
import ButonCurse from '../components/atoms/ButonCurse.vue';
import { useRouter } from 'vue-router';

const router = useRouter();

const changePage = (id: string): void => {
    const ruta = `/roadmap/${id}`;
    router.push(ruta);
}

</script>

<template>
    <MainLayout>
        <article class="container-main">
            <ButonCurse type="java" content="Introducción a Programación"
                @click="changePage('Introducción a Programación')" />

            <ButonCurse type="java" content="Programación Orientada a Objeto"
                @click="changePage('Introducción a Programación')" />

            <ButonCurse type="python" content="Taller de Programación"
                @click="changePage('Introducción a Programación')" />
        </article>
    </MainLayout>
</template>

<style scoped>
.container-main {
    width: 95%;
    height: 100%;

    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: space-evenly;
}
</style>
