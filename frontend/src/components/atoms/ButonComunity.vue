<script setup lang="ts">

interface Props {
    url: string,
    link: string
}

const props = defineProps<Props>();

</script>

<template>
    <button>
        <a href=""><img class="button-img" :src="props.url" alt=""></a>
    </button>

</template>

<style scoped>
button {
    width: 20%;
    height: 70%;
    background-color: var(--color-morado);
    border-radius: 1vh;
    border: none;
    border: var(border);
    overflow: hidden;
    transition: .3s cubic-bezier(.6, .4, 0, 1), transform .15s ease;
}

button:hover {
    background-color: var(--color-naranja);
    transform: scale(1.1);
}

button:active {
    background-color: var(--color-naranja);
    transform: scale(0.95);
}


.button-img {
    width: 70%;
    height: auto;
}
</style>
