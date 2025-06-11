package com.teamseven07.todolist.Model;


import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "images")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ImagesEntity {

    @Id
    private String id;
    private Integer taskId;
    private String fileName;
    private String fileType;

    @NotNull
    private byte[] imageData;
}
