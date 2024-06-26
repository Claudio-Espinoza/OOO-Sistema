<script setup lang="ts">
import MainLayout from '../layouts/MainLayout.vue';
import ArticleSection from '../components/organisms/ArticleSection.vue';
import ButonFilter from '../components/atoms/ButonFilter.vue';
import ChallengerCard from '../components/atoms/ChallengerCard.vue'
import { CardDescription } from '@/model/Challenger.ts';
import { ref } from 'vue';

let activeButton = ref('Introducción a Programación');

const setActiveButton = (newActiveButton: string) => {
    activeButton.value = newActiveButton;
};


const challengerCards = [
    { course: "Introducción a Programación", type: "java", title: "Manejo de arreglos 1" },
    { course: "Introducción a Programación", type: "java", title: "Manejo de arreglos 2" },
    { course: "Programación Orientada a Objetos", type: "java", title: "Manejo de arreglos 3" },
    { course: "Taller de Programación", type: "python", title: "Manejo de arreglos 4" },
    { course: "Taller de Programación", type: "python", title: "Manejo de arreglos 5" },
    { course: "Taller de Programación", type: "python", title: "Manejo de arreglos 6" },
    { course: "Taller de Programación", type: "python", title: "Manejo de arreglos 7" },
    { course: "Programación Orientada a Objetos", type: "java", title: "Manejo de arreglos 1" },
    { course: "Programación Orientada a Objetos", type: "java", title: "Manejo de arreglos 2" },
    { course: "Programación Orientada a Objetos", type: "java", title: "Manejo de arreglos 3" },
    { course: "Taller de Programación", type: "python", title: "Manejo de arreglos 4" },
    { course: "Taller de Programación", type: "python", title: "Manejo de arreglos 5" },
    { course: "Taller de Programación", type: "python", title: "Manejo de arreglos 6" },
    { course: "Taller de Programación", type: "python", title: "Manejo de arreglos 7" },
    { course: "Introducción a Programación", type: "java", title: "Manejo de arreglos 1" },
    { course: "Introducción a Programación", type: "java", title: "Manejo de arreglos 2" },
    { course: "Introducción a Programación", type: "java", title: "Manejo de arreglos 3" },
    { course: "Taller de Programación", type: "python", title: "Manejo de arreglos 4" },
    { course: "Taller de Programación", type: "python", title: "Manejo de arreglos 5" },
    { course: "Taller de Programación", type: "python", title: "Manejo de arreglos 6" },
    { course: "Taller de Programación", type: "python", title: "Manejo de arreglos 7" }
];

function handleCardClick(cardAttributes: CardDescription) {
    console.log('Card clicked:', cardAttributes);
}

</script>

<template>
    <MainLayout>
        <article class="container-main">
            <ArticleSection title="Manejo de arreglos" sub-title="Introducción a la programación" view="1.000"
                review="4.5" autor="Nombre autor" type="java"
                description="Aqui va la descripcion por lo que pondre un texto de prueba. Aqui va la descripcion por lo que pondre un texto de prueba. Aqui va la descripcion por lo que pondre un texto de prueba" />

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
                    <ChallengerCard
                        v-for="(item, index) in challengerCards.filter(card => card.course === activeButton)"
                        :key="index" :course="item.course" :title="item.title" :type="item.type"
                        @cardClicked="handleCardClick" />

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
