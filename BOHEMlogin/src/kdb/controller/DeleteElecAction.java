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
			   throw new Exception("������ ��Ȯ���� �ʽ��ϴ�.");	
			}
			
			//passwordȮ��
			Electronics dbElec=ElecService.selectByModelNum(modelNum, false);//��ȸ����������
			if(dbElec.getPassword().equals(password)){//��ġ
				 if(ElecService.delete(modelNum, password) > 0){//��������
					 response.sendRedirect("elec?command=list");
					 return;//�޼ҵ� ����������.
				 }else{//��������
					 throw new Exception("�������� �ʾҽ��ϴ�.");
				 }
				
			}else{//�������
				throw new Exception("��й�ȣ Ȯ�����ּ���.");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
		}
		
		request.getRequestDispatcher("errorView/error.jsp").forward(request, response);
	
	}

}
