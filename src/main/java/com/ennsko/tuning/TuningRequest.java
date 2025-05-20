package com.ennsko.tuning;

public class TuningRequest {
    Harmony harmony;
    TuningSet tuningSet;
    int referencePos;
    String tuningType;
    String calcType;
    TuningBehavior tuningBehavior;

    Ratios ratios;

    public void performTuning() {
        this.ratios = tuningBehavior.tune(tuningSet, harmony, referencePos, calcType);
    }
}
