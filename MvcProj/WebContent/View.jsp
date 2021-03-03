<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
session=request.getSession();
String sid=(String)session.getAttribute("sid1");
String name=(String)session.getAttribute("name1");

out.println(sid);
out.println(name);

 %>
</body>
</html>