<template>
	<div class="page">
		<van-nav-bar
			title="在线考试系统"
			right-text="登录|注册"
			@click-right="onClickRight"
			fixed
		/>
		<!-- 轮播图 -->
		<!-- 懒加载 -->
		<div class="mar">
			<van-swipe :autoplay="3000">
				<van-swipe-item v-for="(image, index) in images" :key="index">
					<img v-lazy="image" class="img-size" />
				</van-swipe-item>
			</van-swipe>
		</div>
		<!-- 直接轮播 -->
		<!-- <div class="mar">
			<van-swipe class="my-swipe" :autoplay="3000" indicator-color="white">
				<van-swipe-item>1</van-swipe-item>
				<van-swipe-item>2</van-swipe-item>
				<van-swipe-item>3</van-swipe-item>
				<van-swipe-item>4</van-swipe-item>
			</van-swipe>
		</div> -->

		<!-- 课程推荐部分 -->
		<!-- 第一节课 -->
		<van-swipe-cell>
			<van-card
				desc="撸猫是一种学问，此门课程会教你如何撸猫，撸什么猫，怎样子撸猫"
				title="如何撸猫？"
				class="goods-card"
				thumb="https://img.yzcdn.cn/vant/cat.jpeg"
			/>
			<template #right>
				<van-button
					square
					text="删除"
					type="danger"
					class="delete-button"
					@click="del"
				/>
				<van-button
					square
					type="primary"
					text="收藏"
					class="delete-button"
					@click="collection"
				/>
			</template>
		</van-swipe-cell>
		<!-- 第二节课 -->
		<van-swipe-cell>
			<van-card
				desc="撸猫是一种学问，此门课程会教你如何撸猫，撸什么猫，怎样子撸猫"
				title="如何撸猫？"
				class="goods-card"
				thumb="https://img.yzcdn.cn/vant/cat.jpeg"
			/>
			<template #right>
				<van-button
					square
					text="删除"
					type="danger"
					class="delete-button"
					@click="del"
				/>
				<van-button
					square
					type="primary"
					text="收藏"
					class="delete-button"
					@click="collection"
				/>
			</template>
		</van-swipe-cell>
		<!-- 第三节课 -->
		<van-swipe-cell>
			<van-card
				desc="撸猫是一种学问，此门课程会教你如何撸猫，撸什么猫，怎样子撸猫"
				title="如何撸猫？"
				class="goods-card"
				thumb="https://img.yzcdn.cn/vant/cat.jpeg"
			/>
			<template #right>
				<van-button
					square
					text="删除"
					type="danger"
					class="delete-button"
					@click="del"
				/>
				<van-button
					square
					type="primary"
					text="收藏"
					class="delete-button"
					@click="collection"
				/>
			</template>
		</van-swipe-cell>
		<!-- 第四节课 -->
		<van-swipe-cell>
			<van-card
				desc="撸猫是一种学问，此门课程会教你如何撸猫，撸什么猫，怎样子撸猫"
				title="如何撸猫？"
				class="goods-card"
				thumb="https://img.yzcdn.cn/vant/cat.jpeg"
			/>
			<template #right>
				<van-button
					square
					text="删除"
					type="danger"
					class="delete-button"
					@click="del"
				/>
				<van-button
					square
					type="primary"
					text="收藏"
					class="delete-button"
					@click="collection"
				/>
			</template>
		</van-swipe-cell>

		<!-- 底部导航栏 -->
		<router-view />
		<van-tabbar v-model="active">
			<van-tabbar-item to="/page" name="home" icon="home-o"
				>首页</van-tabbar-item
			>
			<van-tabbar-item to="/chat" name="chat" icon="chat-o"
				>消息</van-tabbar-item
			>
			<van-tabbar-item to="/records" name="records" icon="records"
				>考试</van-tabbar-item
			>
			<van-tabbar-item to="/contact" name="contact" icon="contact"
				>我</van-tabbar-item
			>
		</van-tabbar>
	</div>
</template>

<script>
import axios from 'axios'
import { Toast } from 'vant'
import Vue from 'vue'
import { Lazyload } from 'vant'

