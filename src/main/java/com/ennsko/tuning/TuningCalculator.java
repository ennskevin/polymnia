package com.ennsko.tuning;

import java.util.List;

public abstract class TuningCalculator {
    TuningSet tuningSet;

    public TuningCalculator(TuningSet tuningSet) {
        this.tuningSet = tuningSet;
    }

    public double ratio(int semitones) {
        double ratio = 1.0;
        List<Interval> path = this.path(semitones);

        for (Interval member : path) {
            ratio *= member.getRatio();
        }
        return ratio;
    }

    public abstract TuningPath path(int target);
}
