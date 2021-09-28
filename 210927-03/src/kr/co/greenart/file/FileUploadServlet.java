package kr.co.greenart.file;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/fileupload")
@MultipartConfig(location = "D:\\temp", fileSizeThreshold = 1024 * 1024 * 10
	, maxFileSize = 1024 * 1024 * 50)
public class FileUploadServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/upload.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		Part p = req.getPart("upload");
		String filename = p.getSubmittedFileName();
		InputStream fileInputStream = p.getInputStream();
		
		FileDao dao = new FileDao();
		dao.insertFile(filename, fileInputStream);
		
		resp.sendRedirect(req.getContextPath());
	}
}










