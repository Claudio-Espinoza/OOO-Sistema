<script setup lang="ts">

interface Props {
    title: string,
    isActive: boolean
}

const props = defineProps<Props>();


</script>

<template>
    <button :class="'buton-container--' + props.isActive">
        <small class="buton-title"> {{ props.title }}</small>
    </button>
</template>

<style scoped>
.buton-container--false {
    border: none;
    width: 75%;
    height: 10vh;
    margin: 0;

    background-color: var(--background-color);
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: start;

    color: var(--font-color);
    font-family: var(--font-family);
    padding: 0.3vh 0.3vh 0.3vh 0.7vw;
    transition: all 0.2s;
    cursor: pointer;

}

.buton-container--false:hover {
    transform: scale(1.025);
    background: none;
}

.buton-container--true {
    width: 75%;
    height: 10vh;
    border: none;
    margin: 0;
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: start;

    color: #fff;
    font-family: var(--font-family);
    background-color: var(--color-morado);
    border-radius: 2vw 0vw 0vw 2vw;
    padding: 0.3vh 0.3vh 0.3vh 0.7vw;

    cursor: pointer;

}

.buton-img {
    height: auto;
    width: 13%;
    margin-right: 1vw;
}

.buton-title {
    font-size: 0.8rem;
    font-weight: 500;
}
</style>
