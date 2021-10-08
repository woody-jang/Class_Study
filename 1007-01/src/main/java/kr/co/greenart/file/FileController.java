package kr.co.greenart.file;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/file")
public class FileController {
	private Logger logger = LoggerFactory.getLogger(FileController.class);
	@Autowired
	private FileRepository repo;
	
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("list", repo.fileList());
		return "list";
	}
	
	@GetMapping("/upload")
	public String upload() {
		return "upload";
	}
	
	@PostMapping("/upload")
	public String postFile(@RequestParam MultipartFile userfile) {
		String fileName = userfile.getOriginalFilename();
		logger.info("사용자 업로드 파일 이름 : " + fileName);
		
		repo.save(userfile);
		
		return "redirect:/";
	}
	
	@GetMapping("/download")
	public ResponseEntity<Resource> downloadFile(@RequestParam String name) {
		try {
			name = URLDecoder.decode(name, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		logger.info("사용자 다운로드 요청 : " + name);
		
		Resource resource = repo.download(name);
		
		HttpHeaders headers = new HttpHeaders();
		try {
			headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM_VALUE);
			headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="
							+ URLEncoder.encode(name, "utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
	}
}




