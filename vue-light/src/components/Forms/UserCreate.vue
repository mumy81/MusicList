<template>
  <card>
    <h4 slot="header" class="card-title">Kullanıcı Kayıt Formu</h4>
    <h2 v-if="isCreated" class="float-center success">Kayıt Başarılı</h2>
    <form>         
<div class="col-md-6 div-center">
      <div class="row">
        <div class="col-md-12">
          <fg-input type="text"
                    label="Adı"
                    placeholder="Adı"
                    v-model="user.name">
          </fg-input>
        </div>
      </div>
       <div class="row">
        <div class="col-md-12">
          <fg-input type="text"
                    label="Kullanıcı Adı"
                    placeholder="Kullanıcı Adı"
                    v-model="user.username">
          </fg-input>
        </div>
      </div>

      <div class="row">
        <div class="col-md-12">
          <fg-input type="text"
                    label="Email"
                    placeholder="Email"
                    v-model="user.email">
          </fg-input>
        </div>
      </div>
      <div class="row">
        <div class="col-md-12">
          <fg-input type="text"
                    label="Parola"
                    placeholder="Parola"
                    v-model="user.password">
          </fg-input>
        </div>
      </div>
              
        <div class="text-center">
        <button type="submit" class="btn btn-info btn-fill float-center" @click.prevent="createUser">
          Kayıt Ol
        </button>
      </div>
      <div class="clearfix"></div>
      </div>
    </form>
  </card>
</template>
<script>
  import Card from 'src/components/UIComponents/Cards/Card.vue'
  import axios from 'axios'

  export default {
    name:'UserCreate',
    components: {
      Card
    },
    data () {
      return {
        user: {
	username:"",
	email:"",
	name:"",
	password:""
	       },
        isCreated : false
      }
    },
    methods: {
      createUser() {
        alert('Your data: ' + JSON.stringify(this.user))
        axios.post('/user/add', {
           'name' : this.user.name,
           'username' : this.user.username ,
           'password' : this.user.password,
           'date' : this.user.password }).then( (res) => {
      console.log(res.status);
      if (res.status == 200) {
        this.isCreated = true;
      }
      })

      }
    }
  }

</script>
<style>

</style>
