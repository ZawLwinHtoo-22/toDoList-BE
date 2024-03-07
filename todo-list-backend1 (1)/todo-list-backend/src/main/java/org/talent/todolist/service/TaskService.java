package org.talent.todolist.service;

import org.talent.todolist.dto.NewTaskRequest;
import org.talent.todolist.entity.Task;

import java.util.List;

public interface TaskService {
    Task saveNewTask(NewTaskRequest name);
    List<Task> findAll();

    void delete(
            Long id
    );
}
