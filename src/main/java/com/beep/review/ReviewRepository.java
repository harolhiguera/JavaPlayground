package com.beep.review;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;

public interface ReviewRepository extends PagingAndSortingRepository<Review, Long>{

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN') or @reviewRepository.findOne(#id)?.reviewer?.userName == authentication.name")
	void delete(@Param("id") Long id);

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN') or #review.reviewer?.userName == authentication.name")
	void delete(@Param("review") Review entity);

	//TODO: Check out the documentation for authentication security expressions !!!
}
