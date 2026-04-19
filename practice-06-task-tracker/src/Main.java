import manager.InMemoryTaskManager;
import manager.Managers;
import models.*;

public class Main {
    void main() {
        var inMemoryTaskManager = Managers.getDefault();

        var task1 = new Task();
        task1.setTitle("task1");
        task1.setDescription("description1");
        inMemoryTaskManager.createTask(task1);

        var task2 = new Task();
        task2.setTitle("task2");
        task2.setDescription("description2");
        inMemoryTaskManager.createTask(task2);

        var epic1 = new Epic();
        epic1.setTitle("epic1");
        epic1.setDescription("epicDescription1");
        inMemoryTaskManager.createEpic(epic1);

        var subtask1 = new Subtask(epic1.getId());
        subtask1.setTitle("subtask1");
        subtask1.setDescription("subtaskDescription1");
        inMemoryTaskManager.createSubtask(subtask1);

        var subtask2 = new Subtask(epic1.getId());
        subtask2.setTitle("subtask2");
        subtask2.setDescription("subtaskDescription2");
        inMemoryTaskManager.createSubtask(subtask2);

        var epic2 = new Epic();
        epic2.setTitle("epic2");
        epic2.setDescription("epicDescription2");
        inMemoryTaskManager.createEpic(epic2);

        var subtask3 = new Subtask(epic2.getId());
        subtask3.setTitle("subtask3");
        subtask3.setDescription("subtaskDescription3");
        inMemoryTaskManager.createSubtask(subtask3);

        System.out.println("__TASKS__");
        for (Task t : inMemoryTaskManager.getAllTasks()) {
            System.out.println(t.getId() + " | " + t.getTitle() + " | " + t.getStatus());
        }

        System.out.println("__EPICS__");
        for (Epic e : inMemoryTaskManager.getAllEpics()) {
            System.out.println(e.getId() + " | " + e.getTitle() + " | " + e.getStatus());
        }

        System.out.println("__SUBTASKS__");
        for (Subtask s : inMemoryTaskManager.getAllSubtasks()) {
            System.out.println(s.getId() + " | " + s.getTitle() + " | " + s.getStatus() + " | epic " + s.getEpicId());
        }

        task1.setStatus(Status.IN_PROGRESS);
        inMemoryTaskManager.updateTask(task1);

        subtask1.setStatus(Status.DONE);
        inMemoryTaskManager.updateSubtask(subtask1);

        subtask2.setStatus(Status.IN_PROGRESS);
        inMemoryTaskManager.updateSubtask(subtask2);

        subtask3.setStatus(Status.DONE);
        inMemoryTaskManager.updateSubtask(subtask3);

        System.out.println("\n__EPIC1 SUBTASKS__");
        System.out.println(inMemoryTaskManager.getEpicSubtasks(epic1.getId()));

        System.out.println("\n__AFTER STATUS UPDATE__");
        System.out.println("task1: " + task1.getStatus());
        System.out.println("epic1 (expects IN_PROGRESS): " + inMemoryTaskManager.getEpicById(epic1.getId()).getStatus());
        System.out.println("epic2 (expects DONE): " + inMemoryTaskManager.getEpicById(epic2.getId()).getStatus());

        inMemoryTaskManager.deleteTaskById(task2.getId());
        inMemoryTaskManager.deleteEpicById(epic1.getId());

        System.out.println("\n__AFTER REMOVE__");
        System.out.println("tasks: " + inMemoryTaskManager.getAllTasks().size() + " (expects 1)");
        System.out.println("epics: " + inMemoryTaskManager.getAllEpics().size() + " (expects 1)");
        System.out.println("subtasks: " + inMemoryTaskManager.getAllSubtasks().size() + " (expects 1)");

        inMemoryTaskManager.getTaskById(task1.getId());
        inMemoryTaskManager.getTaskById(task2.getId());
        inMemoryTaskManager.getEpicById(epic1.getId());
        inMemoryTaskManager.getSubtaskById(subtask1.getId());
        inMemoryTaskManager.getSubtaskById(subtask2.getId());
        inMemoryTaskManager.getEpicById(epic2.getId());
        inMemoryTaskManager.getSubtaskById(subtask3.getId());
        inMemoryTaskManager.getTaskById(task1.getId());
        inMemoryTaskManager.getEpicById(epic1.getId());
        inMemoryTaskManager.getTaskById(task2.getId());
        inMemoryTaskManager.getEpicById(epic2.getId());

        System.out.println("\n__HISTORY__");
        for (Task t : inMemoryTaskManager.getHistory()) {
            System.out.println(t.getId() + " | " + t.getTitle() + " | " + t.getStatus());
        }
    }
}
