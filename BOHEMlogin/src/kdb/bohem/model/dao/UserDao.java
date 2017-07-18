package kdb.bohem.model.dao;


import java.sql.SQLException;
import java.util.List;

import kdb.bohem.model.dto.UserDto;

public interface UserDao {
	 /**
	  * ���ڵ� ��ü �˻�
	  * */
	  List<UserDto> selectAll() throws SQLException;
	  
	  /**
		  * �𵨹�ȣ�� �ش��ϴ� ���ڵ� �˻�
		  * @param : boolean flag - true�̸� ��ȸ�� ����,  false�̸� ��ȸ���� ����.
		  * */
	  UserDto selectByModelNum(int userindex, boolean flag) throws SQLException;
	  
	/**
	 * ���ڵ� ����
	 * @return : 1�̻� -���Լ��� , 0 - ���Խ���
	 * */
	  int insert(UserDto userdto) throws SQLException;
	  
	  /**
	   * �𵨹�ȣ�� �ش��ϴ� ���ڵ� ����
	   * @return : 1�̻� -�������� , 0 - ��������
	   * */
	  
	  
	   /**
	    * �𵨹�ȣ�� �ش��ϴ� ���ڵ� ����
	    * @return : 1�̻� -�������� , 0 - ��������
	    * */
	 
}





