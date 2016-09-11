package main.java.weights;

import java.util.Collections;
import java.util.Iterator;
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

    public Barbell getBarbellByName(String name) {
        for (Barbell barbell : barbells) {
            if (barbell.getName().equals(name)) {
                return barbell;
            }
        }
        return null;
    }

    public LinkedList<Float> getWeightBreakdown(float weight) {
        LinkedList<Plate> sortedPlates = sortPlates(plates);
        float currentWeight = weight;
        LinkedList<Float> result = new LinkedList<>();

        for (Plate plate : sortedPlates) {
            int numberOfPlates = (int) (currentWeight / plate.getWeight());
            currentWeight %= plate.getWeight();
            if (numberOfPlates != 0) {
                for (int i = 0; i < numberOfPlates; i++) {
                    result.add(plate.getWeight());
                }
            }
        }
        if (currentWeight > 0.0f) {
            result.add(currentWeight);
        } else {
            result.add(0.0f);
        }
        return result;

    }

    private LinkedList<Plate> sortPlates(LinkedList<Plate> plates) {
        LinkedList<Plate> plateClone = (LinkedList<Plate>) plates.clone();
        Collections.sort(plateClone, (o1, o2) -> Float.compare(o1.getWeight(), o2.getWeight()));
        Collections.reverse(plateClone);
        return plateClone;
    }

    public String getWeightBreakdownString(LinkedList<Float> plates) {
        String result = "";
        for (int i = 0; i < plates.size()-1; i++) {
            result += plates.get(i) + " + ";
        }
        if (plates.get(plates.size() - 1) != 0.0f) {
            result += plates.get(plates.size() - 1) + " that couldn't be divided given current weights";
        }
        return result;
    }
}
