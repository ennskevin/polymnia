package com.ennsko.dto.request;

import com.ennsko.service.tuning.*;
import jakarta.validation.constraints.*;


public record TuningRequest (
    @NotNull Harmony harmony,
    @NotNull TuningSet tuningSet,
    int referencePos,
    String tuningType,
    String calcType,
    TuningBehavior tuningBehavior
) {}
