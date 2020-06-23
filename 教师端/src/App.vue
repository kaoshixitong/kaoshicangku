<template>
	<div id="app">
		<div id="nav">
			<!-- <router-link to="/">Home</router-link> |
			<router-link to="/about">About</router-link> -->
		</div>
		<router-view @getAxiosHeader="axiosHeader" :AxiosHeader="AxiosHeader" />
	</div>
</template>

<style></style>

<script>
export default {
	name: 'App',
	data() {
		return {
			AxiosHeader: '',
		}
	},
	methods: {
		axiosHeader(mes) {
			this.AxiosHeader = mes
		},
	},
}
</script>
