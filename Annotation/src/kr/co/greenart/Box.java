package kr.co.greenart;

public class Box {
	private int height;
	private int width;
	private String name;
	
	public Box() {
	}
	public Box(int height, int width, String name) {
		this.height = height;
		this.width = width;
		this.name = name;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Box [height=" + height + ", width=" + width + ", name=" + name + "]";
	}
}
