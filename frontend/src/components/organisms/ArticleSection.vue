<script setup lang="ts">
import ArticleDescription from '../molecules/ArticleDescription.vue';
import ArticleInformation from '../molecules/ArticleInformation.vue';

interface Props {
    title: string,
    subTitle: string,
    review: string,
    autor: string,
    type: string,
    description: string
}

const props = defineProps<Props>();


</script>

<template>
    <article class="container-article">
        <ArticleInformation :autor="props.autor" :review="props.review" :type="props.type" :sub-title="props.subTitle"
            :title="props.title" />

        <ArticleDescription :description="props.description" />

    </article>

</template>

<style scoped>
* {
    margin: 0;
    padding: 0;
}

.container-article {
    width: 38.8%;
    height: 100%;

    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;

    box-sizing: border-box;
    border-left: var(--borde);
}
</style>
