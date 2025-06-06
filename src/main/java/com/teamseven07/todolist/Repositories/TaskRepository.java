package com.teamseven07.todolist.Repositories;
import com.teamseven07.todolist.Model.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository if you use extend the interface for JpaRepository don't have to use @Repository spring knows, and it takes automatically to IoC containers
public interface TaskRepository extends JpaRepository<TaskEntity, Integer> {
}
