package com.lotto.web.services;

import com.lotto.web.domains.LottoBean;

public interface LottoService {
	public void createLotto(LottoBean param);
	public String createLottoSeq();
	public String createBall();
	public String createLotteryNum();
	public boolean duplicatePrevention(int[] arr, int t);
}
