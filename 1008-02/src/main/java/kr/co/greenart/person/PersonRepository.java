package kr.co.greenart.person;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class PersonRepository {
	private List<Person> list;

	public PersonRepository() {
		list = new ArrayList<Person>();
		list.add(new Person("Tom", 55));
		list.add(new Person("Brad", 66));
	}

	public List<Person> getList() {
		return list;
	}

	public Person getByIndex(int index) {
		return list.get(index);
	}
}
