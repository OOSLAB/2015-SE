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

	<form action="/loginController/login.do" method="post">
		사용자 아이디<input type="text" name="userID"> <br/>
		비밀번호<input type="password" name="userPassword"> <br/>
		<input type="submit" value="로그인">
	</form>
	
	<form action="loginController/createAccount.do" method="post">
		<input type="submit" value="계정 생성">
	</form>
	
	<form action="loginController/createDB.do" method="post">
		<input type="submit" value="데이터베이스 생성">
	</form>
	
	<form action="loginController/createTable.do" method="post">
		<input type="submit" value="테이블 생성">
	</form>
	
	<form action="loginController/insertData.do" method="post">
		<input type="submit" value="데이터 인서트">
	</form>
	
	<form action="loginController/updateData.do" method="post">
		<input type="submit" value="데이터 업데이트">
	</form>
	
	<form action="loginController/selectData.do" method="post">
		<input type="submit" value="데이터 출력">
	</form>
	
	<form action="loginController/deleteData.do" method="post">
		<input type="submit" value="데이터 삭제">
	</form>
	
	<form action="loginController/dropTable.do" method="post">
		<input type="submit" value="테이블 삭제">
	</form>
	
	<form action="loginController/dropDB.do" method="post">
		<input type="submit" value="데이터베이스 삭제">
	</form>
	
	<form action="loginController/dropACcount.do" method="post">
		<input type="submit" value="계정 삭제">
	</form>

</body>
</html>




