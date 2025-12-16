package com.ennsko.controller;

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
}
