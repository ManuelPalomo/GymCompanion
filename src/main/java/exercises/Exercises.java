package main.java.exercises;

import java.util.LinkedList;

public class Exercises {
    private LinkedList<Exercise> exercises;

    public Exercises(LinkedList<Exercise> exercises) {
        this.exercises = exercises;
    }

    public LinkedList<Exercise> getExercises() {
        return this.exercises;
    }
}
