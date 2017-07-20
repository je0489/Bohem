package kdb.bohem.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import kdb.bohem.model.dto.Comment;
import kdb.bohem.model.dto.NewComment;
import kdb.bohem.model.service.CommentService;

public class InsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("삽입함수?");
		try{

			int comentIndex = 0;
			String comentComent = request.getParameter("comment");
			int userIndex = Integer.parseInt(request.getParameter("userIndex"));
			String username = request.getParameter("username");
			int recipeIndex=Integer.parseInt(request.getParameter("recipeIndex"));
			String comentDate = null;
			
			NewComment newcoment= new NewComment(comentIndex, comentComent, username, comentDate, userIndex, recipeIndex);
			System.out.println(newcoment);
			if(CommentService.insert(newcoment)>0){
				response.sendRedirect("comm?command=recipeindexselect&index="+recipeIndex);
				return;
			}
			
		}catch(SQLException e){
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());//뷰페이지 ${errorMsg}
			request.setAttribute("redirectPath","index.html");
		}catch(NumberFormatException e){
			String errormsg= "로그인이 필요합니다";
			e.printStackTrace();
			request.setAttribute("errorMsg",errormsg);
			request.setAttribute("redirectPath","index.html");
		}
		
		 request.getRequestDispatcher("errorView/error.jsp").forward(request, response);
		
		System.out.println(request.getParameter("comment"));
	}

}
