import { createRouter, createWebHistory } from 'vue-router'


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: () => import('../components/HelloWorld.vue'),
    },
 
    {
      path: '/test',
      name: 'test',
      component: () => import('../views/test.vue'),
    },
    {
      path: '/test2',
      name: 'test2',
      component: () => import('../views/test2.vue'),
    },
    {
      path: '/test3',
      name: 'test3',
      component: () => import('../views/test3.vue'),
    },
  ]
})

export default router
