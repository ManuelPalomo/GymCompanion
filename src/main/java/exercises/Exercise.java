package main.java.exercises;

import main.java.weights.Barbell;

public class Exercise {
    private String name;
    private Barbell barbellWeight;

    public Exercise(String name, Barbell barbellWeight) {
        this.name = name;
        this.barbellWeight = barbellWeight;
    }

    public String getName() {
        return this.name;
    }

    public Barbell getBarbellWeight() {
        return this.barbellWeight;
    }
}
