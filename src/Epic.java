import java.util.ArrayList;
import java.util.HashMap;

public class Epic extends Task {
    // Хранилище для подзадач эпика
    private HashMap<Integer, Subtask> subtasks;

    // Конструктор эпика
    public Epic(String title, String description) {
        // Вызываем конструктор суперкласс Task
        super(title, description);
        // Инициализируем хранилище для подзадач
        this.subtasks = new HashMap<>();
    }

    // Метод для обновления статуса эпика
    public void updateStatus() {
        // Флаги для определения статуса эпика
        boolean allNew = true;
        boolean allDone = true;

        // Проходим по всем подзадачам эпика
        for (Subtask subtask : subtasks.values()) {
            // Проверяем, не является ли подзадача NEW
            if (!subtask.getStatus().equals("NEW")) {
                allNew = false;
            }
            // Проверяем, не является ли подазада DONE
            if (!subtask.getStatus().equals("DONE")) {
                allDone = false;
            }
            // Если уже известно, что не все подзадачи в одном статусе, прерываем цикл
            if (!allNew && !allDone) {
                break;
            }
        }

        // Определяем статус эпика на основе статусов подзадач
        if (subtasks.isEmpty() || allNew) {
            setStatus("NEW");
        } else if (allDone) {
            setStatus("DONE");
        } else {
            setStatus("IN_PROGRESS");
        }
    }

    // Метод для получения списка подзадач эпика
    public ArrayList<Subtask> getSubtasks() {
        return new ArrayList<>(subtasks.values());
    }

    // Метод для добавления подзадачи к эпику
    public void addSubtask(Subtask subtask) {
        subtasks.put(subtask.getId(), subtask);
    }

    // Метод для удаления подазадачи из эпика по Id
    public void removeSubtaskById(int id) {
        subtasks.remove(id);
    }
}
