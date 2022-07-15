/**
 * This file contains the code to view all the entries 
 * of the task table.
 */
<template>
  <div class="container">
    <h1 class="text-center">Tasks List</h1>
    <div class="card-body">
      <table class="table table-striped">
        <thead>
          <tr>
            <th></th>
            <th>Task Id</th>
            <th>Task Name</th>
            <th>Task Creation</th>
            <th>Task State</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="task in tasks" v-bind:key="task.id">
            <td>
               <router-link :to="{name:'task-detail',params:{id:task.id,taskName:task.name,creationTime:task.creationTime,state:task.state}}" class="btn btn-primary">Detail</router-link>
            </td>
            <td>{{ task.id }}</td>
            <td>{{ task.name }}</td>
            <td>{{ task.creationTime }}</td>
            <td>{{ task.state }}</td>
            <td>
               <div class="row">
                <div class="col-md-4 col-xs-3">
                  <router-link :to="{name:'edit-task',params:{id:task.id,taskName:task.name,creationTime:task.creationTime,state:task.state}}" class="btn btn-success">Edit</router-link>
                </div>
                <div class="col-md-4 col-xs-3">
                  <button class="btn btn-danger" v-on:click="deleteTask(task.id)">Delete</button>
                </div>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import TaskService from "../Services/TaskService";

export default {
  data() {
    return {
      tasks: [],
    };
  },
  created() {
    this.retrieveTasks();

  },
  methods: {
    //this method call a function from service to retrieve all the information from de database
    retrieveTasks() {
      TaskService.getTasks()
        .then((response) => {
          if ( response.status == 200 && Object.keys(response.data).length !== 0 ) {
            this.tasks = response.data;
          }
        })
        .catch((error) => {
          console.log(error);
        })
        .finally(() => {
          //Do somethin if it's needed
        });
    },
    //This method call a function from service to delete a specific task identified by id
    deleteTask(id) {
      if(confirm("Are you sure to delete the task?")){
        TaskService.deleteTask(id)  
          .then((response) => {
            console.log(response.data);
            if(response.data.deleted){
              window.location.href = 'list-tasks';
            }
          })
          .catch((error) => {
            console.log(error);
          })
          .finally(() => {
            //Do somethin if it's needed
          });
      }
    },
  },
};
</script>
