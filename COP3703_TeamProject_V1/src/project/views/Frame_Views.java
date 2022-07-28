package project.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;
import project.common.jdbc_connection;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLayeredPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frame_Views extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame_Views frame = new Frame_Views();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection connection = null;
	private JTable table;
	private JButton btnActivePatients;
	private JButton btnActiveDoctors;
	private JButton btnUnpaidBills;
	private JButton btnOutstandingAppointments;
	private JButton btnPaidBills;
	private JButton btnBack;
	/**
	 * Create the frame.
	 */
	public Frame_Views() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Frame_Views.class.getResource("/project/resources/icon.png")));
		setTitle("Big Bob's Band-aids & More");
		init_components();
		create_events();
	}
	
	private void init_components() {
		connection = jdbc_connection.dbConnection(); // db connection
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 701, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// CENTERS THE THINGY
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		btnActivePatients = new JButton("Active Patients");
		
		btnActivePatients.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnActivePatients.setBounds(10, 82, 151, 38);
		contentPane.add(btnActivePatients);
		
		JLabel lblTitle = new JLabel("Reports");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitle.setBounds(51, 26, 73, 30);
		contentPane.add(lblTitle);
		
		btnActiveDoctors = new JButton("Active Doctors");
		btnActiveDoctors.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnActiveDoctors.setBounds(10, 130, 151, 38);
		contentPane.add(btnActiveDoctors);
		
		btnOutstandingAppointments = new JButton("<html>Outstanding Appointments</html>");
		
		btnOutstandingAppointments.setVerticalAlignment(SwingConstants.TOP);
		btnOutstandingAppointments.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnOutstandingAppointments.setBounds(10, 179, 151, 49);
		contentPane.add(btnOutstandingAppointments);
		
		btnUnpaidBills = new JButton("Unpaid Bills");
		
		btnUnpaidBills.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUnpaidBills.setBounds(10, 239, 151, 38);
		contentPane.add(btnUnpaidBills);
		
		btnPaidBills = new JButton("Paid Bills");
		
		btnPaidBills.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnPaidBills.setBounds(10, 288, 151, 38);
		contentPane.add(btnPaidBills);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(171, 49, 506, 326);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		table.setColumnSelectionAllowed(true);
		scrollPane.setViewportView(table);
		
		btnBack = new JButton("Back");
		
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBack.setBounds(10, 337, 151, 38);
		contentPane.add(btnBack);
	}
	
	private void create_events() {
		
		// active patients yes
		btnActivePatients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				select_views("report_activepatients");
			}
		});
		
		// active doctors
		btnActiveDoctors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				select_views("report_activedoctors");
			}
		});
		// outstanding appointments 
		btnOutstandingAppointments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				select_views("REPORT_APPOINTMENTSREMAINING");
			}
		});
		
		// unpaid bills
		btnUnpaidBills.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				select_views("report_unpaidbills");
			}
		});
		
		// paid bills
		btnPaidBills.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				select_views("report_customerpayments");
			}
		});
		
		// returns to main frame
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				dispose();
				Frame1.main(null);
			}
		});
	}
	
	private void select_views (String j) {
		String query = "SELECT * FROM " + j;
		try {
			PreparedStatement pStmt = connection.prepareStatement(query);
			ResultSet rs = pStmt.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			pStmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
