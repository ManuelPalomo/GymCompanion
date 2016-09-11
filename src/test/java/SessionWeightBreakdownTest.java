package test.java;

import main.java.exercises.ExerciseParser;
import main.java.routines.Routine;
import main.java.routines.RoutineParser;
import main.java.sessions.Session;
import main.java.weights.WeightParser;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;


public class SessionWeightBreakdownTest {
    WeightParser weightParser;
    ExerciseParser exerciseParser;
    RoutineParser routineParser;
    Routine routine;
    Session session;

    @Before
    public void initParser() throws Exception {
        weightParser = new WeightParser();
        exerciseParser = new ExerciseParser(weightParser.parseWeights("files/weights-default.txt"));
        routineParser = new RoutineParser(exerciseParser.parseExercises("files/exercises-default.txt"));
        routine = routineParser.parseRoutines("files/routine-default.txt").getRoutines().get(0);

        LinkedList<Float> weightsInExercises = new LinkedList<>();
        weightsInExercises.add(75f);
        weightsInExercises.add(50f);
        weightsInExercises.add(42.5f);

        LinkedList<String> reps = new LinkedList<>();
        reps.add("5x5");
        reps.add("5x5");
        reps.add("5x5");

        session = new Session(routine, weightParser.parseWeights("files/weights-default.txt"), weightsInExercises, reps);

    }

    @Test
    public void getSessionWeightBreakDown() throws Exception {
        System.out.println(session.getSessionWeightBreakDown());
    }

}