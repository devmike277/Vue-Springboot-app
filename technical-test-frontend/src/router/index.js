/**
 * This file contains the declaration of the routes for
 * navigation between components
 */


import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import CreateTask from '../components/CreateTask.vue'
import EditTask from '../components/EditTask.vue'
import ListTasks from '../components/ListTasks.vue'
import TaskDetail from '../components/TaskDetail.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  {
    path: '/create-task',
    name: 'create-task',
    component: CreateTask
  },
  {
    path: '/edit-task/:id',
    name: 'edit-task',
    component: EditTask
  },
  {
    path: '/list-tasks',
    name: 'list-tasks',
    component: ListTasks
  },
  {
    path: '/task-detail/:id',
    name: 'task-detail',
    component: TaskDetail
  },

]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
