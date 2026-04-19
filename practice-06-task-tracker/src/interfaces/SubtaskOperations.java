package interfaces;

import models.Subtask;

import java.util.List;

public interface SubtaskOperations {
    List<Subtask> getAllSubtasks();
    void deleteAllSubtasks();
    Subtask getSubtaskById(int id);
    void createSubtask(Subtask subtask);
    void updateSubtask(Subtask subtask);
    void deleteSubtaskById(int id);
    List<Subtask> getEpicSubtasks(int epicId);
}
