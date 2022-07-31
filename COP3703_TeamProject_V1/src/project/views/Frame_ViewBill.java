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

public class Frame_ViewBill extends JFrame {
	private JTextField textField_4;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_5;

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
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(194, 267, 130, 20);
		getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(194, 169, 130, 20);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(194, 138, 130, 20);
		getContentPane().add(textField_2);
		
		JLabel lblNewLabel_1 = new JLabel("Procedures Completed");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_1.setBounds(427, 143, 185, 32);
		getContentPane().add(lblNewLabel_1);
		
		JCheckBox chckbxCheckup = new JCheckBox("Checkup");
		chckbxCheckup.setFont(new Font("Dialog", Font.PLAIN, 12));
		chckbxCheckup.setBounds(427, 185, 97, 23);
		getContentPane().add(chckbxCheckup);
		
		JCheckBox chckbxImmunizations = new JCheckBox("Immunizations");
		chckbxImmunizations.setFont(new Font("Dialog", Font.PLAIN, 12));
		chckbxImmunizations.setBounds(427, 211, 113, 23);
		getContentPane().add(chckbxImmunizations);
		
		JCheckBox chckbxPrescription = new JCheckBox("Prescription");
		chckbxPrescription.setFont(new Font("Dialog", Font.PLAIN, 12));
		chckbxPrescription.setBounds(427, 236, 97, 23);
		getContentPane().add(chckbxPrescription);
		
		JCheckBox chckbxConsultation = new JCheckBox("Consultation");
		chckbxConsultation.setFont(new Font("Dialog", Font.PLAIN, 12));
		chckbxConsultation.setBounds(427, 264, 97, 23);
		getContentPane().add(chckbxConsultation);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(194, 202, 130, 20);
		getContentPane().add(textField_3);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(194, 237, 130, 20);
		getContentPane().add(textField_5);
		
		
		
		
		
	}
	
	private void create_events() {
		
	}
}
