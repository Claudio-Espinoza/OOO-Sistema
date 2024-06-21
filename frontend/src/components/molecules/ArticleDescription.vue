<script setup lang="ts">

interface Props {
    description: string
}

const props = defineProps<Props>();


</script>

<template>
    <section class="container-section">
        <h4 class="section--h4">Descripcion del desafio</h4>
        <p class="section--p"> {{ props.description }}</p>
    </section>

</template>

<style scoped>
* {
    margin: 0;
    padding: 0;
}

.container-section {
    width: 80%;
    height: 80%;

    display: flex;
    flex-direction: column;
    align-items: start;

    box-sizing: border-box;
}

.section--h4 {
    margin-top: 10%;
    font-size: 1rem;
    font-weight: 500;
    margin-bottom: 2%;
}

.section--p {
    color: rgb(48, 48, 48);
    font-size: 0.8rem;
    font-weight: 400;
    margin-bottom: 2%;

    text-indent: 10%;
}
</style>
