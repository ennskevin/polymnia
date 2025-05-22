package com.ennsko.tuning;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IntervalTest {

    @Test
    @DisplayName("ennskevin: ratio to cents works")
    public void testGetCents() {
        Interval interval = new Interval(7, 3.0/2.0);
        double expected = 702;
        double actual = Math.round(interval.getCents());
        assertEquals(expected, actual);
    }
}
