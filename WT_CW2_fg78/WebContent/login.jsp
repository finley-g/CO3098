<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Shangri-La Voting</title>
</head>
<body>

<form action="LoginServlet" method="post">
    <table>
    	<tr><td>${login_message}</td></tr>
        <tr><td>User ID: </td><td><input type="email" name="userID"></td></tr>
        <tr><td>Password: </td><td><input type="password" name="password"></td></tr>
        <tr><td><input type="submit" name="loginSubmit" value="Login"></td></tr>
        <tr><td><a href="signup.jsp">Register to vote</a></td></tr>
    </table>

</form>
</body>
</html>