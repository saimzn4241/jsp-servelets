<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="dto.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Success</title>
</head>
<body>
<h1>Login Successful!!!!!!</h1>
<%
	//User user= (User)session.getAttribute("user");
	//User user= (User)request.getAttribute("user");
%>


<jsp:useBean id="user" class="dto.User" scope="request">4
<jsp:setProperty property="userName" name="user" value="NerUser"/>
</jsp:useBean>



<br>Hello  <%=user.getUserName()%>!!!

<br>Hello  <jsp:getProperty property="userName" name="user"/>!!!
 
</body>
</html>