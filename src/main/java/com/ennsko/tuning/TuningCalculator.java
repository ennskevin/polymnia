package com.ennsko.tuning;

import java.util.List;

public abstract class TuningCalculator {
    TuningSet tuningSet;

    public double ratio(int semitones) {
        double ratio = 1.0;
        List<Integer> path = this.pathToInterval();

        // for every member of the path, multiply ratio by
        // that intervals ratio field

        return -1.0;
    }

    public abstract List<Integer> pathToInterval();
}
