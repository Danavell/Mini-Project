package modellayer;

public class Product {
	
	private int prodID;
	private String prodName;
	private double salePrice;
	
	
	public Product(int prodID, String prodName, double salePrice) {
		this.prodID = prodID;
		this.prodName = prodName;
		this.salePrice = salePrice;
	}


	public int getProdID() {
		return prodID;
	}


	public void setProdID(int prodID) {
		this.prodID = prodID;
	}


	public String getProdName() {
		return prodName;
	}


	public void setProdName(String prodName) {
		this.prodName = prodName;
	}


	public double getSalePrice() {
		return salePrice;
	}


	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}
}
