package com.teamseven07.todolist.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskResponseDto {


    private Integer id;

    private String title;

    private String description;
    private TypeEnum taskState;


    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateTime;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdDate;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastModifiedDate;



}
