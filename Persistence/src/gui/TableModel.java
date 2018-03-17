package gui;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class TableModel extends AbstractTableModel {

	private String[] colNames = {"Name", "Product ID", "Quantity", "Price"};

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
	
	

}
