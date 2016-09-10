package test.java;

import main.java.exercises.ExerciseParser;
import main.java.exercises.Exercises;
import main.java.weights.WeightParser;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExerciseParserTest {
    WeightParser weightParser;
    ExerciseParser exerciseParser;

    @Before
    public void initParser() throws Exception {
        weightParser = new WeightParser();
        exerciseParser = new ExerciseParser(weightParser.parseWeights("files/weights-default.txt"));
    }

    @Test
    public void testParseWeights() throws Exception {
        Exercises exercises = exerciseParser.parseExercises("files/exercises-default.txt");
        assertEquals(5,exercises.getExercises().size());
        assertEquals("Squat",exercises.getExercises().get(0).getName());
        assertEquals("Deadlift",exercises.getExercises().get(4).getName());

    }

}