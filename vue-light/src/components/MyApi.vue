<script>
import axios from 'axios';

var myApi = axios.create({
  baseURL: 'http://localhost:8080/api',
  timeout: 1000,
  headers: {'Authorization': ''}
});

  export default {
      name: 'MyApi',
      myApi
  }
</script>