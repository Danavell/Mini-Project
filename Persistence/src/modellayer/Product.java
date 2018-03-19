package modellayer;

public class Product {
	
	private static int count = 1;
	private int quantity;	
	
	private int ProdID;
	private final String ProdName;
	private final double SalePrice;
	private double SupplierPrice;
	private double RentPrice;
	private int Stock;
	private int MinStock;
	private int SupplierID;
	
	public Product(String prodName, double salePrice,double SupplierPrice,double RentPrice,int stock,int minstock,int supplierid) {
		
		this.ProdName = prodName;
		this.SalePrice = salePrice;
		this.SupplierPrice = SupplierPrice;
		this.RentPrice = RentPrice;
		this.Stock = stock;
		this.MinStock = minstock;
		this.SupplierID = supplierid;
		
		
		this.ProdID = count;
		count++;
	}
	
	public Product(int id, String prodName, double salePrice,double SupplierPrice,double RentPrice,int stock,int minstock,int supplierid) {
		
		this(prodName, salePrice, SupplierPrice, RentPrice, stock, minstock, supplierid);
		this.ProdID = id;
	
	}

	public double getSupplierPrice() {
		return SupplierPrice;
	}

	public void setSupplierPrice(double supplierPrice) {
		SupplierPrice = supplierPrice;
	}

	public double getRentPrice() {
		return RentPrice;
	}

	public void setRentPrice(double rentPrice) {
		RentPrice = rentPrice;
	}

	public int getStock() {
		return Stock;
	}

	public void setStock(int stock) {
		Stock = stock;
	}

	public int getMinStock() {
		return MinStock;
	}

	public void setMinStock(int minStock) {
		MinStock = minStock;
	}

	public int getSupplierID() {
		return SupplierID;
	}

	public void setSupplierID(int supplierID) {
		SupplierID = supplierID;
	}

	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public int getProdID() {
		return ProdID;
	}


	public String getProdName() {
		return ProdName;
	}


	public double getSalePrice() {
		return SalePrice;
	}
}