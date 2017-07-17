package kdb.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kdb.model.dto.Electronics;
import kdb.model.service.ElecService;

public class UpdateElecAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="errorView/error.jsp";
		
		//�Ѿ���� ���� �ޱ�
		String modelNum = request.getParameter("modelNum");
		String modelName = request.getParameter("model_name");
		String price =  request.getParameter("price");
		String description = request.getParameter("description");
		String password = request.getParameter("password");
		
		
		//��ȿ�� �˻�
		try{
		  if(modelNum==null || modelName==null || price==null
				  || description==null ||password==null ){
			
			  throw new Exception("�Է°��� ������� �ʽ��ϴ�.");
		  }
		  
		  //��й�ȣ üũ
		 Electronics dbElec = ElecService.selectByModelNum(modelNum, false);
		 if(dbElec.getPassword().equals(password)){//��ġ
			Electronics elec = new Electronics(modelNum, modelName, 
					    Integer.parseInt(price), description, password);
			 
			 if( ElecService.update(elec) > 0){//�����Ϸ�
				 // commmand=detailView , modelNum=? , flag=?
				 url="elec?command=detailView&flag=1";
				 
			 }else{
				 throw new Exception("�������� �ʾҽ��ϴ�...");
			 }
			 
		 }else{//�������
			 throw new Exception("��й�ȣ �ٽ� Ȯ�����ּ���.");
		 }
		
		
		}catch(Exception e){
			request.setAttribute("errorMsg", e.getMessage());
		}
		
		request.getRequestDispatcher(url).forward(request, response);

	}

}
