<script setup lang="ts">
import SourceLayout from '../layouts/SourceLayout.vue';
import MarkdownSection from '../components/molecules/MarkdownSection.vue'
</script>

<template>
    <SourceLayout>
        <article class="container-main">
            <MarkdownSection markdownFilePath="/src/data/clases.md" />
        </article>
    </SourceLayout>
</template>

<style scoped>
.container-main {
    overflow-y: scroll;
    width: 100%;
    display: flex;
    justify-content: center;
    align-items: start;
}
</style>
