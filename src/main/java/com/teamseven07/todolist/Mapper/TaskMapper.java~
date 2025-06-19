package com.teamseven07.todolist.Mapper;

import com.teamseven07.todolist.Model.TaskEntity;
import com.teamseven07.todolist.Model.TaskResponseDto;

public class TaskMapper {
    public static TaskResponseDto entitytoDto(TaskEntity entity){
        return TaskResponseDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .taskState(entity.getTaskState())
                .dateTime(entity.getDateTime())
                .createdDate(entity.getCreatedDate())
                .lastModifiedDate(entity.getLastModifiedDate())
                .build();
    }
}
