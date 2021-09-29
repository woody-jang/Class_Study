package kr.co.greenart.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.greenart.dao.UserDao;

@WebServlet("/user/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("사용자 로그인 요청");
		req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nickname = req.getParameter("nickname");
		String password = req.getParameter("password");
		System.out.println("사용자 로그인 아이디 : " + nickname);
		
		UserDao dao = new UserDao();
		int result = dao.login(nickname, password);
		if (result == 0) {
			req.setAttribute("loginError", "해당하는 유저 정보가 없습니다. 다시 확인해주세요.");
			req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
		} else {
			HttpSession session = req.getSession(false);
			session.setAttribute("user", nickname);
			resp.sendRedirect("/");
		}
	}
}






