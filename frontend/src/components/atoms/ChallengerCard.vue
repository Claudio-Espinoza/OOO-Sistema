<script setup lang="ts">
interface Props {
    title?: String,
    course?: String,
    type?: string
}

const props = defineProps<Props>();
</script>

<template>
    <div class="card">
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
    width: 31%;
    height: 15%;
    border: var(--borde);
    display: flex;
    align-items: center;
    justify-content: space-around;
    flex-direction: row;
    border-radius: 0.5vw;

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