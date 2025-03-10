public class Test {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        // Создаем эпик с двумя подзадачами
        Epic firstEpic = new Epic("Эпик 1 (с двумя подзадачами)", "Описание эпика 1");
        manager.createEpic(firstEpic);
        // Создаем две подзадачи к эпику
        Subtask firstEpicFirstSubtask = new Subtask("Подзадача 1 эпика 1", "Описание подзадачи 1 эпика 1", firstEpic);
        Subtask firstEpicSecondSubtask = new Subtask("Подзадача 2 эпика 1", "Описание подзадачи 2 эпика 1", firstEpic);
        manager.createSubtask(firstEpicFirstSubtask); // Добавляем первую подзадачу к эпику
        manager.createSubtask(firstEpicSecondSubtask); // Добавляем вторую подзадачу к эпику
        // Создаем эпик с одной подзадачей
        Epic secondEpic = new Epic("Эпик 2 (с одной подзадачей)", "Описание эпика 2");
        manager.createEpic(secondEpic);
        // Создаем подзадачу к эпику
        Subtask secondEpicFirstSubtask = new Subtask("Подзадача 1 эпика 2", "Описание подзадачи 1 эпика 2", secondEpic);
        manager.createSubtask(secondEpicFirstSubtask);
        // Создаем две задачи
        Task firstTask = new Task("Задача 1", "Описание задачи 1");
        Task secondTask = new Task("Задача 2", "Описание задачи 2");
        manager.createTask(firstTask);
        manager.createTask(secondTask);
        // Выводим начальные списки задач, эпиков и подзадач
        System.out.println(manager.getListTasks());
        System.out.println(manager.getListEpics());
        System.out.println(manager.getListSubtasks());
        // Изменяем статусы созданных объектов и выводим результаты
        System.out.println("Изначальный статус эпика: " + firstEpic.getStatus());
        // Меняем статус подзадачи на IN_PROGRESS
        firstEpicFirstSubtask.setStatus("IN_PROGRESS");
        System.out.println("Статус эпика после изменения статуса подзадачи: " + firstEpic.getStatus());
        // Меняем статус обеих подзадач на DONE
        firstEpicFirstSubtask.setStatus("DONE");
        firstEpicSecondSubtask.setStatus("DONE");
        System.out.println("Статус эпика после измениния статуса всех подзадач на 'DONE': " + firstEpic.getStatus());
        // Удаляем одну из задач и один из эпиков
        manager.removeTaskByID(6);
        manager.removeEpicById(4);
        // Выводим списки задач, эпиков и подзадач после удаления
        System.out.println(manager.getListTasks());
        System.out.println(manager.getListEpics());
        System.out.println(manager.getListSubtasks());
    }
}