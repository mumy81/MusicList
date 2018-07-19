<template>

</template>
<script>
  
  export default {
    name: 'LoginCheck',
     methods: {
            },
    data () {
      return {
        } },
    created(){
      if(this.$cookie.get('isLogin') != 'true' ) {
        this.$router.push('/admin/login')
      }
      }
  }

</script>
<style scoped>
.div-center {
  margin: auto;
}
</style>

