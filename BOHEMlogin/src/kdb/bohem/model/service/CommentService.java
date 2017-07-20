package kdb.bohem.model.service;

import java.sql.SQLException;
import java.util.List;

import kdb.bohem.model.dao.CommentDAOImpl;
import kdb.bohem.model.dto.Comment;
import kdb.bohem.model.dto.NewComment;

public class CommentService {

	private static CommentDAOImpl comDao = new CommentDAOImpl();
	
	/**
	 * 모든 코멘트 검색하는 메소드 호출
	 * */
	public static List<Comment> selectAll() throws SQLException{
		return comDao.selectAll();
	}
	
	public static List<NewComment> selectIndexAll(String recipeindex) throws SQLException {
		return comDao.selectIndexAll(recipeindex);
	}
	/**
	 * 코멘트 삽입하는 메소드 호출
	 * */
	public static int insert(NewComment newcomment) throws SQLException{
		return comDao.insert(newcomment);
	}
	/**
	 *CommentDAOImpl의 코멘트 번호에 해당하는 코멘트 검색하는 메소드 호출
	 *boolean fla = ????
	 * */
	
	public static Comment selectByComentIndex(int comentIndex) throws SQLException{
		return comDao.selectByComentIndex(comentIndex);
	}
	
	/**
	 * 코멘트 삭제하는 메소드 호출
	 * */
	public static int delete(int comentIndex) throws SQLException{
		return comDao.delete(comentIndex);
	}
	

}
