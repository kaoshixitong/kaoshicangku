import Vue from 'vue'
import App from './App.vue'
import router from './router'
import Vant from 'vant'
import 'vant/lib/index.css'
import axios from 'axios'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'

Vue.use(Vant)
Vue.use(ElementUI)
Vue.config.productionTip = false
Vue.prototype.$ajax = axios

new Vue({
	router,
	render: (h) => h(App),
}).$mount('#app')
