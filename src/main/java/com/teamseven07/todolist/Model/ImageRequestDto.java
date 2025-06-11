package com.teamseven07.todolist.Model;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ImageRequestDto {

    private Integer taskId;
    private String fileName;
    private String fileType;

    @NotNull(message= "Bro!!! Check the image file!!! whether its there are not")
    private byte[] imageData;
}
