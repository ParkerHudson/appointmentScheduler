package project.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;
import project.common.jdbc_connection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frame_BillsCreate extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame_BillsCreate frame = new Frame_BillsCreate();
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
	public Frame_BillsCreate() {
		setTitle("Big Bob's Band-aids & More");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Frame_BillsCreate.class.getResource("/project/resources/icon.png")));
		init_components();
		create_events();
	}
	
	Connection connection = null; // connection var
	private JComboBox cbSSN;
	private JButton btnBack;
	private JButton btnCreate;
	private JCheckBox chckbxConsultation;
	private JCheckBox chckbxPrescription;
	private JCheckBox chckbxImmunizations;
	private JCheckBox chckbxCheckup;
	private JComboBox cbAppID;
	private JComboBox cbDoctorID;
	private JLabel lblNewLabel_1_3;
	
	private void init_components() {
		// connection = jdbc_connection.dbConnection(); //db connection
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnBack = new JButton("Back");
		
		btnBack.setFont(new Font("CMU Serif", Font.PLAIN, 25));
		btnBack.setBounds(439, 311, 109, 61);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel = new JLabel("Create Bill");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel.setBounds(200, 11, 125, 34);
		contentPane.add(lblNewLabel);
		
		cbSSN = new JComboBox();
		cbSSN.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cbSSN.setBounds(252, 133, 131, 22);
		contentPane.add(cbSSN);
		
		JLabel lblNewLabel_1 = new JLabel("SSN");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(252, 108, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Procedures");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(45, 107, 96, 14);
		contentPane.add(lblNewLabel_1_1);
		
		chckbxConsultation = new JCheckBox("Consultation");
		chckbxConsultation.setFont(new Font("Dialog", Font.PLAIN, 16));
		chckbxConsultation.setBounds(38, 212, 139, 23);
		contentPane.add(chckbxConsultation);
		
		chckbxPrescription = new JCheckBox("Prescription");
		chckbxPrescription.setFont(new Font("Dialog", Font.PLAIN, 16));
		chckbxPrescription.setBounds(38, 184, 139, 23);
		contentPane.add(chckbxPrescription);
		
		chckbxImmunizations = new JCheckBox("Immunizations");
		chckbxImmunizations.setFont(new Font("Dialog", Font.PLAIN, 16));
		chckbxImmunizations.setBounds(38, 159, 155, 23);
		contentPane.add(chckbxImmunizations);
		
		chckbxCheckup = new JCheckBox("Checkup");
		chckbxCheckup.setFont(new Font("Dialog", Font.PLAIN, 16));
		chckbxCheckup.setBounds(38, 133, 107, 23);
		contentPane.add(chckbxCheckup);
		
		btnCreate = new JButton("Create");
		
		btnCreate.setFont(new Font("CMU Serif", Font.PLAIN, 23));
		btnCreate.setBounds(439, 239, 107, 61);
		contentPane.add(btnCreate);
		
		JLabel lblNewLabel_1_2 = new JLabel("Appointment ID");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(252, 188, 167, 19);
		contentPane.add(lblNewLabel_1_2);
		
		cbAppID = new JComboBox();
		cbAppID.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cbAppID.setBounds(252, 214, 131, 22);
		contentPane.add(cbAppID);
		
		cbDoctorID = new JComboBox();
		cbDoctorID.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cbDoctorID.setBounds(252, 305, 131, 22);
		contentPane.add(cbDoctorID);
		
		lblNewLabel_1_3 = new JLabel("Doctor ID");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_3.setBounds(252, 279, 167, 19);
		contentPane.add(lblNewLabel_1_3);
		
		// CENTERS THE THINGY
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
	}

	
	// event handling
	private void create_events() {
		
		// sets the combobox
		set_ssn();
		set_appID();
		set_docID();
		
		// returns to bill
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Frame_Bills bills = new Frame_Bills();
				bills.setVisible(true);
			}
		});
		
		// creates bill
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String patientSSN = cbSSN.getSelectedItem().toString();
				String query = "INSERT INTO bills VALUES (?, ?, billnumber.nextval, ?, ?, ?, ?, ?, ?)";
				try {
					PreparedStatement pStmt = connection.prepareStatement(query);
					
					
					pStmt.setString(5, patientSSN);
					//Add patientSSN
					pStmt.setString(5, patientSSN);
					
					int immunization = 125;
					int checkup = 250;
					int prescription = 40;
					int consultation = 200;
					double totalCharge = 0;
					String services = "";
					
					if(chckbxConsultation.isSelected()) {
						//increase totalCharge by 200
						totalCharge+=consultation;
						//add consultation to services
						services = services + "consultation,";
					}
					if(chckbxPrescription.isSelected()) {
						//increase totalCharge by 40
						totalCharge+=prescription;
						//add prescription to services
						services = services + "prescription,";
					}
					if(chckbxCheckup.isSelected()) {
						totalCharge+=checkup;
						services = services + "checkup,";
						
					}
					if(chckbxImmunizations.isSelected()) {
						totalCharge+=immunization;
						services = services + "immunizations,";
					}
					
					
					pStmt.setDouble(1, totalCharge);
					pStmt.setDouble(2, totalCharge);
					pStmt.setInt(3, 0);
					pStmt.setInt(4,0);
					pStmt.setString(6, cbAppID.getSelectedItem().toString());
					pStmt.setString(7, cbDoctorID.getSelectedItem().toString());
					pStmt.setString(8, services);
					
					pStmt.executeQuery();
					pStmt.close();
					JOptionPane.showMessageDialog(null, "Bill Created");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Cannot have identical bills");
				} 
				
				
			}
		});
		
	}
	
	private void set_ssn() {
		connection = jdbc_connection.dbConnection(); //db connection
		String query = "SELECT ssn FROM patients";
		ArrayList<String> list = new ArrayList<String>();
		try {
			PreparedStatement pStmt = connection.prepareStatement(query);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) { 
			    list.add(rs.getString(1));
			}
			cbSSN.setModel(new DefaultComboBoxModel<String>(list.toArray(new String[0])));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void set_appID() {
		connection = jdbc_connection.dbConnection(); //db connection
		String query = "SELECT apptnum FROM appointments";
		ArrayList<String> list = new ArrayList<String>();
		try {
			PreparedStatement pStmt = connection.prepareStatement(query);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) { 
			    list.add(rs.getString(1));
			}
			cbAppID.setModel(new DefaultComboBoxModel<String>(list.toArray(new String[0])));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void set_docID() {
		connection = jdbc_connection.dbConnection(); //db connection
		String query = "SELECT doctorid FROM doctors";
		ArrayList<String> list = new ArrayList<String>();
		try {
			PreparedStatement pStmt = connection.prepareStatement(query);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) { 
			    list.add(rs.getString(1));
			}
			cbDoctorID.setModel(new DefaultComboBoxModel<String>(list.toArray(new String[0])));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
