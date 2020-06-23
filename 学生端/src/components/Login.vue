<template>
	<div class="page">
		<!-- 导航栏--在线考试系统 -->
		<van-nav-bar
			title="在线考试系统"
			left-text="返回"
			left-arrow
			@click-left="onClickLeft"
		>
			<template #right>
				<!-- <van-icon name="search" size="18" /> -->
				<img class="titleimg" src="../image/SchoolBadge.jpg" />
			</template>
		</van-nav-bar>
		<div class="login-container">
			<div class="login-logo">
				<img src="../image/School.png" class="logo_img" />
			</div>
		</div>

		<!-- 登录 -->
		<van-form @submit="onSubmit" v-show="loginShow">
			<van-field
				v-model="studentUsername"
				name="用户名"
				label="用户名"
				placeholder="请输入用户名"
				:rules="[{ required: true, message: '请填写用户名' }]"
			/>
			<van-field
				v-model="password"
				type="password"
				name="密码"
				label="密码"
				placeholder="请输入密码"
				:rules="[{ required: true, message: '请填写密码' }]"
			/>
			<div style="margin: 16px;">
				<van-button block type="info" native-type="submit" @click="Login">
					登 录
				</van-button>
				<!-- <van-button block type="info" native-type="submit" @click="Test">
					测试
				</van-button> -->
			</div>
			<div class="toggle-login-pad">
				<div class="toggle-login">
					<span @click="toRegister">没有账号？马上注册</span>
					<span @click="toFindPsw">忘记密码？</span>
				</div>
			</div>
		</van-form>

		<!-- 注册 -->
		<van-form @submit="onSubmit" v-show="registerShow">
			<!-- <van-field
				v-model="newname"
				name="用户名"
				label="用户名"
				placeholder="请输入用户名"
				:rules="[{ required: true, message: '请填写用户名' }]"
			/> -->
			<van-field
				v-model="newname"
				center
				clearable
				label="用户名"
				placeholder="请输入用户名"
				:rules="[{ required: true, message: '请填写用户名' }]"
			>
				<template #button>
					<van-button size="small" type="primary" @click="queryUsername"
						>验证用户名</van-button
					>
				</template>
			</van-field>
			<!-- <van-field
				v-model="newstudentID"
				name="学号"
				label="学号"
				placeholder="请输入学号"
				:rules="[{ required: true, message: '请填写学号' }]"
			/> -->
			<van-field
				v-model="newpassword"
				type="password"
				name="密码"
				label="密码"
				placeholder="请输入密码"
				:rules="[{ required: true, message: '请填写密码' }]"
			/>
			<van-field
				v-model="newpassword2"
				type="password"
				name="确认密码"
				label="密码"
				placeholder="确认密码"
				:rules="[{ required: true, message: '请填写密码' }]"
			/>
			<van-field
				v-model="telphone"
				name="手机号"
				label="手机号"
				placeholder="请输入手机号"
				:rules="[{ required: true, message: '请填写手机号' }]"
			/>
			<div style="margin: 16px;">
				<van-button block type="info" native-type="submit" @click="register">
					注 册
				</van-button>
			</div>
			<div class="toggle-login-pad">
				<div class="toggle-login">
					<span @click="toLogin">已有账号？马上登录</span>
					<span @click="toFindPsw">忘记密码？</span>
				</div>
			</div>
		</van-form>

		<!-- 忘记密码 -->
		<van-form @submit="onSubmit" v-show="findpswShow">
			<van-field
				v-model="forgetstudentID"
				name="学号"
				label="学号"
				placeholder="请输入学号"
				:rules="[{ required: true, message: '请填写学号' }]"
			/>
			<van-field
				v-model="smsphone"
				center
				clearable
				label="短信验证码"
				placeholder="请输入短信验证码"
				:rules="[{ required: true, message: '请输入手机号' }]"
			>
				<template #button>
					<van-button size="small" type="info">发送验证码</van-button>
				</template>
			</van-field>
			<van-field
				v-model="forgetpassword"
				type="password"
				name="密码"
				label="密码"
				placeholder="请输入新密码"
				:rules="[{ required: true, message: '请填写密码' }]"
			/>
			<van-field
				v-model="forgetpassword2"
				type="password"
				name="确认密码"
				label="密码"
				placeholder="确认新密码"
				:rules="[{ required: true, message: '请填写密码' }]"
			/>
			<div style="margin: 16px;">
				<van-button block type="info" native-type="submit">
					登 录
				</van-button>
			</div>
			<div class="toggle-login-pad">
				<div class="toggle-login">
					<span @click="toLogin">已有账号？马上登录</span>
					<!-- <span>忘记密码？</span> -->
				</div>
			</div>
		</van-form>
	</div>
