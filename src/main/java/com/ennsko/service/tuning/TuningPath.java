package com.ennsko.service.tuning;

import java.util.ArrayList;

// a TuningPath evaluates to a ratio
public class TuningPath extends ArrayList<Interval> {
    int sum = 0;

    public TuningPath() {
        super();
        this.sum = 0;
    }

    public TuningPath(TuningPath tuningPath) {
        super();
        for (Interval interval : tuningPath) {
            this.add(new Interval(interval));
        }
    }

    public boolean add(Interval interval) {
        this.sum += interval.getSemitones();
        return super.add(new Interval(interval));
    }

    public int sum() {
        return this.sum;
    }
}
