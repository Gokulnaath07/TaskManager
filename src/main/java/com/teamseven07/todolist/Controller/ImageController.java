package com.teamseven07.todolist.Controller;


import com.teamseven07.todolist.Model.ImageRequestDto;
import com.teamseven07.todolist.Model.ImageResposeDto;
import com.teamseven07.todolist.Services.ImageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    private final ImageService imageService;

    public ImageController(ImageService imageService){
        this.imageService=imageService;
    }

    @PostMapping("/upload")
    public ResponseEntity<List<ImageResposeDto>> UploadImage(//@RequestBody ImageRequestDto dto, not used because the files are handled through multipart not raw json
                                                             @RequestParam("taskId") Integer TaskId,
                                                             @RequestParam("files")MultipartFile[] files){

        ImageRequestDto dto = new ImageRequestDto();
        dto.setTaskId(TaskId);

        List<ImageResposeDto> responses = imageService.uploadImage(dto, files);
        return ResponseEntity.status(HttpStatus.CREATED).body(responses);

    }

//    @GetMapping("/images/{taskId}")
//    public ResponseEntity<List<ImageResposeDto>> getAllImages(@PathVariable Integer taskId){
//        List<ImageResposeDto> responses = imageService.getAllImages(taskId);
//    }
}
