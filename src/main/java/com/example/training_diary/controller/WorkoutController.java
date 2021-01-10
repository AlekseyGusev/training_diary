package com.example.training_diary.controller;


import com.example.training_diary.model.Exercise;
import com.example.training_diary.service.WorkoutService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping()
public class WorkoutController {

    private final WorkoutService workoutService;

    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
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
    public String showExerciseById (@PathVariable("id") int id, Model model) {
        model.addAttribute("exercise", workoutService.showExerciseById(id));
        return "show_exercise";
    }

    @GetMapping("/create_workout")
    public String currentWorkout(Model model) {
        model.addAttribute("workout", workoutService.showWorkout());
        return "/create_workout";
    }

    @GetMapping("/create_workout_new")
    public String createWorkoutForm (@ModelAttribute("newExercise") Exercise exercise) {
        return "create_workout_new";
    }

    @PostMapping("/create_workout_new")
    public String createWorkoutFormSubmit (@ModelAttribute("newExercise") @Valid Exercise exercise, BindingResult bindingResult){

        if(bindingResult.hasErrors()) {
            return "create_workout_new";
        }

        workoutService.createWorkout(exercise);
        return "redirect:/create_workout";
    }

    @GetMapping("/{id}/edit")
    public String exerciseEditing(Model model, @PathVariable("id") int id) {
        model.addAttribute("exercise", workoutService.showExerciseById(id));
        return "/edit";
    }

    @PatchMapping("/{id}")
    public String updateWorkout(@ModelAttribute("exercise") @Valid Exercise exercise, BindingResult bindingResult, @PathVariable("id") int id) {

        if(bindingResult.hasErrors()) {
            return "/edit";
        }

        workoutService.updateWorkout(id, exercise);
        return "redirect:/create_workout";
    }

    @GetMapping("/delete/{id}")
    public String deleteExercise(@PathVariable("id") int id) {
        workoutService.deleteExercise(id);
        return "redirect:/create_workout";
    }
}
