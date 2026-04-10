package com.abversion.experiment_service.ExperimentController;

import com.abversion.experiment_service.ExperimentService.ExperimentService;
import com.abversion.experiment_service.dto.ExperimentResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/experiment")
public class ExperimentController {

    private final ExperimentService experimentService;

    public ExperimentController(ExperimentService experimentService) {
        this.experimentService = experimentService;
    }

    @GetMapping
    public ExperimentResponse getExperiment(@RequestParam("user_id") String userId) {
        String variant = experimentService.getVariant(userId);

        return new ExperimentResponse(
                userId,
                "homepage_test",
                variant
        );
    }
}
