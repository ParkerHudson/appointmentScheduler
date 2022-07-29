package project.views;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JButton;

public class Frame_AppointmentCreate extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame_AppointmentCreate frame = new Frame_AppointmentCreate();
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
	public Frame_AppointmentCreate() {
		setTitle("Big Bob's Band-aids & More");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Frame_AppointmentCreate.class.getResource("/project/resources/icon.png")));
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
		
		JLabel lblTitle = new JLabel("Create New Appointment");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitle.setBounds(233, 11, 239, 40);
		getContentPane().add(lblTitle);
		
		textField = new JTextField();
		textField.setBounds(149, 206, 130, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Patient SSN:");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(10, 77, 103, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblRoom = new JLabel("Room #:");
		lblRoom.setFont(new Font("Dialog", Font.BOLD, 16));
		lblRoom.setHorizontalAlignment(SwingConstants.LEFT);
		lblRoom.setBounds(10, 108, 91, 14);
		getContentPane().add(lblRoom);
		
		JLabel lblAppointmentTime = new JLabel("Appt. Date:");
		lblAppointmentTime.setFont(new Font("Dialog", Font.BOLD, 16));
		lblAppointmentTime.setHorizontalAlignment(SwingConstants.LEFT);
		lblAppointmentTime.setBounds(10, 133, 91, 25);
		getContentPane().add(lblAppointmentTime);
		
		JLabel lblDoctorName = new JLabel("Doctor's Name:");
		lblDoctorName.setFont(new Font("Dialog", Font.BOLD, 16));
		lblDoctorName.setHorizontalAlignment(SwingConstants.LEFT);
		lblDoctorName.setBounds(10, 203, 129, 20);
		getContentPane().add(lblDoctorName);
		
		JLabel lblNewLabel_1 = new JLabel("Procedures");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(375, 68, 97, 32);
		getContentPane().add(lblNewLabel_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Checkup");
		chckbxNewCheckBox.setFont(new Font("Dialog", Font.PLAIN, 12));
		chckbxNewCheckBox.setBounds(375, 110, 97, 23);
		getContentPane().add(chckbxNewCheckBox);
		
		JCheckBox chckbxImmunizations = new JCheckBox("Immunizations");
		chckbxImmunizations.setFont(new Font("Dialog", Font.PLAIN, 12));
		chckbxImmunizations.setBounds(375, 136, 113, 23);
		getContentPane().add(chckbxImmunizations);
		
		JCheckBox chckbxPrescription = new JCheckBox("Prescription");
		chckbxPrescription.setFont(new Font("Dialog", Font.PLAIN, 12));
		chckbxPrescription.setBounds(375, 161, 97, 23);
		getContentPane().add(chckbxPrescription);
		
		JCheckBox chckbxConsultation = new JCheckBox("Consultation");
		chckbxConsultation.setFont(new Font("Dialog", Font.PLAIN, 12));
		chckbxConsultation.setBounds(375, 189, 97, 23);
		getContentPane().add(chckbxConsultation);
		
		JLabel lblApptTime = new JLabel("Appt Time: ");
		lblApptTime.setHorizontalAlignment(SwingConstants.LEFT);
		lblApptTime.setFont(new Font("Dialog", Font.BOLD, 16));
		lblApptTime.setBounds(10, 169, 91, 23);
		getContentPane().add(lblApptTime);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(149, 175, 130, 20);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(149, 138, 130, 20);
		getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(149, 108, 130, 20);
		getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(149, 77, 130, 20);
		getContentPane().add(textField_4);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.setFont(new Font("Dialog", Font.BOLD, 18));
		btnCreate.setBounds(375, 275, 97, 66);
		getContentPane().add(btnCreate);
		
		btnBack = new JButton("Back");
		btnBack.setFont(new Font("Dialog", Font.BOLD, 18));
		btnBack.setBounds(188, 275, 91, 66);
		getContentPane().add(btnBack);
		
		
		
		
	}
	
	private void create_events() {
	
	// returns to Frame_Apointment
	btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame_Appointment frame = new Frame_Appointment();
				frame.setVisible(true);
				dispose(); 
			}
		});
		
		
	}
}
