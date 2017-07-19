package kdb.bohem.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import kdb.bohem.model.dto.Comment;
import kdb.bohem.model.service.CommentService;

public class InsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ª¿‘«‘ºˆ?");
		try{
			
			int comentIndex = 1;
			String comentComent = request.getParameter("comment");
			int userIndex = 1;
			int recipeIndex=1;
			String comentDate = "2017.07.18";
			
			Comment coment= new Comment(comentIndex, comentComent, userIndex, recipeIndex, comentDate);
			System.out.println(coment);
			if(CommentService.insert(coment)>0){
				response.sendRedirect("contentsView.html");
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
