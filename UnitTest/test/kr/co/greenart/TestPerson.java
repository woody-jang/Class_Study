package kr.co.greenart;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestPerson {
	private static PersonRepository repo;
	@BeforeClass
	public static void setup() {
		repo = new PersonRepository();
		repo.add(new Person("가", 10));
		repo.add(new Person("나", 10));
		repo.add(new Person("다", 10));
		repo.add(new Person("라", 10));
	}
	
	@Test
	public void test() {
		assertTrue(repo.add(new Person("추가추가", 22)));
	}
	
	@Test
	public void test1() {
		assertTrue(repo.delete(new Person("가", 10)));
	}
}
