<template>
  <div class="content">
    <div class="container-fluid">
      <div class="row">
        <div class="col-12">
          <card>
            <template slot="header">
              <h1>{{id}}</h1>
              <h4 class="card-title">Playlist Adı:{{playlist.name}}</h4>
              <p class="card-category"></p>
            </template>
            <div class="table-responsive table-hover table-striped">
              <table class="table">
    <thead>
      <tr>
        <slot name="columns">
          <th>Adı</th>
          <th>Sanatçısı</th>
          <th>Albümü</th>
          <th>Yılı</th>
          <th>Türü</th>
          <th>Süre</th>
        </slot>
      </tr>
    </thead>
    <tbody>
    <tr v-for="track in playlist.tracks">
      <slot :row="track">
        <td>{{track.name}}</td>
        <td>{{track.artist.name}}</td>
        <td>{{track.album.name}}</td>
        <td>{{track.album.date}}</td>
        <td>{{track.genre}}</td>
        <td>{{track.duration}}</td>
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
      playlist: { type: Object, required: true }
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
    axios.get('api/playlist/'+this.id, {   headers: {
	  'Access-Control-Allow-Origin': '*'
	}}).then( (res) => {
      this.playlist=res.data;
      console.log(this.playlist);
      }, function (err) {
            this.error()
          })
  }
  }
</script>
<style>
</style>
