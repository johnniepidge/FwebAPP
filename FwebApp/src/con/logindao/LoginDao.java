package con.logindao;

import com.con.util.DBconnect;
import com.user.bean.User;
import java.sql.*;
import java.util.Vector;

public class LoginDao {
	
	public String validateUser(User user) {
		String Email = user.getEmail();
		String Pword =user.getPword();
		
		Connection con=null;
		Statement stat =null;
		ResultSet rs=null;
		
		String EmailDb ="";
		String PWordDB ="";
		
		try {
			con =DBconnect.createConnction();
			stat=con.createStatement();
			rs =stat.executeQuery("SELECT * FROM JP_USERS");
			if(con!=null) {
				
			
		 while(rs.next()) {
		 EmailDb = rs.getString(Email);
		 PWordDB = rs.getString(Pword);
		 if(Email.equals(EmailDb)&&Pword.equals(PWordDB)) {
			 return "Valid";
		 }
		 }
		}
			else {
				System.out.println("null");
			}
			}
		
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return "ivalid";
		
	}

}
