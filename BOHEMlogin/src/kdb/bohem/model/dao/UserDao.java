package kdb.bohem.model.dao;


import java.sql.SQLException;
import java.util.List;

import kdb.bohem.model.dto.UserDto;

public interface UserDao {
	 /**
	  * 레코드 전체 검색
	  * */
	  List<UserDto> selectAll() throws SQLException;
	  
	  /**
		  * 모델번호에 해당하는 레코드 검색
		  * @param : boolean flag - true이면 조회수 증가,  false이면 조회증가 안함.
		  * */
	 
	  
	/**
	 * 레코드 삽입
	 * @return : 1이상 -삽입성공 , 0 - 삽입실패
	 * */
	  int insert(UserDto userdto) throws SQLException;

	

	boolean checkId(String  userid) throws SQLException;
	  
	  /**
	   * 모델번호에 해당하는 레코드 삭제
	   * @return : 1이상 -삭제성공 , 0 - 삭제실패
	   * */
	  
	boolean checkIdPwd(String userid, String userpwd) throws SQLException ;
	
	boolean logout()throws SQLException;
	 
}





