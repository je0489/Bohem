package kdb.bohem.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConfirmIDCheckServlet
 */
@WebServlet("/confrimIDCheck")
public class ConfirmIDCheckServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		
		/**
		 * 아이디 중복 체크	/	true 아이디 중복 X 가입 가능
		 * 						/	false 중복
		 * @ request.setAttribute ("result",boolean 타입);
		 * @ request.setAttributer("id",id);
		 * @ forward confirmIDView.jsp
		 */
	}
}
