package com.ennsko.tuning;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.ennsko.service.tuning.FewestTermsCalculator;
import com.ennsko.service.tuning.Interval;
import com.ennsko.service.tuning.TuningCalculator;
import com.ennsko.service.tuning.TuningPath;
import com.ennsko.service.tuning.TuningSet;

public class FewestTermsCalculatorTest {

    @Test
    @DisplayName("ennskevin: path should have a negative interval")
    public void testPathSubtract() {
        // set = 3, 5
        // target = 2
        // expected path = [5, -3]
        int target = 2;

        TuningSet set = new TuningSet();
        set.add(new Interval(3));
        set.add(new Interval(5));

        TuningPath expected = new TuningPath();
        expected.add(new Interval(5));
        expected.add(new Interval(-3));

        TuningCalculator calc = new FewestTermsCalculator(set);

        TuningPath actual = calc.path(target);
        assertEquals(expected.get(0).getSemitones(), actual.get(0).getSemitones());
        assertEquals(expected.get(1).getSemitones(), actual.get(1).getSemitones());
    }

    @Test
    @DisplayName("ennskevin: path should have only positive intervals")
    public void testPathAdd() {
        // set = 3, 5
        // target = 6
        // expected path = [3, 3]
        int target = 6;

        TuningSet set = new TuningSet();
        set.add(new Interval(3));
        set.add(new Interval(5));

        TuningPath expected = new TuningPath();
        expected.add(new Interval(3));
        expected.add(new Interval(3));

        TuningCalculator calc = new FewestTermsCalculator(set);

        TuningPath actual = calc.path(target);
        assertEquals(expected.get(0).getSemitones(), actual.get(0).getSemitones());
        assertEquals(expected.get(1).getSemitones(), actual.get(1).getSemitones());
    }

    @Test
    @DisplayName("ennskevin: target is a tuningSet member")
    public void testPathOneSolution() {
        // set = 3, 5
        // target = 3
        // expected path = [3], length == 1
        int target = 3;

        TuningSet set = new TuningSet();
        set.add(new Interval(3));
        set.add(new Interval(5));

        TuningPath expected = new TuningPath();
        expected.add(new Interval(3));

        TuningCalculator calc = new FewestTermsCalculator(set);

        TuningPath actual = calc.path(target);
        assertEquals(expected.get(0).getSemitones(), actual.get(0).getSemitones());
    }

    @Test
    @DisplayName("ennskevin: target is more than two octaves")
    public void testPathTwoOctaves() {
        // set = 13, 7, 5
        // target = 25
        // expected path = [13, 7, 5]
        int target = 25;

        TuningSet set = new TuningSet();
        set.add(new Interval(13));
        set.add(new Interval(7));
        set.add(new Interval(5));

        TuningPath expected = new TuningPath();
        expected.add(new Interval(13));

        TuningCalculator calc = new FewestTermsCalculator(set);

        TuningPath actual = calc.path(target);
        assertEquals(expected.size(), actual.size());
        assertEquals(expected.get(0).getSemitones(), actual.get(0).getSemitones());
    }

    @Test
    @DisplayName("ennskevin: sum and target do not equal each other")
    public void testPathToResidual() {
        // set = 13, 4
        // target = 5
        // expected path = [13, 4], sum = 17 != 5
        int target = 5;

        TuningSet set = new TuningSet();
        set.add(new Interval(13));
        set.add(new Interval(4));

        TuningCalculator calc = new FewestTermsCalculator(set);

        TuningPath actual = calc.path(target);
        assertNotEquals(target, actual.sum());
    }
    
    @Test
    @DisplayName("ennskevin: ratio needs no octave shifting")
    public void testRatioNoOctaveShift() {
        int target = 10;

        TuningSet set = new TuningSet();
        set.add(new Interval(5, 4.0/3.0));

        double expected = (4.0/3.0) * (4.0/3.0);

        TuningCalculator calc = new FewestTermsCalculator(set);

        double actual = calc.ratio(target);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("ennskevin: ratio needs 2 octave shift down")
    public void testRatioOctaveShiftDown() {
        int target = 11;

        TuningSet set = new TuningSet();
        set.add(new Interval(7, 3.0/2.0));
        double perfectFifth = 3.0/2.0;

        double expected = Math.pow(perfectFifth, 5) * Math.pow(2, -2);

        TuningCalculator calc = new FewestTermsCalculator(set);

        double actual = calc.ratio(target);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("ennskevin: ratio needs 1 octave shift up")
    public void testRatioOctaveShiftUp() {
        int target = 26;

        TuningSet set = new TuningSet();
        set.add(new Interval(7, 3.0/2.0));
        double perfectFifth = 3.0/2.0;

        double expected = Math.pow(perfectFifth, 2) * Math.pow(2, 1);

        TuningCalculator calc = new FewestTermsCalculator(set);

        double actual = calc.ratio(target);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("ennskevin: ratio path has negative intervals")
    public void testRatioNegativeIntervalsInPath() {
        // set = 3, 5
        // target = 2
        // expected path = [5, -3]
        int target = 2;

        TuningSet set = new TuningSet();
        set.add(new Interval(3, 6.0/5.0));
        set.add(new Interval(5, 4.0/3.0));

        TuningCalculator calc = new FewestTermsCalculator(set);

        double expected = (4.0/3.0) * (1.0 / (6.0/5.0));
        double actual = calc.ratio(target);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("ennskevin: target is negative")
    public void testRatioNegativeTarget() {
        // set = 3, 5
        // target = -2
        // expected path = [5, -3]
        int target = -2;

        TuningSet set = new TuningSet();
        set.add(new Interval(3, 6.0/5.0));
        set.add(new Interval(5, 4.0/3.0));

        TuningCalculator calc = new FewestTermsCalculator(set);

        double expected = -1 * ((4.0/3.0) * (1.0 / (6.0/5.0)));
        double actual = calc.ratio(target);
        assertEquals(expected, actual);
    }
}
