<template>
  <div class="content">
    <div class="container-fluid">
      <div class="row">
        <div class="col-12">
         <card>
    <div class="col-md-6 div-center"><h4 slot="header" class="card-title">Kullanıcı Girişi</h4>
   
        </div>
    <h2 v-if="isLogin" class="float-center">Giriş Yapıldı</h2>
      
    <form>         

      <div class="row">
        <div class="col-md-6 div-center">
          <fg-input type="text"
                    label="Kullanıcı Adı"
                    placeholder="Kullanıcı Adı"
                    v-model="user.username">
          </fg-input>
        </div>
      </div>

      <div class="row">
         <div class="col-md-6 div-center">
          <fg-input type="password"
                    label="Parola"
                    placeholder="Parola"
                    v-model="user.password">
          </fg-input>
        </div>
      </div>
                
        <div class="col-md-6 text-center div-center">
         

        <button type="submit" class="btn btn-info btn-fill float-center" @click.prevent="login()">
          Giriş ->
        </button>
<br>
<br>
<br>
<br>
         <button type="submit" class="btn btn-info btn-fill float-center" @click.prevent="register()">
          Kaydol ->
        </button>

       

      </div>
      <div class="clearfix"></div>
    </form>
  </card>

        </div>

        </div>
    </div>
  </div>
</template>
<script>
  import axios from 'axios'
  import Card from 'src/components/UIComponents/Cards/Card.vue'
  import base64 from 'base-64'
    // axios.defaults.baseURL = 'http://localhost:8080'
  export default {
    name: 'Login',
    components: {
            },
       methods: {
        login () {
            axios.post('/api/user/login', {
            username : this.user.username,
            password : this.user.password ,
            }).then( (response) => {
             if (response.status === 200) {
               this.$cookie.set('token',response.headers.token , { expires: '30m' })
               this.$cookie.set('isLogin', true , { expires: '30m' })
               this.$cookie.set('user', response.data.id , { expires: '30m' })
              // Vue.http.headers.common['Authorization'] = 'Basic ' + response.data
              console.log(this.$cookie.get('user'))
              this.$router.push('/app/overview')              
            }
          }, function (err) {
            console.log('err', err)
          })
          
        } ,
        register() {
          this.$router.push('/app/register')
        }},
    data () {
      return {
        user:{
          username : "",
          password  : ""
        },
        isLogin:false,
        code : '' ,
        }
    },
    created(){
      console.log(this.$cookie.get('isLogin'))    
  },
  computed(){
    
  }
  }
</script>
<style scoped>
.div-center {
  margin: auto;
}
</style>

