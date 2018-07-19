<template>
  <nav class="navbar navbar-expand-lg">
    <div class="container-fluid">
      <a class="navbar-brand" href="#">Panel</a>
     
     <div class="div-center">
       <form>       
          <input type="text"
                    label="Kullanıcı Adı"
                    placeholder="Arama"
                    v-model="key"
                    />
                    <button type="submit" class="btn btn-info btn-fill float-center" @click.prevent="search">
          Ara ->
        </button>
          </form>
      </div>

       <ul class="navbar-nav ml-auto">
          <li class="nav-item">
            
          <li class="nav-item">
            <router-link tag="li" to="/admin/logout">
 <a>Çıkış</a>
</router-link>
          </li>
        </ul>
     
    </div>
  </nav>
</template>
<script>
import Card from 'src/components/UIComponents/Cards/Card.vue'
  export default {
    components: {
      Card
    },
    computed: {
      routeName () {
        const {name} = this.$route
        return this.capitalizeFirstLetter(name)
      }
    },
    data () {
      return {
        activeNotifications: false,
        key: ''
      }
    },
    methods: {
      capitalizeFirstLetter (string) {
        return string.charAt(0).toUpperCase() + string.slice(1)
      },
      toggleNotificationDropDown () {
        this.activeNotifications = !this.activeNotifications
      },
      closeDropDown () {
        this.activeNotifications = false
      },
      toggleSidebar () {
        this.$sidebar.displaySidebar(!this.$sidebar.showSidebar)
      },
      hideSidebar () {
        this.$sidebar.displaySidebar(false)
      },
      search () {
        this.$sidebar.displaySidebar(false)
      }
    }
  }

</script>
<style>
.div-center {
  margin: auto;
}
</style>
