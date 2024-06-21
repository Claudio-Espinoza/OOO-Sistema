<script setup lang="ts">
import MainLayout from '../layouts/MainLayout.vue';
import ArticleSection from '../components/organisms/ArticleSection.vue';
</script>

<template>
    <MainLayout>
        <article class="container-main">
            <ArticleSection />
            <div class="content">

            </div>

        </article>
    </MainLayout>
</template>

<style scoped>
.container-main {
    width: 95%;
    height: 100%;

    display: flex;
    flex-direction: row-reverse;
    align-items: center;
}

.content {
    width: 100%;
    height: 100%;
}
</style>
