package gui;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import modellayer.Product;

public class TableModel extends AbstractTableModel {

	private String[] colNames = {"Name", "Product ID", "Quantity", "Price"};
	private ArrayList<Product>matches;

	public String getColumnName(int column) {
		return colNames[column];
	}	
	
	@Override
	public int getColumnCount() {
		return colNames.length;
	}


	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setSaleLines(ArrayList<Product>matches) {
		this.matches = matches;
	}
	
	
}
