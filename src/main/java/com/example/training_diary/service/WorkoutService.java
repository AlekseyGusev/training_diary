package com.example.training_diary.service;

import com.example.training_diary.dao.WorkoutRepositoryImpl;
import com.example.training_diary.model.Exercise;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class WorkoutService {

    private final WorkoutRepositoryImpl workoutRepository;

    public WorkoutService(WorkoutRepositoryImpl workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    public Exercise showExerciseByName (String exerciseName) {
        return workoutRepository.showExerciseByName(exerciseName);
    }

    public List<Exercise> showWorkout (){
        return workoutRepository.showWorkout();
    }

    public void createWorkout (Exercise exercise){
        workoutRepository.createWorkout(exercise);
    }

    public void updateWorkout (String exerciseName, Exercise exercise){
        workoutRepository.updateWorkout(exerciseName, exercise);
    }

    public void deleteExercise (String exerciseName){
        workoutRepository.deleteExercise(exerciseName);
    }

}




