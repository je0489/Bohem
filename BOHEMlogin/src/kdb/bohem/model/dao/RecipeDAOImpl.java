package kdb.bohem.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kdb.bohem.model.dto.Recipe;
import kdb.bohem.model.util.DBUtil;

public class RecipeDAOImpl implements RecipeDAO {

	@Override
	public List<Recipe> selectAll() throws SQLException {
		Connection con =DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs= null;
		List<Recipe> recipelist = new ArrayList<Recipe>();
		try{
			ps = con.prepareStatement("select * from recipe");
			rs = ps.executeQuery();
			while(rs.next()){
				Recipe recipe = new Recipe(rs.getInt(1), rs.getString(2),rs.getString(3), rs.getString(4));
				recipelist.add(recipe);
			}
		}
		finally{
			DBUtil.dbClose(con, ps, rs);
		}
		return recipelist;
	}

	@Override
	public Recipe select(String keyword) throws SQLException {
		//System.out.println("dapimpl"+keyword);
		Connection con =DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs= null;
		Recipe recipeinfo = new Recipe();
		System.out.println("dapimpl2"+keyword);
		try{
			
			ps = con.prepareStatement("select * from recipe where recipetitle like '%"+keyword+"%'");
			//ps.setString(1, keyword);

			rs = ps.executeQuery();
			while(rs.next()){
				recipeinfo = new Recipe(rs.getInt(1), rs.getString(2),rs.getString(3), rs.getString(4));
			}
		}
		finally{
			DBUtil.dbClose(con, ps, rs);
		}
		return recipeinfo;
	}

	@Override
	public Recipe selectIndex(String index) throws SQLException {
		Connection con =DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs= null;
		Recipe recipe = null;
		//List<Recipe> recipelist = new ArrayList<Recipe>();
		try{
			
			ps = con.prepareStatement("select * from recipe where recipeindex="+index);
			//ps.setString(1, keyword);

			rs = ps.executeQuery();
			while(rs.next()){
				recipe = new Recipe(rs.getInt(1), rs.getString(2),rs.getString(3), rs.getString(4));
				
			}
		}
		finally{
			DBUtil.dbClose(con, ps, rs);
		}
		return recipe;
	}
	
	
}
