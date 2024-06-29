import './assets/style/variables.css';
import './assets/style/style.css';

import { createApp } from 'vue';
import { createPinia } from 'pinia';
import VueMarkdownIt from 'vue3-markdown-it';

import App from './App.vue';
import router from './router';

const app = createApp(App);

app.use(createPinia());
app.use(router);
app.use(VueMarkdownIt);

app.mount('#app');
