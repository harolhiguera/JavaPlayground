package com.beep.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.beep.users.User;
import com.beep.users.UserRepository;


@Component
@RepositoryEventHandler(Review.class) //Takes a class that would be interested in watching..
public class ReviewEventHandler {

	private final UserRepository users;
	
	@Autowired
	public ReviewEventHandler(UserRepository users){
		this.users = users;
	}
	
	@HandleBeforeCreate
	public void ReviewerBasedOnLoggedInUser(Review review){
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = users.findByUserName(username);
		review.setReviewer(user);
	}
}
