package com.ennsko.dto.response;

import com.ennsko.service.tuning.*;
import jakarta.validation.constraints.*;


public record TuningResponse (
    @NotNull Harmony harmony,
    @NotNull TuningSet tuningSet,
    int referencePos,
    String tuningType,
    String calcType
) {}
