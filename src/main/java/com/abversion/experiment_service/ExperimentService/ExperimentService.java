package com.abversion.experiment_service.ExperimentService;

import com.abversion.experiment_service.exception.ExperimentNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ExperimentService {

    public String getVariant(String userId) {
        if (userId == null || userId.trim().isEmpty()) {
            throw new ExperimentNotFoundException("Experiment variant not found for empty user_id");
        }

        int hash = Math.abs(userId.hashCode());
        return (hash % 2 == 0) ? "A" : "B";
    }
}