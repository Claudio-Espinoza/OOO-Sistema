<script setup lang="ts">
import MainLayout from '../layouts/MainLayout.vue';
import ButonCurse from '../components/atoms/ButonCurse.vue';
</script>

<template>
    <MainLayout>
        <article class="container-main">
            <ButonCurse type="java" content="Introducción a Programación" />
            <ButonCurse type="java" content="Programación Orientada a Objeto" />
            <ButonCurse type="python" content="Taller de Programación" />
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
