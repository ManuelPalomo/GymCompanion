package main.java.weights;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class WeightParser {

    public WeightParser() {
        super();
    }

    public Weights parseWeights(String file) {
        try {
            Boolean platesSet = false;
            LinkedList<Plate> plates = new LinkedList<>();
            LinkedList<Barbell> barbells = new LinkedList<>();

            Scanner scanner = new Scanner(new File(file));

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                if (line.charAt(0) != '/') {
                    if (!platesSet) {
                        plates = plateParser(line);
                        platesSet = true;

                    } else {
                        barbells.add(parseBarbell(line));
                    }
                }
            }
            scanner.close();
            return new Weights(barbells, plates);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private LinkedList<Plate> plateParser(String weightLine) {
        String[] platesLine = weightLine.split("\\|");
        LinkedList<Plate> plates = new LinkedList<>();
        for (String plate : platesLine) {
            plates.add(new Plate(Float.parseFloat(plate)));
        }
        return plates;
    }

    private Barbell parseBarbell(String barbellLine) {
        String[] barbellString = barbellLine.split("#");
        return new Barbell(Integer.parseInt(barbellString[1]), barbellString[0]);
    }

}
