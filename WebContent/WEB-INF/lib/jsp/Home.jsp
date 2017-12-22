<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<c:set scope="session" var="sessionStarted" value="true"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>

	<script type="text/javascript">
	function validate(){
	
		 var user = document.forms["formp"]["user"].value;
		 var pass = document.forms["formp"]["pass"].value;
    if (user == "" || pass=="") {
        alert("Username and password must be filled out");
    return false;
    }
    }
        </script>
</head>
<body>

	<form name="formp" action="LoginServlet" method="post" onSubmit="JavaScript:validate()">
		Enter username : <input type="text" required="true" name="user"> <BR>
		
		Enter password : <input type="password" required="true" name="pass"> <BR>
			
		<input type="submit" />
		
	</form>
	

</body>
</html>