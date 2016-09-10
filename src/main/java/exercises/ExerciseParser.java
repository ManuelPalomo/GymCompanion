package main.java.exercises;

import main.java.weights.Weights;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class ExerciseParser {
    private Weights weights;

    public ExerciseParser(Weights weights) {
        this.weights = weights;
    }

    public Exercises parseExercises(String file) {
        try {
            Scanner scanner = new Scanner(new File(file));
            LinkedList<Exercise> exercises = new LinkedList<>();
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                if (line.charAt(0) != '/') {
                    String[] exerciseLine = line.split("#");
                    exercises.add(new Exercise(exerciseLine[0], weights.getBarbellByName(exerciseLine[1])));
                }
            }
            scanner.close();
            return new Exercises(exercises);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
