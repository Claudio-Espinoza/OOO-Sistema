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

<style scoped>
.markdown-content {
  font-family: 'Helvetica', 'Arial', sans-serif;
  line-height: 1.6;
  max-width: 100%;
  box-sizing: border-box;
  padding: 5%;
  margin: auto;
}

.markdown-content h1,
.markdown-content h2,
.markdown-content h3 {
  color: #333;
}

.markdown-content p {
  margin-bottom: 1em;
}

.markdown-content a {
  color: #0366d6;
  text-decoration: none;
}

.markdown-content a:hover {
  text-decoration: underline;
}

.markdown-content blockquote {
  border-left: 4px solid #ddd;
  padding-left: 16px;
  color: #666;
  margin-left: 0;
  margin-right: 0;
}

.markdown-content code {
  background-color: #f4f4f4;
  padding: 2px 4px;
  border-radius: 4px;
  font-family: 'Courier New', monospace;
}

.markdown-content pre {
  background-color: #f4f4f4;
  padding: 8px;
  border-radius: 4px;
  overflow-x: auto;
}
</style>
