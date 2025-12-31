package com.ennsko.service.tuning;

import java.util.Collections;

public class TuneIncremental implements TuningBehavior{

    @Override
    public Harmony tune(TuningSet tuningSet, Harmony harmony, String calcType) {
        TuningCalculator calc = new TuningCalculatorFactory().get(calcType, tuningSet);
        Harmony tunedHarmony = new Harmony();

        // calculate outward from the 0 interval (reference position)
        // split into positive set of intervals
        // split into negative set of intervals
        // make sure to sum the cents as you go outward, so if you have 0, 4, 7
        // you would tune(4) and then tune(7-4) and then add that to the tune(4) to get tune(7)
        Harmony positives = new Harmony();
        Harmony negatives = new Harmony();
        for (Interval interval : harmony) {
            if (interval.getSemitones() > 0) positives.add(interval);
            if (interval.getSemitones() < 0) negatives.add(interval);
        }
        positives.sortIntervals();
        negatives.sortIntervals();
        Collections.reverse(negatives);
        
        // calculate the positive intervals
        double combinedRatio = 1.0;
        int semitoneSum = 0;
        for (Interval interval : positives) {
            int target = interval.getSemitones() - semitoneSum;
            combinedRatio *= calc.ratio(target);
            semitoneSum += target;
            tunedHarmony.add(new Interval(interval.getSemitones(), combinedRatio));
        }

        return tunedHarmony;

    }
    
}
