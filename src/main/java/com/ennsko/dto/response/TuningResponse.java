package com.ennsko.dto.response;

import com.ennsko.service.tuning.*;
import jakarta.validation.constraints.*;


public record TuningResponse (
    @NotNull Harmony harmony,
    @NotNull TuningSet tuningSet,
    String tuningType,
    String calcType
) {}
