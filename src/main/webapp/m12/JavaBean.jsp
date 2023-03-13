<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<jsp:useBean id="emp" class="com.lcpan.bean.EmpBean" scope="request"/>
<jsp:setProperty name="emp" property="ename" value="pan"/>
<jsp:setProperty name="emp" property="salary" value="56000"/>
<html>
<body>
<h3>寫法一</h3>
姓名：${emp.ename}<br>
薪資：${emp.salary}
<h3>寫法二</h3>
姓名：${emp["ename"]}<br>
薪資：${emp["salary"]}
<h3>寫法三</h3>
姓名：${emp['ename']}<br>
薪資：${emp['salary']}
</body>
</html>
