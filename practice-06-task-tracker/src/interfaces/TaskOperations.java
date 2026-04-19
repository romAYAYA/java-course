package interfaces;

import models.Task;

import java.util.List;

public interface TaskOperations {
    List<Task> getAllTasks();
    void deleteAllTasks();
    Task getTaskById(int id);
    void createTask(Task task);
    void updateTask(Task task);
    void deleteTaskById(int id);
}
