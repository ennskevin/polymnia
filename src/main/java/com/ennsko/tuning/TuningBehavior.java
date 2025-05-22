package com.ennsko.tuning;

public interface TuningBehavior {
    public Harmony tune(TuningSet tuningSet, Harmony harmony, int referencePos, String calcType);
}
