package jp.model;

import jp.beans.Books;
import jp.beans.User;
import jp.util.DBconnect;

import java.awt.print.Book;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


import javax.servlet.http.HttpSession;

public class BookDao {

	public static void addBooks(int s,HttpSession request ) throws SQLException {

System.out.println(request.getAttribute("USER"));
User user =(User) request.getAttribute("USER");

        Connection con=DBconnect.createConnection();		
	 	Statement stat=con.createStatement();
		ResultSet	rs =stat.executeQuery("INSERT INTO JP_ACC(STUDENT_NO,BOOK_ID) VALUES(" + user.getsNumber() + ","+ s + " )");


	}


public static List<Books> getAllBooks(){  
	
    List<Books> list=new ArrayList<Books>();  
    try{  


        Connection con=DBconnect.createConnection();		
	 	Statement stat=con.createStatement();
		ResultSet	rs =stat.executeQuery("SELECT * FROM JP_BOOK ORDER BY ID ASC");
		
		System.out.println(" And what about here IN BOOK"+con);
         

        while(rs.next()){  
        System.out.println(" And what about here IN BOOK"+rs.getString("author"));
            Books b=new Books();
            b.setId(rs.getInt("id"));
            b.setAuthor(rs.getString("author"));
            b.setTitle(rs.getString("title"));
            list.add(b);  

                String test = b.getAuthor();

   System.out.println("b...."+test);  
        }  
    }catch(Exception e){System.out.println(e);}  

   return list;

   }
	
}