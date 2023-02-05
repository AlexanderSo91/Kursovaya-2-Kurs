package model;

import exception.IncorrectArgumentException;

import java.time.LocalDateTime;

public class MonthlyTask extends Task{
    public MonthlyTask(String title, String description, TaskType type, LocalDateTime taskTime) throws IncorrectArgumentException {
        super(title, description, type, taskTime);
    }

    @Override
    public LocalDateTime getTaskNextTime(LocalDateTime dateTime) {
        return dateTime.plusMonths(1);
    }
}
