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
	
	public static Recipe select(String keyword) throws SQLException {
		System.out.println("recipeservice");
		return recipeDao.select(keyword);
	}
	
	public static Recipe selectIndex(String index) throws SQLException {
		return recipeDao.selectIndex(index);
	}
}
