package project.views;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import net.proteanit.sql.DbUtils;

import javax.swing.JCheckBox;

public class Frame_BillAppointment extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame_BillAppointment frame = new Frame_BillAppointment();
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
	public Frame_BillAppointment() {
		setTitle("Big Bob's Band-aids & More");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Frame_BillAppointment.class.getResource("/project/resources/icon.png")));
		init_components();
		create_events();

	}
	
	private void init_components() {
		setBounds(100, 100, 733, 466);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// CENTERS THE THINGY
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Create New Appointments");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitle.setBounds(233, 11, 239, 40);
		getContentPane().add(lblTitle);
		
		textField = new JTextField();
		textField.setBounds(111, 77, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Patient SSN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 80, 91, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblRoom = new JLabel("Room #");
		lblRoom.setHorizontalAlignment(SwingConstants.CENTER);
		lblRoom.setBounds(10, 111, 91, 14);
		getContentPane().add(lblRoom);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(111, 108, 86, 20);
		getContentPane().add(textField_1);
		
		JLabel lblAppointmentTime = new JLabel("Appt. Date / Time");
		lblAppointmentTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblAppointmentTime.setBounds(10, 139, 91, 14);
		getContentPane().add(lblAppointmentTime);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(111, 136, 86, 20);
		getContentPane().add(textField_2);
		
		JLabel lblDoctorName = new JLabel("Doctor's Name");
		lblDoctorName.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoctorName.setBounds(10, 167, 91, 14);
		getContentPane().add(lblDoctorName);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(111, 164, 86, 20);
		getContentPane().add(textField_3);
		
		JLabel lblNewLabel_1 = new JLabel("Procedures");
		lblNewLabel_1.setBounds(375, 80, 85, 14);
		getContentPane().add(lblNewLabel_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Checkup");
		chckbxNewCheckBox.setBounds(375, 107, 97, 23);
		getContentPane().add(chckbxNewCheckBox);
		
		JCheckBox chckbxImmunizations = new JCheckBox("Immunizations");
		chckbxImmunizations.setBounds(375, 135, 97, 23);
		getContentPane().add(chckbxImmunizations);
		
		JCheckBox chckbxPrescription = new JCheckBox("Prescription");
		chckbxPrescription.setBounds(375, 163, 97, 23);
		getContentPane().add(chckbxPrescription);
		
		JCheckBox chckbxConsultation = new JCheckBox("Consultation");
		chckbxConsultation.setBounds(375, 194, 97, 23);
		getContentPane().add(chckbxConsultation);
		
		
		
		
		
	}
	
	private void create_events() {
		
	}
}
