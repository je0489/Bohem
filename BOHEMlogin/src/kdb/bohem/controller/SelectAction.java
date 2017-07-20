package kdb.bohem.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kdb.bohem.model.dto.Comment;

import kdb.bohem.model.service.CommentService;


public class SelectAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url ="errorView/error.jsp";
		//String index = request.getParameter("index");
		//System.out.println(index);
		try{

			List<Comment> comlist = CommentService.selectAll();

			request.setAttribute("comlist", comlist); // viewpage 에서 ${list}
			url="view/commentList.jsp";
		}catch(SQLException e){
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());//뷰페이지 ${errorMsg}
		}
		
		 request.getRequestDispatcher(url).forward(request, response);
			
	}

}
