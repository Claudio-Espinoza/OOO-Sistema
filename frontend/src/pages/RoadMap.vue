<script setup lang="ts">
import MainLayout from '../layouts/MainLayout.vue';


</script>

<template>
    <MainLayout>
        <section class="container-main">
            <article class="roadmap-list">
                <h2 class="roadmap-list-title">Conocimientos hitos de
                    <strong class="roadmap-list-decoration"> Introducción a <br> programación</strong>
                </h2>

                <section class="roadmap-list--button">

                </section>
            </article>
            <aside class="roadmap-description"></aside>
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
    width: 100%;
    height: 100%;
    flex-direction: column;
}

.roadmap-list-title {
    margin-top: 2%;
    text-align: left;
    font-size: 1.2rem;
    font-weight: 400;

    width: 70%;
    height: 10%;
    background-color: azure;

}

.roadmap-list-decoration {
    font-size: 1.2rem;
    font-weight: 500;
    color: var(--color-naranja);
}

.roadmap-list--button {
    display: flex;
    width: 100%;
    height: 100%;
    background-color: brown;
    flex-direction: column;
}


.roadmap-description {
    display: flex;
    width: 80%;
    height: 100%;
    background-color: aqua;
    flex-direction: column;
}
</style>
