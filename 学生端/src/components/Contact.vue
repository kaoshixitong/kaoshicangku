<template>
	<div class="page">
		<van-nav-bar title="个人中心" fixed />
		<router-view />

		<!-- 头部头像和姓名部分 -->
		<div class="people" @click="toLogin">
			<div class="people-img">
				<img class="img" src="../image/School.png" alt="" />
			</div>
			<div class="user-info">
				<span class="little_mar_bot">登录 | 注册</span>
				<br />
				<span><van-icon name="phone-o" /> 暂无绑定手机号</span>
			</div>
			<div class="head_float_right">
				<van-icon name="arrow" size="20px" />
			</div>
			<div class="clear_float"></div>
		</div>

		<!-- 中部单元格 -->
		<van-cell-group>
			<van-cell title="查看成绩" icon="eye-o" is-link @click="info" />
			<van-cell title="收藏题目" icon="star-o" is-link @click="info" />
			<van-cell title="考试日历" icon="underway-o" is-link @click="info" />
			<van-cell title="密码修改" icon="lock" is-link @click="info" />
			<van-cell title="信息修改" icon="info-o" is-link @click="info" />
			<van-cell title="反馈留言" icon="envelop-o" is-link @click="info" />
		</van-cell-group>

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
	name: 'Contact',
	data() {
		return {
			active: 'contact',
		}
	},
	methods: {
		toLogin() {
			this.$router.push({ path: '/login' })
		},
		info() {
			Toast('请先登录系统');
		},
	},
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.people {
	margin-top: 46px;
	position: relative;
	display: block;
	padding: 20px 10px;
}
.people-img {
	float: left;
	width: 60px;
	height: 60px;
	border-radius: 50%;
	overflow: hidden;
	vertical-align: top;
}
.img {
	height: 100%;
	width: 100%;
}
.user-info {
	float: left;
	margin-top: 8px;
	margin-left: 15px;
}
.little_mar_bot {
	margin-bottom: 5px;
	display: inline-block;
	font-size: 18px;
}
.head_float_right {
	float: right;
	margin-top: 20px;
}
.clear_float {
	clear: both;
}
</style>
