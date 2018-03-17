package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;

public class TableResultsPanel extends JPanel {
	
	private JTable table;
	private TableModel tModel;
	private JPopupMenu popup;
	
	public TableResultsPanel() {
		tModel = new TableModel();
		table = new JTable(tModel);
		popup = new JPopupMenu();
		
		JMenuItem editItem = new JMenuItem("Edit");
		
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
		
		editItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int row = table.getSelectedRow();
    			SpinnerNumberModel sModel = new SpinnerNumberModel(0, 0, 30, 1);
    			JSpinner spinner = new JSpinner(sModel);	        	
    			int option = JOptionPane.showOptionDialog(table, spinner, "Enter amount", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
    			if (option == JOptionPane.CANCEL_OPTION)
    			{
  	    		  
    			} else if (option == JOptionPane.OK_OPTION)
    			{
    				
    			}
			}		
		});		
		
		setLayout(new BorderLayout());
			
		add(new JScrollPane(table), BorderLayout.CENTER);
	}
}