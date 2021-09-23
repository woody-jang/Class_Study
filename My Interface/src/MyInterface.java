public interface MyInterface<T> {
	void print(T t);
	T printAndReturn(T t);
	void printString(String a);
}

class MyImpl<T> implements MyInterface<T> {
	@Override
	public void print(T t) {
		System.out.println(t.toString());
	}

	@Override
	public void printString(String a) {
		System.out.println(a);
	}

	@Override
	public T printAndReturn(T t) {
		System.out.println(t.toString());
		return t;
	}
}