<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>員工資料</title>
</head>
<body style="background-color:#fdf5e6">
<div align="center">
<h2>員工資料</h2>


<table>
  <tr>
    <td>員工編號</td>
    <td><input type="text" disabled value="${emp.empno}"></td>
  </tr>
  <tr>
    <td>姓名</td>
    <td><input type="text" disabled value="${emp.ename}"></td>
  </tr>
  <tr>
    <td>到職日</td>
    <td><input type="text" disabled value="${emp.hiredate}"></td>
  </tr>
  <tr>
    <td>薪水</td>
    <td><input type="text" disabled value="${emp.salary}"></td>
  </tr>
  <tr>
    <td>部門編號</td>
    <td><input type="text" disabled value="${emp.deptno}"></td>
  </tr>
  <tr>
    <td>職稱<td><input type="text" disabled value="${emp.title}">

</table>
</div>

</body>
</html>