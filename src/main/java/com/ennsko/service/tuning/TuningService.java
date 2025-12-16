package com.ennsko.service.tuning;

import com.ennsko.dto.request.TuningRequest;
import com.ennsko.dto.response.TuningResponse;

import org.springframework.stereotype.Service;

@Service
public class TuningService {
    
    public TuningResponse calculate(TuningRequest request) {
        return new TuningResponse(
            request.harmony(),
            request.tuningSet(),
            request.referencePos(),
            request.tuningType(),
            request.calcType()
        );
    }

}
