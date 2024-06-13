import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router';

const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    redirect: '/inicio',
  },
  {
    path: '/inicio',
    name: 'inicio',

    component: () => import('../pages/LandingPage.vue'),
  },
  {
    path: '/cursos',
    name: 'cursos',
    component: () => import('../pages/CoursePage.vue'),
  },
  {
    path: '/desafios',
    name: 'desafios',
    component: () => import('../pages/ChallengerPage.vue'),
  },
  {
    path: '/ayudantes',
    name: 'ayudantes',
    component: () => import('../pages/HelperPage.vue'),
  },
  {
    path: '/discord',
    name: 'discord',
    component: () => import('../pages/DiscordPage.vue'),
  },
  {
    path: '/whatsapp',
    name: 'whatsapp',
    component: () => import('../pages/WhatsPage.vue'),
  },
];

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes,
});

export default router;
