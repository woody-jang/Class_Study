package kr.co.greenart;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class Test1 {
	private static MyClass m;
	
	@BeforeClass
	public static void setup() {
		m = new MyClass();
	}
	
	@Test
	public void test() {
		assertEquals(10, 10); // 두개의 값이 같으면 통과
	}
	
	@Test
	public void test2() {
		assertEquals(10, m.sum(5, 5));
	}
	
	@Test
	public void test3() {
		assertEquals(5, m.minus(15, 10));
	}
	
	@Test
	public void test4() {
		Object a = new Object();
		Object b = new Object();
		
		assertSame(a, b);
	}

}
