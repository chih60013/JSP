package com.lcpan.bean;

public class OrderBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private String bookno;
	private double price;
	private int quantity;
	
	public String getBookno() {
		return bookno;
	}
	public double getPrice() {
		return price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	
	public double getSubTotal() {
		return price * quantity;
	}
	
	
	public void setBookno(String bookno) {
		this.bookno = bookno;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
	
	
	
}
