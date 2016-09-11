package main.java.exercises;

import main.java.weights.Weights;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.Scanner;

public class ExerciseParser {
    private Weights weights;

    public ExerciseParser(Weights weights) {
        this.weights = weights;
    }

    public Exercises parseExercises(String file) {
        try {
            InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream(file);
            Scanner scanner = new Scanner(stream);
            LinkedList<Exercise> exercises = new LinkedList<>();
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                if (line.charAt(0) != '/') {
                    String[] exerciseLine = line.split("#");
                    exercises.add(new Exercise(exerciseLine[0], weights.getBarbellByName(exerciseLine[1])));
                }
            }
            stream.close();
            scanner.close();
            return new Exercises(exercises);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