Vue.use(Lazyload)
export default {
	name: 'Page',
	data() {
		return {
			info: null,
			active: 'home',
			images: [
				'https://edu-image.nosdn.127.net/ba2e1537e1a94b87b14918631471ec4c.jpg?imageView&quality=100&thumbnail=776y360',
				'https://edu-image.nosdn.127.net/d747cc9325264fb68d3dbd224b2522bf.png?imageView&quality=100&thumbnail=776y360',
				'https://edu-image.nosdn.127.net/6981461444c24998a7106c374f7b3ecd.png?imageView&quality=100',
				'https://edu-image.nosdn.127.net/c513f743f1db4a8298a5c0f47707ccea.png?imageView&quality=100',
			],
		}
	},
	methods: {
		onClickRight() {
			this.$router.push({ path: '/login' })
		},
		del() {
			Toast('删除成功')
		},
		collection() {
			Toast('收藏成功')
		},
	},
	created() {
		// let getTest = axios.create({
		// 	baseURL: 'http://aiwoqe.xyz:9090', //请求域名，基本路径
		// 	// baseURL: 'http://jsonplaceholder.typicode.com', //请求域名，基本路径
		// 	// timeout: 1000,//请求超时时常
		// 	// url:'/login',//请求路径
		// 	// method:'post',
		// 	// headers: {
		// 	//   Origin:'http://192.168.31.86:8080',
		// 	// 	Authorization:'Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1OTE0NDk5MjgsInVzZXJJZCI6MiwiaWF0IjoxNTkxMDE3OTI4LCJ1c2VybmFtZSI6IuWwj-e6oiJ9.aIc6WzkxMeppB4A21e9_5ZnvlVIMTKivEVHnRA-dLAU',
		// 	// }, //设置请求头
		// 	// params:{},//请求参数拼接在url
		// 	data: {
		// 		username: '小红',
		// 		password: '123',
		// 		roleId: 2,
		// 	}, //请求参数放在请求体里
		// })
		// getTest
		// 	.post('/login')
		// 	.then((res) => {
		// 		console.log(res)
		// 	})
		// 	.catch((err) => {
		// 		console.log(err)
		// 	})
		// getTest
		// 	.post('/login', {
		// 		username: '小红',
		// 		password: '123',
		// 		roleId: 2,
		// 	})
		// 	.then((res) => {
		// 		console.log(res)
		// 	})
		// 	.catch((err) => {
		// 		console.log(err)
		// 	})

		// axios.interceptors.request.use((config) => {
		// 	// config.data = JSON.stringify(config.data)
		// 	// config.headers = {
		// 	// 	'Content-Type': 'application/x-www-form-urlencoded',
		// 	// }
		// 	console.log('请求拦截器启用了')
		// 	// config.headers.Origin = "http://localhost:8080/page"
		// 	config.headers.Authorization = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1OTE1Mzg1ODEsInVzZXJJZCI6MiwiaWF0IjoxNTkxMTA2NTgxLCJ1c2VybmFtZSI6IuWwj-e6oiJ9.dWDUcLrQMWBv0yEV4Te8QEQC-03OFPH_Oxp0JkociFA"
		// 	return config
		// })
		// // getTest.defaults.crossDomain = true
		// axios
		// 	.get('http://aiwoqe.xyz:9090/user/admin/queryAllStudent')
		// 	.then((res) => {
		// 		console.log(res)
		// 	})
		// axios
		// 	.post('http://aiwoqe.xyz:9090/login', {
		// 		username: '小红',
		// 		password: '123',
		// 		roleId: 2,
		// 	})
		// 	.then((res) => {
		// 		console.log(res)
		// 	})
		// 	.catch((err) => {
		// 		console.log(err)
		// 	})
		// $.ajax({
		// 	type: 'POST',
		// 	url: 'http://aiwoqe.xyz:9090/login',
		// 	dataType: 'json',
		// 	data: { username: '小红', password: 123, roleId: 2 },
		// 	success: function(data) {
		// 		//提交成功后调用的方法
		// 		console.log(data)
		// 	},
		// 	error: function(e) {
		// 		console.log(e)
		// 	},
		// })
		// axios({
		// 	method: 'post',
		// 	url: 'http://aiwoqe.xyz:9090/login',
		// 	data: {
		// 		username: '小红',
		// 		password: 123,
		// 		roleId: 2,
		// 	},
		// })
		// 	.then((res) => {
		// 		console.log(res)
		// 	})
		// 	.catch((err) => {
		// 		console.log(err)
		// 	})

		//axios的form-data
		// let data = {
		// 	username: '小红',
		// 	password: 123,
		// 	roleId: 2,
		// }
		// let formData = new fromda()
		// for (let key in data) {
		// 	formData.appnd(key, data[key])
		// }
		// axios.post('http://aiwoqe.xyz:9090/login', formData).then(res => {
		// 	console.log(res)
		// })
	},
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.mar {
	margin-top: 46px;
}
.img-size {
	width: 100%;
	height: 186px;
}
.goods-card {
	margin: 0;
	background-color: white;
	/* height: 40px; */
}
div.van-swipe-cell__wrapper {
	height: 50px !important;
}
div.van-swipe-cell {
	height: 50px !important;
}
a.van-card__thumb {
	height: 40px !important;
	width: 40px !important;
}
div.van-image {
	height: 40px !important;
	width: 40px !important;
}
img.van-image__img {
	height: 35px !important;
	width: 35px !important;
}
.delete-button {
	height: 50px;
}
</style>
