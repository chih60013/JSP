<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>count</title>
</head>
<body>
<%! int count=0; %>
<% count++; %>
Welcome, your visitor number is 
<%=count %>

</body>
</html>