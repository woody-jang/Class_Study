<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
</head>
<body>
MEMBER 테이블의 내용
<table width="100%" border="1">
	<tr>
		<td>이름</td><td>아이디</td><td>이메일</td><td>이름 변경</td><td>삭제</td>
	</tr>
	<%
		// 1. JDBC 드라이버 로딩
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			String jdbcDriver = "jdbc:mysql://localhost:3306/my_db?" + "useUnicod=true&characterEncoding=utf8";
			String dbUser = "root";
			String dbPass = "root";
			
			String query = "SELECT * FROM MEMBER_TABLE order by MEMBERID";
			
			// 2. 데이터 베이스 커넥션 생성
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			
			// 3. Statement 생성
			stmt = conn.createStatement();
			
			// 4. 쿼리 실행
			rs = stmt.executeQuery(query);
			
			// 5. 쿼리 실행 결과 출력
			while (rs.next()) {
				%>
				<tr>
				<td><a href="viewMember.jsp?memberID=<%= rs.getString("MEMBERID") %>"><%= rs.getString("NAME") %></a></td>
				<td><%= rs.getString("MEMBERID") %></td>
				<td><a href="mailto:<%= rs.getString("EMAIL") %>"><%= rs.getString("EMAIL") %></a></td>
				<td><a href="update/updateForm.jsp?memberID=<%= rs.getString("MEMBERID") %>">이름 변경</a></td>
				<td><a href="delete.jsp?memberID=<%= rs.getString("MEMBERID") %>">삭제</a></td>
				</tr>
				<%
			}
		} catch (SQLException ex) {
			out.println(ex.getMessage());
			ex.printStackTrace();
		} finally {
			// 6. 사용한 Statement 종료
			if (rs != null) try { rs.close(); } catch (SQLException ex) {}
			if (stmt != null) try { stmt.close(); } catch (SQLException ex) {}
			
			// 7. 커넥션 종료 
			if (conn != null) try { conn.close(); } catch (SQLException ex) {}
		}
	%>
</table>
</body>
</html>