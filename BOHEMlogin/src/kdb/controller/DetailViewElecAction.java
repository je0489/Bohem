package kdb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kdb.model.dto.Electronics;
import kdb.model.service.ElecService;

public class DetailViewElecAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="errorView/error.jsp";
		String modelNum = request.getParameter("modelNum");
		String flag = request.getParameter("flag");
		boolean state=true;
		if(flag!=null)state=false;
		
		//System.out.println("modelNum : " + modelNum);
		//System.out.println("command : " + request.getParameter("command"));
		
		try{
			if(modelNum==null){
				throw new Exception("modelNum은 반드시 입력해야합니다.");
			}
			
			Electronics elec = 
					ElecService.selectByModelNum(modelNum, state);//조회수증가
		    if(elec==null){
		    	throw new Exception(modelNum +"정보가 없습니다.");
		    }else{
		       request.setAttribute("elec", elec); 	
		       url="elecView/read.jsp";
		    }
		   
		}catch (Exception e) {
			request.setAttribute("errorMsg", e.getMessage());
		}
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}	

}
