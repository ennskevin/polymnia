package com.ennsko.service.tuning;

public interface TuningBehavior {
    public Harmony tune(TuningSet tuningSet, Harmony harmony, String calcType);
}
