package com.ennsko.tuning;

public class Interval {
    private int semitones;
    private double ratio;

    public Interval(int semitones) {
        this.semitones = semitones;
    }

    public Interval(int semitones, double ratio) {
        this.semitones = semitones;
        this.ratio = ratio;
    }

    public double getRatio() {
        return ratio;
    }

    public int getSemitones() {
        return semitones;
    }
}
