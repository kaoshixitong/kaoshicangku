<template>
	<div class="changesex">
		<!-- 导航栏 -->
		<van-nav-bar title="班级修改" right-text="确定" @click-right="onClickRight">
			<template #left>
				<van-icon
					name="arrow-left"
					size="18"
					@click="onClickLeft"
					color="#969799"
				/>
			</template>
		</van-nav-bar>

		<!-- 性别选择栏 -->
		<van-radio-group v-model="radio">
			<van-cell-group>
				<van-cell title="1班" clickable @click="radio = '1'">
					<template #right-icon>
						<van-radio name="1" />
					</template>
				</van-cell>
				<van-cell title="2班" clickable @click="radio = '2'">
					<template #right-icon>
						<van-radio name="2" />
					</template>
				</van-cell>
			</van-cell-group>
		</van-radio-group>
	</div>
</template>

<script>
import axios from 'axios'
import { Toast } from 'vant'
export default {
	name: 'ChangeSex',
	props: ['AxiosHeader'],
	data() {
		return {
			radio: '',
		}
	},
	methods: {
		onClickLeft() {
			this.$router.back(-1)
		},
		onClickRight() {
			let ChangeClass = axios.create({
				baseURL: 'http://localhost:9090', //请求域名，基本路径
				headers: {
					Authorization: 'Bearer ' + this.AxiosHeader,
				}, //设置请求头
			})
			// Toast(this.radio)
			if (this.radio === '1') {
				ChangeClass.put('/user/student/updateInformation', {
					student: { classId: '1' },
				})
					.then((res) => {
						this.$router.back(-1)
						console.log(res)
					})
					.catch((err) => {
						console.log(err)
						Toast('操作失败，请稍后重试')
					})
			} else {
				ChangeClass.put('/user/student/updateInformation', {
					student: { classId: '2' },
				})
					.then((res) => {
						this.$router.back(-1)
						console.log(res)
					})
					.catch((err) => {
						console.log(err)
						Toast('操作失败，请稍后重试')
					})
			}
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
