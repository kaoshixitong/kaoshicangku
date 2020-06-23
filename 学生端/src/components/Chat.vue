<template>
	<div class="page">
		<van-nav-bar title="消息" fixed />
		<router-view />

		<!-- 搜索图标 -->
		<div class="con">
			<van-empty description="登录后查看消息">
				<van-button round type="info" class="bottom-button" @click="toLogin">
					立 即 登 录
				</van-button>
			</van-empty>
		</div>

		<!-- 底部导航栏 -->
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
import { Toast } from 'vant'
export default {
	name: 'Chat',
	data() {
		return {
			active: 'chat',
		}
	},
	methods: {
		toLogin() {
			this.$router.push({ path: '/login' })
		},
	},
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.con {
	margin-top: 46px;
}
.bottom-button {
	width: 160px;
}
</style>
