<template>
	<div class="page">
		<van-nav-bar title="消息" fixed />

		<!-- 课程推荐部分 -->
		<!-- 第1条消息 -->
		<van-swipe-cell>
			<van-card
				desc="[图片消息]"
				title="联系人"
				class="goods-card"
				thumb="http://img2.imgtn.bdimg.com/it/u=1858137112,3715794968&fm=26&gp=0.jpg"
				:tag="tag"
				right-width="auto"
			/>
			<template #right>
				<van-button
					square
					type="warning"
					:text="buttonifon"
					class="delete-button"
					@click="collection"
				/>
				<van-button
					square
					text="删除"
					type="danger"
					class="delete-button"
					@click="del"
				/>
			</template>
		</van-swipe-cell>

		<!-- 第2条消息 -->
		<van-swipe-cell>
			<van-card
				desc="[图片消息]"
				title="联系人2"
				class="goods-card"
				thumb="http://up.enterdesk.com/edpic/d8/92/7e/d8927e1038f8cfd9278e4d66e171ef4e.jpg"
				:tag="tag2"
				right-width="auto"
			/>
			<template #right>
				<van-button
					square
					type="warning"
					:text="buttonifon2"
					class="delete-button"
					@click="collection2"
				/>
				<van-button
					square
					text="删除"
					type="danger"
					class="delete-button"
					@click="del"
				/>
			</template>
		</van-swipe-cell>
	</div>
</template>

<script>
import { Dialog } from 'vant'
import { Toast } from 'vant'
export default {
	name: 'Chat',
	data() {
		return {
			active: 'chat',
			tag: '未读',
			tag2: '',
			buttonifon: '标记已读',
			buttonifon2: '标记未读',
		}
	},
	methods: {
		del() {
			Toast('删除成功')
		},
		collection() {
			// Toast('收藏成功')
			// console.log(this.tag)
			if (this.tag === '未读') {
				this.tag = ''
				this.buttonifon = '标记未读'
				this.$emit('badgedown')
			} else {
				this.tag = '未读'
				this.buttonifon = '标记已读'
				this.$emit('badgeup')
			}
		},
		collection2() {
			// Toast('收藏成功')
			// console.log(this.tag)
			if (this.tag2 === '未读') {
				this.tag2 = ''
				this.buttonifon2 = '标记未读'
				this.$emit('badgedown')
			} else {
				this.tag2 = '未读'
				this.buttonifon2 = '标记已读'
				this.$emit('badgeup')
			}
		},
		// toLogin() {
		// 	this.$router.push({ path: '/login' })
		// },
		// beforeClose({ position, instance }) {
		// 	switch (position) {
		// 		case 'cell':
		// 		case 'outside':
		// 			instance.close()
		// 			break
		// 		case 'right':
		// 			Dialog.confirm({
		// 				message: '确定删除吗？',
		// 			})
		// 				.then(() => {
		// 					instance.close()
		// 					console.log('确定')
		// 				})
		// 				.catch(() => {
		// 					console.log('取消')
		// 				})
		// 			break
		// 	}
		// },
	},
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.con {
	margin-top: 46px;
}
.bottom-button {
	width: 160px;
}
.img-size {
	width: 100%;
	height: 186px;
}
.goods-card {
	margin: 0;
	background-color: white;
	/* height: 40px; */
}
div.van-swipe-cell__wrapper {
	height: 50px !important;
}
div.van-swipe-cell {
	height: 50px !important;
}
a.van-card__thumb {
	height: 40px !important;
	width: 40px !important;
}
div.van-image {
	height: 40px !important;
	width: 40px !important;
}
img.van-image__img {
	height: 35px !important;
	width: 35px !important;
}
.delete-button {
	height: 50px;
}
</style>
