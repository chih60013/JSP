<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<title><c:out value="<c:choose/>的用法" /></title>
</head>
<body>
	<c:choose>
    <c:when test="${param.password == '123'}">
       ${param.user} 歡迎光臨！
    </c:when>
    <c:otherwise>
      	 密碼錯誤,請重新輸入！
    </c:otherwise>
	</c:choose>	
</body>
</html>
