package kdb.bohem.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kdb.bohem.model.dto.UserDto;
import kdb.bohem.model.util.DBUtil;

public class UserDaoImpl implements UserDao {

	
	public List<UserDto> selectAll() throws SQLException {
		Connection con = DBUtil.getConnection();
		PreparedStatement ps =null;
		ResultSet rs =null;
		List<UserDto> list = new ArrayList<UserDto>();
		try{
			 ps = con.prepareStatement( "select * from userinfo");
			 rs = ps.executeQuery();
			 while(rs.next()){
				 UserDto elec = new UserDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
			    list.add(elec);
			 }
		}finally{
			DBUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	/*@Override
	public UserDto selectByModelNum(int userindex, boolean flag) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}*/

	
	public int insert(UserDto userdto) throws SQLException {
		Connection con =DBUtil.getConnection();
		PreparedStatement ps =null;
		int result =0;
		try{
			ps = con.prepareStatement("insert into userinfo values(sequser.nextval,?,?,?,?,?)");
			ps.setString(1, userdto.getUserid());
			ps.setString(2, userdto.getUserpwd());
			ps.setString(3, userdto.getUsername());
			ps.setString(4, userdto.getUsernum());
			ps.setString(5, userdto.getUseremail());
			
			
			result = ps.executeUpdate();
		}finally{
			DBUtil.dbClose(con, ps, null);
		}
		return result;
	}

	@Override
	//중복체크
	public boolean checkId(String userid) throws SQLException {
		Connection con =DBUtil.getConnection();
		PreparedStatement ps =null;
		ResultSet rs = null;
		
		try{
			ps=con.prepareStatement("select userid  from userinfo where userid=?");
			ps.setString(1, userid.trim());
			rs=ps.executeQuery();
			if(rs.next()){
				return true;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.dbClose(con, ps, rs);
		}
		return false;
	}
	
	public boolean checkIdPwd(String userid, String userpwd) throws SQLException {
		Connection con =DBUtil.getConnection();
		PreparedStatement ps =null;
		ResultSet rs = null;
		
		try{
			ps=con.prepareStatement("select userid  from userinfo where userid=? and userpwd=? ");
			ps.setString(1, userid.trim());
			ps.setString(2, userpwd.trim());
			rs=ps.executeQuery();
			if(rs.next()){
				return true;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.dbClose(con, ps, rs);
		}
		return false;
	}
	public boolean logout() throws SQLException{
		return false;
	}
	
	public String whoami(String userid) throws SQLException{
		Connection con = DBUtil.getConnection();
		PreparedStatement ps= null;
		ResultSet rs= null;
		UserDto user = null;
		try{
			ps=con.prepareStatement("select * from userinfo where userid=?");
			ps.setString(1, userid.trim());
			rs=ps.executeQuery();
			while(rs.next()){
				user =  new UserDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
			}
			return user.getUsername();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.dbClose(con, ps, rs);
		}
		return user.getUsername();
	}

}
