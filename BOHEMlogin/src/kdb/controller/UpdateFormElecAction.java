package kdb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kdb.model.dto.Electronics;
import kdb.model.service.ElecService;

public class UpdateFormElecAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String modelNum = request.getParameter("modelNum");
		String url="errorView/error.jsp";
		try{
			if(modelNum==null){
				throw new Exception("modelNum�� �����ϴ�.");
			}
			Electronics elec=ElecService.selectByModelNum(modelNum, false);//��ȸ����������.
			if(elec==null){
				throw new Exception("�ش��ϴ� ��ǰ�� �����ϴ�.");
			}else{
				request.setAttribute("elec", elec);
				url="elecView/update.jsp";
			}
			
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
		}
		
		request.getRequestDispatcher(url).forward(request, response);

	}

}
