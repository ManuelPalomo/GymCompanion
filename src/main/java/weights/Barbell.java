package main.java.weights;

public class Barbell {
    private int weight;
    private String name;

    public Barbell(String name, int weight) {
        this.name = name;
        this.weight = weight;

    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }
}
