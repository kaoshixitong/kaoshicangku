<template>
	<div class="changesex">
		<!-- 导航栏 -->
		<van-nav-bar title="学号修改" right-text="确定" @click-right="onClickRight">
			<template #left>
				<van-icon
					name="arrow-left"
					size="18"
					@click="onClickLeft"
					color="#969799"
				/>
			</template>
		</van-nav-bar>

		<!-- 学号修改栏 -->
		<van-field
			readonly
			clickable
			:value="value"
			@touchstart.native.stop="show = true"
			label="手机号"
		/>
		<van-number-keyboard
			v-model="value"
			:show="show"
			:maxlength="11"
			@blur="show = false"
			theme="custom"
			close-button-text="完成"
		/>
	</div>
</template>

<script>
import { NumberKeyboard } from 'vant'
import axios from 'axios'
import { Toast } from 'vant'
export default {
	name: 'ChangeStudentId',
	props: ['AxiosHeader'],
	data() {
		return {
			show: false,
			value: '',
		}
	},
	methods: {
		onClickLeft() {
			this.$router.back(-1)
		},
		onClickRight() {
      // console.log(this.value)
			let ChangeStudentId = axios.create({
				baseURL: 'http://localhost:9090', //请求域名，基本路径
				headers: {
					Authorization: 'Bearer ' + this.AxiosHeader,
				}, //设置请求头
			})
			ChangeStudentId.put('/user/student/updateInformation', {
				student: { phone: this.value },
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
	created() {
		// let getStudentId = axios.create({
		// 	baseURL: 'http://localhost:9090', //请求域名，基本路径
		// 	headers: {
		// 		Authorization: 'Bearer ' + this.AxiosHeader,
		// 	}, //设置请求头
		// })
		// getStudentId
		// 	.get('/user/student/queryInformation')
		// 	.then((res) => {
		// 		console.log(res)
		// 		// console.log(res.data.data)
		// 		this.value = res.data.data.student.studentId
		// 	})
		// 	.catch((err) => {
		// 		console.log(err)
		// 	})
	},
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.cell-name {
	color: #969799;
	margin-left: 30px;
}
</style>
