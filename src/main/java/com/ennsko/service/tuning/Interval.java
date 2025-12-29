package com.ennsko.service.tuning;

public class Interval {
    private int semitones;
    private double ratio;

    public Interval() {}

    public Interval(Interval interval) {
        this(interval.getSemitones(), interval.getRatio());
    }

    public Interval(int semitones) {
        this.semitones = semitones;
    }

    public Interval(int semitones, double ratio) {
        this.semitones = semitones;
        this.ratio = ratio;
    }

    
    public Interval flip() {
        return new Interval(this.getSemitones() * -1, 1.0 / this.getRatio());
    }
    
    public double getCents() {
        return 1200 * (Math.log(this.ratio) / Math.log(2));
    }

    public double getRatio() {
        return ratio;
    }

    public int getSemitones() {
        return semitones;
    }
}
