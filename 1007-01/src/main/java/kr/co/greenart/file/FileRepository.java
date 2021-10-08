package kr.co.greenart.file;

import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileRepository {
	// 저장
	void save(MultipartFile file);
	// 목록
	List<String> fileList();
	// 다운로드
	Resource download(String fileName);
}
