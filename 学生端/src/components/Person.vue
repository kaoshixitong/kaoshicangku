<template>
	<div class="page">
		<!-- <van-nav-bar
			title="个人中心"
			left-arrow
			@click-left="onClickLeft"
		/> -->
		<van-nav-bar title="个人资料">
			<template #left>
				<van-icon
					name="arrow-left"
					size="18"
					@click="onClickLeft"
					color="#969799"
				/>
			</template>
		</van-nav-bar>
		<!-- <router-view /> -->

		<!-- 头像 -->
		<!-- <van-cell title="单元格" is-link icon="http://img5.imgtn.bdimg.com/it/u=3196197975,1282739574&fm=11&gp=0.jpg" /> -->
		<!-- <van-cell is-link title="头像" @click="show = true" /> -->
		<van-cell title="头像" @click="show = true">
			<!-- 使用 right-icon 插槽来自定义右侧图标 -->
			<template #right-icon>
				<img class="image" :src="userimg" alt="" />
			</template>
		</van-cell>
		<van-action-sheet
			v-model="show"
			:actions="actions"
			cancel-text="取消"
			close-on-click-action
			@cancel="onCancel"
			@select="onCancel2"
		/>
		<!-- 上传头像 -->
		<!-- <el-upload
			class="avatar-uploader"
			action="http://localhost:9090/user/photoUpload"
			:show-file-list="false"
			:on-success="handleAvatarSuccess"
			:before-upload="beforeAvatarUpload"
			:headers="Header"
		>
			<img v-if="imageUrl" :src="imageUrl" class="avatar" />
			<i v-else class="el-icon-plus avatar-uploader-icon"></i>
		</el-upload> -->
		<!-- <van-uploader :after-read="afterRead" />
		<van-uploader>
			<van-button icon="photo" type="primary">上传文件</van-button>
		</van-uploader> -->
		<!-- 图片浏览 -->
		<van-overlay :show="show2" @click="show2 = false">
			<div class="wrapper" @click.stop>
				<img class="image-big" :src="userimg" alt="" />
			</div>
		</van-overlay>
		<van-cell-group>
			<!-- 姓名 -->
			<van-cell is-link @click="dialog">
				<!-- 使用 title 插槽来自定义标题 -->
				<template #title>
					<span class="custom-title">姓名</span>
					<span class="cell-name">{{ student.name ? student.name : '' }}</span>
				</template>
			</van-cell>

			<!-- 性别 -->
			<van-cell is-link to="changesex">
				<!-- 使用 title 插槽来自定义标题 -->
				<template #title>
					<span class="custom-title">性别</span>
					<span class="cell-name">{{ student.sex }}</span>
				</template>
			</van-cell>

			<!-- 班级 -->
			<van-cell is-link to="changeclass">
				<!-- 使用 title 插槽来自定义标题 -->
				<template #title>
					<span class="custom-title">班级</span>
					<span class="cell-name">{{
						student.classId ? student.classId : ''
					}}</span>
				</template>
			</van-cell>

			<!-- 学号 -->
			<van-cell is-link @click="dialog2">
				<!-- 使用 title 插槽来自定义标题 -->
				<template #title>
					<span class="custom-title">学号</span>
					<span class="cell-name">{{
						student.studentId ? student.studentId : ''
					}}</span>
				</template>
			</van-cell>

			<!-- 手机号 -->
			<van-cell is-link to="changeiphone">
				<!-- 使用 title 插槽来自定义标题 -->
				<template #title>
					<span class="custom-title">电话</span>
					<span class="cell-name">{{
						student.phone ? student.phone : ''
					}}</span>
				</template>
			</van-cell>

			<!-- 生日 -->
			<van-cell is-link to="changebirthday">
				<!-- 使用 title 插槽来自定义标题 -->
				<template #title>
					<span class="custom-title">生日</span>
					<span class="cell-name">{{
						student.birthday ? student.birthday : ''
					}}</span>
				</template>
			</van-cell>

			<!-- 邮箱 -->
			<van-cell is-link to="changeemail">
				<!-- 使用 title 插槽来自定义标题 -->
				<template #title>
					<span class="custom-title">邮箱</span>
					<span class="cell-name">{{
						student.email ? student.email : ''
					}}</span>
				</template>
			</van-cell>
		</van-cell-group>

		<div style="margin: 16px;">
			<van-button block type="info" native-type="submit" to="/page">
				退出登录
			</van-button>
		</div>
	</div>
