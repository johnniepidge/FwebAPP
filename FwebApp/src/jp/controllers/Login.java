package jp.controllers;

import jp.beans.*;
import jp.model.LoginDao;

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
    	System.out.println("login before redirect  " +validUser);
    	if(validUser.equals("ValidU")) {

    		request.getRequestDispatcher("/JSP/UserPg.jsp").forward(request, response);;
    		
    	}
    	else if(validUser.equals("ValidA")) {
    				
    	}
    	
    	else {
    		request.getRequestDispatcher("/JSP/Login.jsp").forward(request, response);;
    		System.out.println("Invalid");
    	}
    }
     catch(Exception e){
    	 e.printStackTrace();
    	 
     }
		
				
				
				
	 User userP = loginDao.popUser(user);
	 
	 if(user.getEmail().equals(userP.getEmail())&&user.getPword().equals(userP.getPword())&&userP.getAdmin().equals("admin")) {
			HttpSession session =request.getSession();
			session.setAttribute("ADMIN", userP);
	 }
	 
	 if(user.getEmail().equals(userP.getEmail())&&user.getPword().equals(userP.getPword())&&userP.getAdmin().equals("user")) {
			HttpSession session =request.getSession();
			session.setAttribute("USER", userP);
	 
	 }
	 
		

		out.close();
	

}
}