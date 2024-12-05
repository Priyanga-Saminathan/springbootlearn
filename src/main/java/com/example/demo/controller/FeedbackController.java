package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.EmployeeEntity;
import com.example.demo.entity.Feedback;
import com.example.demo.service.FeedbackService;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {
	@Autowired
	FeedbackService feedbackService;
	@PostMapping("/create")
	public ResponseEntity<String> createFeedback(@RequestParam String position, @RequestParam String title, @RequestParam int num){
		return feedbackService.createFeedback(position, title, num);
	}
	@GetMapping("/get/{id}")
	public Optional<Feedback> getFeedback(@PathVariable int id){
		return feedbackService.getFeedback(id);
	}
}
