<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<title><c:out value="<c:set/>和 <c:remove/>的用法"/></title>
</head>
<body>
	<c:set var="number" value="10"/>
	<c:set var="number" scope="request">20</c:set>
	<c:set var="number" value="30" scope="session"/>	   
	
	初始設定<br>
	pageScope.number :
		<c:out value="${pageScope.number}" default="No value"/><br>
	requestScope.number :
		<c:out value="${requestScope.number}" default="No value"/><br>
	sessionScope.number :
		<c:out value="${sessionScope.number}" default="No value"/><p>
	
	<c:out value='<c:remove var="number" scope="request"/>後'/><br>
	<c:remove var="number" scope="request"/>
	pageScope.number :
		<c:out value="${pageScope.number}" default="No value"/><br>
	requestScope.number :
		<c:out value="${requestScope.number}" default="No value"/><br>
	sessionScope.number :
		<c:out value="${sessionScope.number}" default="No value"/><p>
	
	<c:out value='<c:remove var="number"/>後'/><br>
	<c:remove var="number" />
	pageScope.number :
		<c:out value="${pageScope.number}" default="No value"/><br>
	requestScope.number :
		<c:out value="${requestScope.number}" default="No value"/><br>
	sessionScope.number :
		<c:out value="${sessionScope.number}" default="No value"/>
</body>
</html>