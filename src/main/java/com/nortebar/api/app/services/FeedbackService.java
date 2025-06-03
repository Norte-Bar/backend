package com.nortebar.api.app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nortebar.api.app.repositories.FeedbackRepository;
import com.nortebar.api.models.dtos.FeedbackDTO;
import com.nortebar.api.models.entities.Feedback;

@Service
public class FeedbackService {
    
    final FeedbackRepository feedbackRepository;

    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public List<Feedback> findAll() {
        return feedbackRepository.findAll();
    }

    public Feedback create(FeedbackDTO dto) {
        return feedbackRepository.save(new Feedback(dto));
    }

}
