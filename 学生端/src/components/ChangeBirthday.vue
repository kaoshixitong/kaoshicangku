<template>
	<div class="changesex">
		<!-- 导航栏 -->
		<!-- <van-nav-bar title="生日修改" right-text="确定" @click-right="onClickRight">
			<template #left>
				<van-icon
					name="arrow-left"
					size="18"
					@click="onClickLeft"
					color="#969799"
				/>
			</template>
		</van-nav-bar> -->

		<!-- 生日选择 -->
		<van-datetime-picker
			v-model="currentDate"
			type="date"
			title="选择年月日"
			:min-date="minDate"
			:max-date="maxDate"
			@confirm="onClickRight"
			@cancel="onClickLeft"
		/>
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
			minDate: new Date(1900, 0, 1),
			maxDate: new Date(2025, 10, 1),
			currentDate: new Date(),
			nowData: '',
		}
	},
	methods: {
		onClickLeft() {
			this.$router.back(-1)
		},
		onClickRight() {
			// Toast('nice')
			console.log(this.currentDate)
			this.nowData = this.currentDate.toLocaleDateString()
			console.log(this.nowData)
			let ChangeBirthday = axios.create({
				baseURL: 'http://localhost:9090', //请求域名，基本路径
				headers: {
					Authorization: 'Bearer ' + this.AxiosHeader,
				}, //设置请求头
			})
			ChangeBirthday.put('/user/student/updateInformation', {
				student: { birthday: this.nowData },
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
