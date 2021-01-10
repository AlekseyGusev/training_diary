package com.example.training_diary.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class Exercise {

    private LocalDate date;
    private String exerciseGroup;
    private String exerciseName;

    @Min(value = 1, message = "Weight should be greater than 0")
    private int weight;
    @Min(value = 1, message = "Sets should be greater than 0")
    private int sets;
    @Min(value = 1, message = "Reps should be greater than 0")
    private int reps;

    public Exercise(){}

    public Exercise(@NotEmpty String exerciseGroup, String exerciseName, int weight, int sets, int reps) {
        this.exerciseGroup = exerciseGroup;
        this.exerciseName = exerciseName;
        this.weight = weight;
        this.sets = sets;
        this.reps = reps;
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

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "date=" + date +
                ", exerciseGroup='" + exerciseGroup + '\'' +
                ", exerciseName='" + exerciseName + '\'' +
                ", weight=" + weight +
                ", sets=" + sets +
                ", reps=" + reps +
                '}';
    }
}
