<script setup lang="ts">
interface Props {
    title?: string,
    course?: string,
    type?: string
}

const props = defineProps<Props>();
const emits = defineEmits(['cardClicked']);


function handleClick() {
    emits('cardClicked', { title: props.title, course: props.course, type: props.type });
}
</script>

<template>
    <div class="card" @click="handleClick">
        <div :class="'card-img-' + props.type">
            <img v-if="props.type === 'java'" src="/src/assets/icon/java-blanco.png" alt="">
            <img v-if="props.type === 'python'" src="/src/assets/icon/python-blanco.png" alt="">
        </div>

        <div>
            <h4>{{ props.title }}</h4>
            <small> {{ props.course }} </small>
        </div>
    </div>
</template>

<style scoped>
.card {
    width: 30%;
    height: 15%;
    border: var(--borde);
    display: flex;
    align-items: center;
    justify-content: space-around;
    flex-direction: row;
    border-radius: 0.5vw;
    cursor: pointer;

}

.card:hover {
    transform: scale(1.05);
}

.card:active {
    transform: scale(1);
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
</style>