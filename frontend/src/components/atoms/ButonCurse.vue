<script setup lang="ts">

interface Props {
    type: String,
    content: String
}

const props = defineProps<Props>();

</script>

<template>
    <button :class="'button-' + props.type">
        <img :src="'/src/assets/icon/' + props.type + '.png'" alt="">
        {{ props.content }}

    </button>
</template>

<style scoped>
button {
    box-sizing: border-box;
    width: 20vw;
    height: 60vh;

    box-shadow: 1vh 1vh 2vh rgba(0, 0, 0, 0.1);
    box-sizing: border-box;

    backdrop-filter: blur(1vh);
    border-radius: 1vw;

    text-align: center;
    cursor: pointer;
    transition: all 0.5s;

    display: flex;
    align-items: center;
    justify-content: space-evenly;
    user-select: none;
    color: var(--font-color);

    padding-left: 3vw;
    padding-right: 3vw;

    flex-direction: column;
    font-size: 1.2rem;
    font-weight: 600;
}


@layer java {
    .button-java {
        border: 0.4vh solid var(--color-naranja);
    }

    .button-java:hover {
        transform: scale(1.05);
    }

    .button-java:active {
        transform: scale(0.95);
    }
}

@layer python {
    .button-python {
        border: 0.4vh solid var(--color-morado);
    }

    .button-python:hover {
        transform: scale(1.05);
    }

    .button-python:active {
        transform: scale(0.95);
    }
}
</style>
