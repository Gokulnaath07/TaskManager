package com.teamseven07.todolist.Controller;


import com.teamseven07.todolist.Model.ImageRequestDto;
import com.teamseven07.todolist.Model.ImageResposeDto;
import com.teamseven07.todolist.Model.ImagesEntity;
import com.teamseven07.todolist.Services.ImageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/images")
@CrossOrigin(origins="*")
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

    @GetMapping("/view/{id}")
    public ResponseEntity<byte[]> getAllImages(@PathVariable String id){
        ImagesEntity images=imageService.getImageById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Image not found"));
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(images.getFileType()))
                .body(images.getImageData());
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteImage(@PathVariable String id){
        imageService.getImageById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Image not found"));
        imageService.deleteImageById(id);
        return ResponseEntity.noContent().build();
    }
}
