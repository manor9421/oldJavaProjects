package com.mnr.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	static final String mySqlUser = "jdbc_user";
	static final String mySqlPwd = "1234";
	static final String mySqlUrl = "jdbc:mysql://localhost:3306";
	static final String mySqlDB = "/jdbc_work";
	
	static final String sqLiteUser = "";
	static final String sqLitePwd = "";
	static final String sqLiteUrl = "";
	static final String sqLiteDB = "";
	
	public static Connection getConnection(DBType dbType) throws SQLException{
		
		switch (dbType) {
		case MYSQL:
			return DriverManager.getConnection(mySqlUrl+mySqlDB,mySqlUser,mySqlPwd);
		case SQLITE:
			return DriverManager.getConnection(sqLiteUrl+sqLiteDB,sqLiteUser,sqLitePwd);
		default:
			return null;
		}
		
	}
	

}
