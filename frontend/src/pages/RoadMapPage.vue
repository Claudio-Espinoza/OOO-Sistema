<script setup lang="ts">
import MainLayout from '../layouts/MainLayout.vue';
import ButonRoadMap from '../components/atoms/ButonRoadMap.vue';
import { ref, Ref, onMounted } from 'vue';
import CourseService from '@/service/CourseService.ts'
import { ILeccion } from '@/model/Course';
import { useRoute } from 'vue-router';

const router = useRoute()
const id = router.params.id;
const type = ref(router.params.type);

let milestonesSelected: Ref<string | string[]> = ref('');

let courses = ref<ILeccion[] | null>(null);
const courseService = new CourseService();

onMounted(async () => {
    courses.value = await courseService.fetchLectionForCourse(id);
});

const handleButtonClick = (title: string) => {
    milestonesSelected.value = title;
};

</script>

<template>
    <MainLayout>
        <section class="container-main">
            <article class="roadmap-list">
                <h2 class="roadmap-list-title">Conocimientos hitos de
                    <strong class="roadmap-list-decoration"> Introducción a <br> programación</strong>
                </h2>
                <section class="roadmap-list--button">
                    <ButonRoadMap v-for="(item, index) in courses" :key="index" :title="item.nombre"
                        :position="index + 1" :type="Array.isArray(type) ? type[0] : type"
                        @clicked="handleButtonClick" />
                </section>
            </article>

            <article class="roadmap-description">
                <aside class="description-content">
                    <h4>{{ milestonesSelected }}</h4>
                    <div v-if="milestonesSelected !== ''" class="content-description">
                        <p class="content-description--title">Descripcion del modulo: </p>
                        <p class="content-description--description">Lorem ipsum dolor sit amet, consectetur adipiscing
                            elit. Vivamus lacinia odio vitae vestibulum vestibulum. Cras venenatis euismod malesuada.
                            Nullam ac erat ante. Ut vehicula semper nisl, quis ornare magna mollis et. Maecenas id felis
                            eget sapien gravida dignissim. Nullam vitae orci neque. Fusce euismod nisi sit amet dolor
                            suscipit, nec convallis nibh ultricies. Integer nec justo non justo cursus consectetur vel
                            sed sapien. Ut dictum, urna sit amet bibendum viverra, arcu eros sollicitudin massa, et
                            viverra purus quam ac nisi. Vivamus vehicula congue lacus, ut facilisis purus facilisis vel.
                            Nulla facilisi. Sed ac dolor aliquam, finibus est in, efficitur ligula. Mauris sagittis
                            ipsum nec cursus facilisis.
                            <br>
                            <br>
                            Quisque ac nulla sed libero pharetra fringilla. Phasellus sed posuere eros. In congue dui
                            sit amet lectus ultricies, at sagittis enim posuere. Aenean quis sapien ac felis ornare
                            aliquam. Vivamus vitae risus eget lectus volutpat hendrerit. Maecenas id luctus magna. Nulla
                            nec dapibus purus. Morbi tincidunt, libero ut commodo l
                        </p>
                    </div>


                </aside>
            </article>
        </section>
    </MainLayout>
</template>

<style scoped>
.container-main {
    width: 95%;
    height: 100%;

    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: center;
}

.roadmap-list {
    display: flex;
    width: 85%;
    height: 100%;
    flex-direction: column;
}

.roadmap-list-title {
    margin-top: 4%;
    text-align: left;
    font-size: 1.2rem;
    font-weight: 400;

    width: 70%;
    height: 10%;

}

.roadmap-list-decoration {
    font-size: 1.2rem;
    font-weight: 500;
    color: var(--color-naranja);
}

.roadmap-list--button {
    margin-top: 3%;
    display: flex;
    width: 100%;
    height: 100%;
    flex-direction: column;
    gap: 2vh;
}

.roadmap-description {
    display: flex;
    width: 100%;
    height: 100%;
    align-items: center;
    justify-content: center;
}

.description-content {
    display: flex;
    width: 85%;
    height: 90%;
    flex-direction: column;
    justify-content: start;

    border: var(--borde);
    border-radius: 0.5vw;
    box-sizing: border-box;
    padding: 0% 10% 10% 5%;
}

h4 {
    font-size: 1.7rem;
    font-weight: 500;
    text-align: center;
    margin-bottom: 5%;
    height: 15%;

    display: flex;
    align-items: end;
    justify-content: center;
}

.content-list {

    height: 45%;
    width: 100%;
    display: flex;
    flex-direction: column;

    gap: 2%;
    margin-bottom: 5%;
}

.content-list>p {
    font-size: 1.1rem;
    font-style: italic;
    font-weight: 400;
    margin-bottom: 2%;

}

.content-list--buton>button {
    border: none;
    background-color: var(--color-naranja);
    box-sizing: border-box;
    color: #fff;
    font-size: 0.9rem;
    margin: 1%;
    padding: 2%;
    border-radius: 0.2vw;
}

.content-list--buton {
    width: 100%;
    height: 100%;

    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    align-items: start;
    justify-content: start;
    gap: 2%;

    box-sizing: border-box;
    padding: 2%;
}

.content-description--title {
    font-size: 1.1rem;
    font-style: italic;
    font-weight: 400;
    margin-bottom: 2%;
}

.content-description--description {
    box-sizing: border-box;
    padding: 2%;
    font-size: medium;
}
</style>
