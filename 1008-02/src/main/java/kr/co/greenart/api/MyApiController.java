package kr.co.greenart.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/myapi")
public class MyApiController {
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
}
