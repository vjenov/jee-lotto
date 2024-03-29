package com.lotto.web.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.web.pool.Constants;
import com.lotto.web.domains.LottoBean;
import com.lotto.web.serviceImpls.LottoServiceImpl;
import com.lotto.web.services.LottoService;

@WebServlet("/lotto.do")
public class LottoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		switch(request.getParameter("action")) { //dest : login, join
		case "move" :
			request.getRequestDispatcher(String.format(Constants.VIEW_PATH,"consumer",request.getParameter("dest"))).forward(request, response);
			break;
		case "register" :
		String money = request.getParameter("money");
		LottoBean param = new LottoBean();
		LottoService service = new LottoServiceImpl();
		service.createLotto(param);
		request.getRequestDispatcher(String.format(Constants.VIEW_PATH,"consumer","login")).forward(request, response);
		case "login" :
			
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
