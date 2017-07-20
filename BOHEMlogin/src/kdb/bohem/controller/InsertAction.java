package kdb.bohem.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import kdb.bohem.model.dto.Comment;
import kdb.bohem.model.dto.NewComment;
import kdb.bohem.model.service.CommentService;

public class InsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ª¿‘«‘ºˆ?");
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
			request.setAttribute("errorMsg", e.getMessage());//∫‰∆‰¿Ã¡ˆ ${errorMsg}
		}
		
		 request.getRequestDispatcher("errorView/error.jsp").forward(request, response);
		
		System.out.println(request.getParameter("comment"));
	}

}
