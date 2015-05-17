<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@page import ="java.util.*" %>
   <%@page import ="kr.ac.mju.dto.Gangjwa" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>수강신청 화면</h1>

${userLoginSession.getName() }

<c:forEach var="g" items="${gangjwaList}"  varStatus="status">
<form action="${pageContext.request.contextPath}/gangjwaController/sugang.do" method="post">
	<input type="hidden" name="gangjwaID" value="${g.getID()}">
	<p>${g.getID()} | ${g.getName()} | <button type="submit">수강신청</button></p>
</form>
</c:forEach>

<a href="${pageContext.request.contextPath}/loginController/logout" >로그아웃</a>
</body>
</html>