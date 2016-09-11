package main.java.sessions;

import main.java.exercises.Exercise;
import main.java.routines.Routine;
import main.java.weights.Weights;

import java.util.LinkedList;

public class Session {
    private Routine routine;
    private Weights weights;
    private LinkedList<Float> weightInExercise;
    private LinkedList<String> reps;

    public Session(Routine routine, Weights weights, LinkedList<Float> weight, LinkedList<String> reps) {
        this.routine = routine;
        this.weights = weights;
        this.weightInExercise = weight;
        this.reps = reps;
    }

    private String getExerciseWeightBreakDownPerSide(Exercise exercise, float weight) {
        float weightMinusBar = (weight - exercise.getBarbellWeight().getWeight())/2;
        return exercise.getName() + " : "+"Total: "+weight+" kg | Per Side: " + weights.getWeightBreakdownString(weights.getWeightBreakdown(weightMinusBar));
    }

    public String getSessionWeightBreakDown() {
        String result = "";
        LinkedList<Exercise> exercises = routine.getExercises();
        for (int i = 0; i < exercises.size(); i++) {
            result += getExerciseWeightBreakDownPerSide(exercises.get(i), weightInExercise.get(i)) + "\n";
        }
        return result;
    }
}
