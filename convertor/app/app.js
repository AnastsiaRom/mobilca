import Vue from 'nativescript-vue'
import Navigator from 'nativescript-vue-navigator'

import { routes } from '../routes/index'

import App from './App.vue'

Vue.use(Navigator, { routes })

new Vue({
  render: (h) => h(App),
}).$start()
