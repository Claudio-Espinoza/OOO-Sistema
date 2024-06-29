<script setup lang="ts">
import { ref, Ref } from 'vue';
import ButonSource from '../atoms/ButonSource.vue'
import { useRouter, useRoute } from 'vue-router';

const router = useRouter()
const routePosition = useRoute().params.id;

const props = defineProps({
    seccion: String
})

let activeButton: Ref<string | undefined> = ref(props.seccion || routePosition as string | undefined);

const concepts = [
    { name: "PSeint" },
    { name: "Proyectos de java" },
    { name: "Sintaxis" },
    { name: "Estructura de datos" },
    { name: "Clases" },
    { name: "Objetos" }]

function handleClick(section: string): void {
    activeButton.value = section

    if (section === 'Inicio') {
        router.push('/Inicio')
    } else if (section === 'Volver') {
        router.push('/cursos')
    }
}

const emit = defineEmits(['clicked']);

const handleButtonClick = (title: string) => {
    activeButton.value = title;
    emit('clicked', activeButton.value);
};


</script>

<template>
    <nav class="navbar-container">
        <section class="section-logo">
            <img class="logo-img" src="/src/assets/icon/o.png" alt="">
            <div class="logo-title">
                <h1 class="logo-title--h1">Organizacion
                    <br>Orientada a
                    <br>Objeto
                </h1>
            </div>
        </section>

        <section class="section-option">
            <h2 class="learning-title">Lecciones</h2>
            <ButonSource v-for="(item, index) in concepts" :key="index" :title="item.name"
                :isActive="activeButton === item.name" @click="handleClick(item.name)"
                @clicked="handleButtonClick(item.name)" />

            <h2 class="learning-title">Lecciones</h2>
            <ButonSource title="Inicio" :isActive="activeButton === 'Inicio'" @click="handleClick('Inicio')"
                @clicked="handleButtonClick('Inicio')" />
            <ButonSource title="Volver" :isActive="activeButton === 'Volver'" @click="handleClick('Volver')"
                @clicked="handleButtonClick('Volver')" />
        </section>
    </nav>
</template>

<style scoped>
.navbar-container {
    border-right: var(--borde);
    background-color: var(--background-color);
    width: 18%;
    height: 100vh;

    display: flex;
    flex-direction: column;

}

.section-logo {
    margin-top: 1vh;
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: center;

    width: 100%;
    height: 12%;
    margin-bottom: 3vh;
}

.logo-img {
    height: 52%;
    width: auto;
    margin-right: 0.5vw;
}

.logo-title--h1 {
    font-size: 0.8rem;
    font-weight: 500;
}

.section-option {
    margin-top: 2vh;

    display: flex;
    flex-direction: column;

    gap: 2vh;
    height: 20%;
    width: 100%;

    align-items: end;
}

.learning-title {
    margin-top: 8%;
    font-size: medium;
    font-weight: 400;
    color: #686868;
    width: 80%;

}
</style>
