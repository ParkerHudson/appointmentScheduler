package project.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;
import project.common.jdbc_connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

public class Frame_Appointment extends JFrame {

	private JPanel contentPane;
	private JButton btnEdit;
	private JButton btnBack;
	private JScrollPane scrollPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame_Appointment frame = new Frame_Appointment();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection = null; // connection var
	private JButton btnCreate;

	/**
	 * Creates the frame.
	 */
	public Frame_Appointment() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Frame_Appointment.class.getResource("/project/resources/icon.png")));
		setTitle("Big Bob's Band-aids & More");
		init_components();
		create_events();
	}
	
	private void init_components() {
		connection = jdbc_connection.dbConnection(); //db connection
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 905, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		// CENTERS THE THINGY
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		setContentPane(contentPane);
		
		btnEdit = new JButton("Edit");
		btnEdit.setBounds(15, 173, 212, 57);
		
		btnEdit.setFont(new Font("CMU Serif", Font.PLAIN, 25));
		
		btnBack = new JButton("Back");
		btnBack.setBounds(15, 241, 212, 57);
		
		btnBack.setFont(new Font("CMU Serif", Font.PLAIN, 25));
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(245, 16, 629, 335);
		
		JLabel lblAppointments = new JLabel("Appointments");
		lblAppointments.setBounds(32, 35, 181, 32);
		lblAppointments.setFont(new Font("CMU Serif", Font.BOLD, 24));
		
		btnCreate = new JButton("Create");
		btnCreate.setBounds(15, 105, 212, 57);
		btnCreate.setFont(new Font("CMU Serif", Font.PLAIN, 25));
		
		table = new JTable();
		table.setColumnSelectionAllowed(true);
		scrollPane.setViewportView(table);
		
		
		try {
			String query = "SELECT * FROM appointments";
			PreparedStatement pStmt = connection.prepareStatement(query);
			ResultSet rs = pStmt.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		contentPane.setLayout(null);
		contentPane.add(btnBack);
		contentPane.add(btnEdit);
		contentPane.add(btnCreate);
		contentPane.add(lblAppointments);
		contentPane.add(scrollPane);
		
	}
	
	//////////////////////////////////////////////////////////
	// EVENT HANDLING
	//////////////////////////////////////////////////////////

	private void create_events() {
		
		
		// Switches to the Frame1 (main menu frame)
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				dispose();
				Frame1.main(null);
			}
		});
		
		// Switches to the Create Patient Frame
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame_PatientCreate createPatient;
				try {
					createPatient = new Frame_PatientCreate();
					createPatient.setVisible(true);
					dispose();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		// Switches to the Edit Patient Frame
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame_PatientEdit editPatient = new Frame_PatientEdit();
				editPatient.setVisible(true);
				dispose();
			}
		});
	}
}
