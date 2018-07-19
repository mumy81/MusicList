<template>
  <card>
    <h4 slot="header" class="card-title">Albüm Ekle</h4>
    <h2 v-if="isCreated" class="float-center success">Albüm Eklendi</h2>
    <form>         

      <div class="row">
        <div class="col-md-12">
          <fg-input type="text"
                    label="Adı"
                    placeholder="Adı"
                    v-model="album.name">
          </fg-input>
        </div>
      </div>

      <div class="row">
        <div class="col-md-12">
          <fg-input type="text"
                    label="Sanatçı"
                    placeholder="Sanatçı"
                    v-model="album.artist.name">
          </fg-input>
        </div>
      </div>
      <div class="row">
        <div class="col-md-12">
          <fg-input type="text"
                    label="Tarih"
                    placeholder="Çıkış Yılı"
                    v-model="album.date">
          </fg-input>
        </div>
      </div>
           
        <div class="text-center">
        <button type="submit" class="btn btn-info btn-fill float-center" @click.prevent="createAlbum">
          Albüm Ekle
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
        album: {
          name: '',
          artist: {
            name: '',
          },
          date: ''
        },
        isCreated : false
      }
    },
    methods: {
      createAlbum() {
        alert('Your data: ' + JSON.stringify(this.album))
        axios.post('/album/add', {
           'name' : this.album.name,
           'artist' : this.album.artist ,
           'date' : this.album.date 
           , headers: {
    'Access-Control-Allow-Origin': '*',
    'Content-Type': 'application/json'
	}}).then( (res) => {
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
