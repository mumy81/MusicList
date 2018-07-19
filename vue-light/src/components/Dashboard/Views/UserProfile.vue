<template>
  <div class="content">
    <div class="container-fluid">
      <div class="row">
        <div class="col-md-8">
          <edit-profile-form>
          </edit-profile-form>
        </div>
        </div>
    </div>
  </div>
</template>
<script>
  import EditProfileForm from './UserProfile/EditProfileForm.vue'
  import UserCard from './UserProfile/UserCard.vue'

  export default {
    components: {
      EditProfileForm,
      UserCard
    },
    created: function () {
    // `this` points to the vm instance
     if(this.$cookie.get('isLogin') != 'true' ) {
        this.$router.push('/app/login')
      }
      console.log('here is userprofile : ' + this.$cookie.get('isLogin'))
      }
  }

</script>
<style>

</style>
