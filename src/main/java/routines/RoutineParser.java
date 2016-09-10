package main.java.routines;

import main.java.exercises.Exercise;
import main.java.exercises.Exercises;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class RoutineParser {
    private Exercises exercises;

    public RoutineParser(Exercises exercises) {
        this.exercises = exercises;
    }

    public Routines parseRoutines(String file) {
        try {
            Scanner scanner = new Scanner(new File(file));
            LinkedList<Routine> routines = new LinkedList<>();

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                if (line.charAt(0) != '/') {
                    routines.add(parseRoutine(line));
                }
            }
            scanner.close();
            return new Routines(routines);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Routine parseRoutine(String line) {
        LinkedList<Exercise> exerciseList = new LinkedList<>();

        String[] splittedLine = line.split("#");

        for (int i = 1; i < splittedLine.length; i++) {
            exerciseList.add(exercises.getExerciseByName(splittedLine[i]));
        }

        return new Routine(splittedLine[0], exerciseList);

    }
}
