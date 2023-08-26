import{createRouter, createWebHistory} from 'vue-router'
import Index from '../views/index.vue'

const routes = [{
  path: '/',
  name: 'Home',
  component: Index
},{
  path: '/index',
  name: 'Index',
  component: Index
},
]
/*//解决重复路由报异常问题
const originalPush = createRouter().prototype.push;
createRouter().prototype.push = function push(location) {
  return originalPush.call(this, location).catch(err => err)
}*/
const router = createRouter({
  
  history :createWebHistory(),
  routes,
})
export default router
