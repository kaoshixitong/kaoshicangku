<template>
	<div class="scoresearch">
		<!-- 面包屑 -->
		<el-breadcrumb separator-class="el-icon-arrow-right">
			<el-breadcrumb-item :to="{ path: '/homepagemain' }"
				>成绩查询</el-breadcrumb-item
			>
			<el-breadcrumb-item></el-breadcrumb-item>
		</el-breadcrumb>

		<div class="tabs">
			<el-row>
				<el-col :span="5" :offset="12">
					<!-- 选择框 -->
					<el-select v-model="value" placeholder="请选择">
						<el-option
							v-for="item in options"
							:key="item.value"
							:label="item.label"
							:value="item.value"
						>
						</el-option>
					</el-select>
				</el-col>
				<el-col :span="5">
					<!-- 搜索框 -->
					<el-input placeholder="请输入内容" v-model="searchtext">
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
				<el-table :data="tableData" border stripe style="width: 100%">
					<el-table-column prop="name" label="姓名"> </el-table-column>
					<el-table-column prop="classId" label="班级"> </el-table-column>
					<el-table-column prop="studentId" label="学号"> </el-table-column>
					<el-table-column prop="examName" label="考试名称"> </el-table-column>
					<el-table-column prop="mark" label="成绩"> </el-table-column>
				</el-table>
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
			options: [
				{
					value: '选项1',
					label: '姓名',
				},
				{
					value: '选项2',
					label: '班级',
				},
				{
					value: '选项3',
					label: '学号',
				},
			],
			value: '',
			searchtext: '',
			tableData: [],
		}
	},
	methods: {
		toast() {
			Toast('提示内容')
		},
	},
	created() {
		let getInfo = axios.create({
			baseURL: 'http://localhost:9090', //请求域名，基本路径
			headers: {
				Authorization: 'Bearer ' + this.AxiosHeader,
			}, //设置请求头
		})
		getInfo
			.get('/teacher/score/queryStudentScore')
			.then((res) => {
        console.log(res)
        this.tableData = res.data.data
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
