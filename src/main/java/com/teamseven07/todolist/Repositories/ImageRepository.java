package com.teamseven07.todolist.Repositories;

import com.teamseven07.todolist.Model.ImagesEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ImageRepository extends MongoRepository<ImagesEntity, String> {

    List<ImagesEntity> findByTaskId(Integer taskId);
    void deleteByTaskId(Integer taskId);
}
