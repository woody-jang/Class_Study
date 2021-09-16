<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>world</title>
</head>
<body>
<%
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "root");
	PreparedStatement stmt = conn.prepareStatement("SELECT * FROM country");
	ResultSet rs = stmt.executeQuery();
	while (rs.next()) {
		out.println("<p>");
		out.println(rs.getString("CODE") + ", " + rs.getString("Name"));
		out.println("</p>");
	}
	rs.close();
	stmt.close();
	conn.close();
%>
</body>
</html>