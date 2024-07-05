<script setup lang="ts">
import { ChallengerCardProps } from '@/model/Challenger.ts';
import { useCounterStore } from '@/storage/UseStorage.ts';
import { computed } from 'vue';
import ChallengerService from '@/service/ChallengerService';

const store = useCounterStore();
const rol = computed(() => store.rol);
const props = defineProps<ChallengerCardProps>();
const emits = defineEmits(['cardClicked', 'challengerDeleted', 'updateChallengers']);

function handleClick() {
  emits('cardClicked', { title: props.title, course: props.course, type: props.type });
}

async function handleDelete() {
  if (props.id) {
    await ChallengerService.deleteChallenger(Number(props.id));
    emits('challengerDeleted', props.id);
    emits('updateChallengers');
  }
}
</script>


<template>
  <button class="card" @click="handleClick">
    <div :class="'card-img-' + props.type">
      <img v-if="props.type === 'java'" src="/src/assets/icon/java-blanco.png" alt="">
      <img v-if="props.type === 'python'" src="/src/assets/icon/python-blanco.png" alt="">
    </div>

    <div>
      <button v-if="rol === 'ADMINISTRADOR'" class="deleteButton" @click.stop="handleDelete">
        <img src="/src/assets/icon/Boton-eliminar.png">
      </button>
      <h4>{{ props.title }}</h4>
      <small>{{ props.course }}</small>
    </div>
  </button>
</template>

<style scoped>
.card {
  width: 28%;
  height: 15%;
  border: var(--borde);
  display: flex;
  align-items: center;
  justify-content: space-between;
  flex-direction: row;
  border-radius: 0.5vw;
  cursor: pointer;
  font-size: 1rem;
  position: relative;
}

small {
  font-style: italic;
  font-size: 80%;
}

h4 {
  font-size: 100%;
  font-weight: 500;
}

.card-img-java,
.card-img-python {
  height: 80%;
  width: 18%;
  display: flex;
  align-items: center;
  justify-content: center;
  border-radius: 0.5vw;
}

.card-img-java {
  background-color: var(--color-naranja);
}

.card-img-python {
  background-color: var(--color-morado);
}

.card-img-java > img,
.card-img-python > img {
  width: 70%;
  height: auto;
}

div {
  text-align: start;
  width: 78%;
  height: 100%;
  flex-direction: column;
  display: flex;
  align-items: start;
  justify-content: center;
}

.deleteButton {
  position: absolute;
  width: 10%;
  height: 30%;
  top: 3%;
  right: 2%;
}

.deleteButton img {
  display: block;
  width: 100%;
  height: 100%;
}
</style>
