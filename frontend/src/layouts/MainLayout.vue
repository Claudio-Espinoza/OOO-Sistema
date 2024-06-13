<script setup lang="ts">
import NavBar from '../components/organisms/NavBar.vue';
import HeaderMain from '../components/organisms/HeaderMain.vue'
import { useRoute } from 'vue-router';
import { ref, Ref, watch } from 'vue';

const route = useRoute();
let titleGeneral: Ref<string> = ref(formatTitle(route.path));

watch(() => route.path, (newPath) => {
    titleGeneral.value = formatTitle(newPath);
});

const handleButtonClick = (title: string) => {
    titleGeneral.value = title;
};

function formatTitle(path: string): string {
    return path.replace('/', '').charAt(0).toUpperCase() + path.slice(2);
}
</script>

<template>
    <NavBar @clicked="handleButtonClick" :seccion="titleGeneral" />
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
    display: flex;
    flex-direction: column;
    align-items: center;

}
</style>
