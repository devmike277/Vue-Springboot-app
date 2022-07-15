/**
 * this file contains the functions to perform the requests
 * against the server. It implements calls to retrieve all
 * the records from the task table, create a new record, delete it,
 * and update it.
 */

import axios from 'axios';

const TASK_API_BASE_URL = "http://localhost:9191/api/tasks"

class TaskService{

    //Method for read
    getTasks(){
        return axios.get(TASK_API_BASE_URL);
    }

    //Method for create
    //param: task to post
    postTask(task){
        return axios.post(TASK_API_BASE_URL,task);
    }

    //Method for delete
    //param: id of the task to delete
    deleteTask(id){
        return axios.delete(TASK_API_BASE_URL+"/"+id);
    }

    //Method for update
    //param1: id of the task to update
    //param2: task to update
    updateTask(id, task){
        return axios.put(TASK_API_BASE_URL+"/"+id,{
            name:task.name,
            state:task.state,
            creationTime: task.creationTime
        });
    }
}

export default new TaskService()