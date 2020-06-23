<template>
	<div class="changesex">
		<!-- 导航栏 -->
		<van-nav-bar title="身份绑定" right-text="确定" @click-right="onClickRight">
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
			<van-field v-model="value" label="姓名" placeholder="请输入姓名" />
			<van-field
				v-model="value2"
				label="学号"
				placeholder="请输入学号"
				maxlength="10"
			/>
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
			value2: '',
		}
	},
	methods: {
		onClickLeft() {
			this.$router.back(-1)
		},
		onClickRight() {
			let BindName = axios.create({
				baseURL: 'http://localhost:9090', //请求域名，基本路径
				headers: {
					Authorization: 'Bearer ' + this.AxiosHeader,
				}, //设置请求头
			})
			BindName.put('/user/student/bindInformation', {
				studentId: this.value2,
				name: this.value,
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
