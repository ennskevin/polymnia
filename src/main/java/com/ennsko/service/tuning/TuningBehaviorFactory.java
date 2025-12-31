package com.ennsko.service.tuning;

public class TuningBehaviorFactory {
    public TuningBehavior get(String tuningType) {
        switch (tuningType) {
            case "Incremental":
                return new TuneIncremental();
            case "Absolute":
                return new TuneAbsolute();
            default:
                return new TuneAbsolute();
        }
    }
}
