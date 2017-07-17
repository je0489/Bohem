package kdb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.multipart.ExceededSizeException;

import kdb.model.dto.Electronics;
import kdb.model.service.ElecService;

public class DeleteElecAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String modelNum = request.getParameter("modelNum");
		String password = request.getParameter("password");
		try{
			if(modelNum==null || password == null){
			   throw new Exception("정보가 정확하지 않습니다.");	
			}
			
			//password확인
			Electronics dbElec=ElecService.selectByModelNum(modelNum, false);//조회수증가안함
			if(dbElec.getPassword().equals(password)){//일치
				 if(ElecService.delete(modelNum, password) > 0){//삭제성공
					 response.sendRedirect("elec?command=list");
					 return;//메소드 빠져나가라.
				 }else{//삭제실패
					 throw new Exception("삭제되지 않았습니다.");
				 }
				
			}else{//비번오류
				throw new Exception("비밀번호 확인해주세요.");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
		}
		
		request.getRequestDispatcher("errorView/error.jsp").forward(request, response);
	
	}

}
