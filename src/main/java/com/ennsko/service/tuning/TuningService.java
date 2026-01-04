package com.ennsko.service.tuning;

import com.ennsko.dto.request.TuningRequest;
import com.ennsko.dto.response.TuningResponse;

import org.springframework.stereotype.Service;

@Service
public class TuningService {
    
    public TuningResponse calculate(TuningRequest request) {
        TuningBehavior tuningBehavior = new TuningBehaviorFactory().get(request.tuningType());

        request.tuningSet().validate();

        Harmony harmony = tuningBehavior.tune(
            request.tuningSet(),
            request.harmony(),
            request.calcType()
        );
        harmony.sortIntervals();

        Frequencies frequencies = request.frequencies();
        if (request.anchor() != null) {
            frequencies = harmony.calculateFrequencies(request.anchor());
        }
        
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
