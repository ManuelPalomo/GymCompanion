package main.java.routines;

import main.java.exercises.Exercise;

import java.util.LinkedList;

public class Routine {
    private String name;
    private LinkedList<Exercise> exercises;

    public Routine(String name, LinkedList<Exercise> exercises) {
        this.name = name;
        this.exercises = exercises;
    }

    public String getName() {
        return name;
    }

    public LinkedList<Exercise> getExercises() {
        return exercises;
    }

    @Override
    public String toString() {
        String result = "Routine:" + name + " | Exercises: ";
        for (Exercise exercise : exercises) {
            result += exercise.getName() + "|";
        }
        return result;
    }
}
