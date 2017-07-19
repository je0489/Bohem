package kdb.bohem.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kdb.bohem.model.dao.UserDao;
import kdb.bohem.model.dao.UserDaoImpl;
import kdb.bohem.model.dto.UserDto;

/**
 * Servlet implementation class Apply
 */
@WebServlet("/apply")
public class ApplyServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		int userindex = 0; 
		String userid = request.getParameter("ID");
		String userpwd =  request.getParameter("PW");
		String username =  request.getParameter("NAME");
		String usernum =  request.getParameter("TEL1")+request.getParameter("TEL2")+request.getParameter("TEL3");
		String useremail =  request.getParameter("EMAIL_ID")+"@"+request.getParameter("EMAIL_ADDRESS");
		UserDto UserDto =  new UserDto(userindex, userid, userpwd, username, usernum, useremail);
		
		//저장된 dto 정보를 dao전달해서 등록을 완료
		UserDao UserDao = new UserDaoImpl();
		String urlPath = "applyView.jsp";
		try{	
		int result = UserDao.insert(UserDto);
		if(result>0){
			urlPath = "index.html";
		}else{
			request.setAttribute("errorMsg","등록안됨");
			request.setAttribute("redirectPath","index.html");
		}
		}catch(Exception e){
			request.setAttribute("errorMsg","검색도중 오류");
			request.setAttribute("redirectPath","index.html");
			
		}
		request.getRequestDispatcher(urlPath).forward(request, response);
		/**
		 * response.sendRedirect("index.html");
		 */
	}
}
