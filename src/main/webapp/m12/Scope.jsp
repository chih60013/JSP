<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
session.setAttribute("user","pan");
pageContext.setAttribute("customer","pan1");
request.setAttribute("customer","pan2");
session.setAttribute("customer","pan3");
application.setAttribute("customer","pan4");
%>
<html>
<body>
user 屬性的值：${user}<p>
customer 屬性的值：${customer}<p>
pageContext.customer = ${pageScope.customer}<br>
request.customer = ${requestScope.customer}<br>
session.customer = ${sessionScope.customer}<br>
application.customer = ${applicationScope.customer}
</body>
</html>
