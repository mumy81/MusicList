<template>
  <div class="content">
    <div class="container-fluid">
      <div class="row">
        <div class="col-12">
         <card>
    <div class="col-md-6 div-center"><h2 v-if="this.$cookie.get('isLogin')" class="float-center">Çıkış Yapıldı</h2></div>
    
          </card>

        </div>

        </div>
    </div>
  </div>
</template>
<script>
  
  export default {
    name: 'Logout',
    components: {
            },
       methods: {
            },
    data () {
      return {
        } },
    created(){
      this.$cookie.set('isLogin', false , { expires: '30m' })  
  }
  }
</script>
<style scoped>
.div-center {
  margin: auto;
}
</style>

