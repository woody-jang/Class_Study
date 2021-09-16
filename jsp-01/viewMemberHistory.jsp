<%@page import="java.sql.SQLException"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.Reader"%>
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
			String query = "SELECT * FROM MEMBER_HISTORY WHERE MEMBERID = ?";
			
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			
			stmt = conn.prepareStatement(query);
			stmt.setString(1, memberID);
			
			rs = stmt.executeQuery();
			
			if (rs.next()) {
	%>
	<table border="1">
		<tr>
			<td>아이디</td><td><%= memberID %></td>
		</tr>
		<tr>
			<td>히스토리</td>
			<td>
				<%
					String history = null;
					Reader reader = null;
					try {
						reader = rs.getCharacterStream("HISTORY");
						
						if (reader != null) {
							StringBuilder buff = new StringBuilder();
							char[] ch = new char[512];
							int len = -1;
							
							while ((len = reader.read(ch)) != -1) {
								buff.append(ch, 0, len);
							}
							
							history = buff.toString();
						}
					} catch (IOException ex) {
						out.println("익셉션 발생: " + ex.getMessage());
					} finally {
						if (reader != null) try { reader.close(); } catch(IOException ex) {}
					}
				%>
				<%= history %>
			</td>
		</tr>
	</table>
	<%
			} else {
	%>
	<%= memberID %> 회원의 히스토리가 없습니다.
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