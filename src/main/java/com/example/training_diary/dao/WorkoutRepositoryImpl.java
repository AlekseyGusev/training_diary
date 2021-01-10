package com.example.training_diary.dao;

import com.example.training_diary.model.Exercise;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WorkoutRepositoryImpl implements WorkoutRepository {

    private final JdbcTemplate jdbcTemplate;

    public WorkoutRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Exercise> showWorkout() {
        final String sql = "SELECT * FROM Workout";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Exercise.class));
    }

    @Override
    public Exercise showExerciseById(int id){
        String sql = "SELECT * FROM Workout WHERE id=?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Exercise.class), id)
                .stream()
                .findAny()
                .orElse(null);
    }

    @Override
    public void createWorkout(Exercise exercise) {
        String sql = "INSERT INTO workout (exercise_group, exercise_name, weight, w_sets, w_reps) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, exercise.getExerciseGroup(), exercise.getExerciseName(), exercise.getWeight(), exercise.getW_sets(), exercise.getW_reps());
    }

    @Override
    public void updateWorkout(int id, Exercise updateExercise) {
        String sql = "UPDATE workout Set exercise_group=?, exercise_name=?, weight=?, w_sets=?, w_reps=? WHERE id=?";
        jdbcTemplate.update(sql,
                updateExercise.getExerciseGroup(),
                updateExercise.getExerciseName(),
                updateExercise.getWeight(),
                updateExercise.getW_sets(),
                updateExercise.getW_reps(),
                id);
    }

    @Override
    public void deleteExercise(int id) {
        String sql = "DELETE FROM workout WHERE id=?";
        jdbcTemplate.update(sql, id);
    }
}
