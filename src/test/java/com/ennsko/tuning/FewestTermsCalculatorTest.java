package com.ennsko.tuning;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

}
