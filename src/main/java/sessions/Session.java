package main.java.sessions;

import main.java.routines.Routine;

import java.util.LinkedList;

public class Session {
    private Routine routine;
    private LinkedList<Integer> weight;
    private LinkedList<String> reps;

    public Session(Routine routine, LinkedList<Integer> weight, LinkedList<String> reps) {
        this.routine = routine;
        this.weight = weight;
        this.reps = reps;
    }
}
