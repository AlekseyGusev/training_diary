package com.example.training_diary.controller;


import com.example.training_diary.dao.WorkoutRepository;
import com.example.training_diary.model.Exercise;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping()
public class WorkoutController {

    private final WorkoutRepository workoutRepository;

    public WorkoutController(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    @GetMapping("/main")
    public String mainPage () {
        return "/main";
    }

    @GetMapping("/training_diary")
    public String showWorkout () {
        return "/training_diary";
    }

    @GetMapping("/exercise/{id}")
    public String showExerciseByName (@PathVariable("id") String exerciseName, Model model) {
        model.addAttribute("exercise", workoutRepository.showExerciseByName(exerciseName));
        return "show_exercise";
    }

    @GetMapping("/create_workout")
    public String currentWorkout(Model model) {
        model.addAttribute("workout", workoutRepository.showWorkout());
        return "/create_workout";
    }

    @GetMapping("/create_workout_new")
    public String createWorkoutForm () {
        return "create_workout_new";
    }

    @PostMapping("/create_workout_new")
    public String createWorkoutFormSubmit (@ModelAttribute("exercise") Exercise exercise){
        workoutRepository.createWorkout(exercise);
        return "redirect:/create_workout";
    }

    @GetMapping("/{id}/edit")
    public String exerciseEditing(Model model, @PathVariable("id") String exerciseName) {
        model.addAttribute("exercise", workoutRepository.showExerciseByName(exerciseName));
        return "/edit";
    }

    @PatchMapping("/{id}")
    public String updateWorkout(@ModelAttribute("exercise") Exercise exercise, @PathVariable("id") String exerciseName) {
        workoutRepository.updateWorkout(exerciseName, exercise);
        return "redirect:/create_workout";
    }

    @GetMapping("/delete/{id}")
    public String deleteExercise(@PathVariable("id") String exerciseName) {
        workoutRepository.deleteExercise(exerciseName);
        return "redirect:/create_workout";
    }
}