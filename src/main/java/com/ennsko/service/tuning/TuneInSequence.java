package com.ennsko.service.tuning;

public class TuneInSequence implements TuningBehavior{

    @Override
    public Harmony tune(TuningSet tuningSet, Harmony harmony, String calcType) {
        TuningCalculator calc = new TuningCalculatorFactory().get(calcType, tuningSet);
        Harmony tunedHarmony = new Harmony();

        // calculate outward from the 0 interval (reference position)
        // split into positive set of intervals
        // split into negative set of intervals
        // make sure to sum the cents as you go outward, so if you have 0, 4, 7
        // you would tune(4) and then tune(7-4) and then add that to the tune(4) to get tune(7)

        return null;

    }
    
}
