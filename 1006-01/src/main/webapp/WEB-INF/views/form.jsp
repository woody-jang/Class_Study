<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>폰 등록하기</title>
</head>
<body>
	<form:form modelAttribute="phone" action="/phone/form" method="post">
		<div>
			<form:errors path="*" />
		</div>
		<div>
			<label>모델명</label>
			<form:input type="text" path="model" />
			<form:errors path="model" />
		</div>
		<div>
			<label>제조사</label>
			<form:input type="text" path="production" />
			<form:errors path="production" />
		</div>
		<div>
			<label>재고수량</label>
			<form:input type="number" path="amount" />
			<form:errors path="amount" />
		</div>
		<div>
			<label>정가</label>
			<form:input type="number" path="price" />
			<form:errors path="price" />
		</div>
		<input type="submit">
	</form:form>
</body>
</html>