package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Feedback {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idf;
	private String title;
	@ManyToMany
	private List<EmployeeEntity> feedback;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setFeedback(List<EmployeeEntity> feedback) {
		this.feedback=feedback;
	}
	public List<EmployeeEntity> getFeedback(){
		return this.feedback;
	}
	

	
}
