<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>등록된 인간들 목록</title>
<link href="mystyle.css" rel="stylesheet" />
</head>
<body>
	<c:if test="${empty personList}">
		<h4>등록된 인간이 없습니다.</h4>
	</c:if>
	<c:if test="${empty search}">
		<form action="/personList" method="post">
			<label for="name">이름 </label>
			<input id="name" type="text" name="name">
			<input type="submit" value="검색">
		</form>
	</c:if>
	<c:if test="${not empty search}">
		<p>${search} 이름으로 검색한 결과</p>
	</c:if>
	<ul>
		<c:forEach var="person" items="${personList}">
			<li> 이름 : ${person.getName()}, 나이 : ${person.getAge()}
		</c:forEach>
	</ul>
	<a href="/">처음으로</a>
</body>
</html>