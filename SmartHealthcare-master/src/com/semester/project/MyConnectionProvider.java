package com.semester.project;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class MyConnectionProvider implements MyProvider {
	
	public static Connection con = null;
	
	public static Connection getCon(){
		try{
			
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver Found");
		}
		catch(ClassNotFoundException e){
			System.out.println("Driver not found"+e);
		}
		try{
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","password");
		 System.out.println("Connection successful");
		}catch(SQLException e){
			System.out.println("Something went wrong in connection"+e);
		}
		return con;
		
	}

}
