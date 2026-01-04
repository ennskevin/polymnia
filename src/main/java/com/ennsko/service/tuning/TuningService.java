package com.ennsko.service.tuning;

import com.ennsko.dto.request.TuningRequest;
import com.ennsko.dto.response.TuningResponse;

import org.springframework.stereotype.Service;

@Service
public class TuningService {
    
    public TuningResponse calculateRatios(TuningRequest request) {
        TuningBehavior tuningBehavior = new TuningBehaviorFactory().get(request.tuningType());

        request.tuningSet().validate();

        Harmony harmony = tuningBehavior.tune(
            request.tuningSet(),
            request.harmony(),
            request.calcType()
        );
        harmony.sortIntervals();
        
        return new TuningResponse(
            harmony,
            request.tuningSet(),
            request.tuningType(),
            request.calcType(),
            request.anchor(),
            request.frequencies()
        );
    }

    public TuningResponse calculateFrequencies(TuningRequest request) {
        Harmony harmony = request.harmony();
        
        Frequencies frequencies = harmony.calculateFrequencies(request.anchor());

        return new TuningResponse(
            harmony,
            request.tuningSet(),
            request.tuningType(),
            request.calcType(),
            request.anchor(),
            frequencies
        );        
    }

}
