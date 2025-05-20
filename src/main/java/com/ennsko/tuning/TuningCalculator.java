package com.ennsko.tuning;

import java.util.List;

public abstract class TuningCalculator {
    TuningSet tuningSet;

    public double ratio(int semitones) {
        double ratio = 1.0;
        List<Interval> path = this.pathToInterval();

        for (Interval member : path) {
            ratio *= member.getRatio();
        }
        return ratio;
    }

    public abstract List<Interval> pathToInterval();
}
