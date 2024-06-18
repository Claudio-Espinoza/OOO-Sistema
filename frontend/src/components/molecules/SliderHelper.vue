<script setup lang="ts">
import HelperCard from '../atoms/HelperCard.vue';
import { ref } from 'vue'
const allHelpers = [
    { name: 'Intregando 1', role: 'Rol 1', isDiscord: false, isWhatsApp: false, isGitHub: true },
    { name: 'Intregando 2', role: 'Rol 2', isDiscord: true, isWhatsApp: true, isGitHub: true },
    { name: 'Intregando 3', role: 'Rol 3', isDiscord: false, isWhatsApp: false, isGitHub: true },
    { name: 'Intregando 4', role: 'Rol 4', isDiscord: true, isWhatsApp: true, isGitHub: false },
    { name: 'Intregando 5', role: 'Rol 5', isDiscord: false, isWhatsApp: false, isGitHub: true },
    { name: 'Intregando 6', role: 'Rol 6', isDiscord: false, isWhatsApp: true, isGitHub: true },
    { name: 'Intregando 7', role: 'Rol 7', isDiscord: true, isWhatsApp: true, isGitHub: false }
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
        <button class="next" @click="advanceGroup"><img src="/src/assets/icon/flecha-inverse.png" alt=""></button>
        <button class="prev" @click="retreatGroup"><img src="/src/assets/icon/flecha.png" alt=""></button>
    </section>
</template>

<style scoped>
.container-section {
    position: relative;
    width: 92%;
    height: 100%;
    display: flex;
    justify-content: start;
    align-items: center;
    flex-direction: row;
    gap: 1vw;
    overflow: hidden;
    box-sizing: border-box;
    scroll-behavior: smooth;
}

.prev,
.next {
    width: 2.5vw;
    height: 9vh;
    border-radius: 0.5vw;
    position: fixed;
    top: 50%;
    border: var(--borde);
    cursor: pointer;
}

.prev>img,
.next>img {
    width: 100%;
    height: auto;
}


.prev {
    left: 16%;
}

.next {
    right: 2%;
}

.next:hover {
    transform: scale(0.95);
}

.prev:hover {
    transform: scale(0.95);
}
</style>