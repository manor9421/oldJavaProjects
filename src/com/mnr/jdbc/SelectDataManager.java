package com.mnr.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectDataManager {

	public static boolean selectMySqlData(String name){
		
		// if email is bad
		if( name.isEmpty() ){
			return false;
		}
		
		String sql = "SELECT * FROM users WHERE user_name=?";
		ResultSet rSet = null;
		try(
			Connection conn = DBUtil.getConnection(DBType.MYSQL);
			PreparedStatement stmt = conn.prepareStatement(sql);
			
		){
			
			stmt.setString(1, name);
			
			rSet = stmt.executeQuery();
			
			while(rSet.next()){
				System.out.println(rSet.getString("user_age"));
			}
			
			rSet.last();
			System.out.println("Total names: " + rSet.getRow());
			
			return true;
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	
}
