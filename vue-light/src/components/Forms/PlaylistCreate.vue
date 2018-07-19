<template>
  <card>
    <h4 slot="header" class="card-title">Playlist Ekle</h4>
    <h2 v-if="isCreated" class="float-center success">Playlist Eklendi</h2>
    <form>         

      <div class="row">
        <div class="col-md-12">
          <fg-input type="text"
                    label="Adı"
                    placeholder="Adı"
                    v-model="playlist.name">
          </fg-input>
        </div>
      </div>
        <div class="text-center">
        <button type="submit" class="btn btn-info btn-fill float-center" @click.prevent="createPlaylist">
          Ekle
        </button>
      </div>
      <div class="clearfix"></div>
    </form>
  </card>
</template>
<script>
  import Card from 'src/components/UIComponents/Cards/Card.vue'
  import axios from 'axios'

  export default {
    components: {
      Card
    },
    data () {
      return {
        playlist: {
          name: '',
          user: {
            id:1
            }
        },
        isCreated : false
      }
    },
    methods: {
      createPlaylist() {
        axios.post('/playlist/save', {
           'name' : this.playlist.name,
           'user' : this.playlist.user ,
            }).then( (res) => {
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
