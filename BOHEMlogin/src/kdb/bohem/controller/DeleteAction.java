package kdb.bohem.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
		request.setCharacterEncoding("UTF-8");
		
		int comentIndex = Integer.parseInt(request.getParameter("comentIndex"));
		String recipeIndex = request.getParameter("recipeIndex");
		int userIndex = Integer.parseInt(request.getParameter("userIndex"));
		//System.out.println(comentIndex);
		//System.out.println("왔다");
		String url ="errorView/error.jsp";
		Comment comm=null;
		//PrintWriter out = response.getWriter();
		
		try {
			//System.out.println("왔니?"+comentIndex);
			
			comm = CommentService.selectByComentIndex(comentIndex);
			
			System.out.println(comm);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		
		try{
			if(comm.getUserIndex()==userIndex) {
				if(CommentService.delete(comentIndex) > 0){//삭제성공
					List<Comment> comlist = CommentService.selectAll();
					request.setAttribute("comlist", comlist);
					url="comm?command=recipeindexselect&index="+recipeIndex;
					
					//response.sendRedirect("view/list.jsp");
					// return;//메소드 빠져나가라.
				 }else{//삭제실패
					 throw new Exception("삭제되지 않았습니다.");
				 }
			} else {
					throw new Exception("삭제하실 수 없는 회원의 댓글입니다.");
					
			}
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
			request.setAttribute("redirectPath","index.html");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
