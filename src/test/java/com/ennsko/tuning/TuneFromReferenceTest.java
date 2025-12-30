package com.ennsko.tuning;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.ennsko.service.tuning.Harmony;
import com.ennsko.service.tuning.Interval;
import com.ennsko.service.tuning.TuningBehavior;
import com.ennsko.service.tuning.TuningBehaviorFactory;
import com.ennsko.service.tuning.TuningSet;

public class TuneFromReferenceTest {
    @Test
    @DisplayName("ennskevin: test a major triad root position")
    public void testTuneMajorTriad() {
        // 
        Harmony harmonyInput = new Harmony();
        harmonyInput.add(new Interval(0));
        harmonyInput.add(new Interval(4));
        harmonyInput.add(new Interval(7));

        TuningSet set = new TuningSet();
        set.add(new Interval(4, 5.0/4.0));
        set.add(new Interval(7, 3.0/2.0));

        TuningBehavior tuningBehavior = new TuningBehaviorFactory().get("");
        Harmony harmonyOutput = tuningBehavior.tune(set, harmonyInput, "");
        
        assertEquals(harmonyInput.size(), harmonyOutput.size());
        assertEquals(0, harmonyOutput.get(0).getSemitones());
        assertEquals(5.0/4.0, harmonyOutput.get(1).getRatio());
    }

    @Test
    @DisplayName("ennskevin: tune() reference is not root")
    public void testIntervalsUnchanged() {
        //
        Harmony harmonyInput = new Harmony();
        harmonyInput.add(new Interval(-4));
        harmonyInput.add(new Interval(0));
        harmonyInput.add(new Interval(3));

        TuningSet set = new TuningSet();
        set.add(new Interval(4, 5.0/4.0));
        set.add(new Interval(3, 6.0/5.0));

        TuningBehavior tuningBehavior = new TuningBehaviorFactory().get("");
        Harmony harmonyOutput = tuningBehavior.tune(set, harmonyInput, "");
        
        assertEquals(harmonyInput.size(), harmonyOutput.size());
        assertEquals(-4, harmonyOutput.get(0).getSemitones());
        assertEquals(1.0 / (5.0/4.0), harmonyOutput.get(0).getRatio());
        assertEquals(1.0, harmonyOutput.get(1).getRatio());
        assertEquals(6.0/5.0, harmonyOutput.get(2).getRatio());
    }
}
