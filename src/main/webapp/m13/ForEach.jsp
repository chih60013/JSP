<%@ page contentType="text/html;charset=UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%	
	String[] greetings = new String[4];
	greetings[0] = "Hello World!";	
	greetings[1] = "Have a good time";	
	greetings[2] = "Happy new year";
	greetings[3] = "Nice to meet you";
	
	List<String> names = new ArrayList<>();
	names.add("Pam Pan");
	names.add("Stephen Wang");
	names.add("Jean Tsao");
	
	request.setAttribute("greetings", greetings);
	request.setAttribute("names", names);
%>
<html>
<head>
	<title><c:out value="<c:foreach/>的用法" /></title>
</head>
<body>
	<c:forEach items="${greetings}" var="item" >
  		${item}<br>
	</c:forEach><p>
	
	<c:forEach items="${names}" var="item" >
		${item}<br>
	</c:forEach><p>
	
	<c:forEach items="${greetings}" var="item" begin="1" step="2" >
		${item}<br>
	</c:forEach><p>
	
	<c:forEach begin="10" end="50" step="10" var="item" >
  		${item}<br>
	</c:forEach>	
	
	<c:forEach items="${names}" var="item" varStatus="s">
		<h4><c:out value="${item}"/>的四種屬性：</h4>
		index：${s.index}<br>
		count：${s.count}<br>
		first：${s.first}<br>
		last：${s.last}<br>
	</c:forEach>	
</body>
</html>
