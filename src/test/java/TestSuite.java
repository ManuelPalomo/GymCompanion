package test.java;

import main.java.routines.RoutineParser;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ExerciseParserTest.class,
        WeightParserTest.class,
        RoutineParserTest.class
})
public class TestSuite {
}


