package kdb.bohem.model.service;

import java.sql.SQLException;
import java.util.List;

import kdb.bohem.model.dao.CommentDAOImpl;
import kdb.bohem.model.dto.Comment;

public class CommentService {

	private static CommentDAOImpl comDao = new CommentDAOImpl();
	
	/**
	 * ��� �ڸ�Ʈ �˻��ϴ� �޼ҵ� ȣ��
	 * */
	public static List<Comment> selectAll() throws SQLException{
		return comDao.selectAll();
	}
	/**
	 * �ڸ�Ʈ �����ϴ� �޼ҵ� ȣ��
	 * */
	public static int insert(Comment comment) throws SQLException{
		return comDao.insert(comment);
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
