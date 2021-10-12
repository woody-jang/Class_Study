package kr.co.greenart.person;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/persons")
public class PersonController {
	@Autowired
	private PersonRepository repo;

	@GetMapping
	public List<Person> getList() {
		return repo.getList();
	}

	@GetMapping("/{index}")
	public ResponseEntity<Person> getByIndex(@PathVariable int index) {
		try {
			return ResponseEntity.ok(repo.getByIndex(index));
		} catch (IndexOutOfBoundsException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public String postPerson(@RequestBody String json) {
		return json;
	}
}
