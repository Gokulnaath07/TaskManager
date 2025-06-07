package com.teamseven07.todolist.Services;

import com.teamseven07.todolist.Model.*;

import java.util.List;


public interface TaskService {

    TaskResponseDto createTask(TaskRequestDto dto);
    List<TaskResponseDto> getAllTasks();
    TaskResponseDto getTaskById(Integer id);
    TaskResponseDto updateTask(Integer id, TaskRequestDto dto);
    void deleteTask(Integer id);
    TaskResponseDto singleUpdate(Integer id, TaskStatusDto taskState);
    TaskResponseDto updateDescription(Integer id, TaskDescriptionDto description);

}
