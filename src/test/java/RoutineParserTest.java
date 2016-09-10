package test.java;

import main.java.exercises.ExerciseParser;
import main.java.routines.RoutineParser;
import main.java.routines.Routines;
import main.java.weights.WeightParser;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class RoutineParserTest {
    WeightParser weightParser;
    ExerciseParser exerciseParser;
    RoutineParser routineParser;

    @Before
    public void initParser() throws Exception {
        weightParser = new WeightParser();
        exerciseParser = new ExerciseParser(weightParser.parseWeights("files/weights-default.txt"));
        routineParser = new RoutineParser(exerciseParser.parseExercises("files/exercises-default.txt"));

    }

    @Test
    public void testParseRoutines() throws Exception {
        Routines testRoutines = routineParser.parseRoutines("files/routine-default.txt");
        assertEquals(2,testRoutines.getRoutines().size());
        assertEquals("A",testRoutines.getRoutines().get(0).getName());

    }

}