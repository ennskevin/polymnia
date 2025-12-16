package com.ennsko.service.tuning;

public class TuningBehaviorFactory {
    public TuningBehavior get(String tuningType) {
        return new TuneFromReference();
    }
}
