package com.mnr.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args){
		
		String sql = "INSERT INTO `users`(`user_name`,`user_email`,`user_age`) VALUES(?,?,?)";
		
		try(
			Connection conn = DBUtil.getConnection(DBType.MYSQL);
			PreparedStatement stmt = conn.prepareStatement(sql);	
		){

			stmt.setString(1, "Ben");
			stmt.setString(2, "ben@gmail.com");
			stmt.setInt(3, 31);
			
			int result = stmt.executeUpdate();
			
			if(result == 1){
				System.out.println("Added");
			}
	
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

}
