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
				throw new Exception("modelNum�� �ݵ�� �Է��ؾ��մϴ�.");
			}
			
			Electronics elec = 
					ElecService.selectByModelNum(modelNum, state);//��ȸ������
		    if(elec==null){
		    	throw new Exception(modelNum +"������ �����ϴ�.");
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
