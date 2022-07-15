<template>

  <nav class="navbar navbar-expand navbar-dark bg-dark">
    <div class="nav navbar-nav">
      <router-link to="/create-task" class="nav-link">Create Tasks</router-link>
      <router-link to="/list-tasks" class="nav-link">List Tasks</router-link>|
    </div>
  </nav>
  <br>
  <router-view/>
</template>


