package controllerLayer;

import java.util.ArrayList;

import DbLayer.DBSales;
import DbLayer.IFDBSales;
import modellayer.Product;

public class SalesController {

	public void makeSale(ArrayList<Product>sale) {
        IFDBSales dbSales = new DBSales();
        dbSales.makeSale(sale);
	}
}
