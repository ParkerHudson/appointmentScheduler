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

public class Frame_PatientCreate extends JFrame {

	private JPanel contentPane;
	private JTextField txtLastName;
	private JLabel lblFirstName;
	private JLabel lblMiddleInitial;
	private JTextField txtFirstName;
	private JLabel lblGender;
	private JComboBox cbMiddleInitial;
	private JLabel lblDateOfBirth;
	private JLabel lblInsuranceId;
	private JTextField txtInsuranceID;
	private JLabel lblSsn;
	private JTextField txtSSN;
	private JLabel lblAddress;
	private JTextField txtStreet;
	private JLabel lblStreet;
	private JLabel lblCity;
	private JTextField txtCity;
	private JLabel lblState;
	private JTextField txtState;
	private JLabel lblCountry;
	private JTextField txtCountry;
	private JLabel lblTitle;
	private JLabel lblZipcode;
	private JTextField txtZipcode;
	private JButton btnCreate;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame_PatientCreate frame = new Frame_PatientCreate();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection = null; // connection var
	private JComboBox cbGender;
	private JButton btnBack;
	private JDateChooser dateChooser;

	/**
	 * MAIN THINGY
	 * @throws SQLException 
	 */
	public Frame_PatientCreate() throws SQLException {
		init_components();		
		create_events();
		
	}
	
	private void init_components() {
		
		connection = jdbc_connection.dbConnection(); //db connection
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 578, 644);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		// Centers the Jframe
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		txtLastName = new JTextField();
		txtLastName.setBounds(154, 53, 244, 27);
		txtLastName.setToolTipText("Last name");
		txtLastName.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		txtLastName.setColumns(10);
		
		JLabel lblName = new JLabel("Last Name :");
		lblName.setBounds(15, 56, 97, 22);
		lblName.setFont(new Font("CMU Serif", Font.BOLD, 16));
		
		lblFirstName = new JLabel("First Name :");
		lblFirstName.setBounds(15, 97, 121, 22);
		lblFirstName.setFont(new Font("CMU Serif", Font.BOLD, 16));
		
		lblMiddleInitial = new JLabel("Middle Initial :");
		lblMiddleInitial.setBounds(15, 136, 120, 22);
		lblMiddleInitial.setFont(new Font("CMU Serif", Font.BOLD, 16));
		
		txtFirstName = new JTextField();
		txtFirstName.setBounds(154, 92, 244, 27);
		txtFirstName.setToolTipText("First name");
		txtFirstName.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		txtFirstName.setColumns(10);
		
		lblGender = new JLabel("Gender :");
		lblGender.setBounds(15, 174, 69, 22);
		lblGender.setFont(new Font("CMU Serif", Font.BOLD, 16));
		
