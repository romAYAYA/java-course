package interfaces;

import models.Epic;

import java.util.List;

public interface EpicOperations {
    List<Epic> getAllEpics();
    void deleteAllEpics();
    Epic getEpicById(int id);
    void createEpic(Epic epic);
    void updateEpic(Epic epic);
    void deleteEpicById(int id);
}
