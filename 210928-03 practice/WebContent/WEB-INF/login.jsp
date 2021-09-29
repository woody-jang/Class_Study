<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<c:if test="${ not empty loginError }">
		<p>${ loginError }</p>
	</c:if>
	<form action="/user/login" method="post">
		<div>
			<label>아이디</label><input type="text" name="nickname">
		</div>
		<div>
			<label>패스워드</label><input type="password" name="password">
		</div>
		<input type="submit">
	</form>
</body>
</html>