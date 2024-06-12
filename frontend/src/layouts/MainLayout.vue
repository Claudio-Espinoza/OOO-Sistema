<script setup lang="ts">
import NavBar from '../components/organisms/NavBar.vue';
import HeaderMain from '../components/organisms/HeaderMain.vue'
import { ref } from 'vue';

let titleGeneral = ref('Inicio')

const handleButtonClick = (title: string) => {
    titleGeneral.value = title;
};
</script>

<template>
    <NavBar @clicked="handleButtonClick" />
    <main class="container">
        <HeaderMain :title="titleGeneral" />
        <slot>


        </slot>
    </main>

</template>

<style scoped>
.container {
    background-color: var(--background-color);
    width: 100%;
    height: 100%;
}
</style>
