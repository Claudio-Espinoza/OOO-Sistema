<script setup lang="ts">
import { Helper } from '@/model/Helper.ts';

const props = defineProps<Helper>();
</script>

<template>
    <div class="card">
        <div class="card-content">
            <img class="card-content--img" src="/src/assets/img/prueba.jfif" alt="">
            <h3 class="card-content--name">{{ props.name }}</h3>
            <small class="card-content--rol">{{ props.role }}</small>
        </div>
        <div class="card-red">
            <a v-if="props.isDiscord" href="https://discord.gg/CmbgBYFjUc" target="_blank"><img
                    src="/src/assets/icon/discord.png" alt=""></a>
            <a v-if="props.isWhatsApp" href="" target="_blank"><img src="/src/assets/icon/whatsapp.png" alt=""></a>
            <a v-if="props.isGitHub" href="" target="_blank"><img src="/src/assets/icon/github.png" alt=""></a>
        </div>

    </div>
</template>

<style scoped>
.card {
    width: 21%;
    height: 60%;
    transition: all 0.5s;
    border-radius: 1.5vh;
    flex-shrink: 0;
    border: var(--borde);
    box-shadow: 0.5vh 0.5vh 1vh rgba(0, 0, 0, 0.1);
    box-sizing: border-box;
    backdrop-filter: blur(1vh);
}

.card:hover {
    transform: scale(1.02);
}

.card-content {
    width: 100%;
    height: 80%;
    display: flex;
    align-items: center;
    justify-content: center;
    flex-direction: column;
}

.card-content--img {
    width: 60%;
    height: auto;
    border-radius: 100%;
    border: var(--borde);
    margin-bottom: 3vh;
}

.card-content--name {
    font-weight: 400;
    font-size: 1.5rem;
    color: #222;
}

.card-content--rol {
    font-weight: 300;
    font-size: 1.2rem;
    color: #222;
}

.card-red {
    height: 20%;
    width: 100%;
    display: flex;
    align-items: center;
    justify-content: center;
    gap: 1vw;
    flex-direction: row;
    box-sizing: border-box;
    border-top: var(--borde);
}

a>img {
    width: auto;
    height: 45%;
    cursor: pointer;
}

a {
    width: 20%;
    height: 100%;
    display: flex;
    align-items: center;
    justify-content: center;

}


a>img:hover {
    transform: scale(1.1);
}

a>img:active {
    transform: scale(0.95);
}
</style>
