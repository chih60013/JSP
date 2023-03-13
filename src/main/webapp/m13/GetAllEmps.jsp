<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>員工資料</title>
</head>
<body style="background-color:#fdf5e6">
<div align="center">
<h2>員工資料</h2>


<table border  ="1">
  <tr style="background-color:#a8fefa">
  <th>員工編號<th>姓名<th>到職日<th>薪水<th>部門編號<th>職稱
  
 <c:forEach items="${emps}" var="emp" varStatus="s">
  	
  <tr><td>${emp.empno}
  <td>${emp.ename}
  <td>${emp.hiredate}
  <td>${emp.salary}
  <td>${emp.deptno}
  <td>${emp.title}
  	<c:set var="count" value="${s.count}"/>
	</c:forEach>	

  
  </table>
  <h3>共${count}筆員工資料</h3>
</div>

</body>
</html>