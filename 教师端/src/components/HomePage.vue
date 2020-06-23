<template>
	<div class="homepage">
		<el-container>
			<!-- 侧边栏 -->
			<el-aside :width="asi">
				<el-menu
					default-active="1-4-1"
					class="el-menu-vertical-demo"
					@open="handleOpen"
					@close="handleClose"
					:collapse="isCollapse"
					background-color="#304156"
					text-color="rgb(191, 203, 217)"
					active-text-color="#409EFF"
					router
				>
					<!-- 试题录入 -->
					<el-menu-item index="testenter1">
						<i class="el-icon-edit-outline"></i>
						<span slot="title">
							试题录入
						</span>
					</el-menu-item>
					<!-- <el-submenu index="1">
						<template slot="title">
							<i class="el-icon-edit-outline"></i>
							<span slot="title">
								试题录入
							</span>
						</template>
						<el-menu-item-group>
							<el-menu-item index="testenter1">初级</el-menu-item>
							<el-menu-item index="testenter2">中级</el-menu-item>
							<el-menu-item index="testenter3">高级</el-menu-item>
						</el-menu-item-group>
					</el-submenu> -->

					<!-- 题库 -->
					<el-submenu index="1">
						<template slot="title">
							<i class="el-icon-document-add"></i>
							<span slot="title">
								出卷
							</span>
						</template>
						<el-menu-item-group>
							<el-menu-item index="newpaper">题库</el-menu-item>
							<el-menu-item index="ExamInfo">试卷信息</el-menu-item>
						</el-menu-item-group>
					</el-submenu>

					<!-- <el-menu-item index="newpaper">
						<i class="el-icon-document-add"></i>
						<span slot="title">
							题库
						</span>
					</el-menu-item> -->

					<!-- 成绩查询 -->
					<el-menu-item index="scoresearch">
						<i class="el-icon-search"></i>
						<span slot="title">
							成绩查询
						</span>
					</el-menu-item>

					<!-- 学生管理 -->
					<el-submenu index="2">
						<template slot="title">
							<i class="el-icon-user-solid"></i>
							<span slot="title">
								学生管理
							</span>
						</template>
						<el-menu-item-group>
							<el-menu-item index="addstudent">添加学生</el-menu-item>
							<el-menu-item index="querystudent">查询学生</el-menu-item>
						</el-menu-item-group>
					</el-submenu>

					<!-- 教师管理 -->
					<el-submenu index="3">
						<template slot="title">
							<i class="el-icon-s-custom"></i>
							<span slot="title">
								教师管理
							</span>
						</template>
						<el-menu-item-group>
							<el-menu-item index="addstudent">添加教师</el-menu-item>
							<el-menu-item index="querystudent">查询教师</el-menu-item>
						</el-menu-item-group>
					</el-submenu>

					<!-- 班级管理 -->
					<el-submenu index="4">
						<template slot="title">
							<i class="el-icon-c-scale-to-original"></i>
							<span slot="title">
								班级管理
							</span>
						</template>
						<el-menu-item-group>
							<el-menu-item index="addclass">添加班级</el-menu-item>
							<el-menu-item index="queryclass">查询班级</el-menu-item>
						</el-menu-item-group>
					</el-submenu>

					<!--考试管理 -->
					<el-submenu index="5">
						<template slot="title">
							<i class="el-icon-s-platform"></i>
							<span slot="title">
								考试管理
							</span>
						</template>
						<el-menu-item-group>
							<el-menu-item index="createexam">创建考试</el-menu-item>
							<el-menu-item index="markpaper">在线阅卷</el-menu-item>
						</el-menu-item-group>
					</el-submenu>

					<!--个人中心 -->
					<el-submenu index="6">
						<template slot="title">
							<i class="el-icon-user"></i>
							<span slot="title">
								个人中心
							</span>
						</template>
						<el-menu-item-group>
							<el-menu-item index="person">个人资料</el-menu-item>
							<el-menu-item index="changepsw">修改密码</el-menu-item>
						</el-menu-item-group>
					</el-submenu>
				</el-menu>
			</el-aside>
			<el-container>
				<!-- 头部 -->
				<el-header>
					<!-- 控制侧导航栏切换 -->
					<el-radio-group v-model="isCollapse" style="margin-bottom: 20px;">
						<el-button type="text" class="change_but" @click="changeAside"
							><i class="el-icon-s-unfold"></i
						></el-button>
					</el-radio-group>

					<!-- 右边个人信息 -->
					<span class="head_person">
						<el-dropdown>
							<i class="el-icon-setting" style="margin-right: 15px"></i>
							<el-dropdown-menu slot="dropdown">
								<el-dropdown-item>
									<router-link to="/login">
										<span class="toLogin">退出登录</span>
									</router-link>
								</el-dropdown-item>
								<el-dropdown-item>
									<router-link to="/homepage">
										<span class="toLogin">刷新界面</span>
									</router-link>
								</el-dropdown-item>
							</el-dropdown-menu>
						</el-dropdown>
						<span class="mar--">欢迎您，{{ username }} </span>
					</span>
					<div class="clear_float"></div>
				</el-header>

				<!-- 主要部分 -->
				<el-main>
					<router-view :AxiosHeader="AxiosHeader" :username="username" />
				</el-main>
			</el-container>
		</el-container>
	</div>
</template>

<script>
import axios from 'axios'
import { Toast } from 'vant'
export default {
	name: 'HomePage',
	props: ['AxiosHeader'],
	data() {
		return {
			isCollapse: false,
			asi: '',
			username: '',
		}
	},
	methods: {
		handleOpen(key, keyPath) {
			console.log(key, keyPath)
		},
		handleClose(key, keyPath) {
			console.log(key, keyPath)
		},
		changeAside() {
			this.isCollapse = !this.isCollapse
		},
		// toLogin() {
		//   console.log('test')
		// 	this.$router.push({ path: '/login' })
		// },
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
				this.username = res.data.data.username
				// if (res.data.data.teacher === null) {
				// 	this.teacher = {
				// 		name: '',
				// 		teacherId: '',
				// 	}
				// } else {
				// 	this.teacher = res.data.data.teacher
				// }
			})
			.catch((err) => {
				console.log(err)
			})
	},
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.homepage {
	height: 100vh;
}
.toLogin {
	color: gray;
}
.toLogin:hover {
	color: #1989fa;
}
.mar-- {
	margin-left: -5px;
	margin-right: 5px;
}
.head_person {
	float: right;
	margin-top: 20px;
}
.clear_float {
	clear: both;
}
.el-menu {
	height: 100vh;
}
.el-menu-vertical-demo:not(.el-menu--collapse) {
	width: 200px;
	min-height: 400px;
}
.el-container {
	height: 100%;
}
.el-header {
	background-color: #b3c0d1;
	color: #333;
}
.aside {
	width: 202px !important;
}
.aside-after {
	width: 46px !important;
}
.el-main {
	background-color: #f0f2f5;
	color: #333;
	/* text-align: center; */
	/* line-height: 160px; */
}
.change_but {
	margin-top: 5px;
	font-size: 20px;
}
</style>
