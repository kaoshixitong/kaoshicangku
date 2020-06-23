<template>
	<div class="changesex">
		<!-- 导航栏 -->
		<van-nav-bar
			title="在线答题"
			right-text="提交试卷"
			@click-right="onClickRight"
		>
			<template #left>
				<van-icon
					name="arrow-left"
					size="18"
					@click="onClickLeft"
					color="#969799"
				/>
			</template>
		</van-nav-bar>

		<!-- 倒计时 -->
		<!-- <center>
			<van-count-down :time="time">
				<template v-slot="timeData">
					<span class="block">{{ timeData.hours }}</span>
					<span class="colon">:</span>
					<span class="block">{{ timeData.minutes }}</span>
					<span class="colon">:</span>
					<span class="block">{{ timeData.seconds }}</span>
				</template>
			</van-count-down>
		</center> -->

		<center>
			<van-count-down :time="time2">
				<template v-slot="timeData">
					<span class="block">{{ timeData.hours }}</span>
					<span class="colon">:</span>
					<span class="block">{{ timeData.minutes }}</span>
					<span class="colon">:</span>
					<span class="block">{{ timeData.seconds }}</span>
				</template>
			</van-count-down>
		</center>

		<!-- 试卷 -->
		<div>
			<!-- 头部以及章节 -->
			<!-- <center>
				<h2>{{ examName }}</h2>
				此次考点：{{ chapterName }}
			</center> -->
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
					<van-radio-group v-model="radioChoice[index]">
						<div>
							<span>
								<van-radio icon-size="15px" class="inline" name="A"
									>A.{{ choice.typeA }}</van-radio
								>
							</span>
						</div>
						<div>
							<span>
								<van-radio icon-size="15px" class="inline" name="B"
									>B.{{ choice.typeB }}</van-radio
								>
							</span>
						</div>
						<div>
							<span>
								<van-radio icon-size="15px" class="inline" name="C"
									>C.{{ choice.typeC }}</van-radio
								>
							</span>
						</div>
						<div>
							<span>
								<van-radio icon-size="15px" class="inline" name="D"
									>D.{{ choice.typeD }}</van-radio
								>
							</span>
						</div>
					</van-radio-group>
				</el-card>
			</div>
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
				<van-radio-group v-model="radioJudge[index]">
					<div>
						<span>
							<van-radio icon-size="15px" class="inline" name="A"
								>A.{{ judge.typeA }}</van-radio
							>
						</span>
					</div>
					<div>
						<span>
							<van-radio icon-size="15px" class="inline" name="B"
								>B.{{ judge.typeB }}</van-radio
							>
						</span>
					</div>
				</van-radio-group>
			</el-card>
		</div>

		<!-- 主观题 -->
		<van-divider>主观题</van-divider>
		<div class="pad" v-for="(essay, index) in essays" :key="index">
			<el-card class="box-card">
				<!-- 题目 -->
				<div slot="header" class="clearfix">
					<span class="box-card-title">{{ essay.title }}</span>
					<span>({{ essay.score }}分)</span>
				</div>
				<!-- 文本框 -->
				<div>
					<el-input
						placeholder="请输入内容"
						v-model="inputEssay[index]"
						clearable
					>
					</el-input>
				</div>
			</el-card>
		</div>

		<center>
			<van-button type="info" @click="refer" style="margin-bottom:20px"
				>提交试卷</van-button
			>
		</center>
	</div>
</template>

<script>
import { Notify } from 'vant'
import axios from 'axios'
import { Toast } from 'vant'
export default {
	name: 'Answer',
	props: ['AxiosHeader', 'paperID', 'examID'],
	data() {
		return {
			time: 1 * 60 * 60 * 1000,
			currentDate: new Date(),
			time2: '',
			nowDate: new Date(),
			choices: [],
			judges: [],
			essays: [],
			inputEssay: [],
			radioChoice: [],
			radioJudge: [],
		}
	},
	methods: {
		onClickLeft() {
			this.$router.back(-1)
		},
		onClickRight() {},
		refer() {
			console.log(this.radioChoice)
			console.log(this.radioJudge)
			console.log(this.inputEssay)

			let referTo = axios.create({
				baseURL: 'http://localhost:9090', //请求域名，基本路径
				headers: {
					Authorization: 'Bearer ' + this.AxiosHeader,
				}, //设置请求头
			})
			referTo
				.post('/answer/submitAnswer', {
					choiceAnswerList: [
						{
							choiceAnswer: 'A',
							choiceAnswerScore: 0,
							choiceId: 1,
						},
						{
							choiceAnswer: 'B',
							choiceAnswerScore: 1,
							choiceId: 2,
						},
						{
							choiceAnswer: 'C',
							choiceAnswerScore: 0,
							choiceId: 3,
						},
					],
					end: this.nowDate.toString(),
					essayAnswerList: [
						{
							essayAnswer: '123',
							essayAnswerScore: 0,
							essayId: 1,
						},
					],
					examId: this.examID,
					judgeAnswerList: [
						{
							judgeAnswer: 'A',
							judgeAnswerScore: 2,
							judgeId: 1,
						},
					],
					userId: 1,
				})
				.then((res) => {
					console.log(res)
					Notify({ type: 'success', message: '试卷提交成功' })
				})
				.catch((err) => {
					console.log(err)
					// Toast('操作失败，请稍后重试')
				})
		},
	},
	created() {
		console.log('paperID' + this.paperID)
		// 获取时间
		let getTime = axios.create({
			baseURL: 'http://localhost:9090', //请求域名，基本路径
			headers: {
				Authorization: 'Bearer ' + this.AxiosHeader,
			}, //设置请求头
			// data: {
			// 	examId: 1,
			// },
		})
		getTime
			.get('/answer/queryRemaining', {
				params: {
					examId: this.examID,
				},
			})
			.then((res) => {
				var myDate = new Date()
				myDate = res.data.data
				this.currentDate = myDate
				this.time2 = this.currentDate.toString()
				console.log('time:' + this.currentDate)
				console.log('time2:' + this.time2)
				console.log(res)
			})
			.catch((err) => {
				console.log(err)
				Toast('您已作答，请勿重复作答')
			})

		// 获取试卷
		let getPaper = axios.create({
			baseURL: 'http://localhost:9090', //请求域名，基本路径
			headers: {
				Authorization: 'Bearer ' + this.AxiosHeader,
			}, //设置请求头
		})
		getPaper
			.get('/exam/paper/queryAllTestById', {
				params: {
					paperId: this.paperID,
					page: '1',
					size: '999',
				},
			})
			.then((res) => {
				// console.log(res)
				this.choices = res.data.data.choice
				this.judges = res.data.data.judge
				this.essays = res.data.data.essay
				console.log(res)
			})
			.catch((err) => {
				console.log(err)
				// Toast('操作失败，请稍后重试')
			})
	},
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.cell-name {
	color: #969799;
	margin-left: 30px;
}
/* 倒计时样式 */
.colon {
	display: inline-block;
	margin: 0 4px;
	color: #ee0a24;
	border-radius: 5px;
}
.block {
	display: inline-block;
	width: 22px;
	color: #fff;
	font-size: 12px;
	text-align: center;
	background-color: #ee0a24;
	border-radius: 5px;
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
/* .inline {
	display: inline !important;
} */
</style>
