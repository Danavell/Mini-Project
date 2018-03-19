package modellayer;

import java.util.ArrayList;

public class Product {
	
	private int quantity;	
	
	private final int prodID;
	private final String prodName;
	private final double salePrice;
	
	public Product(int prodID, String prodName, double salePrice) {
		this.prodID = prodID;
		this.prodName = prodName;
		this.salePrice = salePrice;
	}

	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public int getProdID() {
		return prodID;
	}


	public String getProdName() {
		return prodName;
	}


	public double getSalePrice() {
		return salePrice;
	}
}