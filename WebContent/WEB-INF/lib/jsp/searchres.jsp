<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Insert title here</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet" media="screen">
</head>
<body>

<table border="1">
    <!-- here should go some titles... -->
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Salary</th>
        <th>Date of Birth</th>
         <th>Department ID</th>
    </tr>
    <c:forEach items="${collectionOrArray}" var="item">
    <tr>
        <td>
            <c:out value="${item.empId}" />
        </td>
        <td>
            <c:out value="${item.empName}" />
        </td>
        <td>
            <c:out value="${item.salary}" />
        </td>
        <td>
            <c:out value="${item.dob}" />
        </td>
        <td>
            <c:out value="${item.deptId}" />
        </td>
    </tr>
    </c:forEach>
</table>



</body>
</html>
