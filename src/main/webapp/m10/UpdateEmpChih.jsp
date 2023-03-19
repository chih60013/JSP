<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<title>修改員工資料</title>
</head>
<body style="background-color: #fd5e6">
 <div align="center">
  <h2>員工資料</h2>
  <jsp:useBean id="emp" scope="request" class="com.lcpan.bean.EmpBean"></jsp:useBean>
  
 <form method="post" action="UpdateEmpChih">  
<table>
<tr><td> 員工編號
	<td><input type="text" name="empno" value="<%=emp.getEmpno()%>">
<tr><td>姓名<td><input type="text" name="ename" value="<%=emp.getEname()%>">
<tr><td>到職日<td><input type="text" name="hiredate" value="<%=emp.getHiredate()%>">
<tr><td>薪水<td><input type="text" name="salary"  value="<%=emp.getSalary()%>">
<tr><td>部門編號<td><input type="text" name="deptno" value="<%=emp.getDeptno()%>">
<tr><td>職稱<td><input type="text" name="title" value="<%=emp.getTitle()%>">
</table>
		<input type="submit" value="更新資料">
	</form>
 </div>


</body>
</html>