<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Vote Registration</title>
    <script type="text/javascript">
    function checkEmpty() {
        var e;
        e = document.getElementById("signUpInput").value;
        if (x == "") {
            alert("Field left empty");
            return false;
        };
        
    }
    function invalidPWORD() {
            alert("Password must be at least 8 characters, containing at least one special, upper case and lower case character");
            return false;
        };
   function invalidEmail() {
	   alert("Please enter a valid email address");
	   return false;
   }            
   function invalidEmail() {
	   alert("Format YYYY-MM-DD required");
	   return false;
   }          
   function invalidName() {
	   alert("Please enter a valid name");
	   return false;
   }           
        </script>
</head>
<body>
<form action="SignupServlet" method="post">
    <table>
    	<tr><td>${signup_message}</td></tr>
        <tr><td>Full Name: </td><td><input type="text" name="name" value="NameInput" id="signUpInput" pattern="[a-zA-Z ]+"></td></tr>
        <tr><td>User ID: </td><td><input type="email" name="userID" value="userid@mail.com" id="signUpInput" oninvalid="invalidEmail" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$"></td></tr>
        <tr><td>Password: </td><td><input type="password" name="password" value="Password!1" id="signUpInput"  
        pattern="(?=^.{8,}$)(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*\W).*$" oninvalid=invalidPWORD();></td></tr>
        <tr><td>Date Of Birth: </td> <td><input name="dob" type="date" placeholder="YYYY-MM-DD">
        onInvalid=invalidDate() id="signUpInput"></td></tr>
        <tr><td>Biometric I.D.: </td> <td><input type="text" name="bic" value="9T5C-RD3T-RYF2-SSJM" id="signUpInput"></td></tr>
    </table>
    <fieldset>
            <legend>Home Address:</legend>
            Address: <input type="text" name="address" id="signUpInput"><br>
            City: <input type="text" name="city"  id="signUpInput"><br>
            State: <input type="text" name="state" id="signUpInput">
            Postcode: <input type="text" name ="postcode"  id="signUpInput">
        </fieldset>
        <input type="submit" name="signUpSubmit" value="Register" onClick=checkEmpty();>
</form>

<a href="login.jsp">Return to login page</a>

</body>
</html>