<template>
  <div class="content">
    <div class="container-fluid">
      <div class="row">
        <div class="col-12">
          <card>
            <template slot="header">
              <h4 class="card-title">Striped Table with Hover</h4>
              <p class="card-category">Here is a subtitle for this table</p>
            </template>
            <div class="table-responsive">
              <table class="table-hover table-striped">
                <tr>
                  <th>A</th>
                  <th>B</th>
                  <th>C</th>
                  <th>D</th>
                </tr>
              
                <tr v-bind:key="albums" v-for="album in albums">
                  <td>{{album.name}}</td>
                  <td>içerik2</td>
                  <td>içerik3</td>
                  <td>içerik4</td>
                </tr>
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
  // import LTable from 'src/components/UIComponents/Table.vue'
  // import Card from 'src/components/UIComponents/Cards/Card.vue'
    export default {
    name: 'Albums',
    components: {
      
    },
    data () {
      return {
        albums: [],
           
      }
    },
    created(){
    axios.get('/album/all').then( (res) => {
      this.albums = res.data;
      console.log(this.albums);
      console.log(res.data);
      })
  }
  }
</script>
<style>
</style>
