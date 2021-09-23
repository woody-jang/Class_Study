public class Test {
	public static void main(String[] args) {
		MyInterface<Double> m = new MyImpl<Double>();
		
		m.print(Double.valueOf("3.14"));
//		m.print(Integer.valueOf(234));
		m.printString("a");
//		m.printString(Integer.MAX_VALUE);
	}
}
