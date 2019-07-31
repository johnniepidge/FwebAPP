<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<h1>Welcome to NuLibray </h1>
<p1 >Welcome to the NuLibray service you will be able to use this service 
if you are a student, academic, staff or alumni of the Dublin City university
<br>
<br>

<div id="logDetails" style="font-size:12pt" class="login">
Login Details
</div></p1>
<p2>
<form method="POST" action="/FwebApp/Login" name="mylogin">
E-mail:<br>
<input type="email" name="emailinput" placeholder="E-Mail"><br>
Password:<br>
<input type="password" name="passwordinput" placeholder="Password"><br>
<input type="submit"  value="Login">
</form>
</p2>
</body>
</html>