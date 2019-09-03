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
		param.setBall(String.valueOf(createBall()));
		param.setLotteryNum(createLotteryNum());
		dao.insertLotto(param);
		}

	public String createLottoSeq() {
		String lottoSeq = "No.";
		for(int i = 0; i < 4; i++) {
			lottoSeq += (int) (Math.random() * 10);
		}
		lotto.setLottoSeq(lottoSeq);
		return lottoSeq;
	}

	public int createBall() {
		return (int) (Math.random() * 45)+1;
	}

	public String createLotteryNum() {
		int[] arr = new int[6];
		String result = "";
		for(int i = 0; i < arr.length; i++) {
			int t = createBall();
			if(!exist(arr, t)) {
				arr[i] = t;
			}else {
				i--;
			}
		}
		arr = bubbleSort(arr,true);
		for(int i = 0; i <arr.length; i++) {
			result += i==arr.length-1 ? arr[i] : arr[i] + ",";
		}
		return result;
		//return ascendingSort(arr);
	}

	

	public boolean exist(int[] arr, int t) {
		boolean flag = false;
		for(int i = 0; i < arr.length; i++) {
			if(t == arr[i]) {
				flag = true;
				}
			}
		return flag;
	}
	
	 public int[] bubbleSort(int[] arr, boolean flag) {
		 int t = 0;
		 for(int i = 0; i < arr.length; i++) {
			 for(int j = 0; j < arr.length-1; j++) {
				 if(flag) {
					 if(arr[j] > arr[j+1]) {
						 t = arr[j];
						 arr[j] = arr[j+1];
						 arr[j+1] = t;
					 }
				 }else {
					 if(arr[j] < arr[j+1]) {
						 t = arr[j];
						 arr[j] = arr[j+1];
						 arr[j+1] = t;
					 }
				 }
			 }
		 }
		 /*
		 for(int i = 0; i < arr.length; i++) {
		 	for(int j = 1; j < arr.length - i; j++) {
		 		
		 		if(flag) {
		 			if(arr[j] < arr[j-1]) {
		 				t = arr[j-1];
		 				arr[j-1] = arr[j];
		 				arr[j] = t;
		 			}
		 		}else {
		 			if(arr[j] > arr[j-1]) {
		 				t = arr[j-1];
		 				arr[j-1] = arr[j];
		 				arr[j] = t;
		 			}
		 		}
		 	}
		 }
		 */
		return arr;
	 }
}
	/*
	public String ascendingSort(int[] arr) {
		String result = "";
		Arrays.sort(arr);
		for(int i=0; i< arr.length; i++) {
			result += i==5? arr[i] : arr[i] + ",";			
		}
		return result;
	}
	*/
	
	