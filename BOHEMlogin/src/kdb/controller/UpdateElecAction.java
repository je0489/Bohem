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
		
		//넘어오는 값들 받기
		String modelNum = request.getParameter("modelNum");
		String modelName = request.getParameter("model_name");
		String price =  request.getParameter("price");
		String description = request.getParameter("description");
		String password = request.getParameter("password");
		
		
		//유효성 검사
		try{
		  if(modelNum==null || modelName==null || price==null
				  || description==null ||password==null ){
			
			  throw new Exception("입력값이 충분하지 않습니다.");
		  }
		  
		  //비밀번호 체크
		 Electronics dbElec = ElecService.selectByModelNum(modelNum, false);
		 if(dbElec.getPassword().equals(password)){//일치
			Electronics elec = new Electronics(modelNum, modelName, 
					    Integer.parseInt(price), description, password);
			 
			 if( ElecService.update(elec) > 0){//수정완료
				 // commmand=detailView , modelNum=? , flag=?
				 url="elec?command=detailView&flag=1";
				 
			 }else{
				 throw new Exception("수정되지 않았습니다...");
			 }
			 
		 }else{//비번오류
			 throw new Exception("비밀번호 다시 확인해주세요.");
		 }
		
		
		}catch(Exception e){
			request.setAttribute("errorMsg", e.getMessage());
		}
		
		request.getRequestDispatcher(url).forward(request, response);

	}

}
