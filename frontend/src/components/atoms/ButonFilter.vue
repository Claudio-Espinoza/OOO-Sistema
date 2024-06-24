<script setup lang="ts">
import { ButonFilterProps } from '@/model/Challenger.ts';

const props = defineProps<ButonFilterProps>();
</script>

<template>
    <button :class="'button-' + props.state">{{ props.content }}</button>
</template>

<style scoped>
.button-false {
    width: 28%;
    height: 50%;

    border-radius: 0.5vw;
    border: var(--borde);
    font-size: 0.8rem;
    font-weight: 600;
    cursor: pointer;
}

.button-true {
    width: 28%;
    height: 50%;
    border-radius: 0.5vw;
    border: 0.4vh solid var(--color-morado);
    font-size: 0.8rem;
    font-weight: 600;
    color: #fff;
    background-color: var(--color-morado);
    cursor: pointer;
}
</style>
