<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User</title>
<link rel="stylesheet" type="text\css" href="<%=request.getContextPath()%>/CSS/Lout.css">
<%@page import="com.con.util.DBconnect,java.sql.*,java.util.ArrayList,com.user.bean.Books" %>
</head>
<h1>Welcome to NuLibray </h1>
<br>
<body>
<form>
<select>
<option name ="Books available" value="test"> TEst</option>
<c:forEach items=${BDBL} var ="BDBV" >
<option value="ID"> ${BDBV.next()}   
</option>
</c:forEach>

</select>
</form>
</body>
</html>