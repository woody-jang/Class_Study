<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	
	String memberID = request.getParameter("memberID");
	String password = request.getParameter("password");
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection conn = null;
	PreparedStatement stmt = null;
	
	try {
		String jdbcDriver = "jdbc:mysql://localhost:3306/my_db?" + "useUnicode=true&characterEncoding=utf8";
		String dbUser = "root";
		String dbPass = "root";
		
		conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
		
		String query = "INSERT INTO MEMBER_TABLE VALUES (?, ?, ?, ?)";
		stmt = conn.prepareStatement(query);
		stmt.setString(1, memberID);
		stmt.setString(2, password);
		stmt.setString(3, name);
		stmt.setString(4, email);
		
		stmt.executeUpdate();
	} finally {
		if (stmt != null) try { stmt.close(); } catch(SQLException ex) {}
		if (conn != null) try { conn.close(); } catch(SQLException ex) {}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>삽입</title>
</head>
<body>
<p>MEMBER_TABLE 테이블에 새로운 레코드를 삽입했습니다</p>
<p><a href="/viewMemberList.jsp">멤버 리스트 조회</a></p>
</body>
</html>