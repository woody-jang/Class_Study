<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>등록된 인간 수정하기</title>
<link href="mystyle.css" rel="stylesheet" />
</head>
<body>
	<c:if test="${empty personList}">
		<p>등록된 인간이 없습니다.</p>
	</c:if>
	<c:if test="${not empty personList}">
		<p>수정할 줄의 사람 정보를 수정한 후 수정 버튼을 누르세요</p>
	</c:if>
	<c:forEach var="person" items="${personList}">
		<form action="/personUpdate" method="post">
			<label for="name">이름</label><input id="name" type="text" name="name" value="${person.getName()}">
			<label for="age">나이</label><input id="age" type="number" name="age" value="${person.getAge()}">
			<input id="id" type="hidden" name="id" value="${person.getId()}">
			<input type="submit" value="수정">
		</form>
	</c:forEach>
	<a href="/">처음으로</a>
</body>
</html>