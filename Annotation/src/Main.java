import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import kr.co.greenart.Box;

public class Main {
	public static void init1() throws Exception {
		Class c = Box.class;
		Box b = (Box) c.newInstance();
		b.setHeight(100);
		b.setWidth(50);
		b.setName("새 박스");
		System.out.println(b);
	}
	
	public static void init2() throws Exception {
//		Box b = new Box();
		Class c = Class.forName("kr.co.greenart.Box");
		Constructor<Box> cons = c.getConstructor(int.class, int.class, String.class);
		Box b = cons.newInstance(10, 10, "두번째 박스");
		System.out.println(b);
	}
	
	public static void main(String[] args) {
		Class c = Box.class;
		
		Method[] methods = c.getDeclaredMethods();
		for (Method m : methods) {
			System.out.println(m.getName());
			System.out.println("- " + m.getParameterCount());
			System.out.println("- " + m.getReturnType());
			System.out.println();
		}
		
		Field[] fields = c.getDeclaredFields();
		for (Field f : fields) {
			System.out.print(f.getName());
			System.out.println(" - " + f.getType());
		}
	}
}
