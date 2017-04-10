package com.beep.course;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface CourseRepository extends PagingAndSortingRepository<Course, Long>{
	
	// By adding this line 
	Page<Course> findByTitleContaining(@Param("title") String title, Pageable page);
  
}
 