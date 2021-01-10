package com.example.training_diary.dao;

import com.example.training_diary.model.Exercise;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class WorkoutRepositoryImpl implements WorkoutRepository {

    private List<Exercise> current = new ArrayList<>();

    @Override
    public List<Exercise> showWorkout() {
        return current;
    }

    @Override
    public Exercise showExerciseByName(String exerciseName){
        return current.stream()
                .filter(exercise -> exerciseName.equals(exercise.getExerciseName()))
                .findAny()
                .orElse(null);
    }

    @Override
    public void createWorkout(Exercise exercise) {
        current.add(exercise);
    }


    @Override
    public void updateWorkout(String exerciseName, Exercise exercise) {
        Exercise exerciseToUpdate = showExerciseByName(exerciseName);
        exerciseToUpdate.setWeight(exercise.getWeight());
        exerciseToUpdate.setSets(exercise.getSets());
        exerciseToUpdate.setReps(exercise.getReps());
    }

    @Override
    public void deleteExercise(String exerciseName) {
        current.removeIf( exercise -> exerciseName.equals(exercise.getExerciseName()));
    }
}
