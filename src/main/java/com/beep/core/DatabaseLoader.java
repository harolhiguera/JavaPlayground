package com.beep.core;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.beep.course.Course;
import com.beep.course.CourseRepository;
import com.beep.review.Review;

@Component
public class DatabaseLoader implements ApplicationRunner{

	private final CourseRepository courses;
	
	//Automatically wire it up to whatever has a label of CourseRepository
	@Autowired
	public DatabaseLoader(CourseRepository courses) {
		super();
		this.courses = courses;
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
		
		
		List<Course> coursesBunch = new ArrayList<>();
		IntStream.range(0, 100).forEach(i->{
			String template = templates[i % templates.length];
			String buzzWord = buzzWords[i % buzzWords.length];
			String title = String.format(template, buzzWord);
			Course c = new Course(title, "htttp//:.....");
			c.addReview(new Review(i % 5, String.format("More %s please!!", buzzWord)));
			coursesBunch.add(c);
		});
		
		courses.save(coursesBunch);
	}

}
