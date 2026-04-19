import manager.Manager;
import models.*;

public class Main {
    void main() {
        Manager manager = new Manager();

        var task1 = new Task();
        task1.setTitle("task1");
        task1.setDescription("description1");
        manager.createTask(task1);

        var task2 = new Task();
        task2.setTitle("task2");
        task2.setDescription("description2");
        manager.createTask(task2);

        var epic1 = new Epic();
        epic1.setTitle("epic1");
        epic1.setDescription("epicDescription1");
        manager.createEpic(epic1);

        var subtask1 = new Subtask(epic1.getId());
        subtask1.setTitle("subtask1");
        subtask1.setDescription("subtaskDescription1");
        manager.createSubtask(subtask1);

        var subtask2 = new Subtask(epic1.getId());
        subtask2.setTitle("subtask2");
        subtask2.setDescription("subtaskDescription2");
        manager.createSubtask(subtask2);

        var epic2 = new Epic();
        epic2.setTitle("epic2");
        epic2.setDescription("epicDescription2");
        manager.createEpic(epic2);

        var subtask3 = new Subtask(epic2.getId());
        subtask3.setTitle("subtask3");
        subtask3.setDescription("subtaskDescription3");
        manager.createSubtask(subtask3);

        System.out.println("__TASKS__");
        for (Task t : manager.getAllTasks()) {
            System.out.println(t.getId() + " | " + t.getTitle() + " | " + t.getStatus());
        }

        System.out.println("__EPICS__");
        for (Epic e : manager.getAllEpics()) {
            System.out.println(e.getId() + " | " + e.getTitle() + " | " + e.getStatus());
        }

        System.out.println("__SUBTASKS__");
        for (Subtask s : manager.getAllSubtasks()) {
            System.out.println(s.getId() + " | " + s.getTitle() + " | " + s.getStatus() + " | epic " + s.getEpicId());
        }

        task1.setStatus(Status.IN_PROGRESS);
        manager.updateTask(task1);

        subtask1.setStatus(Status.DONE);
        manager.updateSubtask(subtask1);

        subtask2.setStatus(Status.IN_PROGRESS);
        manager.updateSubtask(subtask2);

        subtask3.setStatus(Status.DONE);
        manager.updateSubtask(subtask3);


        System.out.println("\n__EPIC1 SUBTASKS__");
        System.out.println(manager.getEpicSubtasks(epic1.getId()));

        System.out.println("\n__AFTER STATUS UPDATE__");
        System.out.println("task1: " + task1.getStatus());
        System.out.println("epic1 (expects IN_PROGRESS): " + manager.getEpicById(epic1.getId()).getStatus());
        System.out.println("epic2 (expects DONE): " + manager.getEpicById(epic2.getId()).getStatus());

        manager.deleteTaskById(task2.getId());
        manager.deleteEpicById(epic1.getId());

        System.out.println("\n__AFTER REMOVE__");
        System.out.println("tasks: " + manager.getAllTasks().size() + " (expects 1)");
        System.out.println("epics: " + manager.getAllEpics().size() + " (expects 1)");
        System.out.println("subtasks: " + manager.getAllSubtasks().size() + " (expects 1)");
    }
}
