package DBLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modellayer.Product;

public class DbProduct {

	private ArrayList<Product> products;
	private Connection con = DbConnection.getInstance().getDBcon();
	
	public DbProduct()
	{
		products = new ArrayList<>();
	}
	public void addProduct(Product product)
	{
		products.add(product);
	}
	
	public void save() throws SQLException
	{
		String checkSql = "select count(*) as count from Product where prodID=?";
		PreparedStatement checkStatement = con.prepareStatement(checkSql);
		
		String insertSql = "insert into Product (ProdID, ProdName, Saleprice, SupplierPrice, RentPrice, Stock, MinStock, SupplierID) values (?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement insertStatement = con.prepareStatement(insertSql);
		
		String updateSql = "update Product set ProdName=?, Saleprice=?, SupplierPrice=?, RentPrice=?, Stock=?, MinStock=?, SupplierID=? where ProdID=?";
		PreparedStatement updateStatement = con.prepareStatement(updateSql);
		
		for(Product product: products)
		{
			int id = product.getProdID();
			String name = product.getProdName();
			double price = product.getSalePrice();
			double supplierprice = product.getSupplierPrice();
			double rentprice = product.getRentPrice();
			int stock = product.getStock();
			int minstock = product.getMinStock();
			int supplierid = product.getSupplierID();
			
			
			checkStatement.setInt(1, id);
			
			ResultSet checkResult = checkStatement.executeQuery();
			checkResult.next();
			
			int count = checkResult.getInt(1);
			
			if(count == 0)
			{
				System.out.println("Inserting product with ID " + id);
				
				int number = 1;
				insertStatement.setInt(number++, id);
				insertStatement.setString(number++, name);
				insertStatement.setDouble(number++, price);
				insertStatement.setDouble(number++, supplierprice);
				insertStatement.setDouble(number++, rentprice);
				insertStatement.setInt(number++, stock);
				insertStatement.setInt(number++, minstock);
				insertStatement.setInt(number++, supplierid);
				
				
				insertStatement.executeUpdate();
			}
			else
			{
				System.out.println("Updating product with ID " + id);
				
				int number = 1;
				updateStatement.setString(number++, name);
				updateStatement.setDouble(number++, price);
				updateStatement.setDouble(number++, supplierprice);
				updateStatement.setDouble(number++, rentprice);
				updateStatement.setInt(number++, stock);
				updateStatement.setInt(number++, minstock);
				updateStatement.setInt(number++, supplierid);
				updateStatement.setInt(number++, id);
				
				
				updateStatement.executeUpdate();
			}
		}
		updateStatement.close();
		insertStatement.close();
		checkStatement.close();
	
	}
	public void load() throws SQLException
	{
		products.clear();
		
		String sql = "select * from Product";
		Statement selectStatement = con.createStatement();
		
		ResultSet results = selectStatement.executeQuery(sql);
		
		while(results.next())
		{
			int id = results.getInt("ProdID");
			String name = results.getString("ProdName");
			double price = results.getDouble("Saleprice");
			double supplierprice = results.getDouble("SupplierPrice");
			double rentprice = results.getDouble("RentPrice");
			int stock = results.getInt("Stock");
			int minstock = results.getInt("MinStock");
			int supplierid = results.getInt("SupplierID");
			
			Product product = new Product(id,name,price,supplierprice,rentprice,stock,minstock,supplierid);
			products.add(product);
			
			System.out.println(product.getProdName());
		}
		
		
		
		
	}
}