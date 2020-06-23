import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Page from '../components/Page.vue'
import Chat from '../components/Chat.vue'
import Records from '../components/Records.vue'
import Contact from '../components/Contact.vue'
import Login from '../components/Login.vue'
import Person from '../components/Person.vue'
import HomePage from '../components/HomePage.vue'
import ChangeSex from '../components/ChangeSex.vue'
import ChangeClass from '../components/ChangeClass.vue'
import ChangeIphone from '../components/ChangeIphone.vue'
import ChangeBirthday from '../components/ChangeBirthday.vue'
import ChangeEmail from '../components/ChangeEmail.vue'
import BindName from '../components/BindName.vue'
import Answer from '../components/Answer.vue'
// import QueryScore from '../components/QueryScore.vue'
import QueryAllExam from '../components/QueryAllExam.vue'
import RecordSuccess from '../components/RecordSuccess.vue'


Vue.use(VueRouter)

const routes = [
	{
		path: '/',
		name: 'Home',
		component: Home,
		redirect: '/page',
	},
	{
		path: '/page',
		name: 'Page',
		component: Page,
	},
	{
		path: '/contact',
		name: 'Contact',
		component: Contact,
	},
	{
		path: '/records',
		name: 'Records',
		component: Records,
	},
	{
		path: '/chat',
		name: 'Chat',
		component: Chat,
	},
	{
		path: '/login',
		name: 'Login',
		component: Login,
	},
	{
		path: '/person',
		name: 'Person',
		component: Person,
	},
	{
		path: '/changesex',
		name: 'ChangeSex',
		component: ChangeSex,
	},
	{
		path: '/changeclass',
		name: 'ChangeClass',
		component: ChangeClass,
	},
	{
		path: '/changeiphone',
		name: 'ChangeIphone',
		component: ChangeIphone,
	},
	{
		path: '/changebirthday',
		name: 'ChangeBirthday',
		component: ChangeBirthday,
	},
	{
		path: '/changeemail',
		name: 'ChangeEmail',
		component: ChangeEmail,
	},
	{
		path: '/bindname',
		name: 'BindName',
		component: BindName,
	},
	{
		path: '/answer',
		name: 'Answer',
		component: Answer,
  },
  {
		path: '/recordsuccess',
		name: 'RecordSuccess',
		component: RecordSuccess,
	},
	// {
	// 	path: '/queryscore',
	// 	name: 'QueryScore',
	// 	component: QueryScore,
	// },
	{
		path: '/queryallexam',
		name: 'QueryAllExam',
		component: QueryAllExam,
		// children: [
		// 	{
		// 		path: '/queryscore',
		// 		name: 'QueryScore',
		// 		component: () => import('../components/QueryScore.vue'),
		// 	},
		// ],
	},
	{
		path: '/homepage',
		name: 'HomePage',
		component: HomePage,
		redirect: 'pagemain',
		children: [
			{
				path: '/pagemain',
				name: 'PageMain',
				component: () => import('../views/HomePage/PageMain.vue'),
			},
			{
				path: '/chatsuccess',
				name: 'ChatSuccess',
				component: () => import('../views/HomePage/ChatSuccess.vue'),
			},
			{
				path: '/contactsuccess',
				name: 'ContactSuccess',
				component: () => import('../views/HomePage/ContactSuccess.vue'),
			},
			// {
			// 	path: '/recordssuccess',
			// 	name: 'RecordsSuccess',
			// 	component: () => import('../views/HomePage/RecordsSuccess.vue'),
			// },
		],
	},
]

const router = new VueRouter({
	mode: 'history',
	base: process.env.BASE_URL,
	routes,
})

export default router
