package com.vitoriaglr.todoliststart.repository;

import com.vitoriaglr.todoliststart.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
