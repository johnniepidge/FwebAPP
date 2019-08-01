package con.logindao;

import com.con.util.DBconnect;
import com.user.bean.Books;

import java.awt.print.Book;
import java.sql.*;
public class BookDao {

	public Books addBooks(ResultSet rs) {

		Books book =new Books();
		
	
		try {

				 while(rs.next()) {
					 book.setAuthor(rs.getString("Author"));
					 book.setId(rs.getInt("ID"));
					 book.setTitle("TITLE");
					 		}
		

			}
		catch (Exception e) {
		e.printStackTrace();
		}
		
	return book;
}
}