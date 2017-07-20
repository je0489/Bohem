package kdb.bohem.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kdb.bohem.model.dto.UserDto;
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
				 throw new Exception("정보가 정확하지 않습니다.");			
			}
			
			boolean loginCheck = LoginCheckService.checkIdPwd(userid, userpwd);
			String username = LoginCheckService.whoami(userid);
			String userindex = String.valueOf(LoginCheckService.myindex(userid));
			
			//System.out.println(username);
			
			if (loginCheck==true){
				session.setAttribute("userid",userid);
				session.setAttribute("username", username);
				session.setAttribute("userindex", userindex);
			}
			url="view/loginView.jsp";
		
		}catch (Exception e){
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
