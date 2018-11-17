<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="Connector.myConnectorClass, java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$("ul").on("click", "button", function(del) {
    del.preventDefault();
    $(this).parent().remove();
    
});
	
	
	</script>
</head>
<body>
<p> Question Editor </p> 
<!-- 
	-Display current question
	-Display current options
	-Add/remove options
	-Edit Question
	-Submit button
 -->
 
 <ol>
 <%;
 try{
		Connection conn = myConnectorClass.getConnection(); 
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("SELECT * FROM REFERUNDUM_OPTIONS");
		while(rs.next()) {
			%>
		    <li id=<%=rs.getString("OPT_ID") %> ><%=rs.getString("OPTION") %><button>delete</button> </li>
		    <%
		}
	%>
	</ol>
	<%
	rs.close();
	stmt.close();
	conn.close();

 }catch(Exception e) {
 	e.printStackTrace();
 	} 
 
 
 %>
 
 
 
 
 
 
</body>
</html>