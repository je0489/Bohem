package kdb.bohem.model.dao;

import java.sql.SQLException;
import java.util.List;

import kdb.bohem.model.dto.Recipe;

public interface RecipeDAO {

	List<Recipe> selectAll() throws SQLException;
	
	Recipe select(String keyword) throws SQLException;
	
	Recipe selectIndex(String index) throws SQLException;
}
