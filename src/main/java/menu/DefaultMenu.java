package main.java.menu;

import main.java.exercises.Exercise;
import main.java.routines.Routine;
import main.java.routines.Routines;
import main.java.sessions.Session;
import main.java.weights.Weights;

import java.util.LinkedList;
import java.util.Scanner;

public class DefaultMenu {
    private Routines routines;
    private Weights weights;

    public DefaultMenu(Routines routines, Weights weights) {
        this.routines = routines;
        this.weights = weights;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        Routine routine = routinePicker(scanner);
        LinkedList<Float> weightsByExercise = routineWeightPicker(scanner,routine);
        Session session = new Session(routine,weights,weightsByExercise);
        System.out.println(session);
        scanner.close();

    }

    private Routine routinePicker(Scanner scanner) {
        Routine routine = null;
        while (routine == null) {
            System.out.println("Pick one of the routines");
            System.out.println(routines);
            routine = routines.getRoutineByName(scanner.next().toUpperCase());
        }
        return routine;
    }

    private LinkedList<Float> routineWeightPicker(Scanner scanner, Routine routine) {
        LinkedList<Float> result = new LinkedList<>();
        for (Exercise exercise : routine.getExercises()) {
            result.add(exerciseWeightPicker(scanner, exercise));
        }
        return result;
    }

    private float exerciseWeightPicker(Scanner scanner, Exercise exercise) {
        System.out.print("Input a weight for the following exercise:" + exercise.getName() + ": ");
        return scanner.nextFloat();
    }
}
