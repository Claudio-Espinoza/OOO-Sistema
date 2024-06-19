<script setup lang="ts">

interface Props {
    url: string
}

const props = defineProps<Props>();

</script>

<template>
    <button>
        <img class="button-img" :src="props.url" alt="">

    </button>
</template>

<style scoped>
button {
    width: 20%;
    height: 70%;
    background-color: var(--color-naranja);
    border-radius: 1vh;
    border: none;
    border: var(border);
}

.button-img {
    width: 70%;
    height: auto;
}
</style>
