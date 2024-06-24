<script setup lang="ts">
import { LandingProps } from '@/model/Landing.ts'

const props = defineProps<LandingProps>();
</script>

<template>
    <button :class="'button-' + props.type">
        {{ props.content }}
    </button>
</template>

<style scoped>
button {
    border: none;
    font-weight: 700;
    display: flex;
    place-content: center;
    align-items: center;
    width: 12vw;
    height: 8vh;
    border-radius: 0.5vw;
    box-sizing: border-box;
    padding: 2vh;
    cursor: pointer;

}

@layer introduccion {
    .button-intro {
        background-color: var(--color-gris);
        color: var(--font-color);
    }
}

@layer poo {
    .button-poo {
        background-color: var(--color-naranja);
        color: var(--font-color);
    }
}

@layer taller {
    .button-taller {
        background-color: var(--color-morado);
        color: #f2f2f2;
    }
}
</style>
