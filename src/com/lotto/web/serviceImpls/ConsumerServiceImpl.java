package com.lotto.web.serviceImpls;

import com.lotto.web.daoImpls.ConsumerDAOImpl;
import com.lotto.web.daos.ConsumerDAO;
import com.lotto.web.domains.ConsumerBean;
import com.lotto.web.services.ConsumerService;

public class ConsumerServiceImpl implements ConsumerService{
	private	ConsumerDAO dao;
	
	public ConsumerServiceImpl() {
		// TODO Auto-generated constructor stub
		 dao = new ConsumerDAOImpl();
	}
	@Override
	public void registerConsumer(ConsumerBean param) {
		System.out.println("test");
		System.out.println(param.toString());
		dao.insertConsumer(param);
	}

}
