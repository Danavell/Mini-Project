package controllerLayer;

import java.util.ArrayList;

import DbLayer.*;
import modellayer.Product;

public class ProductController {
	
	public ArrayList<Product> searchProductName(String name) {
        IFDBprod dbProd = new DBProduct();
        return dbProd.searchProductName(name);
	}
	
	public Product searchProductID(String id) {
        IFDBprod dbProd = new DBProduct();
        return dbProd.searchProductID(id);
	}
}
