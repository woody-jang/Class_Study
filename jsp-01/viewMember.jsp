<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String memberID = request.getParameter("memberID");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보</title>
</head>
<body>
	<%
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			String jdbcDriver = "jdbc:mysql://localhost:3306/my_db?" + "useUnicode=true&characterEncoding=utf8";
			String dbUser = "root";
			String dbPass = "root";
			String query = "SELECT * FROM MEMBER_TABLE WHERE MEMBERID = ?";
			
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			stmt = conn.prepareStatement(query);
			
			stmt.setString(1, memberID);
			
			rs = stmt.executeQuery();
			if (rs.next()) {
	%>
	<table border="1">
		<tr>
			<td>아이디</td><td><a href="viewMemberHistory.jsp?memberID=<%= memberID %> "><%= memberID %></a></td>
		</tr>
		<tr>
			<td>암호</td><td><%= rs.getString("PASSWORD") %></td>
		</tr>
		<tr>
			<td>이름</td><td><%= rs.getString("NAME") %></td>
		</tr>
		<tr>
			<td>이메일</td><td><%= rs.getString("EMAIL") %></td>
		</tr>
	</table>
	<%
			} else {
	%>
	<%= memberID %>에 해당하는 정보가 존재하지 않습니다.
	<%
			}
		} catch(SQLException ex) {
	%>
	에러 발생: <%= ex.getMessage() %>
	<%
		} finally {
			if (rs != null) try { rs.close(); } catch(SQLException ex) {}
			if (stmt != null) try { stmt.close(); } catch(SQLException ex) {}
			if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
	%>
</body>
</html>