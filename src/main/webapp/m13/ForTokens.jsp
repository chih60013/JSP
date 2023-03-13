<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%	
	String str = "Have a good time";	
	String str1 = "1001,pan,1978/02/25,0933111222";
	
	request.setAttribute("str", str);
	request.setAttribute("str1", str1);
%>
<html>
<head>
	<title><c:out value="<c:forTokens/>的用法" /></title>
</head>
<body>
	<c:forTokens items="${str}" delims=" " var="item" >
  		${item}<br>
	</c:forTokens><p>
	
	<c:forTokens items="${str1}" delims="," var="item" >
  		${item}<br>
	</c:forTokens><p>	

</body>
</html>
