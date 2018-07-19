<template>
  <card>
    <h4 slot="header" class="card-title">Şarkı Ekleme</h4>
    <h2 v-if="isCreated" class="float-center success">Ekleme Başarılı</h2>
    <form>         

      <div class="row">
        <div class="col-md-12">
          <fg-input type="text"
                    label="Adı"
                    placeholder="Adı"
                    v-model="track.name">
          </fg-input>
        </div>
      </div>
       <div class="row">
        <div class="col-md-12">
          <fg-input type="text"
                    label="Süresi"
                    placeholder="Süresi"
                    v-model="track.duration">
          </fg-input>
        </div>
      </div>

       <div class="row">
        <div class="col-md-12">
          <fg-input type="text"
                    label="Sanatçı Adı:"
                    placeholder="Sanatçı Adı:"
                    v-model="track.artist.name">
          </fg-input>
        </div>
      </div>

       <div class="row">
        <div class="col-md-12">
          <fg-input type="text"
                    label="Sanatçı Soyadı:"
                    placeholder="Sanatçı Soyadı:"
                    v-model="track.artist.surname">
          </fg-input>
        </div>
      </div>

       <div class="row">
        <div class="col-md-12">
          <fg-input type="text"
                    label="Türü"
                    placeholder="Türü"
                    v-model="track.genre">
          </fg-input>
        </div>
      </div>

                   
        <div class="text-center">
        <button type="submit" class="btn btn-info btn-fill float-center" @click.prevent="createTrack">
          Şarkı Ekle
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
        track: {
	name:"",
  artist: {name:"", surname:""} ,
  	duration:"",
  genre:""
	       },
        isCreated : false
      }
    },
    methods: {
      createTrack() {
       axios.post('/track/add', {
           'name' : this.track.name,
           'artist' : this.track.artist,
           'duraton' : this.track.duration,
          'genre' : this.track.genre
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