</template>

<script>
import axios from 'axios'
import { Toast } from 'vant'
import { Notify } from 'vant'
export default {
	name: 'Login',
	props: ['AxiosHeader'],
	data() {
		return {
			mes: 'test',
			studentUsername: '',
			password: '',
			// newstudentID: '',
			newpassword: '',
			newpassword2: '',
			newname: '',
			telphone: '',
			forgetstudentID: '',
			smsphone: '',
			forgetpassword: '',
			forgetpassword2: '',
			loginShow: true,
			registerShow: false,
			findpswShow: false,
			axiosHeader: '',
			axiosData: '',
		}
	},
	methods: {
		onClickLeft() {
			this.$router.back(-1)
		},
		onSubmit(values) {
			console.log('submit', values)
		},
		toLogin() {
			this.registerShow = false
			this.findpswShow = false
			this.loginShow = true
		},
		toRegister() {
			this.loginShow = false
			this.findpswShow = false
			this.registerShow = true
		},
		toFindPsw() {
			this.loginShow = false
			this.registerShow = false
			this.findpswShow = true
		},
		Login() {
			axios
				.post('http://localhost:9090/login', {
					username: this.studentUsername,
					password: this.password,
					roleId: 1,
				})
				.then((res) => {
					this.axiosHeader = res.headers.authorization
					this.axiosData = res.data.code
					this.$emit('getAxiosHeader', res.headers.authorization)
					// console.log(this.axiosData)
					// console.log(this.axiosHeader)
					// console.log(res)
					if (this.axiosData === 200) {
						Toast('登录成功')
						this.$router.push({ path: '/homepage' })
					}
				})
				.catch((err) => {
					Toast('登录失败，请稍后尝试')
					console.log(err)
				})
		},
		register() {
			axios
				.post('http://localhost:9090/register', {
					username: this.newname,
					password: this.newpassword,
					confirm: this.newpassword2,
					roleId: 1,
				})
				.then((res) => {
					console.log(res)
					Notify({ type: 'success', message: '注册成功' })
				})
				.catch((err) => {
					// Toast('注册失败，请稍后尝试')
					Notify({ type: 'warning', message: '注册失败，请稍后尝试' })
					console.log(err)
				})
		},
		queryUsername() {
			axios
				.get('http://localhost:9090/user/queryUsername', {
					params: {
						username: this.newname,
					},
				})
				.then((res) => {
					console.log(res)
					Toast('此用户名可用')
				})
				.catch((err) => {
					Toast('该用户名已存在，换个名字吧')
					console.log(err)
				})
		},
	},
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.titleimg {
	width: 40px;
}
.login-container {
	background-color: #f5f5f5;
	padding-top: 25px;
	padding-bottom: 15px;
}
.login-logo {
	width: 90%;
	margin: 0 auto;
	text-align: center;
	margin-bottom: 20px;
	background-image: url('../image/java.png'), url('../image/cplus.png'),
		url('../image/php.png'), url('../image/android.png'), url('../image/h5.png'),
		url('../image/ios.png'), url('../image/js.png'), url('../image/python.png');
	background-size: 50px 50px, 50px 50px, 50px 50px, 50px 50px, 44px 44px,
		32px 32px, 28px 28px, 32px 32px;
	background-repeat: no-repeat, no-repeat, no-repeat, no-repeat, no-repeat,
		no-repeat, no-repeat, no-repeat;
	background-position: 2% 5%, 95% 5%, 90% 40%, 12% 42%, 95% 80%, 5% 78%,
		80% 100%, 18% 100%;
}
.logo_img {
	height: 160px;
	border-radius: 50%;
}
.toggle-login-pad {
	padding: 0 20px;
}
.toggle-login {
	display: flex;
	justify-content: space-between;
	color: #1989fa;
}
</style>
