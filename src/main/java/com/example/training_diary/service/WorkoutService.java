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

    public Exercise showExerciseById (int id) {
        return workoutRepository.showExerciseById(id);
    }

    public List<Exercise> showWorkout (){
        return workoutRepository.showWorkout();
    }

    public void createWorkout (Exercise exercise){
        workoutRepository.createWorkout(exercise);
    }

    public void updateWorkout (int id, Exercise exercise){
        workoutRepository.updateWorkout(id, exercise);
    }

    public void deleteExercise (int id){
        workoutRepository.deleteExercise(id);
    }

}




