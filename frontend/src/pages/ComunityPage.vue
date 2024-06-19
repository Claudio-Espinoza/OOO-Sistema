<script setup lang="ts">
import MainLayout from '../layouts/MainLayout.vue';
import ButonComunity from '../components/atoms/ButonComunity.vue';
</script>

<template>
    <MainLayout>
        <article class="container-main">
            <article class="main-content">
                <div class="main-content-div">
                    <h2 class="content-text">¡Únete a nuestra <em>comunidad</em>!
                        <br>
                        !Forma parte de algo increíble!
                    </h2>
                    <small class="content-subtext">Accede a cualquiera de las tres plataformas disponibles.</small>

                </div>

                <p class="content-p">Únete a nuestra comunidad de aprendizaje de programación donde exploramos juntos el
                    mundo de la
                    programación, sin importar tu nivel de experiencia. Aquí encontrarás un ambiente acogedor para
                    compartir conocimientos, colaborar en proyectos emocionantes y crecer profesionalmente. ¡Únete a
                    nosotros en este apasionante viaje de descubrimiento y desarrollo de habilidades!
                </p>
                <div class="info-button">
                    <ButonComunity url="/src/assets/icon/github-blanco.png" />
                    <ButonComunity url="/src/assets/icon/whatsapp-blanco.png" />
                    <ButonComunity url="/src/assets/icon/discord-blanco.png" />
                </div>
            </article>

            <figure class="main-figure">
                <img src="/src/assets/img/rey-comunity.png" alt="">
            </figure>

        </article>
    </MainLayout>
</template>

<style scoped>
* {
    margin: 0;
    padding: 0;
}

.container-main {
    display: flex;
    flex-direction: row;

    align-content: center;
    justify-content: center;


    width: 95%;
    height: 100%;
}

.main-figure {
    width: 100%;
    height: 100%;
    align-content: center;
    justify-content: center;
}

.main-content {
    width: 100%;
    height: 100%;

    display: flex;
    flex-direction: column;

    align-items: start;
    justify-content: center;
    gap: 2vw;
}

.content-text {
    font-size: 2rem;
    font-weight: 500;
    width: 100%;
}

.content-text>em {
    font-style: normal;
    color: var(--color-morado);

}

.content-subtext {
    font-size: 1.1rem;
    font-style: italic;
    color: var(--color-naranja);
}

.content-p {
    font-size: 1rem;
}

.info-button {
    display: flex;
    align-items: center;
    gap: 2vw;

    height: 20%;
    width: 80%;

}

.main-content-div {
    width: 100%;
    height: 20%;
}
</style>
