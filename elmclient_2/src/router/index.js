import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import Index from '../views/Index.vue'
import BusinessList from '../views/BusinessList.vue'
import Login from '../views/Login.vue'
import Orders from '../views/Orders.vue'
import UserAddress from '../views/UserAddress.vue'
import Payment from '../views/Payment.vue'
import OrderList from '../views/OrderList.vue'
import AddUserAddress from '../views/AddUserAddress.vue'
import EditUserAddress from '../views/EditUserAddress.vue'
import Register from '../views/Register.vue'
const routes = [
  {
    path: '/',
    name: 'home',
    component: Index
  },
  {
    path: '/index',
    name: 'Index',
    component: Index
  },
  {
    path: '/businessList',
    name: 'BusinessList',
    component: BusinessList
  },
  {
    path: '/businessInfo',
    name: 'BusinessInfo',
    component: BusinessInfo
  },
  {
    path: '/login',
    name: 'Login',
    component: Login
  },
  {
    path: '/orders',
    name: 'Orders',
    component: Orders
  },
  {
    path: '/userAddress',
    name: 'UserAddress',
    component: UserAddress
  },
  {
    path: '/payment',
    name: 'Payment',
    component: Payment
  }, {
    path: '/orderList',
    name: 'OrderList',
    component: OrderList
  },
  {
    path: '/addUserAddress',
    name: 'AddUserAddress',
    component: AddUserAddress
  },
  {
    path: '/editUserAddress',
    name: 'EditUserAddress',
    component: EditUserAddress
  },
  {
    path: '/register',
    name: 'Register',
    component: Register
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})



export default router
