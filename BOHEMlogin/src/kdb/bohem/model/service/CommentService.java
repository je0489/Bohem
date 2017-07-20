package kdb.bohem.model.service;

import java.sql.SQLException;
import java.util.List;

import kdb.bohem.model.dao.CommentDAOImpl;
import kdb.bohem.model.dto.Comment;
import kdb.bohem.model.dto.NewComment;

public class CommentService {

	private static CommentDAOImpl comDao = new CommentDAOImpl();
	
	/**
	 * ��� �ڸ�Ʈ �˻��ϴ� �޼ҵ� ȣ��
	 * */
	public static List<Comment> selectAll() throws SQLException{
		return comDao.selectAll();
	}
	
	public static List<NewComment> selectIndexAll(String recipeindex) throws SQLException {
		return comDao.selectIndexAll(recipeindex);
	}
	/**
	 * �ڸ�Ʈ �����ϴ� �޼ҵ� ȣ��
	 * */
	public static int insert(NewComment newcomment) throws SQLException{
		return comDao.insert(newcomment);
	}
	/**
	 *CommentDAOImpl�� �ڸ�Ʈ ��ȣ�� �ش��ϴ� �ڸ�Ʈ �˻��ϴ� �޼ҵ� ȣ��
	 *boolean fla = ????
	 * */
	
	public static Comment selectByComentIndex(int comentIndex) throws SQLException{
		return comDao.selectByComentIndex(comentIndex);
	}
	
	/**
	 * �ڸ�Ʈ �����ϴ� �޼ҵ� ȣ��
	 * */
	public static int delete(int comentIndex) throws SQLException{
		return comDao.delete(comentIndex);
	}
	

}
