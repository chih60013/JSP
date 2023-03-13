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
<jsp:useBean id="emp" scope="request" class="com.lcpan.bean.EmpBean"/>

<table>
  <tr>
    <td>員工編號</td>
    <td><input type="text" disabled value="<%= emp.getEmpno() %>"></td>
  </tr>
  <tr>
    <td>姓名</td>
    <td><input type="text" disabled value="<%= emp.getEname() %>"></td>
  </tr>
  <tr>
    <td>到職日</td>
    <td><input type="text" disabled value="<%= emp.getHiredate() %>"></td>
  </tr>
  <tr>
    <td>薪水</td>
    <td><input type="text" disabled value="<%= emp.getSalary() %>"></td>
  </tr>
  <tr>
    <td>部門編號</td>
    <td><input type="text" disabled value="<%= emp.getDeptno() %>"></td>
  </tr>
  <tr>
    <td>職稱<td><input type="text" disabled value="<%= emp.getTitle() %>">

</table>
</div>

</body>
</html>