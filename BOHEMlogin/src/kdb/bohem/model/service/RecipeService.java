package kdb.bohem.model.service;

import java.sql.SQLException;
import java.util.List;

import kdb.bohem.model.dao.RecipeDAOImpl;
import kdb.bohem.model.dto.Recipe;

public class RecipeService {
	private static RecipeDAOImpl recipeDao = new RecipeDAOImpl();
	
	public static List<Recipe> selectAll() throws SQLException{
		return recipeDao.selectAll();
	}
	
	public static List<Recipe> select(String keyword) throws SQLException {
		return recipeDao.select(keyword);
	}
}
