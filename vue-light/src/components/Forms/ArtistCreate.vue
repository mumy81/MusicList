<template>
  <card>
    <h4 slot="header" class="card-title">Sanatçı Ekleme</h4>
    <h2 v-if="isCreated" class="float-center success">Ekleme Başarılı</h2>
    <form>         

      <div class="row">
        <div class="col-md-12">
          <fg-input type="text"
                    label="Adı"
                    placeholder="Adı"
                    v-model="artist.name">
          </fg-input>
        </div>
      </div>
       <div class="row">
        <div class="col-md-12">
          <fg-input type="text"
                    label="Soyadı"
                    placeholder="Soyadı"
                    v-model="artist.surname">
          </fg-input>
        </div>
      </div>

                   
        <div class="text-center">
        <button type="submit" class="btn btn-info btn-fill float-center" @click.prevent="createArtist">
          Artist Ekle
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
        artist: {
	name:"",
	surname:""
	       },
        isCreated : false
      }
    },
    methods: {
      createArtist() {
       axios.post('/artist/add', {
           'name' : this.artist.name,
           'surname' : this.artist.surname
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
