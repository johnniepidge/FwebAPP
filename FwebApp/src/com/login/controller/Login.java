package com.login.controller;

import com.user.bean.*;

import con.logindao.LoginDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.ServletException;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID=1L;
	Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    

	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	
	User user=new User();
	user.setEmail(request.getParameter("emailinput"));
    user.setPword(request.getParameter("passwordinput"));
		
				LoginDao loginDao =new LoginDao();
				
		
try {
	String validUser =loginDao.validateUser(user);
	if(validUser.equals("Valid")) {
		System.out.println("Valid email");
		HttpSession session =request.getSession();
		session.setAttribute("USER", user);
		
	}
	else {
		System.out.println("Invalid");
	}
}
 catch(Exception e){
	 e.printStackTrace();
	 
 }
		out.close();
	

}
}