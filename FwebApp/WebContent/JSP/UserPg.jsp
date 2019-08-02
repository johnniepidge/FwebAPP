<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User</title>
<link rel="stylesheet" type="text\css" href="<%=request.getContextPath()%>/CSS/Lout.css">
<%@page import="jp.util.DBconnect,java.sql.*,java.util.List,jp.beans.Books,jp.model.BookDao" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<h1>Welcome ${USER.getFname()} </h1>
<br>
<body>

<%  
List<Books> list=BookDao.getAllBooks();  
request.setAttribute("list",list);  
%> 
 
 <form method="POST" action="<%=request.getContextPath()%>/BookCon" name="Books">
<select name="SV">
<c:forEach items='${list}' var ="BDBV" >
<option value='${BDBV.getId()}'> ${BDBV.getId()} - ${BDBV.getTitle()} - ${BDBV.getAuthor()}  
</option>
</c:forEach>
</select>
<input type="submit" value='ADDBOOK' name="ADD"></input>
</form  >
 
 
</body>
</html>