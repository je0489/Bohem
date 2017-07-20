package kdb.bohem.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kdb.bohem.model.service.LoginCheckService;

public class LogoutAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("로그아웃 실행");
		String url="errorView/error.jsp";
		HttpSession session = request.getSession(false);
		LoginCheckService LoginCheckService = new LoginCheckService();
		try{
			session.invalidate();
			url = "view/loginView.jsp";
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
