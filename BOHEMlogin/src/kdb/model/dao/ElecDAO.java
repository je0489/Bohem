package kdb.model.dao;


import java.sql.SQLException;
import java.util.List;

import kdb.model.dto.Electronics;

public interface ElecDAO {
	 /**
	  * ���ڵ� ��ü �˻�
	  * */
	  List<Electronics> selectAll() throws SQLException;
	  
	  /**
		  * �𵨹�ȣ�� �ش��ϴ� ���ڵ� �˻�
		  * @param : boolean flag - true�̸� ��ȸ�� ����,  false�̸� ��ȸ���� ����.
		  * */
	  Electronics selectByModelNum(String modelNum, boolean flag) throws SQLException;
	  
	/**
	 * ���ڵ� ����
	 * @return : 1�̻� -���Լ��� , 0 - ���Խ���
	 * */
	  int insert(Electronics electronics) throws SQLException;
	  
	  /**
	   * �𵨹�ȣ�� �ش��ϴ� ���ڵ� ����
	   * @return : 1�̻� -�������� , 0 - ��������
	   * */
	   int delete(String modelNum, String password) throws SQLException;
	  
	   /**
	    * �𵨹�ȣ�� �ش��ϴ� ���ڵ� ����
	    * @return : 1�̻� -�������� , 0 - ��������
	    * */
	   int update(Electronics electronics) throws SQLException;
}




