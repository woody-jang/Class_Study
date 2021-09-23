package kr.co.greenart;

import java.lang.reflect.Field;

public class PrintBox {
	public static void printBasic(Box b) {
		System.out.println(b.getName());
	}
	
	public static void printReflect(Box b) throws Exception {
		Class clazz = b.getClass();
		
		for (Field f : clazz.getDeclaredFields()) {
			f.setAccessible(true);
			if (f.getType() == String.class
					&& f.isAnnotationPresent(MyAnno.class)) {
				String value = (String) f.get(b);
				
				if (value == null || value.isEmpty()) {
					value = f.getAnnotation(MyAnno.class).value();
				}
				System.out.println(value);
			}
		}
	}
	public static void main(String[] args) throws Exception {
		printBasic(new Box());
		printReflect(new Box());
	}
}
