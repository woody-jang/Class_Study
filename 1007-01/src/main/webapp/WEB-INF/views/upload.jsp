<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드</title>
</head>
<body>
	<h1>파일 업로드</h1>
	<form action="/file/upload" method="post" enctype="multipart/form-data">
		<input type="file" name="userfile">
		<input type="submit">
	</form>
</body>
</html>