<script setup lang="ts">

</script>

<template>
    <header class="card-container">
        <div class="card-text">
            <p class="card-text--user">Desconocido</p>
            <small class="card-text--logger">Iniciar sesion</small>
        </div>
        <img src="/src/assets/icon/user.png" alt="">
    </header>

</template>

<style scoped>
.card-container {
    width: 14%;
    height: 70%;

    display: flex;
    border: var(--borde);
    border-radius: 0.5vw;

    align-items: center;
    justify-content: end;
}

.card-text {
    width: 100%;
    height: 100%;

    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
}

.card-text--user {
    padding: 0.5vh;
    font-size: large;
    font-weight: 700;
    color: var(--font-color);

    margin: 0;
}

.card-text--logger {
    font-size: medium;
    font-weight: 400;
    color: var(--color-morado);
    cursor: pointer;

    margin: 0;
    padding: 0;
}

.card-text--logger:hover {
    transform: scale(1.05)
}

.card-text--logger:active {
    transform: scale(1)
}
</style>
