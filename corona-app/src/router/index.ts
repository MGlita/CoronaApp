import Vue from 'vue'
import VueRouter, { RouteConfig } from 'vue-router'
// @ts-ignore
import Home from '../views/Home.vue'

import Country from '../views/Country.vue'


Vue.use(VueRouter)

import axios from 'axios'
import VueAxios from 'vue-axios'
import L from 'leaflet';
Vue.use(VueRouter);
Vue.use(VueAxios, axios);


  const routes: Array<RouteConfig> = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/poland',
    name: 'Poland',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/Poland.vue')
  },
  {
    path: '/world',
    name: 'World',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/World.vue')
  },
  {
    path: '/country',
    name: 'Country',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    //component: () => import(/* webpackChunkName: "about" */ '../views/Country.vue')
    props:true,
    component: Country

  }
];

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
});

export default router
