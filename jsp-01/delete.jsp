<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	
	String memberID = request.getParameter("memberID");
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	int updateCount = 0;
	
	Connection conn = null;
	PreparedStatement stmt = null;
	
	try {
		String jdbcDriver = "jdbc:mysql://localhost:3306/my_db?" + "useUnicode=true&characterEncoding=utf8";
		String dbUser = "root";
		String dbPass = "root";
		
		conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
		
		String query = "DELETE FROM MEMBER_TABLE WHERE MEMBERID = ?";
		stmt = conn.prepareStatement(query);
		stmt.setString(1, memberID);
		
		updateCount = stmt.executeUpdate();
	} finally {
		if (stmt != null) try { stmt.close(); } catch(SQLException ex) {}
		if (conn != null) try { conn.close(); } catch(SQLException ex) {}
	}
	
	if (updateCount > 0) {
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>삭제완료</title>
</head>
<body>
<p><%= memberID %>를 삭제했습니다.</p>
<p><a href="viewMemberList.jsp">이전페이지로 이동</a></p>
</body>
</html>
<%
	} else {
%>
<script>
	alert("삭제 실패")
	history.go(-1);
</script>
<%
	}
%>