package com.model2.mvc.service.purchase.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.purchase.PurchaseDao;
import com.model2.mvc.service.user.UserService;
import com.model2.mvc.service.user.impl.UserServiceImpl;

@Repository("purchaseDaoImpl")
public class PurchaseDaoImpl implements PurchaseDao {

	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public PurchaseDaoImpl() {
		System.out.println(this.getClass());
	}

	@Override
	public void addPurchase(Purchase purchase) throws Exception {
		sqlSession.insert("PurchaseMapper.addPurchase", purchase);
		
	}

	@Override
	public Purchase getPurchase(int tranNo) throws Exception {
		
		return sqlSession.selectOne("PurchaseMapper.getPurchase", tranNo);
	}

	

	@Override
	public List<Purchase> getPurchaseList(Search search, String buyerId) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("search", search);
		map.put("buyerId", buyerId);
		
		return sqlSession.selectList("PurchaseMapper.getPurchaseList", map);
		
	}

	@Override
	public List<Purchase> getSaleList(Search search) throws Exception {
		
		return sqlSession.selectList("PurchaseMapper.getSaleList", search);
	}

	@Override
	public void updatePurchase(Purchase purchase) throws Exception {
		sqlSession.update("PurchaseMapper.updatePurchase", purchase);
		
	}

	@Override
	public void updateTranCode(Purchase purchase) throws Exception {
		sqlSession.update("PurchaseMapper.updateTranCode", purchase);
		
	}

	@Override
	public int getTotalCount(Search search) throws Exception {
		
		return sqlSession.selectOne("PurchaseMapper.getTotalCount", search);
	}
	
	@Override
	public int getTotalPurchase(Search search, String buyerId) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("search", search);
		map.put("buyerId", buyerId);
		
		
		return sqlSession.selectOne("PurchaseMapper.getTotalPurchase", map);
	}
}
