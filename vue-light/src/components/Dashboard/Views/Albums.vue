<template>
  <div class="content">
    <div class="container-fluid">
      <div class="row">
        <div class="col-12">
          <card>
            <template slot="header">
              <h4 class="card-title">Albümler</h4>
              <h4 v-if="this.$cookie.get('isLogin')" class="card-title">Giriş Yapılı</h4>
              {{this.$cookie.get('isLogin')}}
              <p class="card-category"></p>
            </template>
            <div class="table-responsive table-hover table-striped">
              <table class="table">
    <thead>
      <tr>
        <slot name="columns">
          <th>Adı</th>
          <th>Artist</th>
          <th>Tarihi</th>
        </slot>
      </tr>
    </thead>
    <tbody>
    <tr v-for="album in albums">
      <slot :row="album">
        <td>{{album.name}}</td>
        <td>{{album.artist.name}}</td>
        <td>{{album.date}}</td>
      </slot>
    </tr>
    </tbody>
  </table>
                          </div>
          </card>

        </div>

        </div>
    </div>
  </div>
</template>
<script>
  import axios from 'axios'
  import LTable from 'src/components/UIComponents/Table.vue'
  import Card from 'src/components/UIComponents/Cards/Card.vue'
  const tableColumns = ['Id', 'Name', 'Artist', 'Date']
  const tableData = []
  export default {
    name: 'Albums',
    components: {
      LTable,
      Card
    },
    data () {
      return {
        albums:[]    
      }
    },
    created(){
    axios.get('/album/all', { headers: {
	  'Access-Control-Allow-Origin': '*'
	}}).then( (res) => {
      this.albums=res.data;
      console.log(this.album);
      })
      console.log(this.$cookie.get('test'));
      () => {if(!this.$cookie.get('isLogin')) {
        this.$router.push('/admin/login')
      }}
  }
  }
</script>
<style>
</style>
