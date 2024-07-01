<script setup lang="ts">
import { useRouter } from 'vue-router';

const router = useRouter();

const handleButtonGo = (index: string) => {
    router.push("/roadmap/source/" + index);
}

interface Props {
    title: string,
    position: number,
    type: string
}

const props = defineProps<Props>();

const emit = defineEmits(['clicked']);

const handleButtonClick = (title: string) => {
    emit('clicked', title);
};

</script>

<template>
    <aside class="button">
        <div :class="'button-position-' + props.type.toLowerCase()">
            {{ props.position }}
        </div>
        <p class="button-title">
            {{ props.title }}
        </p>
        <button class="button-action" @click="handleButtonClick(props.title)">
            ver
        </button>
        <button class="button-action" @click="handleButtonGo(props.title)">
            Ingresar
        </button>
    </aside>
</template>

<style scoped>
* {
    margin: 0;
    padding: 0;
}

.button {
    width: 90%;
    height: 8%;

    background-color: var(--background-color);
    display: flex;
    flex-direction: row;

    align-items: center;
    justify-content: space-between;

    color: var(--font-color);
    font-family: var(--font-family);

    padding-left: 0.5vw;
    padding-right: 0.5vw;
    transition: all 0.2s;

    border: var(--borde);
    border-radius: 0.5vw;
}



.button-position-java {
    display: flex;
    align-items: center;
    justify-content: center;

    color: #fff;
    font-weight: 500;
    font-size: 1.2rem;
    width: 6%;
    height: 70%;

    border-radius: 0.2vw;
    background-color: var(--color-naranja);
}


.button-position-python {
    display: flex;
    align-items: center;
    justify-content: center;

    color: #fff;
    font-weight: 500;
    font-size: 1.2rem;
    width: 6%;
    height: 70%;

    border-radius: 0.2vw;
    background-color: var(--color-morado);
}

.button-title {
    color: var(--font-color);
    font-size: 1rem;
    font-weight: 400;
    width: 55%;
}

.button-action {
    background-color: var(--background-color);
    border: var(--borde);
    cursor: pointer;
    height: 60%;
    width: 15%;
    border-radius: 0.2vw;
}

.button-action:hover {
    transform: scale(1.05);
}

.button-action:active {

    transform: scale(0.95);
}
</style>
