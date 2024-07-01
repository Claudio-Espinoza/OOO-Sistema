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
    path: '/roadmap/:id/:type',
    name: 'roadmap',
    component: () => import('../pages/RoadMapPage.vue'),
  },
  {
    path: '/roadmap/source/:id',
    name: 'source',
    component: () => import('../pages/SourcePage.vue'),
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
    path: '/comunidad',
    name: 'comunidad',
    component: () => import('../pages/ComunityPage.vue'),
  },
];

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes,
});

export default router;
