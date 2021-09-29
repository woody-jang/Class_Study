package kr.co.greenart.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.greenart.dao.UserDao;
import kr.co.greenart.model.UserValidator;

@WebServlet(urlPatterns = "/user/join")
public class JoinServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("사용자 가입 요청");
		req.getRequestDispatcher("/WEB-INF/join.jsp")
			.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nickname = req.getParameter("nickname");
		String password = req.getParameter("password");
		System.out.println("사용자 닉네임 : " + nickname);
		UserValidator v = new UserValidator();
		List<String> errors = v.checkUserName(nickname);
		
		if (errors.size() > 0) {
			req.setAttribute("errors", errors);
			req.getRequestDispatcher("/WEB-INF/join.jsp").forward(req, resp);
		} else {
			UserDao dao = new UserDao();
			dao.insert(nickname, password);
			resp.sendRedirect("/");
		}
	}
}










