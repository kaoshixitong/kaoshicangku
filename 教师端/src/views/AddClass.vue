<template>
	<div class="addstudent">
		<!-- 面包屑 -->
		<el-form
			:model="ruleForm"
			:rules="rules"
			ref="ruleForm"
			label-width="100px"
			class="demo-ruleForm"
		>
			<el-breadcrumb separator-class="el-icon-arrow-right">
				<el-breadcrumb-item :to="{ path: '/homepagemain' }"
					>班级管理</el-breadcrumb-item
				>
				<el-breadcrumb-item>添加班级</el-breadcrumb-item>
			</el-breadcrumb>

			<div class="tabs">
				<!-- 所有班级 -->
				<!-- <el-row>
					<el-col :span="4" :offset="9"> </el-col>
					<el-col :span="6"> </el-col>
				</el-row> -->
				<template>
					<el-table :data="tableData" style="width: 100%">
						<el-table-column prop="name" label="班级名称">
							<!-- <template slot-scope="scope">
								<i class="el-icon-time"></i>
								<span style="margin-left: 10px">{{ scope.row.date }}</span>
							</template> -->
						</el-table-column>
						<el-table-column prop="classId" label="班级"> </el-table-column>
						<el-table-column label="操作">
							<template slot-scope="scope">
								<el-button
									size="mini"
									@click="handleEdit(scope.$index, scope.row)"
									>编辑</el-button
								>
								<el-button
									size="mini"
									type="danger"
									@click="handleDelete(scope.$index, scope.row)"
									>删除</el-button
								>
							</template>
						</el-table-column>
					</el-table>
				</template>

				<!-- 班级 -->
				<el-row style="margin-top:30px">
					<el-col :span="6" :offset="7">
						<el-form-item label="班级" prop="class">
							<el-input
								v-model="ruleForm.class"
								placeholder="请输入班级名称"
							></el-input>
						</el-form-item>
					</el-col>
          <!-- 提交按钮 -->
					<el-col :span="2">
						<el-button type="primary" @click="submitForm('ruleForm')"
							>添加</el-button
						>
					</el-col>
				</el-row>

				<!-- 提交按钮 -->
				<!-- <el-row>
					<el-col :span="6" :offset="8">
						<el-form-item>
							<el-button type="primary" @click="submitForm('ruleForm')"
								>添加</el-button
							>
							<el-button @click="resetForm('ruleForm')">重置</el-button>
						</el-form-item>
					</el-col>
				</el-row> -->
			</div>
		</el-form>
	</div>
</template>

<script>
import axios from 'axios'
export default {
	props: ['AxiosHeader'],
	data() {
		return {
			ruleForm: {
				class: '',
			},
			rules: {
				class: [{ required: true, message: '请输入班级', trigger: 'change' }],
			},
			tableData: [
				// {
				// 	classId: '1',
				// 	name: '软件1班',
				// },
				// {
				// 	classId: '2',
				// 	name: '软件2班',
				// },
			],
		}
	},
	methods: {
		submitForm(formName) {
			this.$refs[formName].validate((valid) => {
				if (valid) {
					// alert('submit!')
					console.log(this.ruleForm.class)
					let addClass = axios.create({
						baseURL: 'http://localhost:9090', //请求域名，基本路径
						headers: {
							Authorization: 'Bearer ' + this.AxiosHeader,
						}, //设置请求头
					})
					addClass
						.post('/user/classes/addClasses', {
							name: this.ruleForm.class,
						})
						.then((res) => {
							console.log(res)
							this.$message.success('班级添加成功')
							this.$router.push({ path: '/homepage' })
						})
						.catch((err) => {
							console.log(err)
							this.$message.error('操作失败，请稍后尝试')
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
		handleEdit(index, row) {
			console.log(index, row)
		},
		handleDelete(index, row) {
			console.log(index, row)
			let deletClass = axios.create({
				baseURL: 'http://localhost:9090', //请求域名，基本路径
				headers: {
					Authorization: 'Bearer ' + this.AxiosHeader,
				}, //设置请求头
			})
			deletClass
				.delete('/user/classes/deleteClasses', {
					data: {
						classId: row.classId,
					},
				})
				.then((res) => {
					console.log(res)
					this.$message.success('班级删除成功')
					this.$router.push({ path: '/homepage' })
				})
				.catch((err) => {
					console.log(err)
					this.$message.error('操作失败，请稍后尝试')
				})
		},
	},
	created() {
		let getClass = axios.create({
			baseURL: 'http://localhost:9090', //请求域名，基本路径
			headers: {
				Authorization: 'Bearer ' + this.AxiosHeader,
			}, //设置请求头
		})
		getClass
			.get('/user/classes/queryClasses')
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
</style>
