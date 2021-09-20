import Vue from 'vue'
import Router from 'vue-router'
import layout from '@/layout/index'

Vue.use(Router)

export const constantRoutes = [
    {
      path: '/',
      name: 'layout',
      component: layout
    }
  ]
const createRouter = () => new Router({
  // mode: 'history', // require service support
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRoutes
})

const router = createRouter()


export function resetRouter() {
  const newRouter = createRouter()
  router.matcher = newRouter.matcher // reset router
}

export default router
