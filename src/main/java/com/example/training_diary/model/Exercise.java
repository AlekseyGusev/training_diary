package com.example.training_diary.model;

import org.apache.tomcat.jni.Local;

import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.util.Date;

public class Exercise {

    private int id;
    LocalDate date;
    private String exerciseGroup;
    private String exerciseName;
    @Min(value = 1, message = "Should be greater than 0")
    private int weight;
    @Min(value = 1, message = "Should be greater than 0")
    private int w_sets;
    @Min(value = 1, message = "Should be greater than 0")
    private int w_reps;

    public Exercise(){}

    public Exercise(int id, LocalDate date, String exerciseGroup, String exerciseName, @Min(value = 1, message = "Should be greater than 0") int weight, @Min(value = 1, message = "Should be greater than 0") int w_sets, @Min(value = 1, message = "Should be greater than 0") int w_reps) {
        this.id = id;
        this.date = date;
        this.exerciseGroup = exerciseGroup;
        this.exerciseName = exerciseName;
        this.weight = weight;
        this.w_sets = w_sets;
        this.w_reps = w_reps;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getExerciseGroup() {
        return exerciseGroup;
    }

    public void setExerciseGroup(String exerciseGroup) {
        this.exerciseGroup = exerciseGroup;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getW_sets() {
        return w_sets;
    }

    public void setW_sets(int w_sets) {
        this.w_sets = w_sets;
    }

    public int getW_reps() {
        return w_reps;
    }

    public void setW_reps(int w_reps) {
        this.w_reps = w_reps;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "id=" + id +
                ", date=" + date +
                ", exerciseGroup='" + exerciseGroup + '\'' +
                ", exerciseName='" + exerciseName + '\'' +
                ", weight=" + weight +
                ", w_sets=" + w_sets +
                ", w_reps=" + w_reps +
                '}';
    }
}
