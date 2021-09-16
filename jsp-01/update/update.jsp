<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	
	String memberID = request.getParameter("memberID");
	String name = request.getParameter("name");
	
	int updateCount = 0;
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection conn = null;
	PreparedStatement stmt = null;
	
	try {
		String jdbcDriver = "jdbc:mysql://localhost:3306/my_db?" + "useUnicode=true&characterEncoding=utf8";
		String dbUser = "root";
		String dbPass = "root";
		
		String query = "UPDATE MEMBER_TABLE SET NAME = ? WHERE MEMBERID = ?";
		
		conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
		
		stmt = conn.prepareStatement(query);
		stmt.setString(1, name);
		stmt.setString(2, memberID);
		updateCount = stmt.executeUpdate();
	} finally {
		if (stmt != null) try { stmt.close(); } catch(SQLException ex) {}
		if (conn != null) try { stmt.close(); } catch(SQLException ex) {}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이름 변경</title>
</head>
<body>
	<% if (updateCount > 0) { %>
	<%= memberID %>의 이름을 <%= name %>(으)로 변경
	<% } else { %>
	<%= memberID %> 아이디가 존재하지 않음
	<% } %>
</body>
</html>