package kr.co.greenart.model;

public class Phone {
	private int id;
	private String model;
	private String production;
	private int amount;
	private int price;
	
	public Phone() {}

	public Phone(int id, String model, String production, int amount, int price) {
		super();
		this.id = id;
		this.model = model;
		this.production = production;
		this.amount = amount;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getProduction() {
		return production;
	}

	public void setProduction(String production) {
		this.production = production;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Phone [id=" + id + ", model=" + model + ", production=" + production + ", amount=" + amount + ", price="
				+ price + "]";
	}
}
