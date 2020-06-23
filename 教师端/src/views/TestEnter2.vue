<template>
	<div class="testenter">
		<!-- 面包屑 -->
		<el-breadcrumb separator-class="el-icon-arrow-right">
			<el-breadcrumb-item :to="{ path: '/homepagemain' }">试题录入</el-breadcrumb-item>
			<el-breadcrumb-item>中级</el-breadcrumb-item>
		</el-breadcrumb>

		<!-- 标签页 -->
		<div class="tabs">
			<el-tabs type="border-card">
				<!-- 单选题 -->
				<el-tab-pane label="单选题">
					<div class="pad-lef">
						<el-form ref="form">
							<!-- 选择器 -->
							<el-row :gutter="20">
								<el-col :span="2">
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
							</el-row>

							<!-- 提干 -->
							<div style="margin-top: 20px;">
								<el-row :gutter="20">
									<el-col :span="2">
										提干:
									</el-col>
									<el-col :span="22">
										<el-input
											type="textarea"
											:rows="2"
											placeholder="请输入内容"
											v-model="textareaOne"
										>
										</el-input>
									</el-col>
								</el-row>
							</div>

							<!-- 选项 -->
							<!-- 选项A  -->
							<div style="margin-top: 20px;">
								<el-row :gutter="20">
									<el-col :span="2">
										选项A:
									</el-col>
									<el-col :span="20">
										<el-input
											class="select"
											placeholder="请输入内容"
											v-model="inputA"
										>
											<template slot="append">
												<el-radio v-model="radio" label="1">正确答案</el-radio>
											</template>
										</el-input>
									</el-col>
									<el-col :span="2">
										<el-button type="danger" icon="el-icon-delete"></el-button>
									</el-col>
								</el-row>
							</div>
							<!-- 选项B  -->
							<div style="margin-top: 20px;">
								<el-row :gutter="20">
									<el-col :span="2">
										选项B:
									</el-col>
									<el-col :span="20">
										<el-input
											class="select"
											placeholder="请输入内容"
											v-model="inputB"
										>
											<template slot="append">
												<el-radio v-model="radio" label="2">正确答案</el-radio>
											</template>
										</el-input>
									</el-col>
									<el-col :span="2">
										<el-button type="danger" icon="el-icon-delete"></el-button>
									</el-col>
								</el-row>
							</div>
							<!-- 选项C  -->
							<div style="margin-top: 20px;">
								<el-row :gutter="20">
									<el-col :span="2">
										选项C:
									</el-col>
									<el-col :span="20">
										<el-input
											class="select"
											placeholder="请输入内容"
											v-model="inputC"
										>
											<template slot="append">
												<el-radio v-model="radio" label="3">正确答案</el-radio>
											</template>
										</el-input>
									</el-col>
									<el-col :span="2">
										<el-button type="danger" icon="el-icon-delete"></el-button>
									</el-col>
								</el-row>
							</div>
							<!-- 选项D  -->
							<div style="margin-top: 20px;">
								<el-row :gutter="20">
									<el-col :span="2">
										选项D:
									</el-col>
									<el-col :span="20">
										<el-input
											class="select"
											placeholder="请输入内容"
											v-model="inputD"
										>
											<template slot="append">
												<el-radio v-model="radio" label="4">正确答案</el-radio>
											</template>
										</el-input>
									</el-col>
									<el-col :span="2">
										<el-button type="danger" icon="el-icon-delete"></el-button>
									</el-col>
								</el-row>
							</div>
							<!-- 按钮 -->
							<div style="margin-top: 20px;">
								<el-row :gutter="20">
									<el-col :span="8" :offset="16">
										<el-button type="primary">保存</el-button>
										<el-button type="reset">重置</el-button>
									</el-col>
								</el-row>
							</div>
						</el-form>
					</div>
				</el-tab-pane>

				<!-- 多选题 -->
				<el-tab-pane label="多选题">
					<div class="pad-lef">
						<el-form ref="form">
							<!-- 选择器 -->
							<el-row :gutter="20">
								<el-col :span="2">
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
							</el-row>

							<!-- 提干 -->
							<div style="margin-top: 20px;">
								<el-row :gutter="20">
									<el-col :span="2">
										提干:
									</el-col>
									<el-col :span="22">
										<el-input
											type="textarea"
											:rows="2"
											placeholder="请输入内容"
											v-model="textareaTwo"
										>
										</el-input>
									</el-col>
								</el-row>
							</div>

							<!-- 选项 -->
							<!-- 选项A  -->
							<!-- <el-checkbox-group v-model="checkList"> -->
							<div style="margin-top: 20px;">
								<el-row :gutter="20">
									<el-col :span="2">
										选项A:
									</el-col>
									<el-col :span="20">
										<el-input
											class="select"
											placeholder="请输入内容"
											v-model="multipleA"
										>
											<template slot="append">
												<el-checkbox label="A" v-model="checkList"
													>正确答案</el-checkbox
												>
											</template>
										</el-input>
									</el-col>
									<el-col :span="2">
										<el-button type="danger" icon="el-icon-delete"></el-button>
									</el-col>
								</el-row>
							</div>
							<!-- 选项B  -->
							<div style="margin-top: 20px;">
								<el-row :gutter="20">
									<el-col :span="2">
										选项B:
									</el-col>
									<el-col :span="20">
										<el-input
											class="select"
											placeholder="请输入内容"
											v-model="multipleB"
										>
											<template slot="append">
												<el-checkbox label="B" v-model="checkList"
													>正确答案</el-checkbox
												>
											</template>
										</el-input>
									</el-col>
									<el-col :span="2">
										<el-button type="danger" icon="el-icon-delete"></el-button>
									</el-col>
								</el-row>
							</div>
							<!-- 选项C  -->
							<div style="margin-top: 20px;">
								<el-row :gutter="20">
									<el-col :span="2">
										选项C:
									</el-col>
									<el-col :span="20">
										<el-input
											class="select"
											placeholder="请输入内容"
											v-model="multipleC"
										>
											<template slot="append">
												<el-checkbox label="C" v-model="checkList"
													>正确答案</el-checkbox
												>
											</template>
										</el-input>
									</el-col>
									<el-col :span="2">
										<el-button type="danger" icon="el-icon-delete"></el-button>
									</el-col>
								</el-row>
							</div>
							<!-- 选项D  -->
							<div style="margin-top: 20px;">
								<el-row :gutter="20">
									<el-col :span="2">
										选项D:
									</el-col>
									<el-col :span="20">
										<el-input
											class="select"
											placeholder="请输入内容"
											v-model="multipleD"
										>
											<template slot="append">
												<el-checkbox label="D" v-model="checkList"
													>正确答案</el-checkbox
												>
											</template>
										</el-input>
									</el-col>
									<el-col :span="2">
										<el-button type="danger" icon="el-icon-delete"></el-button>
									</el-col>
								</el-row>
							</div>
							<!-- </el-checkbox-group> -->
							<!-- 按钮 -->
							<div style="margin-top: 20px;">
								<el-row :gutter="20">
									<el-col :span="8" :offset="16">
										<el-button type="primary">保存</el-button>
										<el-button type="reset">重置</el-button>
									</el-col>
								</el-row>
							</div>
						</el-form>
					</div>
				</el-tab-pane>

				<!-- 判断题 -->
				<el-tab-pane label="判断题">
					<div class="pad-lef">
						<el-form ref="form">
							<!-- 选择器 -->
							<el-row :gutter="20">
								<el-col :span="2">
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
							</el-row>

							<!-- 提干 -->
							<div style="margin-top: 20px;">
								<el-row :gutter="20">
									<el-col :span="2">
										提干:
									</el-col>
									<el-col :span="22">
										<el-input
											type="textarea"
											:rows="2"
											placeholder="请输入内容"
											v-model="textareaThree"
										>
										</el-input>
									</el-col>
								</el-row>
							</div>
							<!-- 判断选择 -->
							<div style="margin-top: 20px;">
								<el-row :gutter="20">
									<el-col :span="2">
										答案：
									</el-col>
									<el-col :span="4">
										<el-radio v-model="judgment" label="1">对</el-radio>
										<el-radio v-model="judgment" label="2">错</el-radio>
									</el-col>
								</el-row>
							</div>
							<!-- 按钮 -->
							<div style="margin-top: 20px;">
								<el-row :gutter="20">
									<el-col :span="8" :offset="16">
										<el-button type="primary">保存</el-button>
										<el-button type="reset">重置</el-button>
									</el-col>
								</el-row>
							</div>
						</el-form>
					</div>
				</el-tab-pane>

				<!-- 填空题 -->
				<el-tab-pane label="填空题">
					<div class="pad-lef">
						<el-form ref="form">
							<!-- 选择器 -->
							<el-row :gutter="20">
								<el-col :span="2">
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
							</el-row>

							<!-- 提干 -->
							<div style="margin-top: 20px;">
								<el-row :gutter="20">
									<el-col :span="2">
										提干:
									</el-col>
									<el-col :span="22">
										<el-input
											type="textarea"
											:rows="2"
											placeholder="请输入内容"
											v-model="textareaFour"
										>
										</el-input>
									</el-col>
								</el-row>
							</div>
							<!-- 按钮 -->
							<div style="margin-top: 20px;">
								<el-row :gutter="20">
									<el-col :span="8" :offset="16">
										<el-button type="primary">保存</el-button>
										<el-button type="reset">重置</el-button>
									</el-col>
								</el-row>
							</div>
						</el-form>
					</div>
				</el-tab-pane>

				<!-- 简答题 -->
				<el-tab-pane label="简答题">
										<div class="pad-lef">
						<el-form ref="form">
							<!-- 选择器 -->
							<el-row :gutter="20">
								<el-col :span="2">
									知识点:
								</el-col>
								<el-col :span="6">
									<el-select v-model="value5" multiple placeholder="请选择">
										<el-option
											v-for="item in options"
											:key="item.value"
											:label="item.label"
											:value="item.value"
										>
										</el-option>
									</el-select>
								</el-col>
							</el-row>

							<!-- 提干 -->
							<div style="margin-top: 20px;">
								<el-row :gutter="20">
									<el-col :span="2">
										提干:
									</el-col>
									<el-col :span="22">
										<el-input
											type="textarea"
											:rows="2"
											placeholder="请输入内容"
											v-model="textareaFive"
										>
										</el-input>
									</el-col>
								</el-row>
							</div>
							<!-- 按钮 -->
							<div style="margin-top: 20px;">
								<el-row :gutter="20">
									<el-col :span="8" :offset="16">
										<el-button type="primary">保存</el-button>
										<el-button type="reset">重置</el-button>
									</el-col>
								</el-row>
							</div>
						</el-form>
					</div>
				</el-tab-pane>

				<!-- 程序题 -->
				<el-tab-pane label="程序题">
										<div class="pad-lef">
						<el-form ref="form">
							<!-- 选择器 -->
							<el-row :gutter="20">
								<el-col :span="2">
									知识点:
								</el-col>
								<el-col :span="6">
									<el-select v-model="value6" multiple placeholder="请选择">
										<el-option
											v-for="item in options"
											:key="item.value"
											:label="item.label"
											:value="item.value"
										>
										</el-option>
									</el-select>
								</el-col>
							</el-row>

							<!-- 提干 -->
							<div style="margin-top: 20px;">
								<el-row :gutter="20">
									<el-col :span="2">
										提干:
									</el-col>
									<el-col :span="22">
										<el-input
											type="textarea"
											:rows="2"
											placeholder="请输入内容"
											v-model="textareaSix"
										>
										</el-input>
									</el-col>
								</el-row>
							</div>
							<!-- 按钮 -->
							<div style="margin-top: 20px;">
								<el-row :gutter="20">
									<el-col :span="8" :offset="16">
										<el-button type="primary">保存</el-button>
										<el-button type="reset">重置</el-button>
									</el-col>
								</el-row>
							</div>
						</el-form>
					</div>
				</el-tab-pane>
			</el-tabs>
		</div>
	</div>
</template>

<script>
export default {
	data() {
		return {
			options: [
				{
					value: '选项1',
					label: 'java',
				},
				{
					value: '选项2',
					label: 'python',
				},
				{
					value: '选项3',
					label: 'vue',
				},
				{
					value: '选项4',
					label: '计算机组成原理',
				},
				{
					value: '选项5',
					label: '数据结构',
				},
			],
			value1: [],
			value2: [],
			value3: [],
			value4: [],
			value5: [],
			value6: [],
			textareaOne: '',
			textareaTwo: '',
			textareaThree: '',
			textareaFour: '',
			textareaFive: '',
			textareaSix: '',
			radio: '',
			checkList: [],
			judgment: '',
			inputA: '',
			inputB: '',
			inputC: '',
			inputD: '',
			multipleA: '',
			multipleB: '',
			multipleC: '',
			multipleD: '',
		}
	},
	methods: {
		// test() {
		// 	console.log(this.checkList)
		// },
	},
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.tabs {
	padding: 20px;
}
.pad-lef {
	padding-left: 30px;
	padding-right: 30px;
	padding-top: 15px;
}
</style>
