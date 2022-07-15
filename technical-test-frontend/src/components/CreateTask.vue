/**
* This file contains the view form and the code to create a new task
*
*/
<template>
    <div class="container">
       <div class="card">
        <div class="card-header">
            Add New Task
        </div>
        <div class="card body" style="padding:10px;">
            <form v-on:submit.prevent="addTask">
                <div class="form-group">
                    <label for="name">Name:</label>
                    <input class="form-control" type="text" name="name" v-model="task.name" id="name" placeholder="Enter task name">
                    <small class="form-text text-muted">Type task's name</small>
                </div>
                <br>
                <div class="form-group">
                    <label for="name">Time:</label>
                    <input class="form-control" type="time" step="1" name="hour" v-model="task.creationTime" id="hour">
                    <small class="form-text text-muted">Enter task's creation time</small>
                </div>
                <br>
                <div class="form-group">
                    <label for="state">State:</label>
                    <select class="form-control" v-model="task.state">
                        <option value="CREATED">CREATED</option>
                        <option value="RUNNING">RUNNING</option>
                        <option value="DONE">DONE</option>
                    </select>
                    <small class="form-text text-muted">Select task's state</small>
                </div>
                <br>
                <div class="row">
                    <div class="col-md-1 col-xs-2">
                        <button type="submit" class="btn btn-block btn-xs btn-success">Add</button>
                    </div>
                    <div class="col-md-1 col-xs-2">
                        <router-link :to="{name:'list-tasks'}" class="btn btn-block btn-xs btn-danger">Cancel</router-link>
                    </div>
                </div>
            </form>
        </div>
       </div>
    </div>
</template>

<script>

import TaskService from "../Services/TaskService";

export default({

    data(){
        return{
            task:{}
        }
    },created:function(){
        this.task.state = 'CREATED';
    },
    methods:{
        addTask(){
            //Call to the service method to post a task
            //param: task object
            TaskService.postTask(this.task)
            .then((response) => {
                console.log(response.data);
                window.location.href = 'list-tasks';
            }).catch((error) => {
                console.log(error);
            }).finally(()=>{
                //Do somethin if it's needed
            });
        }
    }

})
</script>