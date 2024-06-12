<script setup lang="ts">
import UserCard from '../molecules/UserCard.vue'


const props = defineProps({
    title: String
})



</script>

<template>
    <header class="header-container">
        <div class="header-subcontainer">
            <h1 class="header-title">{{ props.title }}</h1>
            <UserCard />
        </div>

    </header>

</template>

<style scoped>
.header-container {
    background-color: var(--background-color);
    border-bottom: var(--borde);
    width: 100%;
    height: 13%;

    display: flex;
    align-items: center;
    justify-content: center;
}

.header-title {
    font-size: 2.5vw;
    font-family: var(--font-family);
    color: var(--font-color);
}

.header-subcontainer {
    width: 95%;
    height: 100%;

    display: flex;
    align-items: center;
    justify-content: space-between;
}
</style>
