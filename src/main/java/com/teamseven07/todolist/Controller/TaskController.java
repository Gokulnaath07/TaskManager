package com.teamseven07.todolist.Controller;


import com.teamseven07.todolist.Model.*;
import com.teamseven07.todolist.Services.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins="*")

public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService=taskService;
    }

    @GetMapping
    public ResponseEntity<List<TaskResponseDto>> getAllTasks(){
        //return ResponseEntity.ok(taskService.getAllTasks());
        List<TaskResponseDto> tasks=taskService.getAllTasks();
        return tasks.isEmpty()
                ?ResponseEntity.noContent().build()
                :ResponseEntity.ok(tasks);
   }
   @PostMapping("/create")
    public ResponseEntity<TaskResponseDto> createTask(@RequestBody @Valid TaskRequestDto dto){
        TaskResponseDto createTask=taskService.createTask(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createTask);
   }
   @PutMapping("update/{id}")
    public ResponseEntity<TaskResponseDto> updateTAsk(@PathVariable Integer id,
                                                      @RequestBody @Valid TaskRequestDto dto){
        TaskResponseDto updateTask=taskService.updateTask(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(updateTask);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Integer id){
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("single/{id}")
    public ResponseEntity<TaskResponseDto> getTaskById(@PathVariable Integer id){
        TaskResponseDto taskByid=taskService.getTaskById(id);
        return ResponseEntity.status(HttpStatus.OK).body(taskByid);
    }
}
