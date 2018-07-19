<template>
  <div class="content">
    <div class="container-fluid">

      <div>
    <vue-good-table
      :columns="columns"
      :rows="rows"/>
  </div>

      <div class="row">
        <div class="col-12">
          <card>
            <template slot="header">
              <h4 class="card-title">Playlistler</h4>
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
  import VueGoodTable  from 'vue-good-table'

    export default {
    name: 'Playlists',
    props: {
      playlists: { type: Object, required: true }
    },
    components: {
      LTable,
      Card,
      VueGoodTable
    },
    data () {
      return {
        playlist: {},
        columns: [
        {
          label: 'Name',
          field: 'name',
        },
        {
          label: 'Age',
          field: 'age',
          type: 'number',
        },
        {
          label: 'Created On',
          field: 'createdAt',
          type: 'date',
          dateInputFormat: 'YYYY-MM-DD',
          dateOutputFormat: 'MMM Do YY',
        },
        {
          label: 'Percent',
          field: 'score',
          type: 'percentage',
        },
      ],
      rows: [
        { id:1, name:"John", age: 20, createdAt: '201-10-31:9: 35 am',score: 0.03343 },
        { id:2, name:"Jane", age: 24, createdAt: '2011-10-31', score: 0.03343 },
        { id:3, name:"Susan", age: 16, createdAt: '2011-10-30', score: 0.03343 },
        { id:4, name:"Chris", age: 55, createdAt: '2011-10-11', score: 0.03343 },
        { id:5, name:"Dan", age: 40, createdAt: '2011-10-21', score: 0.03343 },
        { id:6, name:"John", age: 20, createdAt: '2011-10-31', score: 0.03343 },
      ],
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
