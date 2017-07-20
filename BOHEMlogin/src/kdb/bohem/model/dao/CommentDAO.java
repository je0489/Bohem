package kdb.bohem.model.dao;

import java.sql.SQLException;
import java.util.List;

import kdb.bohem.model.dto.Comment;
import kdb.bohem.model.dto.NewComment;

public interface CommentDAO {

	/**
	 * 전체 검색
	 * */
	List<Comment> selectAll() throws SQLException;
	
	List<NewComment> selectIndexAll(String recipeindex) throws SQLException;
	/**
	 * 댓글 삽입
	 * @return : 1이상 삽입성공, 0 삽입실패
	 * */
	
	Comment selectByComentIndex(int ComentIndex) throws SQLException;
	
	int insert(NewComment Newcomment) throws SQLException;
	/**
	 * 댓글 삭제
	 * @return : 1이상 삭제성공, 0 삭제실패
	 * */
	int delete(int comentIndex) throws SQLException;
	
	
	
}
