package com.teamseven07.todolist.Mapper;

import com.teamseven07.todolist.Model.ImageRequestDto;
import com.teamseven07.todolist.Model.ImageResposeDto;
import com.teamseven07.todolist.Model.ImagesEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public class ImageMapper {
    public static ImagesEntity dtotoEntity(ImageRequestDto dto){
        return ImagesEntity.builder()
                .taskId(dto.getTaskId())
                .fileName(dto.getFileName())
                .fileType(dto.getFileType())
                .imageData(dto.getImageData())
                .build();
    }
    public static ImageResposeDto entitytoDto(ImagesEntity entity){
        return ImageResposeDto.builder()
                .id(entity.getId())
                .taskId(entity.getTaskId())
                .fileName(entity.getFileName())
                .fileType(entity.getFileType())
                .viewUrl("/api/images/view/" + entity.getId())
                .build();
    }
    public static ImagesEntity multiparttoEntity(MultipartFile files, Integer taskId)throws IOException{
        return ImagesEntity.builder()
                .taskId(taskId)
                .fileName(files.getOriginalFilename())
                .fileType(files.getContentType())
                .imageData((files.getBytes()))
                .build();
    }

    public static List<ImageResposeDto> entitytoDtoList(List<ImagesEntity> entities){
        return entities.stream()
                .map(ImageMapper::entitytoDto)
                .toList();
    }

}
