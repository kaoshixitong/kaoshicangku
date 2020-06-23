<template>
	<div class="changepsw">
		<!-- 面包屑 -->
		<el-breadcrumb separator-class="el-icon-arrow-right">
			<el-breadcrumb-item :to="{ path: '/homepagemain' }"
				>个人中心</el-breadcrumb-item
			>
			<el-breadcrumb-item>修改密码</el-breadcrumb-item>
		</el-breadcrumb>

		<div class="tabs">
			<el-form
				:model="ruleForm"
				status-icon
				:rules="rules"
				ref="ruleForm"
				label-width="100px"
				class="demo-ruleForm"
			>
				<!-- 原密码 -->
				<el-row>
					<el-col :span="8" :offset="7">
						<el-form-item label="原密码" prop="oldpass">
							<el-input
								type="password"
								v-model="ruleForm.oldpass"
								autocomplete="off"
							></el-input>
						</el-form-item>
					</el-col>
				</el-row>

				<!-- 新密码 -->
				<el-row>
					<el-col :span="8" :offset="7">
						<el-form-item label="密码" prop="pass">
							<el-input
								type="password"
								v-model="ruleForm.pass"
								autocomplete="off"
							></el-input>
						</el-form-item>
					</el-col>
				</el-row>

				<!-- 确认密码 -->
				<el-row>
					<el-col :span="8" :offset="7">
						<el-form-item label="确认密码" prop="checkPass">
							<el-input
								type="password"
								v-model="ruleForm.checkPass"
								autocomplete="off"
							></el-input>
						</el-form-item>
					</el-col>
				</el-row>

				<!-- 按钮 -->
				<el-row>
					<el-col :span="8" :offset="7">
						<el-form-item>
							<el-button type="primary" @click="submitForm('ruleForm')"
								>确认</el-button
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
export default {
	data() {
		var validateOldPass = (rule, value, callback) => {
			if (value === '') {
				callback(new Error('请输入原密码'))
			} else {
				if (this.ruleForm.checkPass !== '') {
					this.$refs.ruleForm.validateField('checkPass')
				}
				callback()
			}
		}
		var validatePass = (rule, value, callback) => {
			if (value === '') {
				callback(new Error('请输入新密码'))
			} else {
				if (this.ruleForm.checkPass !== '') {
					this.$refs.ruleForm.validateField('checkPass')
				}
				callback()
			}
		}
		var validatePass2 = (rule, value, callback) => {
			if (value === '') {
				callback(new Error('请再次输入密码'))
			} else if (value !== this.ruleForm.pass) {
				callback(new Error('两次输入密码不一致!'))
			} else {
				callback()
			}
		}
		return {
			ruleForm: {
				oldpass: '',
				pass: '',
				checkPass: '',
			},
			rules: {
				oldpass: [{ validator: validateOldPass, trigger: 'blur' }],
				pass: [{ validator: validatePass, trigger: 'blur' }],
				checkPass: [{ validator: validatePass2, trigger: 'blur' }],
			},
		}
	},
	methods: {
		submitForm(formName) {
			this.$refs[formName].validate((valid) => {
				if (valid) {
          // alert('submit!')
          this.$message.success('密码修改成功')
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
