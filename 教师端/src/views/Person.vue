<template>
	<div class="changepsw">
		<!-- 面包屑 -->
		<el-breadcrumb separator-class="el-icon-arrow-right">
			<el-breadcrumb-item :to="{ path: '/homepagemain' }"
				>个人中心</el-breadcrumb-item
			>
			<el-breadcrumb-item>个人资料</el-breadcrumb-item>
		</el-breadcrumb>

		<div class="tabs">
			<el-row>
				<el-col :span="7">
					<!-- 左边个人信息部分 -->
					<el-card class="box-card1">
						<div slot="header" class="clearfix">
							<span>关于我</span>
						</div>
						<!-- 头像 -->
						<div class="text item">
							<center>
								<!-- <img class="img" src="http://img5.imgtn.bdimg.com/it/u=3866760381,3381626874&fm=11&gp=0.jpg" alt=""> -->
								<el-upload
									class="avatar-uploader"
									action="https://jsonplaceholder.typicode.com/posts/"
									:show-file-list="false"
									:on-success="handleAvatarSuccess"
									:before-upload="beforeAvatarUpload"
								>
									<img v-if="imageUrl" :src="imageUrl" class="avatar" />
									<i v-else class="el-icon-plus avatar-uploader-icon"></i>
								</el-upload>
							</center>
							<br /><br />
							<el-row>
								<el-col :span="4" :offset="8">教师:</el-col>
								<el-col :span="12">{{ username }}</el-col>
							</el-row>
							<br />
							<el-row>
								<el-col :span="4" :offset="8">电话:</el-col>
								<el-col :span="12">{{
									teacher.phone ? teacher.phone : ''
								}}</el-col>
							</el-row>
							<br />
							<el-row>
								<el-col :span="4" :offset="8">性别:</el-col>
								<el-col :span="12">{{ teacher.sex ? teacher.sex : '' }}</el-col>
							</el-row>
							<br />
							<el-row>
								<el-col :span="4" :offset="8">职工号:</el-col>
								<el-col :span="12">{{
									teacher.teacherId ? teacher.teacherId : ''
								}}</el-col>
							</el-row>
							<br />
							<el-row>
								<el-col :span="4" :offset="8">邮箱:</el-col>
								<el-col :span="12">{{
									teacher.email ? teacher.email : ''
								}}</el-col>
							</el-row>
							<br />
							<el-row>
								<el-col :span="4" :offset="8">生日:</el-col>
								<el-col :span="12">{{
									teacher.birthday ? teacher.birthday : ''
								}}</el-col>
							</el-row>
						</div>
            <div class="height"></div>
					</el-card>
					<!-- <div class="clear-float"></div> -->
				</el-col>

				<el-col :span="16" :offset="1">
					<!-- 右侧修改信息部分 -->
					<el-card class="box-card1">
						<div slot="header" class="clearfix">
							<span>信息修改</span>
						</div>
						<!-- 输入框 -->
						<div class="text item">
							<span class="lable-info"><b>Phone</b></span>
							<el-input v-model="phone" placeholder="请输入电话"></el-input>
						</div>
						<div class="text item">
							<span class="lable-info"><b>Sex</b></span>
							<el-input v-model="sex" placeholder="请输入性别"></el-input>
						</div>
						<div class="text item">
							<span class="lable-info"><b>Email</b></span>
							<el-input
								v-model="email"
								type="email"
								placeholder="请输入邮箱"
							></el-input>
						</div>
						<div class="text item">
							<span class="lable-info"><b>Birthady</b></span>
							<el-input v-model="birthday" placeholder="请输入生日"></el-input>
						</div>
						<div class="text item">
							<br />
							<el-button type="primary" @click="update">更新</el-button>
						</div>
					</el-card>
					<div class="clear-float"></div>
				</el-col>
			</el-row>
		</div>
	</div>
</template>

<script>
import { Toast } from 'vant'
import axios from 'axios'
export default {
	name: 'Person',
	props: ['AxiosHeader', 'username'],
	data() {
		return {
			imageUrl:
				'http://img5.imgtn.bdimg.com/it/u=3866760381,3381626874&fm=11&gp=0.jpg',
			phone: '',
			sex: '',
			email: '',
			birthday: '',
			teacher: {},
		}
	},
	methods: {
		handleAvatarSuccess(res, file) {
			this.imageUrl = URL.createObjectURL(file.raw)
		},
		beforeAvatarUpload(file) {
			const isJPG = file.type === 'image/jpeg'
			const isLt2M = file.size / 1024 / 1024 < 2

			if (!isJPG) {
				this.$message.error('上传头像图片只能是 JPG 格式!')
			}
			if (!isLt2M) {
				this.$message.error('上传头像图片大小不能超过 2MB!')
			}
			return isJPG && isLt2M
		},
		update() {
			let ChangeTeacher = axios.create({
				baseURL: 'http://localhost:9090', //请求域名，基本路径
				headers: {
					Authorization: 'Bearer ' + this.AxiosHeader,
				}, //设置请求头
			})
			ChangeTeacher.put('/user/teacher/updateInformation', {
				teacher: {
					phone: this.phone ? this.phone : this.teacher.phone,
					sex: this.sex ? this.sex : this.teacher.sex,
					email: this.email ? this.email : this.teacher.email,
					birthday: this.birthday ? this.birthday : this.teacher.birthday,
				},
			})
				.then((res) => {
					// this.$router.back(-1)
					console.log(res)
					this.phone = ''
					this.sex = ''
					this.email = ''
          this.birthday = ''
          this.$router.push({ path: '/homepage' })
          // this.$router.push({ path: '/person' })
				})
				.catch((err) => {
					console.log(err)
					// Toast('操作失败，请稍后重试')
					this.$message.error('操作失败，请稍后尝试')
				})
		},
	},
	created() {
		let getTeacherInfo = axios.create({
			baseURL: 'http://localhost:9090', //请求域名，基本路径
			headers: {
				Authorization: 'Bearer ' + this.AxiosHeader,
			}, //设置请求头
		})
		getTeacherInfo
			.get('/user/teacher/queryInformation')
			.then((res) => {
				console.log(res)
				console.log(res.data.data)
				if (res.data.data.teacher === null) {
					this.teacher = {
						name: '',
						teacherId: '',
					}
				} else {
					this.teacher = res.data.data.teacher
				}
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
	/* margin-top: 50px; */
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
/* .box-card1 {
	width: 350px;
	float: left;
} */
.clear-float {
	clear: both;
}
.img {
	width: 150px;
	height: 150px;
}
.avatar-uploader .el-upload {
	border: 1px dashed #d9d9d9;
	border-radius: 6px;
	cursor: pointer;
	position: relative;
	overflow: hidden;
}
.avatar-uploader .el-upload:hover {
	border-color: #409eff;
}
.avatar-uploader-icon {
	font-size: 28px;
	color: #8c939d;
	width: 100px;
	height: 100px;
	line-height: 100px;
	text-align: center;
}
.avatar {
	width: 100px;
	height: 100px;
	display: block;
	border-radius: 50%;
}
.lable-info {
	line-height: 36px;
	text-align: right;
	vertical-align: middle;
	float: left;
	font-size: 14px;
	color: #606266;
	padding: 0 12px 0 0;
}
.height {
  height: 30px;
}
</style>
