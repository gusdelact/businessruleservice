package com.gfi.microservicios.model;

public class Item {
	public class Category {
      public final static String LOW_RANGE="L";
      public final static String HIGH_RANGE="H";
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	public Item(String category, float cost, float price) {
		super();
		this.category = category;
		this.cost = cost;
		this.price = price;
	}

	private String category;
	private float cost;
	private float price;

}
