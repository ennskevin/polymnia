package com.ennsko.tuning;

public class Interval {
    int semitones;
    double ratio;

    public Interval(int semitones) {
        this.semitones = semitones;
    }

    public Interval(int semitones, double ratio) {
        this.semitones = semitones;
        this.ratio = ratio;
    }
}
