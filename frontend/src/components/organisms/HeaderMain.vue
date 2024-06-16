<script setup lang="ts">
import UserCard from '../molecules/UserCard.vue'

interface Props {
    title: string;
}

const props = defineProps<Props>();



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
    font-size: 2.5rem;
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
