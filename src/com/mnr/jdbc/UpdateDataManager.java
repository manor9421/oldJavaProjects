package com.mnr.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDataManager {

	public static boolean inserMySqlData(String name, int newAge){
		
		String sql = "Update users SET user_age=? WHERE user_name=?" ;
		try(
			Connection conn = DBUtil.getConnection(DBType.MYSQL);
			PreparedStatement stmt = conn.prepareStatement(sql);
		){
			
			conn.setAutoCommit(false);
			stmt.setInt(1, newAge);
			stmt.setString(2, name);
			stmt.executeUpdate();
			
			conn.commit();
			
			return true;
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	
}
