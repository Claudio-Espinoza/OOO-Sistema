<script setup lang="ts">
import { ChallengerCardProps } from '@/model/Challenger.ts'

const props = defineProps<ChallengerCardProps>();
const emits = defineEmits(['cardClicked']);


function handleClick() {
    emits('cardClicked', { title: props.title, course: props.course, type: props.type });
}
</script>

<template>
    <button class="card" @click="handleClick">
        <div :class="'card-img-' + props.type">
            <img v-if="props.type === 'java'" src="/src/assets/icon/java-blanco.png" alt="">
            <img v-if="props.type === 'python'" src="/src/assets/icon/python-blanco.png" alt="">
        </div>

        <div>
            <h4>{{ props.title }}</h4>
            <small> {{ props.course }} </small>
        </div>
    </button>
</template>

<style scoped>
.card {
    width: 28%;
    height: 15%;
    border: var(--borde);
    display: flex;
    align-items: center;
    justify-content: flex-start;
    flex-direction: row;
    border-radius: 0.5vw;
    cursor: pointer;
    font-size: 1rem;

}

small {
    font-style: italic;
}

.card-img-java,
.card-img-python {
    height: 80%;
    width: 18%;
    display: flex;
    align-items: center;
    justify-content: center;
    border-radius: 0.5vw;
    margin-right: 10%;
}

.card-img-java {
    background-color: var(--color-naranja);
}

.card-img-python {
    background-color: var(--color-morado);
}

.card-img-java>img,
.card-img-python>img {
    width: 70%;
    height: auto;
}

div {
    text-align: start;
}
</style>