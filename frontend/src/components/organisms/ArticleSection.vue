<script setup lang="ts">

interface Props {
    title: string,
    subTitle: string,
    view: string,
    review: string,
    autor: string,
    type: string
}

const props = defineProps<Props>();


</script>

<template>
    <article class="container-article">

        <section class="article-information">
            <div class="information-title">

                <div class="title-img-java" v-if="props.type === 'java'">
                    <img v-if="props.type === 'java'" src="/src/assets/icon/java-blanco.png" alt="">
                </div>
                <div class=" title-img-python" v-if="props.type === 'python'">
                    <img v-if="props.type === 'python'" src="/src/assets/icon/python-blanco.png" alt="">
                </div>

                <div class="information-title--info">
                    <h3>{{ props.title }}</h3>
                    <small>{{ props.subTitle }}</small>
                </div>
            </div>

            <div class="information-review">


            </div>


        </section>


    </article>

</template>

<style scoped>
.container-article {
    width: 35%;
    height: 95%;

    display: flex;
    flex-direction: column;
    align-items: center;

    box-sizing: border-box;
    border: var(--borde);
    border-radius: 0.5vw;
}

.article-information {
    width: 100%;
    height: 100%;

    display: flex;
    align-items: center;
    justify-content: center;

    flex-direction: column;
}

.article-description {
    width: 100%;
    height: 80%;

    display: flex;
    align-items: center;
    justify-content: center;
}



.information-title {
    height: 50%;
    width: 100%;

    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: space-evenly;
}

.information-review {
    height: 100%;
    width: 100%;

    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;

    background-color: rgb(44, 167, 172);
}


.title-img-java {
    background-color: var(--color-naranja);
    height: 45%;
    width: 30%;
    display: flex;
    align-items: center;
    justify-content: center;
    border-radius: 0.5vw;
}

.title-img-java>img {
    height: auto;
    width: 70%;
}


.title-img-python {
    background-color: var(--color-morado);
    height: 45%;
    width: 30%;
    display: flex;
    align-items: center;
    justify-content: center;
    border-radius: 0.5vw;
}

.title-img-python>img {
    height: auto;
    width: 70%;
}

.information-title--info>small {
    font-style: italic;
}
</style>
