<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="/assets/css/bootstrap.css" rel="stylesheet" media="screen">
<title>Search Employees</title>
</head>
<body>

Search:  <BR>

<form action="search" method="post">
  <select name="criteria">
    <option value="emp_id">Employee ID</option>
    <option value="emp_name">Employee Name</option>
    </select>
<input name="searchvalue" required="true" pattern="[0-9]{1,}|[0-9A-Za-z]{2,}" title="two or more alphanumeric characters required." type="text"></input>
<input type="checkbox" name="incl" id="incl" value="ok">Include partial matches </input> 
&emsp;
 <input type="submit" />

</form>



  

</body>
</html>
