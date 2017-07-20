package kdb.bohem.model.dao;

import java.sql.SQLException;
import java.util.List;

import kdb.bohem.model.dto.Comment;
import kdb.bohem.model.dto.NewComment;

public interface CommentDAO {

	/**
	 * ��ü �˻�
	 * */
	List<Comment> selectAll() throws SQLException;
	
	List<NewComment> selectIndexAll(String recipeindex) throws SQLException;
	/**
	 * ��� ����
	 * @return : 1�̻� ���Լ���, 0 ���Խ���
	 * */
	
	Comment selectByComentIndex(int ComentIndex) throws SQLException;
	
	int insert(NewComment Newcomment) throws SQLException;
	/**
	 * ��� ����
	 * @return : 1�̻� ��������, 0 ��������
	 * */
	int delete(int comentIndex) throws SQLException;
	
	
	
}
