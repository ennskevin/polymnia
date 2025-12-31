package com.ennsko.service.tuning;

import java.util.List;

public abstract class TuningCalculator {
    TuningSet tuningSet;

    public TuningCalculator(TuningSet tuningSet) {
        this.tuningSet = tuningSet;
    }

    public double ratio(int target) {
        if (target == 0) return 1.0; // same note as itself
        boolean isNegative = false;
        if (target < 0) {
            isNegative = true;
            target *= -1;
        }
        double ratio = 1.0;
        TuningPath path = this.path(target);

        for (Interval member : path) {
            ratio *= member.getRatio();
        }

        // find the difference between sum of path and the target
        // for every change in 12, the ratio gets multiplied
        // by a power of 2

        int octaveDifference = target - path.sum();
        octaveDifference /= 12;

        ratio *= Math.pow(2, octaveDifference);

        if (isNegative) ratio = 1.0 / ratio;
        return ratio;
    }

    public abstract TuningPath path(int target);
}
