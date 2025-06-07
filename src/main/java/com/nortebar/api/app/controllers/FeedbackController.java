package com.nortebar.api.app.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nortebar.api.app.services.FeedbackService;
import com.nortebar.api.models.dtos.FeedbackDTO;
import com.nortebar.api.models.entities.Feedback;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/feedback")
public class FeedbackController {
    
    final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GetMapping
    public List<Feedback> findAll() {
        return feedbackService.findAll();
    }

    @PostMapping
    public Feedback create(@RequestBody @Valid FeedbackDTO body) {
        return feedbackService.create(body);
    }
}
