package main.java.weights;

public class Barbell {
    private int weight;
    private String name;

    public Barbell(int weight, String name) {
        this.weight = weight;
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }
}
