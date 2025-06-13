package com.teamseven07.todolist.Services;

import com.teamseven07.todolist.Exception.ResourceNotFoundException;
import com.teamseven07.todolist.Mapper.ImageMapper;
import com.teamseven07.todolist.Model.ImageRequestDto;
import com.teamseven07.todolist.Model.ImageResposeDto;
import com.teamseven07.todolist.Model.ImagesEntity;
import com.teamseven07.todolist.Repositories.ImageRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
public class ImageServiceImpl implements ImageService{

    private final ImageRepository imageRepository;

    public ImageServiceImpl(ImageRepository imageRepository){
        this.imageRepository=imageRepository;
    }

//    @Override
//    public List<ImageResposeDto> uploadImage(ImageRequestDto dto, MultipartFile[] files) {
//        List<ImagesEntity> entity = new ArrayList<>();
//
//        for(MultipartFile file: files){
//            try{
//                ImagesEntity entitySingle = ImageMapper.entitytoMultipart(file, dto.getTaskId());
//                ImagesEntity saveEntity =imageRepository.save(entitySingle);
//                entity.add(saveEntity);
//            }catch(IOException e){
//                throw new RuntimeException("Failed to process file: " + file.getOriginalFilename(), e);
//            }
//
//
//        }
//
//        return entity.stream()
//                .map(ImageMapper:: entitytoDto)
//                .toList();
//    }
    @Override
    public List<ImageResposeDto> uploadImage(ImageRequestDto dto, MultipartFile[] files){
        List<ImagesEntity> responses =new ArrayList<>();
        for(MultipartFile file: files){

            try{
                ImagesEntity entitySingle = ImageMapper.multiparttoEntity(file, dto.getTaskId());
                ImagesEntity savedEntity = imageRepository.save(entitySingle);

                responses.add(savedEntity);
            }catch(IOException e){
                throw new RuntimeException("Failed to process file: " + file.getOriginalFilename(), e);
            }
        }
        return ImageMapper.entitytoDtoList(responses);
    }
    @Override
    public void deleteImage(Integer taskId) {

        if(!imageRepository.findByTaskId(taskId).isEmpty()) {
            imageRepository.deleteByTaskId(taskId);
        }else{
            throw new ResourceNotFoundException("Task with this "+ taskId + " not found");
        }
    }
    @Override
    public List<ImageResposeDto> getImagesById(Integer taskId) {

        List<ImagesEntity> responses= imageRepository.findByTaskId(taskId);
        if(!responses.isEmpty()){
            return ImageMapper.entitytoDtoList(responses);
        }else{
            return Collections.emptyList();
        }

    }
    @Override
    public Optional<ImagesEntity> getImageById(String id) {
        return imageRepository.findById(id);
    }
    @Override
    public void deleteImageById(String id) {
        imageRepository.deleteById(id);
    }

}
