package kr.co.greenart;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("사용자 요청을 처리하는 중");
		LocalDateTime now = LocalDateTime.now();
		req.setAttribute("now", now);
		
		req.getRequestDispatcher("/WEB-INF/myjsp.jsp").forward(req, resp);
		
//		PrintWriter out = resp.getWriter();
//		out.println("<!DOCTYPE html>");
//		out.println("<html>");
//		out.println("<head>");
//		out.println("<title>Servlet service</title>");
//		out.println("</head>");
//		out.println("<body>");
//		out.println("<h1>Hello Servlet</h1>");
//		out.println("</body>");
//		out.println("</html>");
	}
	
}
