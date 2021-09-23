package kr.co.greenart;

import java.util.ArrayList;
import java.util.List;

public class PersonRepository {
	private List<Person> list;
	
	public PersonRepository() {
		this.list = new ArrayList<Person>();
	}
	
	//추가
	public boolean add(Person p) {
		return list.add(p);
	}
	
	//삭제
	public boolean delete(Person p) {
		return list.remove(p);
	}
}
