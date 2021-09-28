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
	<c:if test="${ empty list }">
		<p>파일이 존재하지 않습니다</p>
	</c:if>
	<ul>
	<c:forEach var="file" items="${ list }">
		<c:url value="/download" var="downloadPath">
			<c:param name="id" value="${ file.id }"></c:param>
		</c:url>
		<li>${ file.fileName }</li>
		<a href="${ downloadPath }">다운로드</a>
	</c:forEach>
	</ul>
</body>
</html>