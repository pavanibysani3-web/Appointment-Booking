package com.abs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abs.entity.Feedback;
import com.abs.repository.FeedbackRepository;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository repo;

    public List<Feedback> getAllFeedback() {
        return repo.findAll();
    }

    public Optional<Feedback> getFeedbackById(Integer id) {
        return repo.findById(id);
    }

    public Feedback createFeedback(Feedback feedback) {
        return repo.save(feedback);
    }

    public Feedback updateFeedback(Integer id, Feedback feedback) {
        feedback.setId(id);
        return repo.save(feedback);
    }

    public void deleteFeedback(Integer id) {
        repo.deleteById(id);
    }
}