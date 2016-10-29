package com.mnr.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertDataManager {

	public static boolean inserMySqlData(String name, String email, int age){
		
		// if email is bad
		if(ValidateParams.validEmail(email)==false && name.isEmpty() && age <= 0){
			return false;
		}
		
		String sql = "INSERT INTO `users`(`user_name`,`user_email`,`user_age`) VALUES(?,?,?)";
		
		try(
			Connection conn = DBUtil.getConnection(DBType.MYSQL);
			PreparedStatement stmt = conn.prepareStatement(sql);	
		){

			conn.setAutoCommit(false);
			
			stmt.setString(1, name);
			stmt.setString(2, email);
			stmt.setInt(3, age);
			
			int result = stmt.executeUpdate();
			
			if(result == 1){
				System.out.println("Wait for commit...");
			}
			
			conn.commit();

			System.out.println("Commit");
			
			return true;
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return false;
	}
	
}
