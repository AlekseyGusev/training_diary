package com.example.training_diary.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class Exercise {

    private LocalDate date;
    private String exerciseGroup;
    private String exerciseName;
    private double weight;
    private int sets;
    private int reps;

    public Exercise(String exerciseGroup, String exerciseName, double weight, int sets, int reps) {
        this.exerciseGroup = exerciseGroup;
        this.exerciseName = exerciseName;
        this.weight = weight;
        this.sets = sets;
        this.reps = reps;
        this.date = LocalDate.now();
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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
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

    public LocalDate getDate() {
        return date;
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
