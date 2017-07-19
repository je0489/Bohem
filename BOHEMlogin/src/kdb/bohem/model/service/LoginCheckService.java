package kdb.bohem.model.service;


import java.sql.SQLException;

import kdb.bohem.model.dao.UserDaoImpl;
import kdb.bohem.model.dto.UserDto;

public class LoginCheckService {
	private static UserDaoImpl userDao = new UserDaoImpl();

	public boolean checkIdPwd(String userid, String userpwd) throws SQLException {

		return userDao.checkIdPwd(userid, userpwd);
	}
	
	public boolean logout() throws SQLException{
		return userDao.logout();
	}
	
	public String whoami(String userid) throws SQLException{
		return userDao.whoami(userid);
	}
	
}
