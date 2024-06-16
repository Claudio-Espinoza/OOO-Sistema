<script setup lang="ts">
import ButonNav from '../atoms/ButonNav.vue';
import { ref, Ref } from 'vue';
import { useRouter } from 'vue-router';

const router = useRouter();

const props = defineProps({
    seccion: String
})
const emit = defineEmits(['clicked']);

const activeButton: Ref<string> = ref(props.seccion || 'Inicio');

const handleButtonClick = (title: string) => {
    activeButton.value = title;
    emit('clicked', activeButton.value);
};

function changePage(ruta: string): void {
    router.push(ruta)
}


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

        <section class="section-learning">
            <h2 class="learning-title">APRENDIZAJE</h2>
            <ButonNav title="Inicio" img="casa.png" imgAlternative="casa-blanca.png"
                :isActive="activeButton === 'Inicio'" @clicked="handleButtonClick" @click="changePage('/inicio')" />
            <ButonNav title="Cursos" img="libro.png" imgAlternative="libro-blanco.png"
                :isActive="activeButton === 'Cursos'" @clicked="handleButtonClick" @click="changePage('/cursos')" />
            <ButonNav title="Desafios" img="desafio.png" imgAlternative="desafio-blanco.png"
                :isActive="activeButton === 'Desafios'" @clicked="handleButtonClick" @click="changePage('/desafios')" />
        </section>

        <section class="section-comunity">
            <h2 class="learning-title">COMUNIDAD</h2>
            <ButonNav title="Ayudantes" img="personas.png" imgAlternative="personas-blanco.png"
                :isActive="activeButton === 'Ayudantes'" @clicked="handleButtonClick"
                @click="changePage('/ayudantes')" />
            <ButonNav title="Discord" img="libro.png" imgAlternative="libro-blanco.png"
                :isActive="activeButton === 'Discord'" @clicked="handleButtonClick" @click="changePage('/discord')" />
            <ButonNav title="WhatsApp" img="whatsapp.png" imgAlternative="whatsapp-blanco.png"
                :isActive="activeButton === 'Whatsapp'" @clicked="handleButtonClick" @click="changePage('/whatsapp')" />
        </section>


    </nav>
</template>

<style scoped>
.navbar-container {
    border-right: var(--borde);
    background-color: var(--background-color);

    width: 16%;
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

.section-learning {
    margin-top: 2vh;

    display: flex;
    flex-direction: column;
    gap: 1.5vh;
    height: 20%;
    width: 100%;

    align-items: end;
}

.learning-title {
    font-size: medium;
    font-weight: 500;
    color: #686868;
    width: 80%;

    margin: 0;
}


.section-comunity {
    margin-top: 6vh;
    display: flex;
    flex-direction: column;
    gap: 1.5vh;

    align-items: end;
    height: 20%;
    width: 100%;
}
</style>
