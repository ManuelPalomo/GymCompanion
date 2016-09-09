package main.java.weights;

import java.util.LinkedList;

public class Weights {
    private LinkedList<Barbell> barbells;
    private LinkedList<Plate> plates;

    public Weights(LinkedList<Barbell> barbells, LinkedList<Plate> plates) {
        this.barbells = barbells;
        this.plates = plates;
    }

    public LinkedList<Barbell> getBarbells() {
        return barbells;
    }

    public LinkedList<Plate> getPlates() {
        return plates;
    }
}
