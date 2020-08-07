import Vue from "vue"
import Router from "vue-router"
import Login from "./views/login.vue"
import Admin from "./views/admin.vue"
import Welcome from "./views/admin/welcome.vue"
import Course from "./views/admin/course.vue"
import Chapter from "./views/admin/chapter.vue"
import Section from "./views/admin/section.vue"
import User from "./views/admin/user.vue"

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
        path: "",
        component: Login //"/login"对应Login组件
    }, {
      path: "/login",
      component: Login //"/login"对应Login组件
    },{
      path: "/",
      name:"admin",
      component: Admin,
      children: [{
        path: "welcome",
        name:"welcome",
        component: Welcome,
      },{
        path: "business/course",
        name:"business/course",
        component: Course,
      },{
        path: "business/chapter",
        name:"business/chapter",
        component: Chapter,
      },{
        path: "business/section",
        name:"business/section",
        component: Section,
      },{
        path: "system/user",
        name:"system/user",
        component: User,
      }]
    }]
})

