package com.ennsko.tuning;

public interface TuningBehavior {
    public Ratios tune(TuningSet tuningSet, Harmony harmony, int referencePos, String calcType);
}
