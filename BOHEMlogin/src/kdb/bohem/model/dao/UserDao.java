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
	 
	  
	/**
	 * ���ڵ� ����
	 * @return : 1�̻� -���Լ��� , 0 - ���Խ���
	 * */
	  int insert(UserDto userdto) throws SQLException;

	

	boolean checkId(String  userid) throws SQLException;
	  
	  /**
	   * �𵨹�ȣ�� �ش��ϴ� ���ڵ� ����
	   * @return : 1�̻� -�������� , 0 - ��������
	   * */
	  
	boolean checkIdPwd(String userid, String userpwd) throws SQLException ;
	
	boolean logout()throws SQLException;
	 
}





