<script setup lang="ts">
import { ButonCurseProps } from '@/model/Course.ts';

const props = defineProps<ButonCurseProps>();
</script>

<template>
    <button :class="'button-' + props.type.toLowerCase()">
        <img :src="'/src/assets/icon/' + props.type.toLowerCase() + '.png'" alt="">
        {{ props.content }}
    </button>
</template>

<style scoped>
button {
    box-sizing: border-box;
    width: 20vw;
    height: 60vh;

    box-shadow: 1vh 1vh 2vh rgba(0, 0, 0, 0.1);

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
}

@layer python {
    .button-python {
        border: 0.4vh solid var(--color-morado);
    }
}
</style>
