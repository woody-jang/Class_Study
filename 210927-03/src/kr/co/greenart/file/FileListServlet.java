package kr.co.greenart.file;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/filelist")
public class FileListServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		FileDao dao = new FileDao();
		List<FileInfo> list = dao.listFiles();
		
		req.setAttribute("list", list);
		req.getRequestDispatcher("/WEB-INF/list.jsp").forward(req, resp);
	}
}
