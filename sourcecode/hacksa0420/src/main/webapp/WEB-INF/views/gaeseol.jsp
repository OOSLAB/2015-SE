<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>강좌개설</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/gangjwaController/gaeseol.do" method="post">
	<label> 강좌개설 </label>
		<input type="text" name="gangjwaID" >
		<input type="text" name="gangjwaName" >	
		<button type="submit" name="btnGaeseol" >개설</button>		
</form>
</body>
</html>