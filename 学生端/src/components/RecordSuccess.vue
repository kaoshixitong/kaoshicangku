<template>
	<div class="page">
		<van-nav-bar title="考试查看" fixed left-arrow @click-left="onClickLeft" />
		<!-- 搜索框 -->
		<form action="/">
			<van-search
				v-model="value"
				placeholder="请输入试卷关键词"
				@search="onSearch"
			/>
		</form>

		<!-- <button @click="To">考试</button> -->

		<van-cell-group v-for="(allExam, index) in allExams" :key="index">
			<!-- <van-cell value="点击开始考试" is-link @click="goExam(index)" :to="{ name: 'answer', params: { paperId: this.paperID } }"> -->
			<van-cell value="点击开始考试" is-link @click="goExam(index)">
				<template #title>
					<span class="custom-title">
						{{ allExam.name }}
					</span>
				</template>
			</van-cell>
		</van-cell-group>
	</div>
</template>

<script>
import { Toast } from 'vant'
import axios from 'axios'
export default {
	name: 'Records',
	props: ['AxiosHeader'],
	data() {
		return {
			active: 'records',
			value: '',
			allExams: [],
			paperID: -1,
			examID: -1,
		}
	},
	methods: {
		onSearch(val) {
			Toast(val)
		},
		To() {
			this.$router.push({ path: '/answer' })
		},
		goExam(mes) {
			this.paperID = this.allExams[mes].paperId
			this.examID = this.allExams[mes].examId
			console.log(this.paperID)
			this.$emit('postPaperId', this.paperID, this.examID)
			this.$router.push({ path: '/answer' })
		},
		onClickLeft() {
			this.$router.back(-1)
		},
	},
	created() {
		let queryAll = axios.create({
			baseURL: 'http://localhost:9090', //请求域名，基本路径
			headers: {
				Authorization: 'Bearer ' + this.AxiosHeader,
			}, //设置请求头
		})
		queryAll
			.get('/exam/exam/queryAll')
			.then((res) => {
				this.allExams = res.data.data
				console.log(res)
			})
			.catch((err) => {
				console.log(err)
			})
	},
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped></style>
