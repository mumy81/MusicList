<template>
  <div class="content">
    <div class="container-fluid">
    
      
      <div class="row">
       
        <div class="col-md-10">
          <card>
            <template slot="header">
              <h5 class="title">Playlistlerim</h5>
              <p class="category"></p>
            </template>
            <l-table :data="tableData.data"
                     :columns="tableData.columns">
              <template slot="columns"></template>

              <template slot-scope="{row}">
                <td>
                  <Checkbox v-model="row.checked"></Checkbox>
                </td>
                <td>{{row.title}}</td>
                <td class="td-actions text-right">
                  <button type="button" class="btn-simple btn btn-xs btn-info" v-tooltip.top-center="editTooltip">
                    <i class="fa fa-edit"></i>
                  </button>
                  <button type="button" class="btn-simple btn btn-xs btn-danger" v-tooltip.top-center="deleteTooltip">
                    <i class="fa fa-times"></i>
                  </button>
                </td>
              </template>
            </l-table>
            <div class="footer">
              <hr>
              <div class="stats">
                <i class="fa fa-history"></i> Updated 3 minutes ago
              </div>
            </div>
          </card>

        </div>
      </div>
    </div>
  </div>
</template>
<script>
  import ChartCard from 'src/components/UIComponents/Cards/ChartCard.vue'
  import StatsCard from 'src/components/UIComponents/Cards/StatsCard.vue'
  import Card from 'src/components/UIComponents/Cards/Card.vue'
  import LTable from 'src/components/UIComponents/Table.vue'
  import Checkbox from 'src/components/UIComponents/Inputs/Checkbox.vue'

  export default {
    components: {
      Checkbox,
      Card,
      LTable,
      ChartCard,
      StatsCard
    },
    data () {
      return {
        user: {}        
      }
    },
    created: function () {
    // `this` points to the vm instance
     if(this.$cookie.get('isLogin') != 'true' ) {
        this.$router.push('/app/login')
      }
      console.log('here is ovewview : ' + this.$cookie.get('isLogin'))
      console.log(this.$cookie.get('user'))
      this.user=this.$cookie.get('user')
      }
   
  }
</script>
<style>

</style>
