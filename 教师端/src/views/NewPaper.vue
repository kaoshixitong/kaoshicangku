<template>
	<div class="newpaper">
		<!-- 面包屑 -->
		<el-breadcrumb separator-class="el-icon-arrow-right">
			<el-breadcrumb-item :to="{ path: '/homepagemain' }"
				>出卷</el-breadcrumb-item
			>
			<el-breadcrumb-item>题库</el-breadcrumb-item>
		</el-breadcrumb>

		<div class="tabs">
			<!-- 选择题 -->
			<!-- <el-card class="box-card">
				<div slot="header" class="clearfix">
					<span>选择题</span>
				</div>
				<div style="margin-top: 20px;">
					<el-row :gutter="20">
						<el-col :span="8" :offset="4">
							总个数：{{ seletnum + seletnum1 }}
						</el-col>
						<el-col :span="2">
							分数：
						</el-col>
						<el-col :span="8">
							<el-input-number
								v-model="seletfraction"
								@change="handleChange"
								controls-position="right"
								:min="0"
								:max="999"
								label="描述文字"
							></el-input-number>
						</el-col>
					</el-row>
				</div>
				<div style="margin-top: 20px;">
					<el-row :gutter="20">
						<el-col :span="2" :offset="4">
							知识点:
						</el-col>
						<el-col :span="6">
							<el-select v-model="value1" multiple placeholder="请选择">
								<el-option
									v-for="item in options"
									:key="item.value"
									:label="item.label"
									:value="item.value"
								>
								</el-option>
							</el-select>
						</el-col>
						<el-col :span="2">
							个数：
						</el-col>
						<el-col :span="8">
							<el-input-number
								v-model="seletnum"
								@change="handleChange"
								controls-position="right"
								:min="0"
								:max="999"
								label="描述文字"
							></el-input-number>
						</el-col>
					</el-row>
				</div>
				<div style="margin-top: 20px;">
					<el-row :gutter="20">
						<el-col :span="2" :offset="4">
							知识点:
						</el-col>
						<el-col :span="6">
							<el-select v-model="value2" multiple placeholder="请选择">
								<el-option
									v-for="item in options"
									:key="item.value"
									:label="item.label"
									:value="item.value"
								>
								</el-option>
							</el-select>
						</el-col>
						<el-col :span="2">
							个数：
						</el-col>
						<el-col :span="8">
							<el-input-number
								v-model="seletnum1"
								@change="handleChange"
								controls-position="right"
								:min="0"
								:max="999"
								label="描述文字"
							></el-input-number>
						</el-col>
					</el-row>
				</div>
			</el-card> -->

			<!-- 填空题 -->
			<!-- <div style="margin-top: 20px;">
				<el-card class="box-card">
					<div slot="header" class="clearfix">
						<span>填空题</span>
					</div>
					<div style="margin-top: 20px;">
						<el-row :gutter="20">
							<el-col :span="8" :offset="4">
								总个数：{{ blanksnum + blanksnum1 }}
							</el-col>
							<el-col :span="2">
								分数：
							</el-col>
							<el-col :span="8">
								<el-input-number
									v-model="blanksfraction"
									@change="handleChange"
									controls-position="right"
									:min="0"
									:max="999"
									label="描述文字"
								></el-input-number>
							</el-col>
						</el-row>
					</div>
					<div style="margin-top: 20px;">
						<el-row :gutter="20">
							<el-col :span="2" :offset="4">
								知识点:
							</el-col>
							<el-col :span="6">
								<el-select v-model="value3" multiple placeholder="请选择">
									<el-option
										v-for="item in options"
										:key="item.value"
										:label="item.label"
										:value="item.value"
									>
									</el-option>
								</el-select>
							</el-col>
							<el-col :span="2">
								个数：
							</el-col>
							<el-col :span="8">
								<el-input-number
									v-model="blanksnum"
									@change="handleChange"
									controls-position="right"
									:min="0"
									:max="999"
									label="描述文字"
								></el-input-number>
							</el-col>
						</el-row>
					</div>
					<div style="margin-top: 20px;">
						<el-row :gutter="20">
							<el-col :span="2" :offset="4">
								知识点:
							</el-col>
							<el-col :span="6">
								<el-select v-model="value4" multiple placeholder="请选择">
									<el-option
										v-for="item in options"
										:key="item.value"
										:label="item.label"
										:value="item.value"
									>
									</el-option>
								</el-select>
							</el-col>
							<el-col :span="2">
								个数：
							</el-col>
							<el-col :span="8">
								<el-input-number
									v-model="blanksnum1"
									@change="handleChange"
									controls-position="right"
									:min="0"
									:max="999"
									label="描述文字"
								></el-input-number>
							</el-col>
						</el-row>
					</div>
				</el-card>
			</div> -->

			<!-- 试卷 -->
			<div v-show="show">
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
						<el-input
							type="textarea"
							:rows="2"
							placeholder="请输入内容"
							v-model="textarea"
						>
						</el-input>
					</el-card>
				</div>
			</div>
		</div>

		<el-row :gutter="20">
			<el-col :span="6" :offset="16">
				<el-button type="primary">生成试卷</el-button>
			</el-col>
		</el-row>
	</div>
</template>

<script>
import axios from 'axios'
export default {
	props: ['AxiosHeader'],
	data() {
		return {
			// seletfraction: 0,
			// seletnum: 0,
			// seletnum1: 0,
			// blanksfraction: 0,
			// blanksnum: 0,
			// blanksnum1: 0,
			// options: [
			// 	{
			// 		value: '选项1',
			// 		label: 'java',
			// 	},
			// 	{
			// 		value: '选项2',
			// 		label: 'python',
			// 	},
			// 	{
			// 		value: '选项3',
			// 		label: 'vue',
			// 	},
			// 	{
			// 		value: '选项4',
			// 		label: '计算机组成原理',
			// 	},
			// 	{
			// 		value: '选项5',
			// 		label: '数据结构',
			// 	},
			// ],
			// value1: [],
			// value2: [],
			// value3: [],
			// value4: [],
			show: true,
			choices: [],
			essays: [],
			judges: [],
			textarea: '',
		}
	},
	methods: {
		handleChange(value) {
			console.log(value)
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
			.get('/exam/paper/queryAllTest', {
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
.text {
	font-size: 14px;
}

.item {
	margin-bottom: 18px;
}

.clearfix:before,
.clearfix:after {
	display: table;
	content: '';
}
.clearfix:after {
	clear: both;
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
