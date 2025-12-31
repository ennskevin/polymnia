package com.ennsko.service.tuning;

public class TuneAbsolute implements TuningBehavior {

    @Override
    public Harmony tune(TuningSet tuningSet, Harmony harmony, String calcType) {
        TuningCalculator calc = new TuningCalculatorFactory().get(calcType, tuningSet);
        Harmony tunedHarmony = new Harmony();
        // if interval has negative semitones, we flip the ratio after solving
        // the absolute value semitones
        for (Interval interval : harmony) {
            int target = Math.abs(interval.getSemitones());
            double tunedRatio = calc.ratio(target);
            Interval tunedInterval = new Interval(target, tunedRatio);
            if (interval.getSemitones() < 0) {
                tunedInterval = tunedInterval.flip();
            }
            tunedHarmony.add(tunedInterval);
        }
        return tunedHarmony;
    }

}