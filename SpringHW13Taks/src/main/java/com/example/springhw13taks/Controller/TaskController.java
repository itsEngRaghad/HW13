package com.example.springhw13taks.Controller;

import com.example.springhw13taks.APIResponse.APIResponse;
import com.example.springhw13taks.Model.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/task")//URL
public class TaskController {

    ArrayList<Task> Tasks =new ArrayList<>();

    //CRUD

    //Read (Display Task) --> Get in postman
    @GetMapping("/get")
    public ArrayList getTask(){
        return Tasks; //endpoint for Displaying tasks
        //it will get Task from Model then return it in the array
    }

//    public APIResponse getbytitle(){
//    }

    //Create (ADD TASK) --> post in postman
    @PostMapping("/add")
    public APIResponse addTask(@RequestBody Task task){
        Tasks.add(task); //adding to the arrayList (Tasks)
        return new APIResponse("Task has been added!");
    }


    //Update (Update Task) --> put in postman
    @PutMapping("/update/{index}")
    public APIResponse updateTask(@PathVariable int index, @RequestBody Task task){
       Tasks.set(index,task);
       return new APIResponse("task has been updated!");
    }

    //Delete (Delete Task) --> Delete in postman
    @DeleteMapping("/delete/{index}")
    public APIResponse deleteTask(@PathVariable int index){
        Tasks.remove(index);
        return new APIResponse("Task has been removed!");
    }

}
