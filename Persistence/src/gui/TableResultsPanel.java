package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;

import modellayer.Product;

public class TableResultsPanel extends JPanel implements ActionListener{
	
	private JTable table;
	private ResultsTableModel tModel;
	private JPopupMenu popup;
	private JMenuItem editItem;
	private ProductTransfer transfer;
	private ArrayList<Product> matches;
	
	public TableResultsPanel() {
		tModel = new ResultsTableModel();
		table = new JTable(tModel);
		popup = new JPopupMenu();
		
		editItem = new JMenuItem("Edit");
		popup.add(editItem);

		table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				
				int row = table.rowAtPoint(e.getPoint());
				table.getSelectionModel().setSelectionInterval(row, row);
				
				if(e.getButton() == MouseEvent.BUTTON1) {
					popup.show(table, e.getX(), e.getY());
				}
			}
			
		});
		
		editItem.addActionListener(this);
		
		setLayout(new BorderLayout());			
		add(new JScrollPane(table), BorderLayout.CENTER);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		int row;
		if(e.getSource() == editItem) {
			row = table.getSelectedRow();
			Product product = matches.get(row);
			SpinnerNumberModel sModel = new SpinnerNumberModel(0, 0, 30, 1);
			JSpinner spinner = new JSpinner(sModel);	        	
			int option = JOptionPane.showOptionDialog(table, spinner, "Enter amount", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
			if (option == JOptionPane.CANCEL_OPTION)
			{
  		 
			} else if (option == JOptionPane.OK_OPTION)
			{
				if(transfer != null) {
					int quantity = (int) spinner.getValue();					
					transfer.emit(product, quantity);
				}	
			}	
		}	
	}	
	
	public void refresh() {
		tModel.fireTableDataChanged();
	}
	
	public void setMatches(ArrayList<Product> matches) {
		tModel.setMatches(matches);
	}
	
	public void setInterface(ProductTransfer transfer) {
		this.transfer = transfer;
	}
}