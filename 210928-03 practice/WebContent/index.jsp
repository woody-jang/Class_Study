<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
</head>
<body>
	<c:if test="${ not empty user }">
		<p>${ user }님 환영합니다.</p>
		<a href="/user/logout">로그아웃</a>
	</c:if>
	<c:if test="${ empty user }">
		<a href="/user/join">회원가입</a>
		<a href="/user/login">로그인</a>
	</c:if>
	<a href="/public/p1.jsp">링크1</a>
	<a href="/public/p2.jsp">링크2</a>
	<a href="/notpublic/ap1.jsp">링크3</a>
	<a href="/notpublic/ap2.jsp">링크4</a>
</body>
</html>