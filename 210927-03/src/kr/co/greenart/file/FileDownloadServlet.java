package kr.co.greenart.file;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/download")
public class FileDownloadServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		FileDao dao = new FileDao();
		FileInfo fileInfo = dao.selectFile(id);
		
		resp.setContentType("application/octet-stream");
//		resp.setHeader("Content-Type", value);
		resp.setHeader("Content-Disposition", "attachment; filename="
													+ URLEncoder.encode(fileInfo.getFileName()));
		
		ServletOutputStream output = resp.getOutputStream();
		byte[] file = fileInfo.getFile();
		output.write(file, 0, file.length);
	}
}
