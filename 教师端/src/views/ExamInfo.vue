<template>
	<div class="newpaper">
		<!-- 面包屑 -->
		<el-breadcrumb separator-class="el-icon-arrow-right">
			<el-breadcrumb-item :to="{ path: '/homepagemain' }"
				>出卷</el-breadcrumb-item
			>
			<el-breadcrumb-item>试卷信息</el-breadcrumb-item>
		</el-breadcrumb>

		<div class="tabs" v-show="show">
			<!-- 选择题 -->
			<van-divider>选择题</van-divider>
			<div class="pad" v-for="(choice, index) in choices" :key="index">
				<el-card class="box-card">
					<!-- 题目 -->
					<div slot="header" class="clearfix">
						<span class="box-card-title">{{ choice.title }}</span>
						<span>({{ choice.score }}分)</span>
					</div>
					<!-- 选项 -->
					<div>
						<span>A.</span>
						<span>{{ choice.typeA }}</span>
					</div>
					<div>
						<span>B.</span>
						<span>{{ choice.typeB }}</span>
					</div>
					<div>
						<span>C.</span>
						<span>{{ choice.typeC }}</span>
					</div>
					<div>
						<span>D.</span>
						<span>{{ choice.typeD }}</span>
					</div>
					<!-- 分割线 -->
					<el-divider></el-divider>
					<!-- 正确答案 -->
					<div>
						<span>正确答案：</span>
						<span>{{ choice.right }}</span>
					</div>
					<!-- 分割线 -->
					<el-divider></el-divider>
					<el-button type="primary" @click="editChoice(index)">编辑</el-button>
					<el-button type="danger" @click="delChoice(index)">删除</el-button>
				</el-card>
			</div>

			<!-- 判断题 -->
			<van-divider>判断题</van-divider>
			<div class="pad" v-for="(judge, index) in judges" :key="index">
				<el-card class="box-card">
					<!-- 题目 -->
					<div slot="header" class="clearfix">
						<span class="box-card-title">{{ judge.title }}</span>
						<span>({{ judge.score }}分)</span>
					</div>
					<!-- 选项 -->
					<div>
						<span>A.</span>
						<span>{{ judge.typeA }}</span>
					</div>
					<div>
						<span>B.</span>
						<span>{{ judge.typeB }}</span>
					</div>
					<!-- 分割线 -->
					<el-divider></el-divider>
					<!-- 正确答案 -->
					<div>
						<span>正确答案：</span>
						<span>{{ judge.right }}</span>
					</div>
					<!-- 分割线 -->
					<el-divider></el-divider>
					<el-button type="primary">编辑</el-button>
					<el-button type="danger" @click="delJudge(index)">删除</el-button>
				</el-card>
			</div>

			<!-- 简答题 -->
			<van-divider>简答题</van-divider>
			<div class="pad" v-for="(essay, index) in essays" :key="index">
				<el-card class="box-card">
					<!-- 题目 -->
					<div slot="header" class="clearfix">
						<span class="box-card-title">{{ essay.title }}</span>
						<span>({{ essay.score }}分)</span>
					</div>
					<!-- 参考答案 -->
					<div>
						<span>参考答案：</span>
						<span>{{ essay.reference }}</span>
					</div>
					<!-- 分割线 -->
					<el-divider></el-divider>
					<el-button type="primary">编辑</el-button>
					<el-button type="danger" @click="delEssay(index)">删除</el-button>
				</el-card>
			</div>
		</div>

		<!-- 编辑框 -->
		<div class="tabs" v-show="!show">
			<el-tabs type="border-card">
				<!-- 单选题 -->
				<el-tab-pane label="单选题">
					<div class="pad-lef">
						<el-form ref="form">
							<!-- 提干 -->
							<div style="margin-top: 20px;">
								<el-row :gutter="20">
									<el-col :span="2">
										提干:
									</el-col>
									<el-col :span="22">
										<el-input
											type="textarea"
											:rows="2"
											:placeholder="choices[nowIndex].title"
											v-model="upDateChoice"
										>
										</el-input>
									</el-col>
								</el-row>
							</div>

							<!-- 选项 -->
							<!-- 选项A  -->
							<div style="margin-top: 20px;">
								<el-row :gutter="20">
									<el-col :span="2">
										选项A:
									</el-col>
									<el-col :span="20">
										<el-input
											class="select"
											:placeholder="choices[nowIndex].typeA"
											v-model="inputA"
										>
											<template slot="append">
												<el-radio v-model="radio" label="A">正确答案</el-radio>
											</template>
										</el-input>
									</el-col>
									<el-col :span="2">
										<el-button type="danger" icon="el-icon-delete"></el-button>
									</el-col>
								</el-row>
							</div>
							<!-- 选项B  -->
							<div style="margin-top: 20px;">
								<el-row :gutter="20">
									<el-col :span="2">
										选项B:
									</el-col>
									<el-col :span="20">
										<el-input
											class="select"
											:placeholder="choices[nowIndex].typeB"
											v-model="inputB"
										>
											<template slot="append">
												<el-radio v-model="radio" label="B">正确答案</el-radio>
											</template>
										</el-input>
									</el-col>
									<el-col :span="2">
										<el-button type="danger" icon="el-icon-delete"></el-button>
									</el-col>
								</el-row>
							</div>
							<!-- 选项C  -->
							<div style="margin-top: 20px;">
								<el-row :gutter="20">
									<el-col :span="2">
										选项C:
									</el-col>
									<el-col :span="20">
										<el-input
											class="select"
											:placeholder="choices[nowIndex].typeC"
											v-model="inputC"
										>
											<template slot="append">
												<el-radio v-model="radio" label="C">正确答案</el-radio>
											</template>
										</el-input>
									</el-col>
									<el-col :span="2">
										<el-button type="danger" icon="el-icon-delete"></el-button>
									</el-col>
								</el-row>
							</div>
							<!-- 选项D  -->
							<div style="margin-top: 20px;">
								<el-row :gutter="20">
									<el-col :span="2">
										选项D:
									</el-col>
									<el-col :span="20">
										<el-input
											class="select"
											:placeholder="choices[nowIndex].typeD"
											v-model="inputD"
										>
											<template slot="append">
												<el-radio v-model="radio" label="D">正确答案</el-radio>
											</template>
										</el-input>
									</el-col>
									<el-col :span="2">
										<el-button type="danger" icon="el-icon-delete"></el-button>
									</el-col>
								</el-row>
							</div>
							<!-- 按钮 -->
							<div style="margin-top: 20px;">
								<el-row :gutter="20">
									<el-col :span="8" :offset="16">
										<el-button type="primary" @click="choiceUpdae"
											>保存</el-button
										>
										<el-button type="reset">重置</el-button>
									</el-col>
								</el-row>
							</div>
						</el-form>
					</div>
				</el-tab-pane>
			</el-tabs>
		</div>
	</div>
