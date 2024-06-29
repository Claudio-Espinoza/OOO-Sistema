<script setup lang="ts">
import MainLayout from '../layouts/MainLayout.vue';
import ButonRoadMap from '../components/atoms/ButonRoadMap.vue';
import { useRoute } from 'vue-router';
import { ref, Ref } from 'vue';

const route = useRoute();
console.log(route);

let milestonesSelected: Ref<string> = ref('');


const handleButtonClick = (title: string) => {
    milestonesSelected.value = title;
};

const contents = [
    { name: 'Variables' },
    { name: 'Operaciones' },
    { name: 'Estructura de control' },
    { name: 'Analisis de problematica' },
    { name: 'Analisis de problematica' },
    { name: 'Analisis de problematica' },
    { name: 'Analisis de problematica' }
];

const milestones = [
    { name: "PSeint", type: 'java' },
    { name: "Proyectos de java", type: 'java' },
    { name: "Sintaxis", type: 'java' },
    { name: "Estructura de datos", type: 'java' },
    { name: "Clases", type: 'java' },
    { name: "Objetos", type: 'java' },
];

</script>

<template>
    <MainLayout>
        <section class="container-main">
            <article class="roadmap-list">
                <h2 class="roadmap-list-title">Conocimientos hitos de
                    <strong class="roadmap-list-decoration"> Introducción a <br> programación</strong>
                </h2>
                <section class="roadmap-list--button">
                    <ButonRoadMap v-for="(item, index) in milestones" :key="index" :title="item.name"
                        :position="index + 1" :type="item.type" @clicked="handleButtonClick" />
                </section>
            </article>

            <article class="roadmap-description">
                <aside class="description-content">
                    <h4>{{ milestonesSelected }}</h4>
                    <div class="content-list">
                        <p>Contenido: </p>
                        <div class="content-list--buton">
                            <button v-for="(item, index) in contents" :key="index">{{ item.name }}</button>

                        </div>
                    </div>
                    <div class="content-description">
                        <p class="content-description--title">Descripcion del modulo: </p>
                        <p class="content-description--description">Lorem ipsum dolor sit amet consectetur adipisicing
                            elit. Labore esse debitis quia odit
                            voluptates deserunt exercitationem saepe laboriosam quam voluptas, itaque facere velit
                            sequi. Autem mollitia asperiores eveniet nulla aspernatur!</p>
                    </div>


                </aside>
            </article>
        </section>
    </MainLayout>
</template>

<style scoped>
.container-main {
    width: 95%;
    height: 100%;

    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: center;
}

.roadmap-list {
    display: flex;
    width: 85%;
    height: 100%;
    flex-direction: column;
}

.roadmap-list-title {
    margin-top: 4%;
    text-align: left;
    font-size: 1.2rem;
    font-weight: 400;

    width: 70%;
    height: 10%;

}

.roadmap-list-decoration {
    font-size: 1.2rem;
    font-weight: 500;
    color: var(--color-naranja);
}

.roadmap-list--button {
    margin-top: 3%;
    display: flex;
    width: 100%;
    height: 100%;
    flex-direction: column;
    gap: 2vh;
}

.roadmap-description {
    display: flex;
    width: 100%;
    height: 100%;
    align-items: center;
    justify-content: center;
}

.description-content {
    display: flex;
    width: 85%;
    height: 90%;
    flex-direction: column;
    justify-content: space-evenly;

    border: var(--borde);
    border-radius: 0.5vw;
    box-sizing: border-box;
    padding: 0% 10% 10% 5%;
}

h4 {
    font-size: 1.7rem;
    font-weight: 500;
    text-align: center;
    margin-bottom: 5%;
    height: 15%;

    display: flex;
    align-items: end;
    justify-content: center;
}

.content-list {

    height: 45%;
    width: 100%;
    display: flex;
    flex-direction: column;

    gap: 2%;
    margin-bottom: 5%;
}

.content-list>p {
    font-size: 1.1rem;
    font-style: italic;
    font-weight: 400;
    margin-bottom: 2%;

}

.content-list--buton>button {
    border: none;
    background-color: var(--color-naranja);
    box-sizing: border-box;
    color: #fff;
    font-size: 0.9rem;

    padding: 2%;
    border-radius: 0.2vw;
}

.content-list--buton {
    width: 100%;
    height: 100%;

    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    align-items: start;
    justify-content: start;
    gap: 2%;

    box-sizing: border-box;
    padding: 2%;
}

.content-description--title {
    font-size: 1.1rem;
    font-style: italic;
    font-weight: 400;
    margin-bottom: 2%;
}

.content-description--description {
    box-sizing: border-box;
    padding: 2%;
    font-size: medium;
}
</style>
