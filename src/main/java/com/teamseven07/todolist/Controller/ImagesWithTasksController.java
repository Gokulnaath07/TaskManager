package com.teamseven07.todolist.Controller;


import com.teamseven07.todolist.Model.ImageRequestDto;
import com.teamseven07.todolist.Model.ImageResposeDto;
import com.teamseven07.todolist.Model.TaskAndImageDto;
import com.teamseven07.todolist.Model.TaskResponseDto;
import com.teamseven07.todolist.Services.ImageService;
import com.teamseven07.todolist.Services.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/iWithT")
@CrossOrigin(origins="*")
public class ImagesWithTasksController {

    final private ImageService imageService;
    final private TaskService taskService;

    public ImagesWithTasksController(ImageService imageService, TaskService taskService) {
        this.imageService=imageService;
        this.taskService=taskService;

    }

    @GetMapping("/taskImages/{id}")
    public ResponseEntity<TaskAndImageDto> getImagesOfTask(@PathVariable Integer id){
        TaskResponseDto tasks=taskService.getTaskById(id);
        List<ImageResposeDto> images=imageService.getImagesById(id);

        TaskAndImageDto dto= new TaskAndImageDto();
        dto.setTasks(tasks);
        if(!images.isEmpty()){
            dto.setImages(images);
        }

        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteImagesWithTasks(@PathVariable Integer id){
        TaskResponseDto task=taskService.getTaskById(id);
        taskService.deleteTask(id);
        imageService.deleteImage(task.getId());
        return ResponseEntity.noContent().build();

    }

//    @PostMapping
//    public ResponseEntity<TaskAndImageDto> createIwithT(@RequestBody TaskAndImageDto dto){
//        TaskResponseDto task = taskService.createTask(dto.getTaskRequestDto());
//        Integer taskId= task.getId();
//
//        ArrayList<ImageResposeDto> responses = new ArrayList<>();
//        for(ImageRequestDto images: dto.getImageRequestDto()){
//            images.setTaskId(taskId);
//
//        }
//    }
}
