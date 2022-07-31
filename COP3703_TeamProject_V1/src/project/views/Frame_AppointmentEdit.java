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
import javax.swing.JButton;
import javax.swing.JSpinner;
import com.toedter.calendar.JDateChooser;

public class Frame_AppointmentEdit extends JFrame {
	private JTextField textField_4;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame_AppointmentEdit frame = new Frame_AppointmentEdit();
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
	public Frame_AppointmentEdit() {
		setTitle("Big Bob's Band-aids & More");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Frame_AppointmentEdit.class.getResource("/project/resources/icon.png")));
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
		
		JLabel lblTitle = new JLabel("Edit Appointment");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitle.setBounds(262, 11, 291, 40);
		getContentPane().add(lblTitle);
		
		JLabel lblEnterAppointment = new JLabel("Enter Appointment #:");
		lblEnterAppointment.setFont(new Font("Dialog", Font.BOLD, 16));
		lblEnterAppointment.setBounds(10, 71, 196, 26);
		getContentPane().add(lblEnterAppointment);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Dialog", Font.PLAIN, 16));
		textField_4.setColumns(10);
		textField_4.setBounds(10, 96, 185, 26);
		getContentPane().add(textField_4);
		
		JButton btnLoad = new JButton("Load");
		btnLoad.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnLoad.setBounds(203, 97, 94, 25);
		getContentPane().add(btnLoad);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnDelete.setBounds(307, 97, 94, 25);
		getContentPane().add(btnDelete);
		
		JLabel lblNewLabel = new JLabel("Patient SSN:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel.setBounds(97, 183, 103, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblRoom = new JLabel("Room #:");
		lblRoom.setHorizontalAlignment(SwingConstants.LEFT);
		lblRoom.setFont(new Font("Dialog", Font.BOLD, 16));
		lblRoom.setBounds(97, 214, 91, 14);
		getContentPane().add(lblRoom);
		
		JLabel lblAppointmentTime = new JLabel("Appt. Date:");
		lblAppointmentTime.setHorizontalAlignment(SwingConstants.LEFT);
		lblAppointmentTime.setFont(new Font("Dialog", Font.BOLD, 16));
		lblAppointmentTime.setBounds(97, 239, 91, 25);
		getContentPane().add(lblAppointmentTime);
		
		JLabel lblApptTime = new JLabel("Appt Time: ");
		lblApptTime.setHorizontalAlignment(SwingConstants.LEFT);
		lblApptTime.setFont(new Font("Dialog", Font.BOLD, 16));
		lblApptTime.setBounds(97, 275, 91, 23);
		getContentPane().add(lblApptTime);
		
		JLabel lblDoctorName = new JLabel("Doctor's ID:");
		lblDoctorName.setHorizontalAlignment(SwingConstants.LEFT);
		lblDoctorName.setFont(new Font("Dialog", Font.BOLD, 16));
		lblDoctorName.setBounds(97, 309, 129, 20);
		getContentPane().add(lblDoctorName);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(236, 312, 130, 20);
		getContentPane().add(textField);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(236, 279, 130, 20);
		getContentPane().add(spinner);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().setFont(new Font("Dialog", Font.PLAIN, 16));
		dateChooser.setFont(new Font("Dialog", Font.PLAIN, 16));
		dateChooser.setDateFormatString("MM/dd/yyyy");
		dateChooser.setBounds(236, 244, 130, 20);
		getContentPane().add(dateChooser);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(236, 214, 130, 20);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(236, 183, 130, 20);
		getContentPane().add(textField_2);
		
		JLabel lblNewLabel_1 = new JLabel("Procedures");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_1.setBounds(462, 174, 97, 32);
		getContentPane().add(lblNewLabel_1);
		
		JCheckBox chckbxCheckup = new JCheckBox("Checkup");
		chckbxCheckup.setFont(new Font("Dialog", Font.PLAIN, 12));
		chckbxCheckup.setBounds(462, 216, 97, 23);
		getContentPane().add(chckbxCheckup);
		
		JCheckBox chckbxImmunizations = new JCheckBox("Immunizations");
		chckbxImmunizations.setFont(new Font("Dialog", Font.PLAIN, 12));
		chckbxImmunizations.setBounds(462, 242, 113, 23);
		getContentPane().add(chckbxImmunizations);
		
		JCheckBox chckbxPrescription = new JCheckBox("Prescription");
		chckbxPrescription.setFont(new Font("Dialog", Font.PLAIN, 12));
		chckbxPrescription.setBounds(462, 267, 97, 23);
		getContentPane().add(chckbxPrescription);
		
		JCheckBox chckbxConsultation = new JCheckBox("Consultation");
		chckbxConsultation.setFont(new Font("Dialog", Font.PLAIN, 12));
		chckbxConsultation.setBounds(462, 295, 97, 23);
		getContentPane().add(chckbxConsultation);
		
		
		
		
		
	}
	
	private void create_events() {
		
	}
}
