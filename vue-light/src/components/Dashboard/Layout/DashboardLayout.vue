<template>
  <div class="wrapper">
    <side-bar>
      <mobile-menu slot="content"></mobile-menu>
      <sidebar-link to="/app/overview">
        <i class="nc-icon nc-chart-pie-35"></i>
        <p>Panel</p>
      </sidebar-link>
      <sidebar-link to="/app/user">
        <i class="nc-icon nc-circle-09"></i>
        <p>Hesabım</p>
      </sidebar-link>
      <sidebar-link to="/app/playlists">
        <i class="nc-icon nc-notes"></i>
        <p>Playlistlerim</p>
      </sidebar-link>
      <sidebar-link to="/app/albums">
        <i class="nc-icon nc-paper-2"></i>
        <p>Albümler</p>
      </sidebar-link>
      <sidebar-link to="/app/artists">
        <i class="nc-icon nc-paper-2"></i>
        <p>Sanatçılar</p>
      </sidebar-link>
        
    </side-bar>
    <div class="main-panel">
      <top-navbar></top-navbar>

      <dashboard-content @click="toggleSidebar">

      </dashboard-content>

      <content-footer></content-footer>
    </div>
  </div>
</template>
<style lang="scss">

</style>
<script>
  import TopNavbar from './TopNavbar.vue'
  import ContentFooter from './ContentFooter.vue'
  import DashboardContent from './Content.vue'
  import MobileMenu from './MobileMenu.vue'
  export default {
    components: {
      TopNavbar,
      ContentFooter,
      DashboardContent,
      MobileMenu
    },
    methods: {
      toggleSidebar () {
        if (this.$sidebar.showSidebar) {
          this.$sidebar.displaySidebar(false)
        }
      }
    }
  }

</script>
