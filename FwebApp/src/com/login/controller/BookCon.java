package com.login.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.con.util.DBconnect;
import com.user.bean.Books;

import con.logindao.BookDao;

@WebServlet("/BookCon")
public class BookCon extends HttpServlet {
	private static final long serialVersionUID=1L;
	Connection con = null;
    Statement stat = null;
    ResultSet rs = null;


	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	
	BookDao bookdao=new BookDao();
	
	try {
		con =DBconnect.createConnction();
		stat=con.createStatement();
		rs =stat.executeQuery("SELECT * FROM JP_BOOK");
		while(rs.next()) {
			bookdao.addBooks(rs);
		}
		HttpSession session =request.getSession();
		session.setAttribute("BOOK", bookdao);
		
		request.getRequestDispatcher("/JSP/UserPg.jsp").forward(request, response);;
		System.out.println(bookdao.toString() +"added");
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}

	
	
	}

}
