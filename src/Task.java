public class Task {
    // Уникальный идентификатор задачи
    protected int id;
    // Название задачи
    protected String title;
    // Описание задачи
    protected String description;
    // Статус задачи (NEW, IN_PROGRESS, DONE)
    protected String status;
    // Конструктор задачи
    public Task(String title, String description) {
        // Инициализируем описание и название задачи
        this.title = title;
        this.description = description;
        // Устанавливаем начальный статус задачи как NEW
        this.status = "NEW";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
