<template>
	<div class="scoresearch">
		<!-- 面包屑 -->
		<el-breadcrumb separator-class="el-icon-arrow-right">
			<el-breadcrumb-item :to="{ path: '/homepagemain' }"
				>班级管理</el-breadcrumb-item
			>
			<el-breadcrumb-item>
				查询班级
			</el-breadcrumb-item>
		</el-breadcrumb>

		<div class="tabs">
			<el-row>
				<el-col :span="5" :offset="17">
					<!-- 搜索框 -->
					<el-input placeholder="请输入所要查询的班级" v-model="searchtext">
						<template slot="append">
							<el-button
								icon="el-icon-search"
								type="primary"
								@click="toast"
							></el-button>
						</template>
					</el-input>
				</el-col>
			</el-row>

			<!-- 表格 -->
			<div class="mar-top">
				<template>
					<el-table
						:data="
							tableData.filter(
								(data) =>
									!search ||
									data.name.toLowerCase().includes(search.toLowerCase())
							)
						"
						style="width: 100%"
					>
						<el-table-column label="姓名" prop="name"> </el-table-column>
						<el-table-column label="班级" prop="classId"> </el-table-column>
						<el-table-column label="学号" prop="studentId"> </el-table-column>
						<el-table-column label="性别" prop="sex"> </el-table-column>
						<el-table-column label="生日" prop="birthday"> </el-table-column>
						<el-table-column label="邮箱" prop="email"> </el-table-column>
						<el-table-column label="手机号" prop="phone"> </el-table-column>
						<el-table-column align="right">
							<!-- <template slot="header" slot-scope="scope"> -->
							<!-- 防止eslint报错,暂不知有何bug -->
							<template slot="header">
								<el-input
									v-model="search"
									size="mini"
									placeholder="输入关键字搜索"
								/>
							</template>
							<template slot-scope="scope">
								<el-button
									size="mini"
									@click="handleEdit(scope.$index, scope.row)"
									>Edit</el-button
								>
								<el-button
									size="mini"
									type="danger"
									@click="handleDelete(scope.$index, scope.row)"
									>Delete</el-button
								>
							</template>
						</el-table-column>
					</el-table>
				</template>
			</div>
		</div>
	</div>
</template>

<script>
import axios from 'axios'
import { Toast } from 'vant'
export default {
	props: ['AxiosHeader'],
	data() {
		return {
			searchtext: '',
			search: '',
			tableData: [],
		}
	},
	methods: {
		toast() {
			// Toast('提示内容')
			let query = axios.create({
				baseURL: 'http://localhost:9090', //请求域名，基本路径
				headers: {
					Authorization: 'Bearer ' + this.AxiosHeader,
				}, //设置请求头
			})
			query
				.get('/user/classes/queryStudents', {
					params: {
						classId: this.searchtext,
						page: '1',
						size: '999',
					},
				})
				.then((res) => {
					this.tableData = res.data.data
					console.log(res)
				})
				.catch((err) => {
					console.log(err)
					this.$message.error('操作失败，请稍后尝试')
				})
		},
		handleEdit(index, row) {
			console.log(index, row)
		},
		handleDelete(index, row) {
			console.log(index, row)
		},
	},
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.tabs {
	padding: 20px;
}
.flo-right {
	float: right;
}
.claer-float {
	clear: both;
}
.mar-top {
	margin-top: 25px;
}
</style>
