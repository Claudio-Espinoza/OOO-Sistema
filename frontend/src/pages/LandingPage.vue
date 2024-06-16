<script setup lang="ts">
import MainLayout from '../layouts/MainLayout.vue';
import ButonLanding from '../components/atoms/ButonLanding.vue';

</script>

<template>
    <MainLayout>
        <article class="container-main">
            <section class="main-info">
                <div>
                    <small class="info-small">Recibe y da apoyo</small>
                    <h1 class="info-title">Aprende diferentes conceptos de programación</h1>
                </div>

                <p class="info-context">¡Bienvenidos a nuestra agrupación de apoyo en la UFRO! Estamos aquí para
                    ayudarlos a fortalecer sus
                    conocimientos en 'Introducción a la Programación', 'Programación Orientada a Objetos' y 'Taller de
                    Programación'. Juntos, resolveremos dudas y compartiremos experiencias para asegurar su éxito
                    académico. ¡Vamos a explorar el apasionante mundo de la programación juntos!</p>
                <div class="info-button">
                    <ButonLanding type="intro" content="Introducción a Programación" />
                    <ButonLanding type="poo" content="Programación Orientada a Objeto" />
                    <ButonLanding type="taller" content="Taller de Programación" />
                </div>
            </section>
            <section class="main-img">
                <img class="img-codigo" src="/src/assets/img/codigo.png" alt="codigo">
                <div class="img-figura"></div>
                <img class="img-esteban" src="/src/assets/img/rey.png" alt="esteban">
            </section>
        </article>
    </MainLayout>
</template>

<style scoped>
.container-main {
    width: 95%;
    height: 100%;

    display: flex;
    flex-direction: row;
}




@layer info-container {
    .main-info {
        width: 100%;
        height: auto;
        gap: 4vh;
        display: flex;
        place-content: center;
        flex-direction: column;
    }

    .info-small {
        color: var(--color-morado);
        font-size: 1rem;
    }

    .info-title {
        font-size: 2rem;
        width: 80%;
    }

    .info-context {
        text-align: start;
        width: 80%;
    }

    .info-button {
        width: 80%;
        height: 25%;
        gap: 1vw;
        display: flex;
        align-items: end;
        flex-direction: row;
        flex-wrap: wrap;
    }


}

@layer img-container {
    .main-img {
        width: 100%;
        height: auto;

        display: flex;
        align-items: center;
        justify-content: start;
        position: relative;
    }

    .img-codigo {
        width: 80%;
        height: auto;
        border-radius: 1vw;
        z-index: 1;
    }

    .img-figura {
        position: absolute;
        width: 80%;
        height: 55.5%;
        background-color: var(--color-morado);
        z-index: 0;
        border-radius: 1vw;

        top: 19%;
        left: 4%;
    }

    .img-esteban {
        position: absolute;
        width: 35%;
        height: auto;
        z-index: 2;

        left: 57.5%;
        top: 55%;
    }
}
</style>
