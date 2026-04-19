package interfaces;

import models.Task;

import java.util.List;

public interface TaskManager {
    List<Task> getHistory();
}
