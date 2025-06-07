package com.nortebar.api.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nortebar.api.models.entities.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer>{   
}
