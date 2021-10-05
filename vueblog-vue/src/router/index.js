import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'

import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../views/Login.vue'
import BlogDetail from '../views/BlogDetail.vue'
import BlogEdit from '../views/BlogEdit.vue'


const routes = [
  {
    path: '/',
    name: 'Index',
    redirect: { name: 'Blogs' }
    // component: Home
  },
  {
    path: '/login',
    name: 'Login',
    component: Login
  },
  {
    path: '/blogs',
    name: 'Blogs',
    // 懒加载
    component: () => import('../views/Blogs.vue')
  },
  {
    path: '/blog/add', // 注意放在 path: '/blog/:blogId'之前
    name: 'BlogAdd',
    meta: {
      requireAuth: true
    },
    component: BlogEdit
  },
  {
    path: '/blog/:blogId',
    name: 'BlogDetail',
    component: BlogDetail
  },
  {
    path: '/blog/:blogId/edit',
    name: 'BlogEdit',
    meta: {
      requireAuth: true
    },
    component: BlogEdit
  }
  ,
  {
    path: '/home',
    name: 'Home',
    component: Home
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
