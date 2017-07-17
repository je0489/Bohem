package kdb.model.service;


import java.sql.SQLException;
import java.util.List;

import kdb.model.dao.ElecDaoImpl;
import kdb.model.dto.Electronics;

public class ElecService {
	private static ElecDaoImpl  electronicsDao = new ElecDaoImpl();
	
	/**
	 * ElectronicsDAOImpl�� ��緹�ڵ� �˻��ϴ� �޼ҵ� ȣ��
	 * */
	public static List<Electronics> selectAll() throws SQLException{
		  return electronicsDao.selectAll();
	  }
	  
	  /**
	   * ElectronicsDAOImpl�� ���ڵ� �����ϴ� �޼ҵ� ȣ��
	   * */
	  public static int insert(Electronics electronics) throws SQLException{
		  return electronicsDao.insert(electronics);
	  }
	  
	  /**
	   * ElectronicsDAOImpl�� �𵨹�ȣ�� �ش��ϴ� ���ڵ� �˻��ϴ� �޼ҵ� ȣ��
	   * @param : boolean flag - ��ȸ�� ���� ���θ� �Ǻ��ϴ� �Ű�������(true�̸� ��ȸ������ / false�̸� ��ȸ�� ���� ����)
	   * */
	  public static Electronics selectByModelNum(String model_num, boolean flag) throws SQLException{
		  return electronicsDao.selectByModelNum(model_num , flag);
	  }
	  
	  /**
	   * ElectronicsDAOImpl�� �𵨹�ȣ�� �ش��ϴ� ���ڵ� ���� �޼ҵ� ȣ��
	   * */
	  public static int delete(String model_num, String password) throws SQLException{
		  return electronicsDao.delete(model_num,password);
	  }
	  
	  
	  /**
	   * ElectronicsDAOImpl�� �𵨹�ȣ�� �ش��ϴ� ���ڵ� ����  �޼ҵ� ȣ��
	   * */
	  public static int update(Electronics electronics) throws SQLException{
		  return electronicsDao.update(electronics);
	  }
	  
	  
}



