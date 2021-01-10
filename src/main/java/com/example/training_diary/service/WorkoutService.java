package com.example.training_diary.service;

import com.example.training_diary.dao.WorkoutRepositoryImpl;
import com.example.training_diary.model.Exercise;
import org.springframework.stereotype.Service;


@Service
public class WorkoutService {

    private final WorkoutRepositoryImpl workoutRepository;

    public WorkoutService(WorkoutRepositoryImpl workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    public void saveWorkout(Exercise exercise) {
        workoutRepository.createWorkout(exercise);
    }

    public void updateExercise (Exercise exercise) {

    }
}




