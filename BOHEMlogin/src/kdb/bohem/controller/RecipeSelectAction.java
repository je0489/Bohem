package kdb.bohem.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kdb.bohem.model.dto.Recipe;
import kdb.bohem.model.service.RecipeService;

public class RecipeSelectAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글 인코딩
		//
		System.out.println("여기 들어왔냐");
		String url = "errorView/error.jsp";
		String keyword = request.getParameter("keyword");
		try{
			
			List<Recipe> recipelist = RecipeService.select(keyword);
			request.setAttribute("recipelist", recipelist);
			url = "view/test.jsp";
		}catch(SQLException e){
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);	}

}
