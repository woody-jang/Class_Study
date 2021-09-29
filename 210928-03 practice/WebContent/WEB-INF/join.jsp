<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>
	<c:if test="${ not empty errors }">
		<ul>
			<c:forEach var="e" items="${ errors }">
				<li>${ e }</li>
			</c:forEach>
		</ul>
	</c:if>
	<form action="/user/join" method="post">
		<div>
			<label>아이디</label><input type="text" name="nickname">
		</div>
		<div>
			<label>비밀번호</label><input type="password" name="password">
		</div>
		<input type="submit">
	</form>
</body>
</html>