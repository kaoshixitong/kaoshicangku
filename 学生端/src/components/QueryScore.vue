<template>
	<div class="queryscore">
		<!-- 头部以及章节 -->
		<center>
			<h2>{{ examName }}</h2>
			此次考点：{{ chapterName }}
		</center>

		<!-- 选择题 -->
		<van-divider>选择题</van-divider>
		<div
			class="pad"
			v-for="(choiceScoreList, index) in choiceScoreLists"
			:key="index"
		>
			<el-card class="box-card">
				<!-- 题目 -->
				<div slot="header" class="clearfix">
					<span class="box-card-title">{{ choiceScoreList.title }}</span>
					<span>({{ choiceScoreList.score }}分)</span>
				</div>
				<!-- 选项 -->
				<div>
					<span>A.</span>
					<span>{{ choiceScoreList.choiceTypeA }}</span>
				</div>
				<div>
					<span>B.</span>
					<span>{{ choiceScoreList.choiceTypeB }}</span>
				</div>
				<div>
					<span>C.</span>
					<span>{{ choiceScoreList.choiceTypeC }}</span>
				</div>
				<div>
					<span>D.</span>
					<span>{{ choiceScoreList.choiceTypeD }}</span>
				</div>
				<!-- 分割线 -->
				<el-divider></el-divider>
				<!-- 正确答案 -->
				<div>
					<span>正确答案：</span>
					<span>{{ choiceScoreList.right }}</span>
				</div>
				<div>
					<span>你的答案：</span>
					<span>{{ choiceScoreList.choiceAnswer }}</span>
				</div>
				<div>
					<span>你的得分：</span>
					<span>{{ choiceScoreList.choiceAnswerScore }}分</span>
				</div>
			</el-card>
		</div>

		<!-- 判断题 -->
		<van-divider>判断题</van-divider>
		<div
			class="pad"
			v-for="(judgeScoreList, index) in judgeScoreLists"
			:key="index"
		>
			<el-card class="box-card">
				<!-- 题目 -->
				<div slot="header" class="clearfix">
					<span class="box-card-title">{{ judgeScoreList.title }}</span>
					<span>({{ judgeScoreList.score }}分)</span>
				</div>
				<!-- 选项 -->
				<div>
					<span>A.</span>
					<span>{{ judgeScoreList.judgeTypeA }}</span>
				</div>
				<div>
					<span>B.</span>
					<span>{{ judgeScoreList.judgeTypeB }}</span>
				</div>
				<!-- 分割线 -->
				<el-divider></el-divider>
				<!-- 正确答案 -->
				<div>
					<span>正确答案：</span>
					<span>{{ judgeScoreList.right }}</span>
				</div>
				<div>
					<span>你的答案：</span>
					<span>{{ judgeScoreList.judgeAnswer }}</span>
				</div>
				<div>
					<span>你的得分：</span>
					<span>{{ judgeScoreList.judgeAnswerScore }}分</span>
				</div>
			</el-card>
		</div>

		<!-- 简答题 -->
		<van-divider>简答题</van-divider>
		<div
			class="pad"
			v-for="(essayScoreList, index) in essayScoreLists"
			:key="index"
		>
			<el-card class="box-card">
				<!-- 题目 -->
				<div slot="header" class="clearfix">
					<span class="box-card-title">{{ essayScoreList.title }}</span>
					<span>({{ essayScoreList.score }}分)</span>
				</div>
				<!-- 选项 -->
				<div>
					<span>你的答案：</span>
					<span>{{ essayScoreList.essayAnswer }}</span>
				</div>
				<!-- 分割线 -->
				<el-divider></el-divider>
				<!-- 正确答案 -->
				<div>
					<span>参考答案：</span>
					<span>{{ essayScoreList.reference }}</span>
				</div>
				<div>
					<span>你的得分：</span>
					<span>{{ essayScoreList.essayAnswerScore }}分</span>
				</div>
			</el-card>
		</div>
	</div>
</template>

<script>
import { Dialog } from 'vant'
import axios from 'axios'
import { Toast } from 'vant'
export default {
	name: 'Contact',
	props: ['AxiosHeader'],
	data() {
		return {
			examName: '',
			chapterName: '',
			choiceScoreLists: [],
			judgeScoreLists: [],
			essayScoreLists: [],
		}
	},
	methods: {},
	created() {
		let getScore = axios.create({
			baseURL: 'http://localhost:9090', //请求域名，基本路径
			headers: {
				Authorization: 'Bearer ' + this.AxiosHeader,
			}, //设置请求头
		})
		getScore
			.get('/answer/queryScoreResult', {
				params: {
					examId: 1,
				},
			})
			.then((res) => {
				console.log(res)
				this.examName = res.data.data.examName
				this.chapterName = res.data.data.chapterName
				this.choiceScoreLists = res.data.data.choiceScoreList
				this.judgeScoreLists = res.data.data.judgeScoreList
				this.essayScoreLists = res.data.data.essayScoreList
			})
			.catch((err) => {
				console.log(err)
			})
	},
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.pad {
	padding: 0 30px 30px 30px;
}
.box-card-title {
	font-size: 14px;
}
.box-card span{
  font-size: 14px;
}
</style>
