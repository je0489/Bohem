package kdb.bohem.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kdb.bohem.model.service.LoginCheckService;


public class LoginCheckAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "errorView/error.jsp";
		String userid = request.getParameter("ID");
		String userpwd =  request.getParameter("PW");
		HttpSession session = request.getSession(false);
		
		LoginCheckService LoginCheckService = new LoginCheckService();
		try{
			if(userid==null || userpwd == null){
				 throw new Exception("������ ��Ȯ���� �ʽ��ϴ�.");			
			}
			
			boolean loginCheck = LoginCheckService.checkIdPwd(userid, userpwd);
			if (loginCheck==true){
				session.setAttribute("id",userid);
			}
			url="loginView.jsp";
		
		}catch (Exception e){
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}