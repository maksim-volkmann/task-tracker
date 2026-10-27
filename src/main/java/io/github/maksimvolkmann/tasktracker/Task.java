package io.github.maksimvolkmann.tasktracker;

import java.time.LocalDateTime;
import java.util.Objects;

public class Task {
    private final int id;
    private String description;
    private Status status;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Task(int id, String description){
        if(id <= 0){
            throw new IllegalArgumentException("Your ID: %d. ID cannot be negative or 0!".formatted(id));
        }
        Objects.requireNonNull(description, "Description cannot be null!");
        if(description.isBlank()){
            throw new IllegalArgumentException("Description cannot be empty!");
        }

        this.id = id;
        this.description = description;

        status = Status.TODO;
        createdAt = LocalDateTime.now();
        updatedAt = createdAt;
    }

    @Override
    public String toString(){
        return "Task{id=%d, description='%s', status=%s}".formatted(id, description, status);
    }


}
