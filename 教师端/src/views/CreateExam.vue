<template>
	<div class="createxam">
		<!-- 面包屑 -->
		<el-breadcrumb separator-class="el-icon-arrow-right">
			<el-breadcrumb-item :to="{ path: '/homepagemain' }"
				>考试管理</el-breadcrumb-item
			>
			<el-breadcrumb-item>创建考试</el-breadcrumb-item>
		</el-breadcrumb>

		<div class="tabs">
			<el-form
				:model="ruleForm"
				:rules="rules"
				ref="ruleForm"
				label-width="100px"
				class="demo-ruleForm"
			>
				<!-- 考试名称 -->
				<el-row>
					<el-col :span="8" :offset="7">
						<el-form-item label="考试名称" prop="examname">
							<el-input
								v-model="ruleForm.examname"
								placeholder="请输入考试名称"
							></el-input>
						</el-form-item>
					</el-col>
				</el-row>

				<!-- 考试编号选择 -->
				<el-row>
					<el-col :span="8" :offset="7">
						<el-form-item label="考试编号" prop="examId">
							<el-select
								v-model="ruleForm.examId"
								placeholder="请选择考试编号"
								style="width: 100%;"
							>
								<el-option label="1" value="1"></el-option>
								<el-option label="2" value="2"></el-option>
								<el-option label="3" value="3"></el-option>
							</el-select>
						</el-form-item>
					</el-col>
				</el-row>

				<!-- 试卷编号选择 -->
				<el-row>
					<el-col :span="8" :offset="7">
						<el-form-item label="试卷编号" prop="paperId">
							<el-select
								v-model="ruleForm.paperId"
								placeholder="请选择试卷编号"
								style="width: 100%;"
							>
								<el-option label="1" value="1"></el-option>
								<el-option label="2" value="2"></el-option>
								<el-option label="3" value="3"></el-option>
							</el-select>
						</el-form-item>
					</el-col>
				</el-row>

				<!-- 考试日期 -->
				<el-row>
					<el-col :span="8" :offset="7">
						<el-form-item label="考试日期" required>
							<el-form-item prop="examdata">
								<el-date-picker
									type="date"
									placeholder="选择日期"
									v-model="ruleForm.examdata"
									style="width: 100%;"
								></el-date-picker>
							</el-form-item>
						</el-form-item>
					</el-col>
				</el-row>

				<!-- 起始时间 -->
				<el-row>
					<el-col :span="8" :offset="7">
						<el-form-item label="起始时间" required>
							<el-form-item prop="examstart">
								<el-time-picker
									placeholder="请选择考试开始时间"
									v-model="ruleForm.examstart"
									style="width: 100%;"
								></el-time-picker>
							</el-form-item>
						</el-form-item>
					</el-col>
				</el-row>

				<!-- 截至时间 -->
				<el-row>
					<el-col :span="8" :offset="7">
						<el-form-item label="截至时间" required>
							<el-form-item prop="examend">
								<el-time-picker
									placeholder="请选择考试结束时间"
									v-model="ruleForm.examend"
									style="width: 100%;"
								></el-time-picker>
							</el-form-item>
						</el-form-item>
					</el-col>
				</el-row>

				<!-- 按钮 -->
				<el-row>
					<el-col :span="8" :offset="7">
						<el-form-item>
							<el-button type="primary" @click="submitForm('ruleForm')"
								>立即创建</el-button
							>
							<el-button @click="resetForm('ruleForm')">重置</el-button>
						</el-form-item>
					</el-col>
				</el-row>
			</el-form>
		</div>
	</div>
</template>

<script>
// 时间转换
Date.prototype.Format = function(fmt) {
	//author: meizz
	var o = {
		'M+': this.getMonth() + 1, //月份
		'd+': this.getDate(), //日
		'h+': this.getHours(), //小时
		'm+': this.getMinutes(), //分
		's+': this.getSeconds(), //秒
		'q+': Math.floor((this.getMonth() + 3) / 3), //季度
		S: this.getMilliseconds(), //毫秒
	}
	if (/(y+)/.test(fmt))
		fmt = fmt.replace(
			RegExp.$1,
			(this.getFullYear() + '').substr(4 - RegExp.$1.length)
		)
	for (var k in o)
		if (new RegExp('(' + k + ')').test(fmt))
			fmt = fmt.replace(
				RegExp.$1,
				RegExp.$1.length == 1 ? o[k] : ('00' + o[k]).substr(('' + o[k]).length)
			)
	return fmt
}

import axios from 'axios'
export default {
	props: ['AxiosHeader'],
	data() {
		return {
			ruleForm: {
				examname: '',
				examId: null,
				paperId: null,
				examdata: '',
				examstart: '',
				examend: '',
			},
			rules: {
				examname: [
					{ required: true, message: '请输入考试名称', trigger: 'blur' },
				],
				examId: [
					{ required: true, message: '请选择考试编号', trigger: 'change' },
				],
				paperId: [
					{ required: true, message: '请选择试卷编号', trigger: 'change' },
				],
				examdata: [
					{
						type: 'date',
						required: true,
						message: '请选择日期',
						trigger: 'change',
					},
				],
				examstart: [
					{
						type: 'date',
						required: true,
						message: '请选择考试开始时间',
						trigger: 'change',
					},
				],
				examend: [
					{
						type: 'date',
						required: true,
						message: '请选择考试结束时间',
						trigger: 'change',
					},
				],
			},
		}
	},
	methods: {
		submitForm(formName) {
			this.$refs[formName].validate((valid) => {
				if (valid) {

					let createExam = axios.create({
						baseURL: 'http://localhost:9090', //请求域名，基本路径
						headers: {
							Authorization: 'Bearer ' + this.AxiosHeader,
						}, //设置请求头
					})
					createExam
						.post('/exam/exam/addExam', {
							begin: this.ruleForm.examstart,
							end: this.ruleForm.examend,
							during: 10,
							name: this.ruleForm.examname,
							examId: this.ruleForm.examId,
							paperId: this.ruleForm.paperId,
						})
						.then((res) => {
							console.log(res)
						})
						.catch((err) => {
							console.log(err)
						})
				} else {
					console.log('error submit!!')
					return false
				}
			})
		},
		resetForm(formName) {
			this.$refs[formName].resetFields()
		},
	},
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.tabs {
	padding: 20px;
	margin-top: 50px;
}
</style>
