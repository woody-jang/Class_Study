package kr.co.greenart.person;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/personList")
public class PersonListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String func = request.getParameter("func");
		PersonDAO dao = new PersonDAO();
		List<Person> personList = dao.read();
		request.setAttribute("personList", personList);
		if (func == null)
			request.getRequestDispatcher("WEB-INF/showlist.jsp").forward(request, response);
		else if (func.equals("delete"))
			request.getRequestDispatcher("/WEB-INF/delete.jsp").forward(request, response);
		else if (func.equals("update"))
			request.getRequestDispatcher("/WEB-INF/update.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String name = req.getParameter("name");
		PersonDAO dao = new PersonDAO();
		List<Person> personList = dao.read(name);
		req.setAttribute("search", name);
		req.setAttribute("personList", personList);
		req.getRequestDispatcher("WEB-INF/showlist.jsp").forward(req, resp);
	}

}
