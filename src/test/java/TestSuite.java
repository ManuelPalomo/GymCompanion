package test.java;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ExerciseParserTest.class,
        WeightParserTest.class,
        RoutineParserTest.class,
        WeightsBreakdownTest.class,
        SessionWeightBreakdownTest.class,
})
public class TestSuite {
}


