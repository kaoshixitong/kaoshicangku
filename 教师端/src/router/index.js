import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../components/Login.vue'
import HomePage from '../components/HomePage.vue'
import HomePageMain from '../views/HomePageMain.vue'

Vue.use(VueRouter)

const routes = [
	{
		path: '/',
		name: 'Home',
		component: Home,
		redirect: '/login',
	},
	{
		path: '/login',
		name: 'Login',
		component: Login,
	},
	{
		path: '/homepage',
		name: 'HomePage',
		component: HomePage,
		redirect: 'homepagemain',
		children: [
			{
				path: '/homepagemain',
				name: 'HomePageMain',
				component: HomePageMain,
			},
			{
				path: '/testenter1',
				name: 'TestEnter1',
				component: () =>
					import(/* webpackChunkName: "about" */ '../views/TestEnter1.vue'),
			},
			{
				path: '/testenter2',
				name: 'TestEnter2',
				component: () =>
					import(/* webpackChunkName: "about" */ '../views/TestEnter2.vue'),
			},
			{
				path: '/testenter3',
				name: 'TestEnter3',
				component: () =>
					import(/* webpackChunkName: "about" */ '../views/TestEnter3.vue'),
			},
			{
				path: '/newpaper',
				name: 'NewPaper',
				component: () =>
					import(/* webpackChunkName: "about" */ '../views/NewPaper.vue'),
			},
			{
				path: '/scoresearch',
				name: 'ScoreSearch',
				component: () =>
					import(/* webpackChunkName: "about" */ '../views/ScoreSearch.vue'),
			},
			{
				path: '/addstudent',
				name: 'AddStudent',
				component: () =>
					import(/* webpackChunkName: "about" */ '../views/AddStudent.vue'),
      },
      {
				path: '/addclass',
				name: 'AddClass',
				component: () =>
					import(/* webpackChunkName: "about" */ '../views/AddClass.vue'),
			},
			{
				path: '/querystudent',
				name: 'QueryStudent',
				component: () =>
					import(/* webpackChunkName: "about" */ '../views/QueryStudent.vue'),
      },
      {
				path: '/queryclass',
				name: 'QueryClass',
				component: () =>
					import(/* webpackChunkName: "about" */ '../views/QueryClass.vue'),
			},
			{
				path: '/createexam',
				name: 'CreateExam',
				component: () =>
					import(/* webpackChunkName: "about" */ '../views/CreateExam.vue'),
			},
			{
				path: '/changepsw',
				name: 'ChangePsw',
				component: () =>
					import(/* webpackChunkName: "about" */ '../views/ChangePsw.vue'),
			},
			{
				path: '/person',
				name: 'Person',
				component: () =>
					import(/* webpackChunkName: "about" */ '../views/Person.vue'),
      },
      {
				path: '/markpaper',
				name: 'MarkPaper',
				component: () =>
					import(/* webpackChunkName: "about" */ '../views/MarkPaper.vue'),
      },
      {
				path: '/examinfo',
				name: 'ExamInfo',
				component: () =>
					import(/* webpackChunkName: "about" */ '../views/ExamInfo.vue'),
			},
		],
	},
	// 懒加载
	// {
	// 	path: '/about',
	// 	name: 'About',
	// 	// route level code-splitting
	// 	// this generates a separate chunk (about.[hash].js) for this route
	// 	// which is lazy-loaded when the route is visited.
	// 	component: () =>
	// 		import(/* webpackChunkName: "about" */ '../views/About.vue'),
	// },
]

const router = new VueRouter({
	mode: 'history',
	base: process.env.BASE_URL,
	routes,
})

export default router
