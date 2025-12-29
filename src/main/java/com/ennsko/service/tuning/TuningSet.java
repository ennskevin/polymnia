package com.ennsko.service.tuning;

import java.util.ArrayList;

import com.ennsko.exception.InvalidTuningSetException;

public class TuningSet extends ArrayList<Interval>{
    
    public void validate() throws InvalidTuningSetException {
        int gcd = gcdList();
        gcd = gcd(gcd, 12);
        if (gcd != 1) throw new InvalidTuningSetException("Tuning set cannot reach all 12 notes of an octave.");
    }

    // euclids
    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        else {
            return gcd(b, a % b);
        }
    }

    public int gcdList() {
        int g = 0;
        for (Interval interval : this) {
            int semitones = interval.getSemitones();
            g = gcd(g, semitones);
        }
        return g;
    }

}
