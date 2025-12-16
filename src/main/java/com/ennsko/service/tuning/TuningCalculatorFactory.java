package com.ennsko.service.tuning;

public class TuningCalculatorFactory {
    public TuningCalculator get(String calcType, TuningSet set) {
        return new FewestTermsCalculator(set);
    }
}
