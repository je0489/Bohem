package kdb.bohem.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kdb.bohem.model.dto.Comment;
import kdb.bohem.model.dto.NewComment;
import kdb.bohem.model.util.DBUtil;

public class CommentDAOImpl implements CommentDAO {

	@Override
	public List<Comment> selectAll() throws SQLException {
		//System.out.println("실행되냐교ㅗ요");
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Comment> comList = new ArrayList<>();
		//List<NewComment> newComList = new ArrayList<>;
		try{
			con = DBUtil.getConnection();
			ps = con.prepareStatement("select * from coment ORDER BY COMENTiNDEX ASC");
			rs = ps.executeQuery();//
			//System.out.println("2실행되냐교ㅗ요");
			while(rs.next()){
				//System.out.println("3실행되냐교ㅗ요");
				//(int comentIndex, String comentComent, int userIndex, int recipeIndex, String comentDate)
				Comment com = new Comment(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5));
				comList.add(com);
				//System.out.println(com);
			}
		}finally{
			DBUtil.dbClose(con, ps, rs);
		}
		return comList;
	}

	
	
	@Override
	public List<NewComment> selectIndexAll(String recipeindex) throws SQLException {
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs= null;
		List<NewComment> newComList = new ArrayList<>();
		try{
			con= DBUtil.getConnection();
			ps= con.prepareStatement("select c.comentindex, c.comentcoment, u.username, c.comentdate, u.USERINDEX, r.RECIPEINDEX "
									+"from coment c, userinfo u, recipe r "
									+"where c.userindex=u.userindex "
									+"and c.recipeindex=r.recipeindex "
									+"and c.recipeindex="+recipeindex+" ORDER BY COMENTiNDEX ASC");
			rs = ps.executeQuery();
			while(rs.next()){
				NewComment newcom= new NewComment(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getInt(5),rs.getInt(6));
				newComList.add(newcom);
			}
		}finally{
			DBUtil.dbClose(con, ps, rs);
		}
		return newComList;
	}



	@Override
	public Comment selectByComentIndex(int comentIndex) throws SQLException {
		//System.out.println("여기는 selectbycomentIndex = "+comentIndex);
		Connection con = DBUtil.getConnection();
		PreparedStatement ps= null;
		ResultSet rs = null;
		Comment comm = null;
		
		try{		
			//System.out.println("selectbycomentIndex try ="+comentIndex);
			ps=con.prepareStatement("select * from Coment where comentIndex =?");
			ps.setInt(1, comentIndex);
			rs = ps.executeQuery();
			if(rs.next()){
				comm = new Comment(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5));		
			}
		}finally{
			DBUtil.dbClose(con, ps, rs);			
		}
		return comm;
		
	}

	@Override
	public int insert(NewComment Newcomment) throws SQLException {
		Connection con = DBUtil.getConnection();
		PreparedStatement ps = null;
		int result = 0;
		try{
			ps = con.prepareStatement("insert into Coment values(coment_seq.nextval ,?,?,?,sysdate)");
			ps.setString(1,Newcomment.getComentComent());
			ps.setInt(2, Newcomment.getUserIndex());
			ps.setInt(3, Newcomment.getRecipeIndex());
			//System.out.println(comment.getComentIndex());
			//System.out.println(comment.getRecipeIndex());
			result = ps.executeUpdate();
		}finally{
			DBUtil.dbClose(con, ps, null);
		} 
		return result;
	}

	@Override
	public int delete(int comentIndex) throws SQLException {
		Connection con = DBUtil.getConnection();
		PreparedStatement ps = null;
		int result=0;
		try{
			System.out.println("comentDao comentIndex="+comentIndex);
			ps = con.prepareStatement("delete Coment where comentIndex=?");
			ps.setInt(1, comentIndex);
			result = ps.executeUpdate();
					
		}finally{
			DBUtil.dbClose(con, ps, null);
			
		}
		return result;
	}




	

}
