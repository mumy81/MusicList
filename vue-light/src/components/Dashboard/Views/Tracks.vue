<template>
  <div class="content">
    <div class="container-fluid">
      <div class="row">
        <div class="col-12">
          <card>
            <template slot="header">
              <h4 class="card-title">Şarkılar</h4>
              <div class="float-center"><router-link tag="li" to="/playlist_create">
  <button> Playlist Ekle </button>
</router-link></div>
            </template>
            <div class="table-responsive table-hover table-striped">
              <table class="table">
    <thead>
      <tr>
        <slot name="columns">
          <th>Adı</th>
          <th>Tarihi</th>
          <th>Kullanıcı</th>
        </slot>
      </tr>
    </thead>
    <tbody>
    <tr v-for="playlist in playlists">
      <slot :row="playlist">
        <td>{{playlist.name}}</td>
        <td>{{playlist.createDate}}</td>
        <td>{{playlist.user.name}}</td>
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
    export default {
    name: 'Playlists',
    props: {
      playlists: { type: Object, required: true }
    },
    components: {
      LTable,
      Card
    },
    data () {
      return {
        playlist: {},
        id:0
      }
    },
    created(){
    console.log(this.$route);
    this.id = this.$route.params.id;
    axios.get('api/playlist/all/', {   headers: {
	  	}}).then( (res) => {
      this.playlists=res.data;
      console.log(this.playlists);
      })
  }
  }
</script>
<style>
</style>
