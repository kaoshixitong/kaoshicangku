<template>
	<div id="app">
		<div id="nav">
			<!-- <router-link to="/">Home</router-link> |
      <router-link to="/about">About</router-link> -->
		</div>
		<!-- <router-view :badgenum="badgenum" @badgedown="down" /> -->
		<router-view
			@getAxiosHeader="axiosHeader"
			:AxiosHeader="AxiosHeader"
			@postPaperId="postPaperIdTo"
			:paperID="paperID"
      :examID="examID"
		/>
	</div>
</template>

<style></style>

<script>
export default {
	name: 'App',
	data() {
		return {
			AxiosHeader: '',
			paperID: -1,
			examID: -1,
		}
	},
	methods: {
		axiosHeader(mes) {
			this.AxiosHeader = mes
		},
		postPaperIdTo(mes, mes2) {
      this.paperID = mes
      this.examID = mes2
		},
	},
}
</script>
