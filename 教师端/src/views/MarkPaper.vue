<template>
	<div class="createxam">
		<!-- 面包屑 -->
		<el-breadcrumb separator-class="el-icon-arrow-right">
			<el-breadcrumb-item :to="{ path: '/homepagemain' }"
				>考试管理</el-breadcrumb-item
			>
			<el-breadcrumb-item>在线阅卷</el-breadcrumb-item>
		</el-breadcrumb>

		<!-- 全部考试 -->
		<div class="tabs">
			<template>
				<el-table
					:data="tableData"
					stripe
					style="width: 100%"
					v-show="allexamshow"
				>
					<el-table-column label="考试名称" prop="name"> </el-table-column>
					<el-table-column label="开始时间" prop="begin"> </el-table-column>
					<el-table-column label="结束时间" prop="end"> </el-table-column>
					<el-table-column label="考试时长(分钟)" prop="during">
					</el-table-column>
					<el-table-column align="right">
						<template slot-scope="scope">
							<el-button
								size="mini"
								@click="handleEdit(scope.$index, scope.row)"
								>阅卷</el-button
							>
						</template>
					</el-table-column>
				</el-table>
			</template>

			<!-- 考试学生 -->
			<template>
				<el-table
					:data="examStudent"
					stripe
					style="width: 100%"
					v-show="allstudentshow"
				>
					<el-table-column label="姓名" prop="name"> </el-table-column>
					<el-table-column label="学号" prop="studentId"> </el-table-column>
					<el-table-column label="用户名" prop="username"> </el-table-column>
					<el-table-column align="right">
						<template slot-scope="scope">
							<el-button size="mini" @click="getPaper(scope.$index, scope.row)"
								>阅卷</el-button
							>
						</template>
					</el-table-column>
				</el-table>
			</template>

			<!-- 学生作答 -->
			<el-card
				class="box-card"
				v-for="(exam, index) in exams"
				:key="index"
				style="margin-bottom:40px"
				v-show="answershow"
			>
				<div slot="header" class="clearfix">
					<div>
						<span class="papaertitle"><b>题目：</b></span>
						<span>({{ exam.score }}分)</span>
						<br /><br />
						{{ exam.title }}
					</div>
				</div>
				<div>
					<span class="papaertitle"><b>学生作答：</b></span>
					<br /><br />
					{{ exam.essayAnswer }}
				</div>
				<el-divider></el-divider>
				<div>
					<span class="papaertitle"><b>标准答案：</b></span>
					<br /><br />
					{{ exam.reference }}
				</div>
				<el-divider></el-divider>
				<div>
					<el-input
						placeholder="请输入分数"
						v-model="input[nowIndex]"
						clearable
					>
						<template slot="prepend">
							<el-button type="primary" @click="nowIndex = index"
								>提交题号</el-button
							>
						</template>
						<template slot="append">
							<el-button type="primary" @click="submit">提交分数</el-button>
						</template>
					</el-input>
				</div>
			</el-card>
		</div>
	</div>
</template>

<script>
import axios from 'axios'
export default {
	props: ['AxiosHeader'],
	data() {
		return {
			nowIndex: -1,
			input: [],
			allexamshow: true,
			allstudentshow: false,
			answershow: false,
			tableData: [],
			examStudent: [],
			exams: [],
			exam: '',
			examID: '',
			userID: '',
		}
	},
	methods: {
		getPaper(index, row) {
			this.userID = this.examStudent[index].userId
			console.log(this.userID)
			let getPaper = axios.create({
				baseURL: 'http://localhost:9090', //请求域名，基本路径
				headers: {
					Authorization: 'Bearer ' + this.AxiosHeader,
				}, //设置请求头
			})
			getPaper
				.get('/teacher/score/queryEssayList', {
					params: {
						examId: this.examID,
						userId: this.userID,
					},
				})
				.then((res) => {
					this.exams = res.data.data
					this.allstudentshow = !this.allstudentshow
					this.answershow = !this.answershow
					console.log(res)
				})
				.catch((err) => {
					console.log(err)
					this.$message.error('操作失败，请稍后尝试')
				})
		},
		submit() {
			console.log(this.input[this.nowIndex])
			let submitScore = axios.create({
				baseURL: 'http://localhost:9090', //请求域名，基本路径
				headers: {
					Authorization: 'Bearer ' + this.AxiosHeader,
				}, //设置请求头
			})
			submitScore
				.put('/teacher/score/submitScore', {
					essayScoreList: [
						{
							essayAnswer: this.exams[this.nowIndex].essayAnswer,
							essayAnswerId: this.exams[this.nowIndex].essayAnswerId,
							essayAnswerScore: this.input[this.nowIndex],
							essayId: this.exams[this.nowIndex].essayId,
							reference: '略',
							// score: this.input[this.nowIndex],
							score: this.exams[this.nowIndex].score,
							title: this.exams[this.nowIndex].title,
						},
					],
					examId: this.examID,
					userId: this.userID,
				})
				.then((res) => {
					console.log(res)
					this.$message.success('评分成功')
				})
				.catch((err) => {
					console.log(err)
					this.$message.error('操作失败，请稍后尝试')
				})
		},
		handleEdit(index, row) {
			this.examID = this.tableData[index].examId
			console.log(this.examID)
			let paper = axios.create({
				baseURL: 'http://localhost:9090', //请求域名，基本路径
				headers: {
					Authorization: 'Bearer ' + this.AxiosHeader,
				}, //设置请求头
			})
			paper
				.get('/teacher/score/queryExamUser', {
					params: {
						examId: this.examID,
						page: '1',
						size: '999',
					},
				})
				.then((res) => {
					console.log(res)
					this.examStudent = res.data.data
					this.allexamshow = !this.allexamshow
					this.allstudentshow = !this.allstudentshow
				})
				.catch((err) => {
					console.log(err)
					this.$message.error('操作失败，请稍后尝试')
				})
		},
	},
	created() {
		let getAll = axios.create({
			baseURL: 'http://localhost:9090', //请求域名，基本路径
			headers: {
				Authorization: 'Bearer ' + this.AxiosHeader,
			}, //设置请求头
		})
		getAll
			.get('/exam/exam/queryAll', {
				params: {
					page: '1',
					size: '999',
				},
			})
			.then((res) => {
				console.log(res)
				this.tableData = res.data.data
			})
			.catch((err) => {
				console.log(err)
				this.$message.error('操作失败，请稍后尝试')
			})
	},
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.tabs {
	padding: 20px;
	margin-top: 50px;
}
.papaertitle {
	margin-right: 5px;
}
</style>
