<template>
	<div class="login">
		<!-- <div class="bgc"></div> -->
		<div class="con">
			<center><h2 class="mar_bot">系统登录</h2></center>
			<van-form @submit="onSubmit">
				<van-field
					class="opa"
					v-model="teacherID"
					label="教工号"
					name="教工号"
					placeholder="请输入教工号"
					:rules="[{ required: true, message: '请填写教工号' }]"
				/>
				<van-field
					class="opa"
					id="password"
					v-model="password"
					label="密码"
					type="password"
					name="密码"
					placeholder="请输入密码"
					:rules="[{ required: true, message: '请填写密码' }]"
				>
					<template #button>
						<van-button @click="showPsw" class="icon_but">
							<van-icon v-show="!ifShowPsw" name="closed-eye" />
							<van-icon v-show="ifShowPsw" name="eye-o" />
						</van-button>
					</template>
				</van-field>
				<div style="margin: 16px;">
					<van-button block type="info" native-type="submit" @click="Login">
						提交
					</van-button>
				</div>
				<div class="toggle-login-pad">
					<div class="toggle-login">
						<span>没有账号？马上注册</span>
						<span>忘记密码？</span>
					</div>
				</div>
			</van-form>
		</div>
	</div>
</template>

<script>
import axios from 'axios'
import { Toast } from 'vant'
export default {
	name: 'Login',
	data() {
		return {
			axiosHeader: '',
			axiosData: '',
			teacherID: '',
			password: '',
			ifShowPsw: false,
		}
	},
	methods: {
		onSubmit(values) {
			console.log('submit', values)
		},
		showPsw() {
			this.ifShowPsw = !this.ifShowPsw
			var oUlook = document.getElementById('password')
			if (oUlook.type == 'password') {
				oUlook.type = 'text'
			} else {
				oUlook.type = 'password'
			}
		},
		Login() {
			axios
				.post('http://localhost:9090/login', {
					username: this.teacherID,
					password: this.password,
					roleId: 2,
				})
				.then((res) => {
					this.axiosHeader = res.headers.authorization
					this.axiosData = res.data.code
					this.$emit('getAxiosHeader', res.headers.authorization)
					// console.log(this.axiosData)
					// console.log(this.axiosHeader)
					// console.log(res)
					if (this.axiosData === 200) {
						// Toast('登录成功')
            this.$message.success('登录成功，欢迎您')
						this.$router.push({ path: '/homepage' })
					}
				})
				.catch((err) => {
					// Toast('登录失败，请稍后尝试')
					this.$message.error('登录失败，请稍后尝试')
					console.log(err)
				})
		},
	},
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
* {
	margin: 0;
	padding: 0;
}
/* .bgc {
	background-color: rgb(45, 58, 75);
	height: 100%;
	width: 100%;
	position: absolute;
	z-index: -1;
} */
.con {
	width: 400px;
	margin: 0 auto;
	padding-top: 200px;
}
.mar_bot {
	margin-bottom: 20px;
	/* color: white; */
}
.toggle-login-pad {
	padding: 0 20px;
}
.toggle-login {
	display: flex;
	justify-content: space-between;
	color: #1989fa;
}
.icon_but {
	width: 10px;
	height: 10px;
	border: 0;
	background: transparent;
}
/* .opa {
	background: transparent;
  color: white;
} */
</style>
