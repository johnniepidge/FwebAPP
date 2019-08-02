package jp.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.beans.Books;
import jp.model.BookDao;
import jp.util.DBconnect;

@WebServlet("/BookCon")
public class BookCon extends HttpServlet {
	private static final long serialVersionUID=1L;
	Connection con = null;
    Statement stat = null;
    ResultSet rs = null;

 
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	System.out.println(" it is in the book con");
	
	BookDao bookdao=new BookDao();
	System.out.println(request.getParameter("SV"));
	
	HttpSession session =request.getSession();
	int Bid =Integer.valueOf(request.getParameter("SV"));
	try {
		BookDao.addBooks(Bid, session);
		request.getRequestDispatcher("/JSP/UserPg.jsp").forward(request, response);;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
