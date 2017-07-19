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
				Recipe recipe = new Recipe(rs.getInt(1), rs.getString(2),rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(7));
				recipelist.add(recipe);
			}
		}
		finally{
			DBUtil.dbClose(con, ps, rs);
		}
		return recipelist;
	}

	@Override
	public List<Recipe> select(String keyword) throws SQLException {
		
		Connection con =DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs= null;
		List<Recipe> recipelist = new ArrayList<Recipe>();
		try{
			ps = con.prepareStatement("select * from recipe where recipetitle like '%?%'");
			ps.setString(1, keyword);

			rs = ps.executeQuery();
			while(rs.next()){
				Recipe recipe = new Recipe(rs.getInt(1), rs.getString(2),rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(7));
				recipelist.add(recipe);
			}
		}
		finally{
			DBUtil.dbClose(con, ps, rs);
		}
		return recipelist;
	}

}
