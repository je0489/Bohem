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
		//System.out.println("�Դ�");
		String url ="errorView/error.jsp";
		
		try {
			//System.out.println("�Դ�?"+comentIndex);
			
			Comment comm = CommentService.selectByComentIndex(comentIndex);
			System.out.println(comm);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		try{
			if(CommentService.delete(comentIndex) > 0){//��������
				List<Comment> comlist = CommentService.selectAll();
				request.setAttribute("comlist", comlist);
				url="comm?command=recipeindexselect&index="+recipeIndex;
				
				//response.sendRedirect("view/list.jsp");
				// return;//�޼ҵ� ����������.
			 }else{//��������
				 throw new Exception("�������� �ʾҽ��ϴ�.");
			 }
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
