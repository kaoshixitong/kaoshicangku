<template>
	<div class="page">
		<van-nav-bar title="考试查看" fixed />
		<!-- 搜索框 -->
		<div class="con">
			<form action="/">
				<van-search
					v-model="value"
					placeholder="请输入试卷关键词"
					@search="onSearch"
				/>
			</form>
		</div>

		<!-- 搜索图标 -->
		<van-empty image="search" description="登录后查看考试">
			<van-button round type="info" class="bottom-button" @click="toLogin">
				立 即 登 录
			</van-button>
		</van-empty>

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
import { Toast } from 'vant'
export default {
	name: 'Records',
	data() {
		return {
			active: 'records',
			value: '',
		}
	},
	methods: {
		onSearch(val) {
			Toast(val)
		},
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
