package com.ennsko.service.tuning;

import java.util.ArrayList;
import java.util.Comparator;

// a collection of ints who's range is <= 32
// the ints represent semitones from the reference, can be neg or pos
public class Harmony extends ArrayList<Interval> {

    public void sortIntervals() {
        this.sort(Comparator.comparingInt(Interval::getSemitones));
    }
    
    public Frequencies calculateFrequencies(double anchor) {
        sortIntervals();
        Frequencies frequencies = new Frequencies();
        for (Interval interval : this) {
            double frequency = anchor * interval.getRatio();
            frequencies.add(frequency);
        }
        return frequencies;
    }
}
