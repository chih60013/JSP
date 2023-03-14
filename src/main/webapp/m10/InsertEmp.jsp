<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<title>員工資料</title>
</head>
<body style="background-color: #fd5e6">
 <div align="center">
  <h2>員工資料</h2>
  <jsp:useBean id="emp" scope="request" class="com.lcpan.bean.EmpBean"></jsp:useBean>
  <table>
   <tr>
    <td>員工編號
    <td><input type="text" disabled value="<%=emp.getEmpno()%>">
   <tr>
    <td>姓名
    <td><input type="text" disabled value="<%=emp.getEname()%>">
   <tr>
    <td>到職日
    <td><input type="text" disabled value="<%=emp.getHiredate()%>">
   <tr>
    <td>薪水
    <td><input type="text" disabled value="<%=emp.getSalary()%>">
   <tr>
    <td>部門編號
    <td><input type="text" disabled value="<%=emp.getDeptno()%>">
   <tr>
    <td>職稱
    <td><input type="text" disabled value="<%=emp.getTitle()%>">
   <tr>
    
    <td><input type="text" disabled value="<%=request.getAttribute("message")%>">
  </table>
 </div>


</body>
</html>