		cbGender = new JComboBox();
		cbGender.setBounds(154, 171, 82, 27);
		cbGender.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		cbGender.setToolTipText("gender");
		cbGender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		
		cbMiddleInitial = new JComboBox();
		cbMiddleInitial.setBounds(154, 133, 111, 27);
		cbMiddleInitial.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		cbMiddleInitial.setModel(new DefaultComboBoxModel(new String[] {"(No Initial)", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"}));
		
		lblDateOfBirth = new JLabel("Date of Birth:");
		lblDateOfBirth.setBounds(15, 216, 113, 22);
		lblDateOfBirth.setFont(new Font("CMU Serif", Font.BOLD, 16));
		
		lblInsuranceId = new JLabel("Insurance ID:");
		lblInsuranceId.setBounds(15, 264, 113, 22);
		lblInsuranceId.setFont(new Font("CMU Serif", Font.BOLD, 16));
		
		txtInsuranceID = new JTextField();
		txtInsuranceID.setBounds(154, 261, 244, 27);
		txtInsuranceID.setToolTipText("First name");
		txtInsuranceID.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		txtInsuranceID.setColumns(10);
		
		lblSsn = new JLabel("SSN:");
		lblSsn.setBounds(15, 302, 113, 22);
		lblSsn.setFont(new Font("CMU Serif", Font.BOLD, 16));
		
		txtSSN = new JTextField();
		txtSSN.setBounds(154, 299, 244, 27);
		txtSSN.setToolTipText("First name");
		txtSSN.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		txtSSN.setColumns(10);
		
		lblAddress = new JLabel("Address:");
		lblAddress.setBounds(5, 378, 113, 22);
		lblAddress.setFont(new Font("CMU Serif", Font.BOLD, 16));
		
		txtStreet = new JTextField();
		txtStreet.setBounds(169, 418, 244, 27);
		txtStreet.setToolTipText("First name");
		txtStreet.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		txtStreet.setColumns(10);
		
		lblStreet = new JLabel("Street");
		lblStreet.setBounds(66, 421, 48, 22);
		lblStreet.setFont(new Font("CMU Serif", Font.BOLD, 16));
		
		lblCity = new JLabel("City");
		lblCity.setBounds(66, 459, 48, 22);
		lblCity.setFont(new Font("CMU Serif", Font.BOLD, 16));
		
		txtCity = new JTextField();
		txtCity.setBounds(169, 456, 244, 27);
		txtCity.setToolTipText("First name");
		txtCity.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		txtCity.setColumns(10);
		
		lblState = new JLabel("State");
		lblState.setBounds(66, 497, 41, 22);
		lblState.setFont(new Font("CMU Serif", Font.BOLD, 16));
		
		txtState = new JTextField();
		txtState.setBounds(169, 494, 244, 27);
		txtState.setToolTipText("First name");
		txtState.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		txtState.setColumns(10);
		
		lblCountry = new JLabel("Country");
		lblCountry.setBounds(66, 530, 99, 22);
		lblCountry.setFont(new Font("CMU Serif", Font.BOLD, 16));
		
		txtCountry = new JTextField();
		txtCountry.setBounds(169, 527, 244, 27);
		txtCountry.setToolTipText("First name");
		txtCountry.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		txtCountry.setColumns(10);
		
		lblTitle = new JLabel("ADD NEW PATIENTS");
		lblTitle.setBounds(162, 5, 220, 25);
		lblTitle.setFont(new Font("CMU Serif", Font.BOLD, 18));
		
		lblZipcode = new JLabel("Zipcode");
		lblZipcode.setBounds(66, 563, 67, 22);
		lblZipcode.setFont(new Font("CMU Serif", Font.BOLD, 16));
		
		txtZipcode = new JTextField();
		txtZipcode.setBounds(169, 560, 244, 27);
		txtZipcode.setToolTipText("First name");
		txtZipcode.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		txtZipcode.setColumns(10);
		
		btnCreate = new JButton("Create");
		btnCreate.setBounds(459, 530, 93, 66);
		
		
		btnCreate.setFont(new Font("CMU Serif", Font.BOLD, 18));
		
		btnBack = new JButton("Back");
		btnBack.setBounds(459, 436, 93, 66);
		
		btnBack.setFont(new Font("CMU Serif", Font.BOLD, 18));
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(154, 216, 144, 27);
		dateChooser.setDateFormatString("MM/dd/yyyy");
		dateChooser.getCalendarButton().setFont(new Font("CMU Serif", Font.PLAIN, 16));
		dateChooser.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		contentPane.setLayout(null);
		contentPane.add(lblTitle);
		contentPane.add(lblFirstName);
		contentPane.add(lblName);
		contentPane.add(lblMiddleInitial);
		contentPane.add(lblGender);
		contentPane.add(lblDateOfBirth);
		contentPane.add(lblInsuranceId);
		contentPane.add(lblSsn);
		contentPane.add(txtInsuranceID);
		contentPane.add(dateChooser);
		contentPane.add(cbMiddleInitial);
		contentPane.add(txtLastName);
		contentPane.add(txtFirstName);
		contentPane.add(cbGender);
		contentPane.add(txtSSN);
		contentPane.add(lblAddress);
		contentPane.add(lblState);
		contentPane.add(lblCity);
		contentPane.add(lblCountry);
		contentPane.add(lblZipcode);
		contentPane.add(lblStreet);
		contentPane.add(txtCity);
		contentPane.add(txtState);
		contentPane.add(txtCountry);
		contentPane.add(txtZipcode);
		contentPane.add(btnBack);
		contentPane.add(btnCreate);
		contentPane.add(txtStreet);
	}
	
	//////////////////////////////////////////////////////////
	// EVENT HANDLING
	//////////////////////////////////////////////////////////
	
	public void create_events() {
		
		// creates a new patient
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input_verify verify = new input_verify();
				
				String query = "INSERT INTO patients VALUES (?, ?, ?, TO_DATE(?, 'MM DD YYYY'), ?, ?, ?, ?)";
				PreparedStatement pStmt;
				
				while (verify.verify(txtFirstName) == true && verify.verify(txtLastName) == true 
						&& verify.verify_int(txtSSN) == true && verify.verify_int(txtInsuranceID) == true) {
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
						pStmt.setString(4, format_bday());	
						
						pStmt.setString(5, txtInsuranceID.getText());
						
						// fixes gender
						if (cbGender.getSelectedItem().toString() == "Male") {
							pStmt.setString(6, "M");
						} else {
							pStmt.setString(6, "F");
						}
						
						pStmt.setString(7, txtSSN.getText());
						pStmt.setString(8, concat_address());
						
						pStmt.executeQuery();
						JOptionPane.showMessageDialog(null, "Patient Created");
						pStmt.close();
						break;
					} catch (java.sql.SQLIntegrityConstraintViolationException e1) {
						JOptionPane.showMessageDialog(null, "Cannot be created due to an existing Patient SSN");
					} catch (SQLException e2) {
						e2.printStackTrace();
						JOptionPane.showMessageDialog(null, "Cannot insert NULL into one or more fields");
						break;
					}
				} 
			}
		});
		
		// returns to Frame_Patient
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame_Patient frame_pat = new Frame_Patient();
				frame_pat.setVisible(true);
				dispose(); 
			}
		});
		
	}
	
	// fix de address yes
	private String concat_address() { 
		String address = "";
		address = txtStreet.getText() + ", " + txtCity.getText()+ " " + txtState.getText() 
			+ ", " + txtCountry.getText() + ", " + txtZipcode.getText();
		return address;
	}
	
	
	/**
	 * Formats the date to usable form yes
	 * @return
	 */
	private String format_bday() {
		Date test = dateChooser.getDate();
		String input = test.toString();
		
		String bday = "";
		DateFormat inputFormatter = new SimpleDateFormat("EE MMM dd HH:mm:ss zzz yyyy");
		
		try {
			Date date = inputFormatter.parse(input);
			DateFormat outputFormatter = new SimpleDateFormat("MM dd yyyy");
			bday = outputFormatter.format(date);
	
		} catch (ParseException e) {
			e.printStackTrace();
		}	
		return bday;
	}
}
