<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<form action="${pageContext.request.contextPath}/loginController/login.do" method="post">
	<label> 로그인</label>
		<input type="text" name="userID" min="3">
		<input type="password" name="userPassword" min="3">	
		<button type="submit" name="btnLogin" >로그인</button>		
</form>
</body>
</html>
