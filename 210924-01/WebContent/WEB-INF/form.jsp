<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인간 등록하기</title>
<link href="mystyle.css" rel="stylesheet" />
</head>
<body>
	<c:if test="${ not empty errorList }">
		<c:forEach var="message" items="${errorList}">
		<p>${message}</p>
		</c:forEach>
	</c:if>
	<form action="/person" method="post">
		<div>
			<label for="name">이름</label><input id="name" type="text" name="name" required>
		</div>
		<div>
			<label>나이</label><input type="number" name="age" required>
		</div>
		<input type="submit" value="등록">
	</form>
	<a href="/">처음으로</a>
</body>
</html>