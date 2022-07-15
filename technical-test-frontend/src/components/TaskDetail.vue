/**
 * This file contains the code to to view the detail of the selected task
 */
<template>
        <div class="center">
        <div class="card" style="width:26rem;padding: 2em;">
            <div class="card-title center">Details Of Task {{this.$route.params.id}}</div>
            <div class="card-body">
                <h2 class="card-text">Name: {{this.task.name}}</h2>
                <h2 class="card-text">State: {{this.task.state}}</h2>
                <h3 class="card-text">Creation Time: {{this.task.creationTime}}</h3>
            </div>
            <div class="center">
                 <router-link :to="{name:'list-tasks'}" class="btn btn-warning">Back</router-link> 
            </div> 
       </div>
    </div>
</template>

<script>

export default({
    data(){
        return{
            task:{}
        }
    },
    created:function(){
        this.task.name = this.$route.params.taskName;
        this.task.creationTime = this.$route.params.creationTime;
        this.task.state = this.$route.params.state;
    }
})
</script>

<style scoped>
    .center{
        background-color: #EEE ;
        display:flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
    }
</style>