package com.abversion.experiment_service.dto;

public record ExperimentResponse(
        String user_id,
        String experiment,
        String variant
) {
}

