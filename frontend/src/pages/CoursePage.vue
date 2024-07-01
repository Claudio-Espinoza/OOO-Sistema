<script setup lang="ts">
import MainLayout from '../layouts/MainLayout.vue';
import ButonCurse from '../components/atoms/ButonCurse.vue';
import { useRouter } from 'vue-router';
import { onMounted, ref } from 'vue';
import CourseService from '@/service/CourseService.ts'
import { ICurso } from '@/model/Course';

const router = useRouter();
const courseService = new CourseService();

let courses = ref<ICurso[] | null>(null);

const changePage = (id: number, type: string): void => {
    const ruta = `/roadmap/${id}/${type}`;
    router.push(ruta);
}

onMounted(async () => {
    courses.value = await courseService.fetchAllCourse();
});

</script>

<template>
    <MainLayout>
        <article class="container-main">
            <ButonCurse v-for="(item, index) in courses" :key="index" :content="item.nombre" :type="item.lenguaje"
                @click="changePage(item.id, item.lenguaje.toLowerCase())" />
        </article>
    </MainLayout>
</template>

<style scoped>
.container-main {
    width: 95%;
    height: 100%;

    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: space-evenly;
}
</style>
