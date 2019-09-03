package com.lotto.web.services;

import com.lotto.web.domains.LottoBean;

public interface LottoService {
	public void createLotto(LottoBean param);
	public String createLottoSeq();
	public int createBall();
	public String createLotteryNum();
	public boolean exist(int[] arr, int t);
	public int[] bubbleSort(int[] arr, boolean flag);
}
