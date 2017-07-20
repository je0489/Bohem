package kdb.bohem.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kdb.bohem.model.dto.Recipe;
import kdb.bohem.model.service.RecipeService;

public class RecipeAllAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "errorView/error.jsp";
		try{
			List<Recipe> recipelist = RecipeService.selectAll();
			request.setAttribute("recipelist", recipelist);
			url = "view/test.jsp";
		}catch(SQLException e){
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
			request.setAttribute("redirectPath","index.html");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
