package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import modellayer.Product;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JButton;

public class ProcessOrders extends JFrame {

	private JPanel contentPane;
	private JTextField TotalTextField;
	private JLabel lblTotal;
	private JButton btnAddCustomer;
	private JTextField CustomerTextField;
	private JLabel lblNewLabel;
	private JButton btnProcessOrder;
	private TablePanel table;
	private TableResultsPanel search;
	private JTextField productNameSearch;
	private JTextField textField;
	private JButton btnSearch;
	private ProductTransfer transfer;
	private ArrayList<Product>sales = new ArrayList<>();	
	private double runningTotal;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProcessOrders frame = new ProcessOrders();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public ProcessOrders() {		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 915, 507);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		runningTotal = 0.0;
		
		
		btnAddCustomer = new JButton("Add Customer");
		btnProcessOrder = new JButton("Process Order");
		
		
		lblNewLabel = new JLabel("Customer:");
		lblTotal = new JLabel("Total:");
		JLabel lblSearchProductName = new JLabel("Search Product Name:");
		
		
		TotalTextField = new JTextField();
		TotalTextField.setEditable(false);
		TotalTextField.setColumns(10);
		TotalTextField.setText(Double.toString(runningTotal));
				
		CustomerTextField = new JTextField();
		CustomerTextField.setEditable(false);
		CustomerTextField.setColumns(10);
		
		productNameSearch = new JTextField();
		productNameSearch.setColumns(10);
		
		
		table = new TablePanel();
		
		
		table.setDeleteInterface(new DeleteRow() {
			public void delete(int row) {
				sales.remove(row);
			}
		});
		
		
		search = new TableResultsPanel();
		
		search.setInterface(new ProductTransfer() {
			public void emit(Product product) {
				double price = product.getSalePrice() * product.getQuantity();
				runningTotal += price;
				TotalTextField.setText(Double.toString(runningTotal));
				sales.add(product);
				
				table.setMatch(product);
				table.refresh();				
			}			
		});
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Product>matches = new ArrayList<>();
				matches.add(new Product(1, "hammer", 2.5));
				search.setMatches(matches);
				search.refresh();
			}
		});
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblSearchProductId = new JLabel("Search Product ID:");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSearchProductName)
								.addComponent(lblSearchProductId, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(productNameSearch, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
							.addGap(199)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnAddCustomer, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblNewLabel))
								.addComponent(lblTotal))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(CustomerTextField)
								.addComponent(TotalTextField, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
								.addComponent(search, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(table, GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
								.addComponent(btnProcessOrder, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(search, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
						.addComponent(table, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(TotalTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTotal)
						.addComponent(lblSearchProductName)
						.addComponent(productNameSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(CustomerTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel)
						.addComponent(btnAddCustomer)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSearchProductId))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnProcessOrder, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}