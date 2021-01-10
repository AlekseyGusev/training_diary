package com.example.training_diary.dao;

import com.example.training_diary.model.Exercise;

import java.util.List;

public interface WorkoutRepository {

    void createWorkout (Exercise exercise);
    List<Exercise> showWorkout ();
    Exercise showExerciseByName(String exerciseName);
    void updateWorkout (String exerciseName, Exercise exercise);
    void deleteExercise (String exerciseName);

}
