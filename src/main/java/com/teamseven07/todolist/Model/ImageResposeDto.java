package com.teamseven07.todolist.Model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ImageResposeDto {


    private Integer taskId;
    private String fileName;
    private String fileType;

}
