package model;

import exception.IncorrectArgumentException;

import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Task implements Repeatable {

    private static int idGenerator = 1;

    private int id;
    private String title;
    private String description;
    private TaskType type;
    private LocalDateTime taskTime;


    public Task(String title, String description, TaskType type, LocalDateTime taskTime) throws IncorrectArgumentException {
        this.id = idGenerator++;
        setTitle(title);
        setDescription(description);
        setType(type);
        setTaskTime(taskTime);
    }


    public static int getIdGenerator() {
        return idGenerator;
    }

    public static void setIdGenerator(int idGenerator) {
        Task.idGenerator = idGenerator;
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

    public void setTitle(String title) throws IncorrectArgumentException {
        if (title != null && !title.isEmpty()) {
            this.title = title;
        } else {
            throw new IncorrectArgumentException(" Заголовок задачи");
        }
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) throws IncorrectArgumentException {
        if (description != null && !description.isEmpty()) {
            this.description = description;
        } else {
            throw new IncorrectArgumentException(" Описание задачи");
        }
    }


    public TaskType getType() {
        return type;
    }

    public void setType(TaskType type) throws IncorrectArgumentException {
        if (type != null) {
            this.type = type;
        } else {
            throw new IncorrectArgumentException(" Тип задачи");
        }
    }


    public LocalDateTime getTaskTime() throws IncorrectArgumentException {
        if (taskTime != null) {
            this.taskTime = taskTime;
        } else {
            throw new IncorrectArgumentException(" Дата и время задачи");
        }
        return null;
    }


    public void setTaskTime(LocalDateTime taskTime) {
            this.taskTime = taskTime;
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && title.equals(task.title) && description.equals(task.description) && type == task.type && taskTime.equals(task.taskTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, type, taskTime);
    }

    @Override
    public String toString() {
        return "Задача: " +
                "id=" + id +
                ", Заголовок='" + title + '\'' +
                ",Описание='" + description + '\'' +
                ", Тип=" + type +
                ", Время=" + taskTime;
    }
}

