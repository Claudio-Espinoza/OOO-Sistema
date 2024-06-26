<script setup lang="ts">
import MainLayout from '../layouts/MainLayout.vue';
import { useRouter } from 'vue-router';

const router = useRouter();

</script>

<template>
    <MainLayout>
        <article class="container-main">

        </article>
    </MainLayout>
</template>

<style scoped>
.container-main {
    width: 95%;
    height: 100%;
    background-color: aqua;

    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: center;
}
</style>
