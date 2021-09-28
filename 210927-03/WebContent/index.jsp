<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Files</title>
</head>
<body>
	<c:url value="/fileupload" var="uploadPath"></c:url>
	<c:url value="/filelist" var="listPath"></c:url>
	<a href="${ uploadPath }">파일 업로드하기</a>
	<a href="${ listPath }">파일 목록</a>
</body>
</html>