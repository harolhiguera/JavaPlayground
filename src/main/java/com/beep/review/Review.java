package com.beep.review;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.beep.core.BaseEntity;
import com.beep.course.Course;
import com.beep.users.User;

@Entity
public class Review extends BaseEntity{
	

	private int rating;
	private String description;
	
	// DB Relations
	@ManyToOne
	private Course course;
	@ManyToOne // Because one user can have many reviews
	private User reviewer;
	
	
	// TODO: Duplication of the code for every single entity
	protected Review(){
		// In case we need to change something specific in all the entities that extend BaseEntity
		super();	
	}

	// Constructors
	public Review(int rating, String description) {
		super();
		this.rating = rating;
		this.description = description;
	}
	
	// Course
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	// Rating
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	// Description
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	// User (Reviewer)

	public User getReviewer() {
		return reviewer;
	}

	public void setReviewer(User reviewer) {
		this.reviewer = reviewer;
	}
	
	
}


