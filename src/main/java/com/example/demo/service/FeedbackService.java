package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.EmployeeEntity;
import com.example.demo.entity.Feedback;
import com.example.demo.repo.EmployeeRepo;
import com.example.demo.repo.FeedbackRepo;

@Service
public class FeedbackService {
	@Autowired
	FeedbackRepo feedbackrepo;
	@Autowired
	EmployeeRepo emprepo;
	;
	public ResponseEntity<String> createFeedback(String position,String title, int num) {
		List<EmployeeEntity> feed=emprepo.getFeedbackByPosition(position, num);
		Feedback fb=new Feedback();
		fb.setTitle(title);
		fb.setFeedback(feed);
		feedbackrepo.save(fb);
		return new ResponseEntity<>("success",HttpStatus.CREATED);
		
	}
	public Optional<Feedback> getFeedback(int id) {
		return feedbackrepo.findById(id);
	}
}
