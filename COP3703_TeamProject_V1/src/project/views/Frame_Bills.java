	package project.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;
import project.common.jdbc_connection;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frame_Bills extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame_Bills frame = new Frame_Bills();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the frame.
	 */
	public Frame_Bills() {
		setTitle("Big Bob's Band-aids & More");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Frame_Bills.class.getResource("/project/resources/icon.png")));
		init_components();
		create_events();
	}
	
	Connection connection = null; // connection var
	private JButton btnBack;
	private JButton btnEdit;
	private JButton btnCreate;
	
	private void init_components() {
		connection = jdbc_connection.dbConnection(); //db connection
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1156, 585);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPatients = new JLabel("Bills");
		lblPatients.setFont(new Font("CMU Serif", Font.BOLD, 24));
		lblPatients.setBounds(80, 26, 62, 32);
		contentPane.add(lblPatients);
		
		btnCreate = new JButton("Create");
		
		btnCreate.setFont(new Font("CMU Serif", Font.PLAIN, 25));
		btnCreate.setBounds(10, 71, 212, 57);
		btnCreate.setEnabled(false);
		contentPane.add(btnCreate);
		
		
		btnEdit = new JButton("Edit");
		
		btnEdit.setFont(new Font("CMU Serif", Font.PLAIN, 25));
		btnEdit.setBounds(10, 139, 212, 57);
		contentPane.add(btnEdit);
		
		btnBack = new JButton("Back");
		
		btnBack.setFont(new Font("CMU Serif", Font.PLAIN, 25));
		btnBack.setBounds(10, 207, 212, 57);
		contentPane.add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(235, 11, 895, 524);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setColumnSelectionAllowed(true);
		scrollPane.setViewportView(table);
		
		try {
			String query = "SELECT * FROM bills";
			PreparedStatement pStmt = connection.prepareStatement(query);
			ResultSet rs = pStmt.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// CENTERS THE THINGY
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		
				
	}
	
	
	// event handling
	private void create_events() {
		
		//create 
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Frame_BillsCreate bill_create = new Frame_BillsCreate();
				bill_create.setVisible(true);
			}
		});
		
		// back
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				dispose();
				Frame1.main(null);
			}
		});
		
		// edit
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame_ViewBill view_bill = new Frame_ViewBill();
				view_bill.setVisible(true);
				dispose();
			}
		});
	}
}
