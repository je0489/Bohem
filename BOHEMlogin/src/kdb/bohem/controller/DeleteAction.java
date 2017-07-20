package kdb.bohem.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kdb.bohem.model.dto.Comment;
import kdb.bohem.model.service.CommentService;


public class DeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int comentIndex = Integer.parseInt(request.getParameter("comentIndex"));
		String recipeIndex = request.getParameter("recipeIndex");
		//System.out.println(comentIndex);
		//System.out.println("왔다");
		String url ="errorView/error.jsp";
		
		try {
			//System.out.println("왔니?"+comentIndex);
			
			Comment comm = CommentService.selectByComentIndex(comentIndex);
			System.out.println(comm);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		try{
			if(CommentService.delete(comentIndex) > 0){//삭제성공
				List<Comment> comlist = CommentService.selectAll();
				request.setAttribute("comlist", comlist);
				url="comm?command=recipeindexselect&index="+recipeIndex;
				
				//response.sendRedirect("view/list.jsp");
				// return;//메소드 빠져나가라.
			 }else{//삭제실패
				 throw new Exception("삭제되지 않았습니다.");
			 }
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
