/// <reference types="vite/client" />
declare module '*.vue' {
  import { DefineComponent } from 'vue';
  const component: DefineComponent<{}, {}, any>;
}

declare module 'vue3-markdown-it' {
  import { Plugin } from 'vue';
  const VueMarkdownIt: Plugin;
  export default VueMarkdownIt;
}
