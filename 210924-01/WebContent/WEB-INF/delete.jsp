<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인간 삭제</title>
<style>
	input[type="text"] {
		text-align: center;
		color: white;
		background-color: black;
		width: 45px;
	}
	input[type="number"] {
		text-align: center;
		color: white;
		background-color: black;
		width: 30px;
	}
</style>
</head>
<body>
	<c:if test="${empty personList}">
		<p>등록된 인간이 없습니다.</p>
	</c:if>
	<c:forEach var="person" items="${personList}">
		<form action="/personDelete" method="post">
			<label for="name">이름</label><input id="name" type="text" name="name" value="${person.getName()}" readonly>
			<label for="age">나이</label><input id="age" type="number" name="age" value="${person.getAge()}" readonly>
			<input id="id" type="hidden" name="id" value="${person.getId()}">
			<input type="submit" value="삭제">
		</form>
	</c:forEach>
	<a href="/">처음으로</a>
</body>
</html>