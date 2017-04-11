package com.beep.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.beep.course.Course;
import com.beep.course.CourseRepository;
import com.beep.review.Review;
import com.beep.users.User;
import com.beep.users.UserRepository;

@Component
public class DatabaseLoader implements ApplicationRunner{

	private final CourseRepository courses;
	private final UserRepository users;
	
	//Automatically wire it up to whatever has a label of CourseRepository
	@Autowired
	public DatabaseLoader(CourseRepository courses, UserRepository user) {
		super();
		this.courses = courses; 
		this.users = user;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		Course course = new Course("Java Basics", "Http://.......");
		course.addReview(new Review(3, "This is a very bad review!!"));
		courses.save(course);
		
		String[] templates = {
				"Up and running with %s",
				"%s Elementary",
				"%s Basics",
				"%s Inteemediate",
				"%s Advance"		
		};
		String[] buzzWords = {
				
				"buzzWords 1",	
				"buzzWords 2",	
				"buzzWords 3",	
				"buzzWords 4",	
				"buzzWords 5"	
				};
		List<User> students = Arrays.asList(
				new User("User_01",  "User_01", "UserSurname_01","user_01_password", new String[] {"ROLE_USER"}),
				new User("User_02",  "User_02", "UserSurname_02","user_02_password", new String[] {"ROLE_USER"}),
				new User("User_03",  "User_03", "UserSurname_03","user_03_password", new String[] {"ROLE_USER"}),
				new User("User_04",  "User_04", "UserSurname_04","user_04_password", new String[] {"ROLE_USER"}),
				new User("User_05",  "User_05", "UserSurname_05","user_05_password", new String[] {"ROLE_USER"}),
				new User("User_06",  "User_06", "UserSurname_06","user_06_password", new String[] {"ROLE_USER"}),
				new User("User_07",  "User_07", "UserSurname_07","user_07_password", new String[] {"ROLE_USER"})
				);
		users.save(students);
		users.save(new User("Harol1", "Higuera1", "harol1", "password", new String[] {"ROLE_USER", "ROLE_ADMIN"}));
		
				
		List<Course> coursesBunch = new ArrayList<>();
		IntStream.range(0, 100).forEach(i->{
			String template = templates[i % templates.length];
			String buzzWord = buzzWords[i % buzzWords.length];
			String title = String.format(template, buzzWord);
			Course c = new Course(title, "htttp//:.....");
			Review review = new Review((i % 5) + 1, String.format("More %s please!!", buzzWord));
			review.setReviewer(students.get(i % students.size()));
			c.addReview(review);
			coursesBunch.add(c);
		});
		
		courses.save(coursesBunch);
	}

}
