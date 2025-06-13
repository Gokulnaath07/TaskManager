package com.teamseven07.todolist.Model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskAndImageDto {

    private List<ImageResposeDto> images;
    private TaskResponseDto tasks;

//    private List<ImageRequestDto> imageRequestDto;
//    private TaskRequestDto taskRequestDto;
}
