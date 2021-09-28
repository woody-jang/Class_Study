<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드</title>
</head>
<body>
	<c:url value="/fileupload" var="uploadPath"></c:url>
	<form action="${ uploadPath }" method="POST" enctype="multipart/form-data">
		<input name="upload" type="file">
		<input type="submit">
	</form>
</body>
</html>