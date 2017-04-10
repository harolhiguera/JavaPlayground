package com.beep.course;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.beep.core.BaseEntity;
import com.beep.review.Review;

@Entity
public class Course extends BaseEntity{  

	// Validates the title text !!!
	@NotNull
	@Size(min=2, max=240)
	private String title;
	private String url;
	
	// DB Relations
	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL) 
	private List<Review> reviews;
	
	// Constructors
	protected Course(){
		super();
		reviews = new ArrayList<>();
	}
	public Course(String title, String url) {
		this();
		this.title = title;
		this.url = url;
	}
	

	// Review 
	public List<Review> getReviews() {
		return reviews;
	}
	public void addReview(Review review){
		review.setCourse(this);
		reviews.add(review);
	}
	// Title 
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	// URL 
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
