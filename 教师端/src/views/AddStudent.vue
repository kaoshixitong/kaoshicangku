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
					>学生管理</el-breadcrumb-item
				>
				<el-breadcrumb-item>添加学生</el-breadcrumb-item>
			</el-breadcrumb>

			<div class="tabs">
				<!-- 姓名 -->
				<el-row>
					<el-col :span="6" :offset="8">
						<el-form-item label="姓名" prop="name">
							<el-input v-model="ruleForm.name"></el-input>
						</el-form-item>
					</el-col>
				</el-row>

				<!-- 选择班级 -->
				<el-row>
					<el-col :span="6" :offset="8">
						<el-form-item label="班级" prop="class">
							<el-select v-model="ruleForm.class" placeholder="请选择班级">
								<el-option label="1班" value="1班"></el-option>
								<el-option label="2班" value="2班"></el-option>
							</el-select>
						</el-form-item>
					</el-col>
				</el-row>

				<!-- 提交按钮 -->
				<el-row>
					<el-col :span="6" :offset="8">
						<el-form-item>
							<el-button type="primary" @click="submitForm('ruleForm')"
								>添加</el-button
							>
							<el-button @click="resetForm('ruleForm')">重置</el-button>
						</el-form-item>
					</el-col>
				</el-row>
			</div>
		</el-form>
	</div>
</template>

<script>
export default {
	data() {
		return {
			ruleForm: {
				name: '',
				class: '',
			},
			rules: {
				name: [{ required: true, message: '请输入姓名', trigger: 'blur' }],
				class: [{ required: true, message: '请选择班级', trigger: 'change' }],
			},
		}
	},
	methods: {
		submitForm(formName) {
			this.$refs[formName].validate((valid) => {
				if (valid) {
          // alert('submit!')
          this.$message.error('不好意思，该操作仅限管理员执行')
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
