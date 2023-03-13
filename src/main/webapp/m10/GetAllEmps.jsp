<%@page import="java.util.ArrayList"%>
<%@page import="com.lcpan.bean.EmpBean"%>
<%@page import="java.util.List"%>
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


<table border  ="1">
  <tr style="background-color:#a8fefa">
  <th>員工編號<th>姓名<th>到職日<th>薪水<th>部門編號<th>職稱
  <% List<EmpBean> emps=(ArrayList<EmpBean>)request.getAttribute("emps");
  	for(EmpBean emp: emps){ %>
  	

  	
  <tr><td><%= emp.getEmpno() %>
  <td><%=emp.getEname() %>
  <td><%= emp.getHiredate() %>
  <td><%= emp.getSalary() %>
  <td><%= emp.getDeptno() %>
  <td><%= emp.getTitle() %>
  <%} %>
  
  </table>
  <h3>共<%=emps.size() %>筆員工資料</h3>
</div>

</body>
</html>