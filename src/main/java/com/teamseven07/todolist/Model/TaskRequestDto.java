package com.teamseven07.todolist.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;


import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskRequestDto {

    @NotBlank
    @Size(max=100, message = "Bro!!! Check the title its too long")
    private String title;

    @Size(max=1000, message = "Bro!!! Too Long")
    private String description;

    @NotNull(message = "Bro!!! Check the state")
    private TypeEnum taskState;

    @NotNull(message = "Bro!!! Check the date")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateTime;
}
