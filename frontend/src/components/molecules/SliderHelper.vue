<script setup lang="ts">
import HelperCard from '../atoms/HelperCard.vue';
import { ref } from 'vue'
const allHelpers = [
    { name: 'Intregando 1', role: 'Rol 1', isDiscord: true, isWhatsApp: true, isGitHub: true },
    { name: 'Intregando 2', role: 'Rol 2', isDiscord: true, isWhatsApp: true, isGitHub: true },
    { name: 'Intregando 3', role: 'Rol 3', isDiscord: false, isWhatsApp: true, isGitHub: true },
    { name: 'Intregando 4', role: 'Rol 4', isDiscord: true, isWhatsApp: true, isGitHub: true },
    { name: 'Intregando 5', role: 'Rol 5', isDiscord: false, isWhatsApp: true, isGitHub: true },
    { name: 'Intregando 6', role: 'Rol 6', isDiscord: false, isWhatsApp: true, isGitHub: true },
    { name: 'Intregando 7', role: 'Rol 7', isDiscord: true, isWhatsApp: true, isGitHub: true }
];
const container = ref<HTMLElement | null>(null);


const advanceGroup = () => {
    if (container.value) {
        container.value.scrollLeft += container.value.offsetWidth;
    }
};

const retreatGroup = () => {
    if (container.value) {
        container.value.scrollLeft -= container.value.offsetWidth;
    }
};

</script>

<template>
    <section class="container-section" ref="container">
        <HelperCard v-for="(helper, index) in allHelpers" :key="index" :name="helper.name" :role="helper.role"
            :is-discord="helper.isDiscord" :is-git-hub="helper.isGitHub" :is-whats-app="helper.isWhatsApp" />
        <button class="next" @click="advanceGroup">Avanzar</button>
        <button class="prev" @click="retreatGroup">retroceder</button>
    </section>
</template>

<style scoped>
.container-section {
    position: relative;
    width: 95%;
    height: 100%;
    display: flex;
    justify-content: start;
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
    position: fixed;
    top: 50%;
    padding: 10px;
    background-color: #ccc;
    border: none;
    cursor: pointer;
}

.prev {
    left: 15%;
}

.next {
    right: 0;
}
</style>