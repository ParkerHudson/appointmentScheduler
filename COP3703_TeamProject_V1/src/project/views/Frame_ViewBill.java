package project.views;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import net.proteanit.sql.DbUtils;
import project.common.input_verify;
import project.common.jdbc_connection;

import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JSpinner;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frame_ViewBill extends JFrame {
	private JTextField txtRemaining;
	private JTextField txtInsuranceCov;
	private JTextField txtPatientPay;
	private JTextField txtTotal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame_ViewBill frame = new Frame_ViewBill();
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
	public Frame_ViewBill() {
		setTitle("Big Bob's Band-aids & More");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Frame_ViewBill.class.getResource("/project/resources/icon.png")));
		init_components();
		create_events();

	}
	
	Connection connection = null; // connection var
	private JComboBox cbBillNum;
	private JButton btnLoad;
	private JButton btnBack;
	private JCheckBox chckbxCheckup;
	private JCheckBox chckbxImmunizations;
	private JCheckBox chckbxPrescription;
	private JCheckBox chckbxConsultation;
	private JComboBox cbPatientSSN;
	private JButton btnRefresh;
	private JButton btnSave;
	private JButton btnDelete;
	private void init_components() {
		setBounds(100, 100, 733, 466);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// CENTERS THE THINGY
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Bill Details");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitle.setBounds(10, 11, 697, 40);
		getContentPane().add(lblTitle);
		
		JLabel lblEnterAppointment = new JLabel("Enter Bill #:");
		lblEnterAppointment.setFont(new Font("Dialog", Font.BOLD, 16));
		lblEnterAppointment.setBounds(10, 71, 196, 26);
		getContentPane().add(lblEnterAppointment);
		
		btnLoad = new JButton("Load");
		
		btnLoad.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnLoad.setBounds(203, 97, 94, 25);
		getContentPane().add(btnLoad);
		
		btnDelete = new JButton("Delete");
		
		btnDelete.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnDelete.setBounds(307, 97, 94, 25);
		getContentPane().add(btnDelete);
		
		JLabel lblNewLabel = new JLabel("Patient SSN:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 141, 103, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblRoom = new JLabel("Insurance Coverage:");
		lblRoom.setHorizontalAlignment(SwingConstants.LEFT);
		lblRoom.setFont(new Font("Dialog", Font.BOLD, 16));
		lblRoom.setBounds(10, 172, 160, 14);
		getContentPane().add(lblRoom);
		
		JLabel lblAppointmentTime = new JLabel("Patient Payment:");
		lblAppointmentTime.setHorizontalAlignment(SwingConstants.LEFT);
		lblAppointmentTime.setFont(new Font("Dialog", Font.BOLD, 16));
		lblAppointmentTime.setBounds(10, 197, 160, 25);
		getContentPane().add(lblAppointmentTime);
		
		JLabel lblApptTime = new JLabel("Total: ");
		lblApptTime.setHorizontalAlignment(SwingConstants.LEFT);
		lblApptTime.setFont(new Font("Dialog", Font.BOLD, 16));
		lblApptTime.setBounds(10, 233, 91, 23);
		getContentPane().add(lblApptTime);
		
		JLabel lblDoctorName = new JLabel("Remaining:");
		lblDoctorName.setHorizontalAlignment(SwingConstants.LEFT);
		lblDoctorName.setFont(new Font("Dialog", Font.BOLD, 16));
		lblDoctorName.setBounds(10, 267, 129, 20);
		getContentPane().add(lblDoctorName);
		
		txtRemaining = new JTextField();
		txtRemaining.setColumns(10);
		txtRemaining.setBounds(194, 267, 130, 20);
		getContentPane().add(txtRemaining);
		
		txtInsuranceCov = new JTextField();
		txtInsuranceCov.setColumns(10);
		txtInsuranceCov.setBounds(194, 169, 130, 20);
		getContentPane().add(txtInsuranceCov);
		
		JLabel lblNewLabel_1 = new JLabel("Procedures Completed");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_1.setBounds(427, 143, 185, 32);
		getContentPane().add(lblNewLabel_1);
		
		chckbxCheckup = new JCheckBox("Checkup");
		chckbxCheckup.setFont(new Font("Dialog", Font.PLAIN, 12));
		chckbxCheckup.setBounds(427, 185, 97, 23);
		getContentPane().add(chckbxCheckup);
		
		chckbxImmunizations = new JCheckBox("Immunizations");
		chckbxImmunizations.setFont(new Font("Dialog", Font.PLAIN, 12));
		chckbxImmunizations.setBounds(427, 211, 113, 23);
		getContentPane().add(chckbxImmunizations);
		
		chckbxPrescription = new JCheckBox("Prescription");
		chckbxPrescription.setFont(new Font("Dialog", Font.PLAIN, 12));
		chckbxPrescription.setBounds(427, 236, 97, 23);
		getContentPane().add(chckbxPrescription);
		
		chckbxConsultation = new JCheckBox("Consultation");
		chckbxConsultation.setFont(new Font("Dialog", Font.PLAIN, 12));
		chckbxConsultation.setBounds(427, 264, 97, 23);
		getContentPane().add(chckbxConsultation);
		
		txtPatientPay = new JTextField();
		txtPatientPay.setColumns(10);
		txtPatientPay.setBounds(194, 202, 130, 20);
		getContentPane().add(txtPatientPay);
		
		txtTotal = new JTextField();
		txtTotal.setColumns(10);
		txtTotal.setBounds(194, 237, 130, 20);
		getContentPane().add(txtTotal);
		
		btnRefresh = new JButton("Refresh");
		
		btnRefresh.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnRefresh.setBounds(379, 342, 94, 60);
		getContentPane().add(btnRefresh);
		
		btnSave = new JButton("Save");
		
		btnSave.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnSave.setBounds(587, 342, 94, 60);
		getContentPane().add(btnSave);
		
		btnBack = new JButton("Back");
		
		btnBack.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnBack.setBounds(483, 342, 94, 60);
		getContentPane().add(btnBack);
		
		cbBillNum = new JComboBox();
		cbBillNum.setBounds(8, 99, 185, 26);
		getContentPane().add(cbBillNum);
		
		cbPatientSSN = new JComboBox();
		cbPatientSSN.setEditable(true);
		cbPatientSSN.setBounds(194, 133, 130, 23);
		getContentPane().add(cbPatientSSN);
		
	}
	
	private void create_events() {
		set_bill();
		set_patientSSN();
		
		// loads bill data
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display_info(cbBillNum.getSelectedItem().toString());
				display_services(cbBillNum.getSelectedItem().toString());
			}
		});
		
		// returns to bills
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			Frame_Bills bills = new Frame_Bills();
			bills.setVisible(true);
			}
		});
		
		// edits bills
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				edit_info(cbBillNum.getSelectedItem().toString());
			}
		});
		
		// refreshes data
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display_info(cbBillNum.getSelectedItem().toString());
				display_services(cbBillNum.getSelectedItem().toString());
			}
		});
		
		// deletes 
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int action = JOptionPane.showConfirmDialog(null, "Do you really want to delete?","Choose an option",JOptionPane.YES_NO_OPTION);
				if (action == 0) {
					delete_bill(cbBillNum.getSelectedItem().toString());
				}
			}
		});
	}
	
	private void set_bill() {
		connection = jdbc_connection.dbConnection(); //db connection
		String query = "SELECT billnumber FROM bills";
		ArrayList<String> list = new ArrayList<String>();
		try {
			PreparedStatement pStmt = connection.prepareStatement(query);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) { 
			    list.add(rs.getString(1));
			}
			cbBillNum.setModel(new DefaultComboBoxModel<String>(list.toArray(new String[0])));
			pStmt.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void set_patientSSN() {
		connection = jdbc_connection.dbConnection(); //db connection
		String query = "SELECT bills_ssn FROM bills";
		ArrayList<String> list = new ArrayList<String>();
		try {
			PreparedStatement pStmt = connection.prepareStatement(query);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) { 
			    list.add(rs.getString(1));
			}
			cbPatientSSN.setModel(new DefaultComboBoxModel<String>(list.toArray(new String[0])));
			pStmt.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void display_info(String id) {
		try {
			String query = "SELECT bills_ssn, amtinsur, amtpatient, totalcharge, final_amtdue FROM bills WHERE billnumber = '" + id + "'";
			PreparedStatement pStmt = connection.prepareStatement(query);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				cbPatientSSN.getEditor().setItem(rs.getString(1));
				txtInsuranceCov.setText(rs.getString(2));
				txtPatientPay.setText(rs.getString(3));
				txtTotal.setText(rs.getString(4));
				txtRemaining.setText(rs.getString(5));
				
			}	
			pStmt.close();
		} catch (SQLException e1) {	
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "Uhhh something got bonked..");
		}
	}
	
	private void display_services(String id) {
		String query = "SELECT services FROM bills WHERE billnumber = '" + id + "'";
		String services = "";
		try {
			PreparedStatement pStmt = connection.prepareStatement(query);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				services = rs.getString(1);
			}	
			if (services.contains("checkup")) {
				chckbxCheckup.setSelected(true);
			}
			if (services.contains("immunizations")) {
				chckbxImmunizations.setSelected(true);
			}
			if (services.contains("prescription")) {
				chckbxPrescription.setSelected(true);
			}
			if (services.contains("consultation")) {
				chckbxConsultation.setSelected(true);
			}
		} catch(SQLException e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "Uhhh something got bonked..");
		}
	}
	
	private void edit_info(String id) { 	
		try {
			int immunization = 125;
			int checkup = 250;
			int prescription = 40;
			int consultation = 200;
			double totalCharge = 0;
			int insuranceCov = Integer.parseInt(txtInsuranceCov.getText());
			int patientCov = Integer.parseInt(txtPatientPay.getText());
			String services = "";
			
			String query = "UPDATE bills SET amtinsur=?, amtpatient=?, totalcharge=?, final_amtdue=?, services=? WHERE bills_ssn=?";
			PreparedStatement pStmt = connection.prepareStatement(query);
			pStmt.setString(6, cbPatientSSN.getSelectedItem().toString());	
			pStmt.setInt(1, insuranceCov);
			pStmt.setInt(2, patientCov);
			
			
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
			pStmt.setDouble(3, totalCharge);
			
			
			double finalAmt = totalCharge - (insuranceCov + patientCov);
			pStmt.setDouble(4, finalAmt);
			pStmt.setString(5, services);
			
			pStmt.execute();
			JOptionPane.showMessageDialog(null, "Bill Updated");	
			pStmt.close();
			
			display_info(cbBillNum.getSelectedItem().toString());
			display_services(cbBillNum.getSelectedItem().toString());
			
		} catch (SQLException e) {
			e.printStackTrace();

		}
		
	}
	
	private void delete_bill (String id) {
		String query = "DELETE FROM bills WHERE billnumber=?";
		try {
			PreparedStatement pStmt = connection.prepareStatement(query);
			pStmt.setString(1, id);	
			pStmt.executeQuery();
			JOptionPane.showMessageDialog(null, "Bill Deleted");
			pStmt.close();
		} catch (java.sql.SQLException e1) {
			e1.printStackTrace();
		}
	}
}
