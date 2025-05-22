package com.ennsko.tuning;

public class TuningRequest {
    Harmony harmonyInput;
    TuningSet tuningSet;
    int referencePos;
    String tuningType;
    String calcType;
    TuningBehavior tuningBehavior;

    Harmony harmonyOutput;

    public void performTuning() {
        this.harmonyOutput = tuningBehavior.tune(tuningSet, harmonyInput, referencePos, calcType);
    }
}
