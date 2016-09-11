package main;

import main.java.exercises.ExerciseParser;
import main.java.exercises.Exercises;
import main.java.menu.DefaultMenu;
import main.java.routines.RoutineParser;
import main.java.routines.Routines;
import main.java.weights.WeightParser;
import main.java.weights.Weights;

public class Main {

    public static void main(String[] args) {
        Weights weights = new WeightParser().parseWeights("weights-default.txt");
        Exercises exercises = new ExerciseParser(weights).parseExercises("files/exercises-default.txt");
        Routines routines = new RoutineParser(exercises).parseRoutines("files/routines-default.txt");
        DefaultMenu menu = new DefaultMenu(routines, weights);
        menu.run();
    }
}
