import DashboardLayout from '../components/Dashboard/Layout/DashboardLayout.vue'
// GeneralViews
import NotFound from '../components/GeneralViews/NotFoundPage.vue'

// Admin pages
import Overview from 'src/components/Dashboard/Views/Overview.vue'
import UserProfile from 'src/components/Dashboard/Views/UserProfile.vue'
import Albums from 'src/components/Dashboard/Views/Albums.vue'
import Login from 'src/components/Dashboard/Views/Login.vue'
import Logout from 'src/components/Logout.vue'
import Playlists from 'src/components/Dashboard/Views/Playlists.vue'
import Artists from 'src/components/Dashboard/Views/Artists.vue'
import Tracks from 'src/components/Dashboard/Views/Tracks.vue'
import Playlist from 'src/components/Dashboard/Views/Playlist.vue'
import UserCreate from 'src/components/Forms/UserCreate.vue'
import PlaylistCreate from 'src/components/Forms/PlaylistCreate.vue'
import TrackCreate from 'src/components/Forms/TrackCreate.vue'
import ArtistCreate from 'src/components/Forms/ArtistCreate.vue'
import CreateAlbum from 'src/components/Dashboard/Views/Albums/CreateAlbum.vue'

const routes = [
  {
    path: '/',
    component: DashboardLayout,
    redirect: '/app/overview'
  },
  {
    path: '/app',
    component: DashboardLayout,
    redirect: '/app/overview',
    children: [
      {
        path: 'overview',
        name: 'Overview',
        component: Overview
      },
      {
        path: 'user',
        name: 'User',
        component: UserProfile
      },
      {
        path: 'register',
        name: 'UserCreate',
        component: UserCreate
      },
      {
        path: 'track_crate',
        name: 'TrackCreate',
        component: TrackCreate
      },{
        path: 'artist_create',
        name: 'ArtistCreate',
        component: ArtistCreate
      }
      ,{
        path: 'playlist_create',
        name: 'PlaylistCreate',
        component: PlaylistCreate
      },
      {
        path: 'playlist/:id',
        name: 'Playlist',
        component: Playlist
      },
      {
        path: 'playlists',
        name: 'Playlists',
        component: Playlists
      },
      {
        path: 'tracks',
        name: 'Tracks',
        component: Tracks
      },
      {
        path: 'artists',
        name: 'Artists',
        component: Artists
      },
      {
        path: 'login',
        name: 'Login',
        component: Login
      },{
        path: 'logout',
        name: 'Logout',
        component: Logout
      },
      {
        path: 'albums',
        name: 'Albums',
        component: Albums
      },
      {
        path: 'create_album',
        name: 'CreateAlbum',
        component: CreateAlbum
      }
    ]
  },
  { path: '*', component: NotFound }
]

/**
 * Asynchronously load view (Webpack Lazy loading compatible)
 * The specified component must be inside the Views folder
 * @param  {string} name  the filename (basename) of the view to load.
function view(name) {
   var res= require('../components/Dashboard/Views/' + name + '.vue');
   return res;
};**/

export default routes
