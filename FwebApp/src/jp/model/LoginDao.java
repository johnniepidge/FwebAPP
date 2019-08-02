package jp.model;

import jp.beans.User;
import jp.util.DBconnect;

import java.sql.*;
import java.util.Vector;

import javax.servlet.http.HttpSession;

public class LoginDao {
	Connection con=null;
	Statement stat =null;
	ResultSet rs=null;
	
	String EmailDb ="";
	String PWordDB ="";
	String RoleDB = "";
	String FName = "";
	String Sname ="";
	int SNUM ;
	
	public  User  popUser(User user) {
try {
	
			con =DBconnect.createConnection();
			stat=con.createStatement();
			rs =stat.executeQuery("SELECT * FROM JP_USERS");
			
				
		 while(rs.next()) {
		 EmailDb = rs.getString("EMAIL");
		 PWordDB = rs.getString("PASSWORD");
		 RoleDB =rs.getString("ROLE");
		 FName = rs.getString("FIRSTNAME");
		 Sname =rs.getString("SURENAME");
		 SNUM =rs.getInt("STUDENT_NO");
		 
			 user.setAdmin(RoleDB);
			 user.setEmail(EmailDb);
			 user.setPword(PWordDB);
			 user.setFname(FName);
			 user.setSname(Sname);
			 user.setsNumber(SNUM);
			 
			 System.out.println(user.getFname() +"Testing Dao");
		 }
		 } catch (Exception e) {
				e.printStackTrace();
			}
		
		return user;
	}
		 
	
	public String validateUser(User user) {
		String Email = user.getEmail();
		String Pword =user.getPword();
		

		
		System.out.println(Email +Pword +" dao");
		
		try {
			con =DBconnect.createConnection();
			stat=con.createStatement();
			rs =stat.executeQuery("SELECT * FROM JP_USERS");
			
				
		 while(rs.next()) {
		 EmailDb = rs.getString("EMAIL");
		 PWordDB = rs.getString("PASSWORD");
		 RoleDB =rs.getString("ROLE");
		 FName = rs.getString("FIRSTNAME");
		 Sname =rs.getString("SURENAME");
		 SNUM =rs.getInt("STUDENT_NO");
		 
		 
		 if(Email.equals(EmailDb)&&Pword.equals(PWordDB)&&"user".equals(RoleDB)) {
			 System.out.println("valid u");
			 return "ValidU";
		 		}

		 else if(Email.equals(EmailDb)&&Pword.equals(PWordDB)&&"admin".equals(RoleDB)) {
			 System.out.println("valid admin");
			 return "ValidA";
	 		}
		 	}

		}
		
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return "Invalid";
		
	}

}
