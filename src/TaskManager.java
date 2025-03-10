import java.util.ArrayList;
import java.util.HashMap;

public class TaskManager {
    // Хранилища для задач, эпиков и подзадач
    private HashMap<Integer, Task> tasks = new HashMap<>();
    private HashMap<Integer, Epic> epics = new HashMap<>();
    private HashMap<Integer, Subtask> subtasks = new HashMap<>();

    // Счетчик для генерации уникальных идентификаторов
    private int uniqueId = 1;

    // Создание задачи
    public void createTask(Task task) {
        // Присваиваем задаче уникальный Id
        task.setId(getUniqueId());
        // Добавляем задачу в хранилище
        tasks.put(task.getId(), task);
    }

    // Создание эпика
    public void createEpic(Epic epic) {
        // Присваиваем эпику уникальный Id
        epic.setId(getUniqueId());
        // Добавляем эпик в хранилище
        epics.put(epic.getId(), epic);
    }

    // Создание подзадачи
    public void createSubtask(Subtask subtask) {
        // Получаем эпик, к которому относится подзадача
        Epic epic = subtask.getEpic();
        // Проверяем, существует ли эпик в хранилище
        if (epics.containsKey(epic.getId())) {
            // Присваиваем подзадаче уникальный Id
            subtask.setId(getUniqueId());
            // Добавляем подзадачу в эпик
            epic.addSubtask(subtask);
            // Обновляем статус эпика, учитывая изменения подзадач
            epic.updateStatus();
            // Добавляем подзадачу в хранилище
            subtasks.put(epic.getId(), subtask);
        }
    }

    // Обновление задачи по Id
    public void update(int id, Task task) {
        // Заменяем задачу с заданным Id обновленной версией
        tasks.put(id, task);
    }

    // Получение задачи по Id
    public Task getTaskByID(int id){
        return tasks.get(id);
    }
    // Получение эпика по Id
    public Epic getEpicByID(int id){
        return epics.get(id);
    }
    // Получение подзадачи по Id
    public Subtask getSubtaskByID(int id){
        return subtasks.get(id);
    }
    // Удаление задачи по Id
    public void removeTaskByID(int id){
        tasks.remove(id);
    }
    public void removeEpicById(int id) {
        // Проверяем, существует ли эпик
        if (epics.containsKey(id)) {
            Epic epic = epics.get(id);
            // Проходим по всем подзадачам эпика
            for (Subtask subtask : epic.getSubtasks()) {
                // Удаляем подзадачу
                subtasks.remove(subtask.getId());
            }
            // Удаляем эпик
            epics.remove(id);
        }
    }
    // Удаление подзадачи по Id
    public void removeSubtaskById(int id) {
        // Проверяем, найдена ли подзадача
        if (subtasks.containsKey(id)) {
            // Получаем подзадачу для удаления
            Subtask subtaskToRemove = subtasks.get(id);
            // Получаем эпик, к которому относится подзадача
            Epic epic = subtaskToRemove.getEpic();
            // Удаляем подзадачу из эпика
            epic.removeSubtaskById(id);
            // Обновляем статус эпика
            epic.updateStatus();
            // Удаляем подзадачу из хранилища
            subtasks.remove(id);
        }
    }
    // Получение списка задач
    public ArrayList<Task> getListTasks(){
        return new ArrayList<>(tasks.values());
    }
    // Получение списка эпиков
    public ArrayList<Epic> getListEpics(){
        return new ArrayList<>(epics.values());
    }
    // Получение списка подзадач
    public ArrayList<Subtask> getListSubtasks(){
        return new ArrayList<>(subtasks.values());
    }
    // Получение списка подзадач для данного эпика
    public ArrayList<Subtask> getSubtasksForEpic(Epic epic){
        return getListSubtasks();
    }
    // Очищение всех хранилищ
    public void clearAllHashMaps(){
        tasks.clear();;
        subtasks.clear();
        epics.clear();
    }
    // Генерация уникального Id
    private int getUniqueId() {
        return uniqueId++;
    }
}
