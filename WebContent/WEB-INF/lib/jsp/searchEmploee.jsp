<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Search Employees</title>
</head>
<body>

Search:  <BR>

<form action="search" method="post">
  <select name="criteria">
    <option value="emp_id">Employee ID</option>
    <option value="emp_name">Employee Name</option>
    </select>
<input name="searchvalue" type="text"></input>
<input type="checkbox" name="incl" id="incl" value="ok">Include partial matches </input> 
&emsp;
 <input type="submit" />

</form>



  

</body>
</html>
