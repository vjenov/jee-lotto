package com.lotto.web.serviceImpls;

 

import java.util.Random;

import java.util.Arrays;

import com.lotto.web.daoImpls.LottoDAOImpl;

import com.lotto.web.daos.LottoDAO;

import com.lotto.web.domains.LottoBean;

import com.lotto.web.services.LottoService;

 

public class LottoServiceImpl implements LottoService{

	private LottoBean lotto;
	private LottoDAO dao;
	
	public LottoServiceImpl() {
		// TODO Auto-generated constructor stub
		 dao = new LottoDAOImpl();
	}

	@Override

	public void createLotto(LottoBean param) {
		lotto = new LottoBean();
		param.setLottoSeq(createLottoSeq());
		param.setBall(createBall());
		param.setLotteryNum(createLotteryNum());
		dao.insertLotto(param);
		}

	public String createLottoSeq() {
		String lottoSeq = "No.";
		Random ran = new Random();
		for(int i = 0; i < 4; i++) {
			lottoSeq += ran.nextInt(10);
		}
		lotto.setLottoSeq(lottoSeq);
		return lottoSeq;
	}

	public String createBall() {
		return new Random().nextInt(45)+1+"";
	}

	public String createLotteryNum() {
		int[] arr = new int[6];
		String lotteryNum = "";
		for(int i = 0; i < 6; i++) {
			int t = Integer.parseInt(createBall());
			if(!duplicatePrevention(arr, t)) {
				arr[i] = t;
			}
		}

		Arrays.sort(arr);

		for(int i=0; i<6; i++) {
			lotteryNum += i==5? arr[i] : arr[i] + ",";			
		}
		return lotteryNum;
	}

	

	public boolean duplicatePrevention(int[] arr, int t) {
		boolean flag = false;
		for(int i = 0; i < 6; i++) {
			if(arr[i] == t) {
				flag = true;
				}
			}
		return flag;
	}
	
	public String ascendingSort(int[] arr) {
		return createLotteryNum();
	}

}