<script setup lang="ts">
import SourceNav from '../components/organisms/SourceNav.vue';


</script>

<template>
    <SourceNav />
    <main class="container">
        <slot>


        </slot>
    </main>

</template>

<style scoped>
.container {
    background-color: var(--background-color);
    width: 100%;
    height: 100%;
    display: flex;
    flex-direction: column;
    align-items: center;

}
</style>
