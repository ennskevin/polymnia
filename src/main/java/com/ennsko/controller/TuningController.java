package com.ennsko.controller;

import com.ennsko.dto.request.TuningRequest;
import com.ennsko.dto.response.TuningResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ennsko.service.tuning.TuningService;

@RestController
@RequestMapping("/api/tuning")
public class TuningController {
    
    private final TuningService tuningService;

    public TuningController(TuningService tuningService) {
        this.tuningService = tuningService;
    }

    @PostMapping
    public TuningResponse run(@RequestBody TuningRequest request) {
        return tuningService.calculate(request);
    }
}
