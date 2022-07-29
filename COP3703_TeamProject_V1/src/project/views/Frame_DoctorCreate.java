package project.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import project.common.input_verify;
import project.common.jdbc_connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import com.toedter.calendar.JDateChooser;

public class Frame_DoctorCreate extends JFrame {

	private JPanel contentPane;
	private JTextField txtLastName;
	private JLabel lblFirstName;
	private JLabel lblMiddleInitial;
	private JTextField txtFirstName;
	private JComboBox cbMiddleInitial;
	private JLabel lblTitle;
	private JButton btnCreate;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame_DoctorCreate frame = new Frame_DoctorCreate();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection = null; // connection var
	private JButton btnBack;
	private JLabel lblSpecialization;
	private JTextField txtSpecialization;

	/**
	 * MAIN THINGY
	 * @throws SQLException 
	 */
	public Frame_DoctorCreate() throws SQLException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Frame_DoctorCreate.class.getResource("/project/resources/icon.png")));
		setTitle("Big Bob's Band-aids & More");
		init_components();		
		create_events();
		
	}
	
	private void init_components() {
		
		connection = jdbc_connection.dbConnection(); //db connection
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 578, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		// Centers the Jframe
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		txtLastName = new JTextField();
		txtLastName.setToolTipText("Last name");
		txtLastName.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		txtLastName.setColumns(10);
		
		JLabel lblName = new JLabel("Last Name :");
		lblName.setFont(new Font("CMU Serif", Font.BOLD, 16));
		
		lblFirstName = new JLabel("First Name :");
		lblFirstName.setFont(new Font("CMU Serif", Font.BOLD, 16));
		
		lblMiddleInitial = new JLabel("Middle Initial :");
		lblMiddleInitial.setFont(new Font("CMU Serif", Font.BOLD, 16));
		
		txtFirstName = new JTextField();
		txtFirstName.setToolTipText("First name");
		txtFirstName.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		txtFirstName.setColumns(10);
		
		cbMiddleInitial = new JComboBox();
		cbMiddleInitial.setToolTipText("Middle Initial");
		cbMiddleInitial.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		cbMiddleInitial.setModel(new DefaultComboBoxModel(new String[] {"(No Initial)", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"}));
		
		lblTitle = new JLabel("ADD NEW DOCTORS");
		lblTitle.setFont(new Font("CMU Serif", Font.BOLD, 18));
		
		btnCreate = new JButton("Create");
		
		
		btnCreate.setFont(new Font("CMU Serif", Font.BOLD, 18));
		
		btnBack = new JButton("Back");
		
		btnBack.setFont(new Font("CMU Serif", Font.BOLD, 18));
		
		lblSpecialization = new JLabel("Specialization: ");
		lblSpecialization.setFont(new Font("CMU Serif", Font.BOLD, 16));
		
		txtSpecialization = new JTextField();
		txtSpecialization.setToolTipText("Specialization");
		txtSpecialization.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		txtSpecialization.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(37, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(157)
							.addComponent(lblTitle))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblName)
								.addComponent(lblFirstName, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMiddleInitial)
								.addComponent(lblSpecialization))
							.addGap(22)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(cbMiddleInitial, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(Alignment.LEADING, gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(txtFirstName, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)
									.addComponent(txtLastName, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)
									.addComponent(txtSpecialization, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnCreate))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnCreate, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTitle)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtLastName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblName))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblFirstName)
								.addComponent(txtFirstName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblMiddleInitial)
								.addComponent(cbMiddleInitial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(26)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtSpecialization, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSpecialization, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
							.addGap(74)))
					.addContainerGap(17, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	//////////////////////////////////////////////////////////
	// EVENT HANDLING
	//////////////////////////////////////////////////////////
	
	public void create_events() {
		
		// creates a new patient
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input_verify verify = new input_verify();
				
				String query = "INSERT INTO doctors VALUES (?, ?, ?, doctorid.nextval, ?)";
				PreparedStatement pStmt;
				
				while (verify.verify(txtFirstName) == true && verify.verify(txtLastName) == true 
				&& verify.verify(txtSpecialization) == true) {
					try {
						pStmt = connection.prepareStatement(query);
						
						
						
						pStmt.setString(1, txtFirstName.getText());	
						
						// checks for null middle initial
						if (cbMiddleInitial.getSelectedItem().toString() == "(No Initial)") {
							pStmt.setString(2, null);
						} else {
							pStmt.setString(2, cbMiddleInitial.getSelectedItem().toString());
						}
						
						pStmt.setString(3, txtLastName.getText());	
						
						//pStmt.setString(4, txtDoctorID.getText());	
						pStmt.setString(4, txtSpecialization.getText());	
											
						pStmt.executeQuery();
						JOptionPane.showMessageDialog(null, "Doctor Created");
						pStmt.close();
						break;
					} catch (java.sql.SQLIntegrityConstraintViolationException e1) {
						JOptionPane.showMessageDialog(null, "Cannot be created due to an existing Doctor ID");
						break;
					} catch (SQLException e2) {
						e2.printStackTrace();
						JOptionPane.showMessageDialog(null, "Cannot insert NULL into one or more fields");
						break;
					}
				} 
			}
		});
		
		// returns to Frame_Doctor
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame_Doctor frame_doc = new Frame_Doctor();
				frame_doc.setVisible(true);
				dispose(); 
			}
		});
		
	}
}
