package kdb.bohem.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Apply
 */
@WebServlet("/apply")
public class ApplyServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		 
		String id = request.getParameter("ID");
		String pw =  request.getParameter("PW");
		String name =  request.getParameter("NAME");
		String tel =  request.getParameter("TEL1")+request.getParameter("TEL2")+request.getParameter("TEL3");
		String email =  request.getParameter("EMAIL_ID")+"@"+request.getParameter("EMAIL_ADDRESS");
		
		/**
		 * response.sendRedirect("index.html");
		 */
	}
}
