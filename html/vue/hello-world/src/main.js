import Vue from 'vue'
import App from './App.vue'
import Vant from 'vant';
import axios from 'axios'
import 'vant/lib/index.css';

Vue.use(Vant);
import { Uploader } from 'vant';
Vue.use(Uploader);
Vue.prototype.$axios = axios;

Vue.config.productionTip = false

new Vue({
  render: h => h(App),
}).$mount('#app')
