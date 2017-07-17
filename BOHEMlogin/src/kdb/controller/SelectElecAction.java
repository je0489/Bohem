package kdb.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kdb.model.dto.Electronics;
import kdb.model.service.ElecService;

public class SelectElecAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url="errorView/error.jsp";
		try{	
		 List<Electronics> list = ElecService.selectAll();
		 request.setAttribute("list", list);//viewpage���� ${list}
		 url="elecView/list.jsp";
		 
		}catch(SQLException e){
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());//�������� ${errorMsg}
		}
		
		 request.getRequestDispatcher(url).forward(request, response);
		
	}

}