</template>

<script>
import { Dialog } from 'vant'
import axios from 'axios'
import { Toast } from 'vant'
export default {
	name: 'Contact',
	props: ['AxiosHeader'],
	components: {
		[Dialog.Component.name]: Dialog.Component,
	},
	data() {
		return {
			show: false,
			show2: false,
			actions: [{ name: '拍照' }, { name: '从相册选择' }, { name: '查看原图' }],
			student: {},
			userimg: '',
			imageUrl: '',
			// Header: {
			// 	Authorization: '',
			// },
		}
	},
	methods: {
		onClickLeft() {
			this.$router.back(-1)
		},
		onCancel() {
			Toast('取消')
		},
		onCancel2() {
			this.show2 = true
		},
		dialog() {
			if (this.student.name === '') {
        // Toast('绑定')
        this.$router.push({ path: '/bindname' })
			} else {
				Dialog.confirm({
					message: '实名认证后姓名不可修改，如需修改请联系客服',
					cancelButtonText: '知道了',
					confirmButtonText: '联系客服',
				})
					.then(() => {
						// on confirm
					})
					.catch(() => {
						// on cancel
					})
			}
		},
		dialog2() {
			Dialog.confirm({
				message: '学生学号不可修改，如需修改请联系客服',
				cancelButtonText: '知道了',
				confirmButtonText: '联系客服',
			})
				.then(() => {
					// on confirm
				})
				.catch(() => {
					// on cancel
				})
		},
		// afterRead(File) {
		// 	let upImg = axios.create({
		// 		baseURL: 'http://localhost:9090', //请求域名，基本路径
		// 		headers: {
		// 			Authorization: 'Bearer ' + this.AxiosHeader,
		// 		}, //设置请求头
		// 	})
		// 	upImg
		// 		.post('/user/photoUpload', {
		// 			file: File,
		// 		})
		// 		.then((res) => {
		// 			// this.$router.back(-1)
		// 			console.log(res)
		// 		})
		// 		.catch((err) => {
		// 			console.log(err)
		// 			Toast('操作失败，请稍后重试')
		// 		})
		// 	// 此时可以自行将文件上传至服务器
		// 	console.log(file)
		// },
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
		// save() {
		// 	// let upImage = axios.create({
		// 	// 	baseURL: 'http://localhost:9090', //请求域名，基本路径
		// 	// 	headers: {
		// 	// 		Authorization: 'Bearer ' + this.AxiosHeader,
		// 	// 	}, //设置请求头
		// 	// })
		// 	let formData = new FormData()
		// 	formData.append('name', this.name)
		// 	formData.append('img', this.$refs.file.files[0])
		// 	this.axios
		// 		.post('http://localhost:9090/user/photoUpload', formData, {
		// 			'Content-Type': 'multipart/form-data',
		// 			Authorization: 'Bearer ' + this.AxiosHeader,
		// 		})
		// 		.then((res) => {})
		// },
	},
	created() {
		let getTest = axios.create({
			// baseURL: 'http://localhost:9090', //请求域名，基本路径
			headers: {
				Authorization: 'Bearer ' + this.AxiosHeader,
			}, //设置请求头
		})
		getTest
			.get('http://localhost:9090/user/student/queryInformation')
			.then((res) => {
				console.log(res)
				// console.log(res.data.data)
				// this.userimg = 'http://localhost:9090/photo/' + res.data.data.photo
				this.userimg =
					'http://img5.imgtn.bdimg.com/it/u=3196197975,1282739574&fm=11&gp=0.jpg'
				if (res.data.data.student === null) {
					this.student = {
						name: '',
						sutdentId: '',
					}
				} else {
					this.student = res.data.data.student
				}
			})
			.catch((err) => {
				console.log(err)
			})
		// this.Header.Authorization = 'Bearer ' + this.AxiosHeader
		// axios.headers.Authorization = 'Bearer ' + this.AxiosHeader
	},
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.people {
	margin-top: 46px;
	position: relative;
	display: block;
	padding: 20px 10px;
}
.image {
	height: 50px;
	width: 50px;
	border-radius: 10px;
}
.wrapper {
	display: flex;
	align-items: center;
	justify-content: center;
	height: 90%;
}
.image-big {
	height: 300px;
	width: 300px;
}
.cell-name {
	color: #969799;
	margin-left: 30px;
}
</style>
