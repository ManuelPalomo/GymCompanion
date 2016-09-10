package test.java;

import main.java.weights.WeightParser;

import static org.junit.Assert.*;

import main.java.weights.Weights;
import org.junit.Test;
import org.junit.Before;

public class WeightParserTest {
    WeightParser parser;

    @Before
    public void initParser() {
        parser = new WeightParser();
    }

    @Test
    public void testParseWeight() {
        Weights weightsTest = parser.parseWeights("files/weights-default.txt");
        assertEquals(5, weightsTest.getPlates().size());
        assertEquals(2, weightsTest.getBarbells().size());
        assertEquals(1.25, weightsTest.getPlates().get(0).getWeight(), 0);
    }
}