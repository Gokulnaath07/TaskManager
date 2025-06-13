package com.teamseven07.todolist.Services;

import com.teamseven07.todolist.Model.ImageRequestDto;
import com.teamseven07.todolist.Model.ImageResposeDto;
import com.teamseven07.todolist.Model.ImagesEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface ImageService {



    /*private final ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public void savDummy(){
        ImagesEntity image = new ImagesEntity();
        image.setTaskId(1);
        image.setFileName("Start");
        image.setFileType("jpg");
        image.setImageData("Test image content".getBytes());
        imageRepository.save(image);
    }*/


    public List<ImageResposeDto> uploadImage(ImageRequestDto dto, MultipartFile[] files);
    public void deleteImage(Integer taskId);
    public List<ImageResposeDto> getImagesById(Integer taskId);
}
