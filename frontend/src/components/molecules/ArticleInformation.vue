<script setup lang="ts">
import axios from 'axios';
import { ArticleInformationProps } from '@/model/Challenger.ts';
import { ref } from 'vue'

const props = defineProps<ArticleInformationProps>();

const idDesafio = ref(props.id);

const handleDownload = async () => {
    try {
        const response = await axios.get(
            `http://localhost:8080/desafio/descargar-pdf/${idDesafio.value}`,
            {
                responseType: 'blob',
            }
        );
        const url = window.URL.createObjectURL(new Blob([response.data]));
        const link = document.createElement('a');
        link.href = url;
        link.setAttribute('download', `desafio-${idDesafio.value}.pdf`);
        document.body.appendChild(link);
        link.click();

        if (link.parentNode) {
            link.parentNode.removeChild(link);
        }
        window.URL.revokeObjectURL(url);
    } catch (error) {
        console.error('Hubo un error al descargar el PDF:', error);
    }
};

</script>

<template>
    <section class="container-section" v-if="props.title !== ''">
        <div class="title-img-java" v-if="props.type === 'java'">
            <img v-if="props.type === 'java'" src="/src/assets/icon/java-blanco.png" alt="" />
        </div>
        <div class="title-img-python" v-if="props.type === 'python'">
            <img v-if="props.type === 'python'" src="/src/assets/icon/python-blanco.png" alt="" />
        </div>

        <div class="information-title">
            <h3>{{ props.title }}</h3>
            <small>{{ props.subTitle }}</small>
        </div>

        <div class="information-review">
            <small><strong>Valoraciones negativas: </strong>
                {{ props.negativePoint }}</small>
            <small><strong>Valoraciones positivas:: </strong>
                {{ props.positivePoint }}</small>
            <small><strong>Autor: </strong> {{ props.autor }}</small>
        </div>

        <button class="information-buton" @click="handleDownload">Descargar desafio (.pdf)</button>
    </section>
</template>

<style scoped>
* {
    margin: 0;
    padding: 0;
}

.container-section {
    width: 100%;
    height: 100%;

    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: space-evenly;

    box-sizing: border-box;
}

.title-img-java,
.title-img-python {
    width: 30%;
    height: 30%;
    border-radius: 0.5vw;
    display: flex;
    align-items: center;
    justify-content: center;
}

.title-img-java {
    background-color: var(--color-naranja);
}

.title-img-python {
    background-color: var(--color-morado);
}

img {
    width: 75%;
    height: auto;
}

.information-title {
    display: flex;
    align-items: center;
    flex-direction: column;
}

.information-review {
    width: 60%;
    display: flex;
    align-items: start;
    flex-direction: column;
}

strong {
    font-weight: 500;
}

.information-title>small {
    font-style: italic;
}

.information-buton {
    border: 0.4vh solid var(--color-morado);
    color: var(--color-morado);
    border-radius: 0.8vw;
    width: 60%;
    height: 10%;
    font-weight: 500;
    cursor: pointer;
}

.information-buton:hover {
    cursor: pointer;
    transform: scale(1.05);
}

.information-buton:active {
    transform: scale(0.95);
    color: #fff;
    background-color: var(--color-morado);
    cursor: pointer;
}
</style>
