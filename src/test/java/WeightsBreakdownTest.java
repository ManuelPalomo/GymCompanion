package test.java;

import main.java.weights.WeightParser;
import main.java.weights.Weights;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class WeightsBreakdownTest {
    Weights weights;

    @Before
    public void setUp() throws Exception {
        weights = new WeightParser().parseWeights("files/weights-default.txt");
    }

    @Test
    public void getWeightBreakdown() throws Exception {
        LinkedList<Float> result1 = weights.getWeightBreakdown(500f);
        LinkedList<Float> result2 = weights.getWeightBreakdown(21.5f);
        LinkedList<Float> result3 = weights.getWeightBreakdown(0f);
        assertEquals(26, result1.size());
        assertEquals(3, result2.size());
        assertEquals(1, result3.size());

    }

}