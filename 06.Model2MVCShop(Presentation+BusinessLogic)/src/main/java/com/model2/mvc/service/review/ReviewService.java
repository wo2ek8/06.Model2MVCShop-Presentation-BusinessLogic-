package com.model2.mvc.service.review;

import java.util.Map;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Review;

public interface ReviewService {

	public void addReview(Review review) throws Exception;
	
	public Map<String, Object> getReviewList(Search search, int prodNo) throws Exception;
	
}
