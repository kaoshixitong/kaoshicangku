<template>
	<div class="scoresearch">
		<!-- 面包屑 -->
		<el-breadcrumb separator-class="el-icon-arrow-right">
			<el-breadcrumb-item :to="{ path: '/homepagemain' }"
				>学生管理</el-breadcrumb-item
			>
			<el-breadcrumb-item>
				查询学生
			</el-breadcrumb-item>
		</el-breadcrumb>

		<div class="tabs">
			<!-- <el-row>
				<el-col :span="5" :offset="12"> -->
			<!-- 选择框 -->
			<!-- <el-select v-model="value" placeholder="请选择">
						<el-option
							v-for="item in options"
							:key="item.value"
							:label="item.label"
							:value="item.value"
						>
						</el-option>
					</el-select>
				</el-col>
				<el-col :span="5"> -->
			<!-- 搜索框 -->
			<!-- <el-input placeholder="请输入内容" v-model="searchtext">
						<template slot="append">
							<el-button
								icon="el-icon-search"
								type="primary"
								@click="toast"
							></el-button>
						</template>
					</el-input>
				</el-col>
			</el-row> -->

			<!-- 表格 -->
			<div class="mar-top">
				<!-- <el-table :data="tableData" border stripe style="width: 100%">
					<el-table-column prop="name" label="姓名"> </el-table-column>
					<el-table-column prop="class" label="班级"> </el-table-column>
					<el-table-column prop="studentID" label="学号"> </el-table-column>
					<el-table-column label="操作">
						<center>
							<el-button type="primary" size="mini">修改</el-button>
							<el-button type="danger" size="mini">删除</el-button>
						</center>
					</el-table-column>
				</el-table> -->
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
						<el-table-column label="班级" prop="class"> </el-table-column>
						<el-table-column label="学号" prop="studentID"> </el-table-column>
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
import { Toast } from 'vant'
export default {
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
			search: '',
			tableData: [
				{
					name: '学生1',
					class: '1',
					studentID: '2018011111',
				},
				{
					name: '学生2',
					class: '1',
					studentID: '2018011112',
				},
				{
					name: '学生3',
					class: '1',
					studentID: '2018011113',
				},
				{
					name: '学生4',
					class: '2',
					studentID: '2018011114',
				},
				{
					name: '学生5',
					class: '2',
					studentID: '2018011115',
				},
			],
			// tableData: [
			// 	{
			// 		name: '王小虎',
			// 		class: '1班',
			// 		studentID: '2018010000',
			// 	},
			// 	{
			// 		name: '王小虎',
			// 		class: '1班',
			// 		studentID: '2018010000',
			// 	},
			// 	{
			// 		name: '王小虎',
			// 		class: '1班',
			// 		studentID: '2018010000',
			// 	},
			// 	{
			// 		name: '王小虎',
			// 		class: '1班',
			// 		studentID: '2018010000',
			// 	},
			// ],
		}
	},
	methods: {
		toast() {
			Toast('提示内容')
		},
		handleEdit(index, row) {
      this.$message.error('不好意思，该操作仅限管理员执行')
			console.log(index, row)
		},
		handleDelete(index, row) {
      this.$message.error('不好意思，该操作仅限管理员执行')
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
