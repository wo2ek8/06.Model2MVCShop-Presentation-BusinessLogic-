package com.model2.mvc.service.review.impl;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Review;
import com.model2.mvc.service.review.ReviewDao;

@Repository("reviewDaoImpl")
public class ReviewDaoImpl implements ReviewDao {

	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public ReviewDaoImpl() {
		System.out.println(this.getClass());
	}
	
	@Override
	public void addReview(Review review) throws Exception {
		sqlSession.insert("ReviewMapper.addReview", review);
		
	}

	@Override
	public List<Review> getReviewList(Search search, int prodNo) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("search", search);
		map.put("prodNo", prodNo);
		return sqlSession.selectList("ReviewMapper.getReviewList", map);
	}

	@Override
	public int getProdReview(Search search, int prodNo) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("search", search);
		map.put("prodNo", prodNo);
		return sqlSession.selectOne("ReviewMapper.getProdReview", map);
	}

}
