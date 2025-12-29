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
            request.referencePos(),
            request.calcType()
        );
        harmony.sortIntervals();
        
        return new TuningResponse(
            harmony,
            request.tuningSet(),
            request.referencePos(),
            request.tuningType(),
            request.calcType()
        );
    }

}
