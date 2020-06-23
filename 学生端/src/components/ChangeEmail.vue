<template>
	<div class="changesex">
		<!-- 导航栏 -->
		<van-nav-bar title="邮箱修改" right-text="确定" @click-right="onClickRight">
			<template #left>
				<van-icon
					name="arrow-left"
					size="18"
					@click="onClickLeft"
					color="#969799"
				/>
			</template>
		</van-nav-bar>

		<!-- 邮箱 -->
		<van-cell-group>
			<van-field v-model="value" label="邮箱" placeholder="请输入邮箱" />
		</van-cell-group>
	</div>
</template>

<script>
import axios from 'axios'
import { Toast } from 'vant'
export default {
	name: 'ChangeBirthday',
	props: ['AxiosHeader'],
	data() {
		return {
			value: '',
		}
	},
	methods: {
		onClickLeft() {
			this.$router.back(-1)
		},
		onClickRight() {
			let ChangeEmail = axios.create({
				baseURL: 'http://localhost:9090', //请求域名，基本路径
				headers: {
					Authorization: 'Bearer ' + this.AxiosHeader,
				}, //设置请求头
			})
			ChangeEmail.put('/user/student/updateInformation', {
				student: { email: this.value },
			})
				.then((res) => {
					this.$router.back(-1)
					console.log(res)
				})
				.catch((err) => {
					console.log(err)
					Toast('操作失败，请稍后重试')
				})
		},
	},
	created() {},
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.cell-name {
	color: #969799;
	margin-left: 30px;
}
</style>
