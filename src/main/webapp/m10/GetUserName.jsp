<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HELLO</title>
</head>
<body>
<h1>Hello,<%= (String)request.getAttribute("username") %></h1><br>
</body>
</html>