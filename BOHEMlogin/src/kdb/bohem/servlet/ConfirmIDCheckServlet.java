package kdb.bohem.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kdb.bohem.model.dao.UserDao;
import kdb.bohem.model.dao.UserDaoImpl;
import kdb.bohem.model.dto.UserDto;
import kdb.bohem.model.util.DBUtil;

/**
 * Servlet implementation class ConfirmIDCheckServlet
 */
@WebServlet("/confrimIDCheck")
public class ConfirmIDCheckServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userid = request.getParameter("id");
		
		UserDao UserDao = new UserDaoImpl();
		String urlPath = "view/confirmIDView.jsp";
		try{	
		
		
		if( UserDao.checkId(userid)){
			request.setAttribute("result", userid+"�� �ߺ��Դϴ�.");
		}else{
			request.setAttribute("result", userid+"�� ��밡���մϴ�..");
		}
		}catch(Exception e){
			request.setAttribute("errorMsg","�˻����� ����");
			request.setAttribute("redirectPath","index.html");
		} finally {
			request.setAttribute("id", userid);
			request.getRequestDispatcher(urlPath).forward(request, response);
		}
	
		/**
		 * ���̵� �ߺ� üũ	/	true ���̵� �ߺ� X ���� ����
		 * 						/	false �ߺ�
		 * @ request.setAttribute ("result",boolean Ÿ��);
		 * @ request.setAttributer("id",id);
		 * @ forward confirmIDView.jsp
		 */
	}
}
