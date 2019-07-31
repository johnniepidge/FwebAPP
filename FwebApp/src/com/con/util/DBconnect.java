package com.con.util;

import java.sql.*;
import java.util.Vector;

import com.user.bean.User;

public class DBconnect {


	public static Connection createConnction() {
		Connection con =null;
		String url ="jdbc:oracle:thin:@ee417.c7clh2c6565n.eu-west-1.rds.amazonaws.com:1521:EE417";
		
		String password ="ee_pass";
		String username ="ee_user";
		
		
		try {
			System.out.println();
			Class.forName("oracle.jdbc.driver.OracleDriver");
	
		con=DriverManager.getConnection(url,username,password);
				System.out.println("Connection esbtablished" +con );
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		return con;
	}
}
