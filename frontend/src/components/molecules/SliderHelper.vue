<script setup lang="ts">
import HelperCard from '../atoms/HelperCard.vue';
import { ref } from 'vue';

const allHelpers = [
    { name: 'Nombre1', role: 'Rol1' },
    { name: 'Nombre2', role: 'Rol2' },
    { name: 'Nombre3', role: 'Rol3' },
    { name: 'Nombre4', role: 'Rol4' },
    { name: 'Nombre5', role: 'Rol5' },
    { name: 'Nombre6', role: 'Rol6' },
    { name: 'Nombre7', role: 'Rol7' }
];

const helpersGroups: Array<Array<{ name: string; role: string }>> = [];
for (let i = 0; i < allHelpers.length; i += 4) {
    helpersGroups.push(allHelpers.slice(i, i + 4));
}

let currentGroupIndex = ref(0);
let helpers = ref(helpersGroups[currentGroupIndex.value]);
let isAnimating = ref(false);

const advanceGroup = () => {
    if (!isAnimating.value) {
        isAnimating.value = true;
        currentGroupIndex.value = (currentGroupIndex.value + 1) % helpersGroups.length;
        helpers.value = helpersGroups[currentGroupIndex.value];
        setTimeout(() => {
            isAnimating.value = false;
        }, 500);
    }
};

const retreatGroup = () => {
    if (!isAnimating.value) {
        isAnimating.value = true;
        currentGroupIndex.value = (currentGroupIndex.value - 1 + helpersGroups.length) % helpersGroups.length;
        helpers.value = helpersGroups[currentGroupIndex.value];
        setTimeout(() => {
            isAnimating.value = false;
        }, 500);
    }
};

</script>



<template>
    <section class="container-section">
        <HelperCard v-for="(helper, index) in helpers" :key="index" :name="helper.name" :role="helper.role"
            :class="{ 'slide-in-left': isAnimating }" />
        <button class="prev" @click="advanceGroup">Avanzar</button>
        <button class="next" @click="retreatGroup">Avanzar</button>
    </section>
</template>

<style scoped>
.container-section {
    transition: transform 0.5s ease-in-out;
    position: relative;
    width: 100%;
    height: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: row;
    gap: 1vw;
    overflow: hidden;
    padding: 1em;
    box-sizing: border-box;
    scroll-behavior: smooth;
}

.prev,
.next {
    position: absolute;
    top: 50%;
    transform: translateY(-50%);
    padding: 10px;
    background-color: #ccc;
    border: none;
    cursor: pointer;
}

.prev {
    left: 0;
}

.next {
    right: 0;
}
</style>