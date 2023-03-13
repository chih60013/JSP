<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>count</title>
</head>
<body>
<h3>Using JavaBeans with JSP</h3>
<jsp:useBean id="stringBean" class="com.lcpan.bean.StringBean" />
<ol>
	<li><jsp:setProperty property="message" name="stringBean" value="this is a test"/>
	Set and get property with JSP:setProperty:<br>
		<i><jsp:getProperty name="stringBean" property="message" /></i>
	<li><% stringBean.setMessage("Learning JSP is wonderful"); %>
	Set and get property with JSP:setProperty:<br>
	<i> <%= stringBean.getMessage() %></i>
	

</ol>

</body>
</html>