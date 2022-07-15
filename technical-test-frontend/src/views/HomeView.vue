<template>
  <div class="home">
    <ListTasks></ListTasks>
  </div>
</template>

<script>
// @ is an alias to /src
import ListTasks from '@/components/ListTasks.vue'

export default {
  name: 'HomeView',
  components: {
    ListTasks
  }
}
</script>
