package kr.co.greenart.file;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
@Primary
public class SystemFileRepository implements FileRepository {
	private final Logger logger = LoggerFactory.getLogger(SystemFileRepository.class);
	private final Path filePath;

	public SystemFileRepository() {
		this.filePath = Paths.get("C:\\Users\\zkm02\\Desktop");
	}

	@Override
	public void save(MultipartFile file) {
		Path dest = this.filePath.resolve(Paths.get(file.getOriginalFilename())).normalize().toAbsolutePath();

		logger.info(dest.toString());

		try {
			file.transferTo(dest);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<String> fileList() {
		List<String> list = null;
		try {
			list = Files.walk(filePath, 1).filter(p -> !p.equals(this.filePath))
					.map(f -> this.filePath.relativize(f).toString()).collect(Collectors.toList());
//			Stream<Path> stream =  Files.walk(filePath, 1);
//			for (Object p : stream.toArray()) {
//				System.out.println(p);
//			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Resource download(String fileName) {
		Path file = this.filePath.resolve(fileName);
		try {
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists()) {
				return resource;
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
