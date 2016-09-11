package main.java.routines;

import java.util.LinkedList;

public class Routines {
    LinkedList<Routine> routines;

    public Routines(LinkedList<Routine> routines) {
        this.routines = routines;
    }

    public LinkedList<Routine> getRoutines() {
        return routines;
    }

    public Routine getRoutineByName(String name) {
        for (Routine routine : routines) {
            if (routine.getName().equals(name)) {
                return routine;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String result = "";
        for (Routine routine : routines) {
            result += routine + "\n";
        }
        return result;
    }
}
