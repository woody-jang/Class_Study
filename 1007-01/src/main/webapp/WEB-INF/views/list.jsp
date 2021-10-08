<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 목록</title>
</head>
<body>
	<h1>파일 목록</h1>
	<c:if test="${ empty list }">
		<p>파일이 없습니다</p>
	</c:if>
	<c:if test="${ not empty list }">
		<ul>
			<c:forEach var="fileName" items="${ list }">
				<c:url value="/file/download" var="u">
					<c:param name="name" value="${ fileName }"></c:param>
				</c:url>
				<li><a href="/file/download?name=${ fileName }">${ fileName }</a></li>
			</c:forEach>
		</ul>
	</c:if>
</body>
</html>