</template>

<script>
import axios from 'axios'
export default {
	props: ['AxiosHeader'],
	data() {
		return {
			choices: [],
			essays: [],
			judges: [],
			show: true,
			nowIndex: 1,
			radio: '',
			upDateChoice: '',
			inputA: '',
			inputB: '',
			inputC: '',
			inputD: '',
			choiceID: '',
		}
	},
	methods: {
		delChoice(mes) {
			console.log(mes)
			let deleteChoice = axios.create({
				baseURL: 'http://localhost:9090', //请求域名，基本路径
				headers: {
					Authorization: 'Bearer ' + this.AxiosHeader,
				}, //设置请求头
			})
			deleteChoice
				.delete('/exam/choice/deleteChoiceById', {
					data: {
						choiceId: this.choices[mes].choiceId,
					},
				})
				.then((res) => {
					console.log(res)
					this.$message({
						message: '删除成功',
						type: 'success',
					})
					this.$router.push({ path: '/homepage' })
				})
				.catch((err) => {
					console.log(err)
				})
		},
		delJudge(mes) {
			console.log(mes)
			let deleteJudge = axios.create({
				baseURL: 'http://localhost:9090', //请求域名，基本路径
				headers: {
					Authorization: 'Bearer ' + this.AxiosHeader,
				}, //设置请求头
			})
			deleteJudge
				.delete('/exam/judge/deleteJudgeById', {
					data: {
						judgeId: this.judges[mes].judgeId,
					},
				})
				.then((res) => {
					console.log(res)
					this.$message({
						message: '删除成功',
						type: 'success',
					})
					this.$router.push({ path: '/homepage' })
				})
				.catch((err) => {
					console.log(err)
				})
		},
		delEssay(mes) {
			console.log(mes)
			let deleteEssay = axios.create({
				baseURL: 'http://localhost:9090', //请求域名，基本路径
				headers: {
					Authorization: 'Bearer ' + this.AxiosHeader,
				}, //设置请求头
			})
			deleteEssay
				.delete('/exam/essay/deleteEssayById', {
					data: {
						essayId: this.essays[mes].essayId,
					},
				})
				.then((res) => {
					console.log(res)
					this.$message({
						message: '删除成功',
						type: 'success',
					})
					this.$router.push({ path: '/homepage' })
				})
				.catch((err) => {
					console.log(err)
				})
		},
		editChoice(mes) {
			console.log(mes)
			this.nowIndex = mes
			this.show = !this.show
			this.choiceID = this.choices[mes].choiceId
		},
		choiceUpdae() {
			this.show = !this.show
			console.log(this.inputB)
			let updateChoice = axios.create({
				baseURL: 'http://localhost:9090', //请求域名，基本路径
				headers: {
					Authorization: 'Bearer ' + this.AxiosHeader,
				}, //设置请求头
			})
			updateChoice
				.put('/exam/choice/updateChoiceById', {
					typeA: this.inputA ? this.inputA : this.choices[this.nowIndex].typeA,
					typeB: this.inputB ? this.inputB : this.choices[this.nowIndex].typeB,
					typeC: this.inputC ? this.inputC : this.choices[this.nowIndex].typeC,
					typeD: this.inputD ? this.inputD : this.choices[this.nowIndex].typeD,
					title: this.upDateChoice
						? this.upDateChoice
						: this.choices[this.nowIndex].title,
					right: this.radio ? this.radio : this.choices[this.nowIndex].right,
					paperId: 1,
					single: 1,
					score: 1,
					subjectId: 1,
					chapterId: 1,
					choiceId: this.choiceID,
				})
				.then((res) => {
					console.log(res)
					this.$message({
						message: '编辑成功',
						type: 'success',
					})
				})
				.catch((err) => {
					console.log(err)
				})
		},
	},
	created() {
		let queryAllTest = axios.create({
			baseURL: 'http://localhost:9090', //请求域名，基本路径
			headers: {
				Authorization: 'Bearer ' + this.AxiosHeader,
			}, //设置请求头
		})
		queryAllTest
			.get('/exam/paper/queryAllContent', {
				params: {
					page: '1',
					size: '999',
				},
			})
			.then((res) => {
				console.log(res)
				this.choices = res.data.data.choices
				this.judges = res.data.data.judges
				this.essays = res.data.data.essays
			})
			.catch((err) => {
				console.log(err)
			})
	},
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.tabs {
	padding: 20px;
}
.box-card {
	width: 100%;
}
.pad {
	padding: 0 30px 30px 30px;
}
.box-card-title {
	font-size: 14px;
}
.box-card span {
	font-size: 14px;
}
</style>
