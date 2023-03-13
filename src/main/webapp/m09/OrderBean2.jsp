<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Using JavaBeans with JSP</title>
</head>
<body>
<div align="center">
<h3>Using JavaBeans with JSP</h3>
<jsp:useBean id="order" class="com.lcpan.bean.OrderBean" scope="request"/>
<jsp:setProperty name="order" property="*" />

<table border="1">
	<tr><th>book no.<th>unit price <th>quantity<th>subTotal
	<tr align="right">
		<td><jsp:getProperty property="bookno" name="order"/>
		<td>$<jsp:getProperty property="price" name="order"/>
		<td><jsp:getProperty property="quantity" name="order"/>
		<td>$<jsp:getProperty property="subTotal" name="order"/>     
		
</table>
</div>
</body>
</html>