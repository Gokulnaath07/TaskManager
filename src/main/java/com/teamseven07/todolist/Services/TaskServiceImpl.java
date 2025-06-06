package com.teamseven07.todolist.Services;

import com.teamseven07.todolist.Exception.ResourceNotFoundException;
import com.teamseven07.todolist.Mapper.TaskMapper;
import com.teamseven07.todolist.Model.*;
import com.teamseven07.todolist.Repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;
    //if we do constructor injection no need for Autowired but not for multiple constructor
    /*
     means more than one method with same name but different purpose
     example
             public class TaskServiceImpl {

            // Constructor 1 — no arguments
            public TaskServiceImpl() {
                // some logic
            }

            // Constructor 2 — takes a dependency
            public TaskServiceImpl(TaskRepository taskRepository) {
                this.taskRepository = taskRepository;
            }
        }

     */
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    @Override
    public TaskResponseDto createTask(TaskRequestDto dto) {
        TaskEntity entity = new TaskEntity();
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setTaskState(dto.getTaskState());
        entity.setDateTime(dto.getDateTime());

        TaskEntity savedEntity = taskRepository.save(entity);

        return TaskMapper.entitytoDto(savedEntity);


    }
    @Override
    public List<TaskResponseDto> getAllTasks() {
        List<TaskEntity> taskEntities=taskRepository.findAll();
        return taskEntities.stream()
                .map(TaskMapper::entitytoDto)
                .toList();
        /*we are using java 21 which is higher than 16+ so we can use toList()(produce immutable list
        instead of collect(Collectors.toList())(produce mutable list);
        */
    }
    @Override
    public TaskResponseDto updateTask(Integer id, TaskRequestDto dto){

        TaskEntity existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task with ID " + id + " not found"));

        existingTask.setTitle(dto.getTitle());
        existingTask.setDescription(dto.getDescription());
        existingTask.setTaskState(dto.getTaskState());
        existingTask.setDateTime(dto.getDateTime());

        TaskEntity updatedTask= taskRepository.save(existingTask);

        return TaskMapper.entitytoDto(updatedTask);

    }
    @Override
    public TaskResponseDto getTaskById(Integer id){
        //Optional<TaskEntity> findById = taskRepository.findById(id);
        return taskRepository.findById(id)
                .map(TaskMapper::entitytoDto)
                .orElseThrow(()-> new ResourceNotFoundException("Task with ID " + id + " not found"));
/*
        if(findById.isPresent()){
            return TaskMapper.entitytoDto(findById.get());
        }else{
            throw new ResourceNotFoundException("Task with ID " + id + " not found");
        }
        */
    }
    @Override
    public void deleteTask(Integer id){
        if(taskRepository.findById(id).isPresent()){
            taskRepository.deleteById(id);
        }else{
            throw new ResourceNotFoundException("Task with this "+ id + " not found");
        }
    }

}
