<script setup lang="ts">
import MainLayout from '../layouts/MainLayout.vue';
import ArticleSection from '../components/organisms/ArticleSection.vue';
import ButonFilter from '../components/atoms/ButonFilter.vue';
import ChallengerCard from '../components/atoms/ChallengerCard.vue';
import { onMounted, ref } from 'vue';
import ChallengerService from '@/service/ChallengerService.ts';
import { IChallenger } from '@/model/Challenger.ts';

let activeButton = ref('Introducción a programación');

const setActiveButton = (newActiveButton: string) => {
    activeButton.value = newActiveButton;
};

const courseService = new ChallengerService();
let challengers = ref<IChallenger[] | null>(null);

onMounted(async () => {
    challengers.value = await courseService.fetchAllChallenger();
    console.log(challengers);
});

let cardDescription = ref<IChallenger | null>(null);

function handleCardClick(cardAttributes: IChallenger) {
    console.log('Card clicked:', cardAttributes);
    cardDescription.value = cardAttributes;
}
</script>

<template>
    <MainLayout>
        <article class="container-main">
            <ArticleSection :title="cardDescription?.nombre || ''" :sub-title="cardDescription?.nombreCurso || ''"
                :autor="cardDescription?.autor || ''" :type="cardDescription?.type || ''"
                :description="cardDescription?.descripcion || ''"
                :negative-point="cardDescription?.puntuacion_negativa ?? 2"
                :positive-point="cardDescription?.puntuacion_positiva ?? 4"
                :direccion_pdf_contenido="cardDescription?.direccion_pdf_contenido ?? 'Desafío de la semana - 7 de Mayo.pdf'" />

            <section class="content">
                <div class="content-navbar">
                    <ButonFilter content="Introducción a Programación"
                        :state="activeButton === 'Introducción a Programación'"
                        @click="setActiveButton('Introducción a Programación')" />
                    <ButonFilter content="Programación Orientada a Objetos"
                        :state="activeButton === 'Programación Orientada a Objetos'"
                        @click="setActiveButton('Programación Orientada a Objetos')" />
                    <ButonFilter content="Taller de Programación" :state="activeButton === 'Taller de Programación'"
                        @click="setActiveButton('Taller de Programación')" />
                </div>

                <div class="content-card">
                    <h4 class="content-card--title">Desafios disponibles</h4>
                    <small class="content-card--small">Basado en la seleccion del curso</small>
                </div>

                <div class="content-card-objet">
                    <ChallengerCard v-for="(item, index) in challengers?.filter(
                        (card) => card.nombreCurso === activeButton
                    ) || []" :key="index" :course="item.nombreCurso" :title="item.nombre" :type="item.type"
                        @cardClicked="handleCardClick(item)" />
                </div>
            </section>
        </article>
    </MainLayout>
</template>

<style scoped>
.container-main {
    width: 97.5%;
    height: 100%;
    margin-left: 2.5%;

    display: flex;
    flex-direction: row-reverse;
    align-items: center;
}

.content {
    display: flex;
    flex-direction: column;
    width: 100%;
    height: 100%;
}

.content-navbar {
    gap: 2vw;
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: start;
    margin-left: 1%;
    width: 92.5%;

    height: 15%;
}

.content-card {
    margin-left: 1.2%;
    width: 80.5%;
}

.content-card--title {
    font-size: 1.2rem;
    font-weight: 500;
}

.content-card--small {
    font-style: italic;
    font-size: 0.9rem;
}

.content-card-objet {
    box-sizing: border-box;
    margin-top: 2%;
    width: 98%;
    height: 65%;

    display: flex;
    flex-wrap: wrap;
    flex-direction: row;

    justify-content: start;
    align-content: flex-start;
    gap: 1.5vw;
    overflow-x: hidden;
    overflow-y: auto;
    padding: 1%;
}

::-webkit-scrollbar {
    border-radius: 10%;
    width: 10px;
}

::-webkit-scrollbar-track {
    border-radius: 0.5vw;
    background: #f1f1f1;
}

::-webkit-scrollbar-thumb {
    border-radius: 0.5vw;
    background: #888;
}

::-webkit-scrollbar-thumb:hover {
    border-radius: 0.5vw;
    background: #555;
}
</style>
