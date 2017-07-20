package kdb.bohem.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kdb.bohem.model.dto.NewComment;
import kdb.bohem.model.dto.Recipe;
import kdb.bohem.model.service.CommentService;
import kdb.bohem.model.service.RecipeService;

public class RecipeIndexSelectAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글 인코딩
				request.setCharacterEncoding("UTF-8");
			
				String url = "errorView/error.jsp";
				String index = request.getParameter("index");
				try{
					List<NewComment> newComList = CommentService.selectIndexAll(index);
					Recipe recipeinfo = RecipeService.selectIndex(index);
					request.setAttribute("newComList", newComList);
					request.setAttribute("recipeinfo", recipeinfo);
					url = "view/testView.jsp";
				}catch(SQLException e){
					
					e.printStackTrace();
					request.setAttribute("errorMsg", e.getMessage());
					request.setAttribute("redirectPath","index.html");
				}
				request.getRequestDispatcher(url).forward(request, response);	
				}

}
