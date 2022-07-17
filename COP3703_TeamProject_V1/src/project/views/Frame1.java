package project.views;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;

import projects.common.jdbc_connection;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Frame1 {

	private JFrame frame1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 window = new Frame1();
					window.frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection = null;
	private JButton btnPatient;
	private JButton btnDoctors;
	private JButton btnAppointments;
	private JButton btnBills;
	
	/**
	 * Create the application.
	 */
	public Frame1() {
		initialize();
		connection = jdbc_connection.dbConnection(); // connects to database
	}

	/**	
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		init_components();
		create_events();
	}
	

	/** 
	 * This method contains all the code for creating/initializing
	 */
	private void init_components() {
		frame1 = new JFrame();
		frame1.setBounds(100, 100, 716, 422);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btnPatient = new JButton("Patients");
		btnPatient.setFont(new Font("CMU Serif", Font.PLAIN, 25));
		
		btnDoctors = new JButton("Doctors");
		btnDoctors.setFont(new Font("CMU Serif", Font.PLAIN, 25));
		
		btnAppointments = new JButton("Appointments");
		btnAppointments.setFont(new Font("CMU Serif", Font.PLAIN, 25));
		
		btnBills = new JButton("Bills");
		btnBills.setFont(new Font("CMU Serif", Font.PLAIN, 25));

		GroupLayout groupLayout = new GroupLayout(frame1.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnBills, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAppointments, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDoctors, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPatient, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(471, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(46)
					.addComponent(btnPatient, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnDoctors, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnAppointments, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnBills, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					.addGap(170))
		);
		frame1.getContentPane().setLayout(groupLayout);
	}
	
	/** 
	 * 	This method contains all  of the code for event handling
	 */
	private void create_events() {
		btnPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame1.dispose();
				Frame_Patient frame_patient = new Frame_Patient();
				frame_patient.setVisible(true);
			}
		});
		
	}
}
