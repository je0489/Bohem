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
		int userIndex = 0;
		//System.out.println(comentIndex);
		//System.out.println("�Դ�");
		String url ="errorView/error.jsp";
		Comment comm=null;
		//PrintWriter out = response.getWriter();
		
		try {
			//System.out.println("�Դ�?"+comentIndex);
			userIndex=Integer.parseInt(request.getParameter("userIndex"));
			comm = CommentService.selectByComentIndex(comentIndex);
			
			System.out.println(comm);
		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch(NumberFormatException e){
			String errormsg= "�α����� �ʿ��մϴ�";
			e.printStackTrace();
			request.setAttribute("errorMsg",errormsg);
			request.setAttribute("redirectPath","index.html");
		}
		
		
		try{
			if(comm.getUserIndex()==userIndex) {
				if(CommentService.delete(comentIndex) > 0){//��������
					List<Comment> comlist = CommentService.selectAll();
					request.setAttribute("comlist", comlist);
					url="comm?command=recipeindexselect&index="+recipeIndex;
					
					//response.sendRedirect("view/list.jsp");
					// return;//�޼ҵ� ����������.
				 }else{//��������
					 throw new Exception("�������� �ʾҽ��ϴ�.");
				 }
			} else {
					throw new Exception("�����Ͻ� �� ���� ȸ���� ����Դϴ�.");
					
			}
		}catch(NullPointerException e){
			String errormsg= "�α����� �ʿ��մϴ�";
			e.printStackTrace();
			request.setAttribute("errorMsg",errormsg);
			request.setAttribute("redirectPath","index.html");
		}
		catch(Exception e){
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
			request.setAttribute("redirectPath","index.html");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
