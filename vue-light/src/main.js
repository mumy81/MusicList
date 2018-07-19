import Vue from 'vue'
import VueRouter from 'vue-router'
import App from './App.vue'
import VueCookie from 'vue-cookie'





// LightBootstrap plugin
import LightBootstrap from './light-bootstrap-main'

// router setup
import routes from './routes/routes'
// plugin setup
Vue.use(VueRouter)
Vue.use(LightBootstrap)
Vue.use(VueCookie)

import VueGoodTablePlugin from 'vue-good-table';

// import the styles 
import 'vue-good-table/dist/vue-good-table.css'

Vue.use(VueGoodTablePlugin);


// configure router
const router = new VueRouter({
  routes, // short for routes: routes
  linkActiveClass: 'nav-item active'
})


/* eslint-disable no-new */
new Vue({
  el: '#app',
  render: h => h(App),
  router
})
