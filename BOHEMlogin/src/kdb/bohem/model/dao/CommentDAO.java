package kdb.bohem.model.dao;

import java.sql.SQLException;
import java.util.List;

import kdb.bohem.model.dto.Comment;

public interface CommentDAO {

	/**
	 * ��ü �˻�
	 * */
	List<Comment> selectAll() throws SQLException;
	
	/**
	 * ��� ����
	 * @return : 1�̻� ���Լ���, 0 ���Խ���
	 * */
	
	Comment selectByComentIndex(int ComentIndex) throws SQLException;
	
	int insert(Comment comment) throws SQLException;
	/**
	 * ��� ����
	 * @return : 1�̻� ��������, 0 ��������
	 * */
	int delete(int comentIndex) throws SQLException;
	

	
}
