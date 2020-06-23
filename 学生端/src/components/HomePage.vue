<template>
	<div class="page">
		<van-nav-bar
			title="在线考试系统"
			right-text="个人中心"
			@click-right="onClickRight"
		/>

		<!-- 路由 -->
		<!-- <router-view
			@badgedown="downnum"
			@badgeup="upnum"
			@postPaperId="postPaperIdTo"
			:AxiosHeader="AxiosHeader"
		/> -->
		<router-view
			@badgedown="downnum"
			@badgeup="upnum"
			:AxiosHeader="AxiosHeader"
		/>

		<!-- 底部导航栏 -->
		<van-tabbar v-model="active">
			<van-tabbar-item to="/pagemain" name="home" icon="home-o"
				>首页</van-tabbar-item
			>
			<van-tabbar-item
				to="/chatsuccess"
				name="chat"
				icon="chat-o"
				:badge="badgenum"
				>消息</van-tabbar-item
			>
			<van-tabbar-item to="/recordsuccess" name="records" icon="records"
				>考试</van-tabbar-item
			>
			<van-tabbar-item to="/contactsuccess" name="contact" icon="contact"
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
	props: ['AxiosHeader'],
	data() {
		return {
			badgenum: 1,
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
			this.$router.push({ path: '/person' })
		},
		del() {
			Toast('删除成功')
		},
		collection() {
			Toast('收藏成功')
		},
		upnum() {
			this.badgenum++
		},
		downnum() {
			this.badgenum--
			if (this.badgenum === 0) this.badgenum = null
		},
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
