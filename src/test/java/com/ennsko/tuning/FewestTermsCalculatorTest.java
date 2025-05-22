package com.ennsko.tuning;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FewestTermsCalculatorTest {
    @Test
    @DisplayName("ennskevin: path should have a negative interval")
    public void testPathSubtract() {
        // set = 3, 5
        // target = 2
        // expected path = [5, -3]
    }

    @Test
    @DisplayName("ennskevin: path should have only positive intervals")
    public void testPathAdd() {
        // set = 3, 5
        // target = 6
        // expected path = [3, 3]
    }

    @Test
    @DisplayName("ennskevin: target is a tuningSet member")
    public void testPathOneSolution() {
        // set = 3, 5
        // target = 3
        // expected path = [3], length == 1
    }

    @Test
    @DisplayName("ennskevin: target is more than two octaves")
    public void testPathTwoOctaves() {
        // set = 13, 7, 5
        // target = 25
        // expected path = [13, 7, 5]
    }

    @Test
    @DisplayName("ennskevin: sum and target do not equal each other")
    public void testPathToResidual() {
        // set = 13, 4
        // target = 5
        // expected path = [13, 4], sum = 17 != 5
    }

}
