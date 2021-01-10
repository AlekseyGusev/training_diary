package com.example.training_diary.dao;

import com.example.training_diary.model.Exercise;

import java.util.List;

public interface WorkoutRepository {

    void createWorkout (Exercise exercise);
    List<Exercise> showWorkout ();
    Exercise showExerciseById(int id);
    void updateWorkout (int id, Exercise exercise);
    void deleteExercise (int id);

}
