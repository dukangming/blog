import Vue from "vue"
import Router from "vue-router"
import Login from "./views/login.vue"
import Admin from "./views/admin.vue"

Vue.use(Router);

export default new Router({
    mode: "history",
    //内置变量
    base: process.env.BASE_URL,
    routes: [{
        path: "*", //随意输入什么
        redirect: "/login", //跳转到"/login"
    }, {
        path: "",
        redirect: "/login",
    }, {
        path: "/login",
        component: Login //"/login"对应Login组件
    }, {
      path: "/admin",
      component: Admin
    }]
})
