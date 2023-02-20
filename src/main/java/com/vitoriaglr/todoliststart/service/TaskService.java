package com.vitoriaglr.todoliststart.service;

import com.vitoriaglr.todoliststart.model.Task;
import com.vitoriaglr.todoliststart.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class TaskService {


    private TaskRepository taskRepository;

    public Task createTask (Task task){
        return taskRepository.save(task);
    }


    public List<Task> listAllTasks(){
        return taskRepository.findAll();
    }


    public ResponseEntity<Task> findTaskById(Long id){
        return taskRepository.findById(id)
                .map(task -> ResponseEntity.ok().body(task))
                .orElse(ResponseEntity.notFound().build());
    }


    public ResponseEntity<Task> updateTaskById(Task task, Long id){
            return taskRepository.findById(id)
                    .map(taskToUpdate -> {
                        taskToUpdate.setTitle(task.getTitle());
                        taskToUpdate.setDescription(task.getDescription());
                        taskToUpdate.setDeadLine(task.getDeadLine());
                        taskToUpdate.setFinished(task.getFinished());
                        Task updated = taskRepository.save(taskToUpdate);
                        return ResponseEntity.ok().body(updated);
                    }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Object> deleteById (Long id){
        return taskRepository.findById(id)
                .map(taskToDelete ->{
                    taskRepository.deleteById(id);
                    return ResponseEntity.noContent().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
