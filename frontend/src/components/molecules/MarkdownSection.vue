<script setup>
import { ref, onMounted } from 'vue';
import Markdown from 'vue3-markdown-it';

const props = defineProps({
  markdownFilePath: String
});

const markdownContent = ref('');

onMounted(async () => {
  if (props.markdownFilePath) {
    const response = await fetch(props.markdownFilePath);
    if (response.ok) {
      const text = await response.text();
      markdownContent.value = text;
    } else {
      console.error('Failed to load markdown file', response.status);
    }
  }
});


</script>

<template>
  <div class="markdown-content">

    <Markdown :source="markdownContent" />
  </div>
</template>
