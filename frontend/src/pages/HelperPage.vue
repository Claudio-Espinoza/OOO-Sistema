<script setup lang="ts">
import MainLayout from '../layouts/MainLayout.vue';
import SliderHelper from '../components/molecules/SliderHelper.vue';
</script>

<template>
    <MainLayout>
        <article class="container-main">
            <SliderHelper />
        </article>
    </MainLayout>
</template>

<style scoped>
.container-main {
    width: 95%;
    height: 100%;

    display: flex;
    justify-content: center;
    align-items: center;
}
</style>
