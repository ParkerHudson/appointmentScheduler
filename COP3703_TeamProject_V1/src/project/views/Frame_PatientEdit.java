package project.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import project.common.jdbc_connection;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;

public class Frame_PatientEdit extends JFrame {

	private JPanel contentPane;
	private JButton btnLoad;
	private JTextField txtFirstName;
	private JTextField txtSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame_PatientEdit frame = new Frame_PatientEdit();
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
	public Frame_PatientEdit() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Frame_PatientEdit.class.getResource("/project/resources/icon.png")));
		setTitle("Big Bob's Band-aids & More");
		init_components();
		create_events();
		
	}
	
	/**
	 * Initializes components
	 */
	
	Connection connection = null;
	private JTextField txtLastName;
	private JTextField txtInsuranceID;
	private JTextField txtSSN;
	private JComboBox cbGender;
	private JLabel lblEditExistingPatients;
	private JTextField txtAddress;
	private JButton btnBack;
	private JDateChooser dateChooser;
	private JComboBox cbMiddleInitial;
	private JButton btnSave;
	
	private void init_components() {
		connection = jdbc_connection.dbConnection(); //db connection
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 648, 508);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// CENTERS THE THINGY
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		txtSearch = new JTextField();
		txtSearch.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		txtSearch.setBounds(10, 69, 185, 26);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		JLabel lblSSN = new JLabel("ENTER SSN:");
		lblSSN.setFont(new Font("CMU Serif", Font.BOLD, 16));
		lblSSN.setBounds(10, 38, 132, 26);
		contentPane.add(lblSSN);
		
		btnLoad = new JButton("Load");
		
		btnLoad.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		btnLoad.setBounds(205, 69, 94, 25);
		contentPane.add(btnLoad);
		
		txtFirstName = new JTextField();
		txtFirstName.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		txtFirstName.setColumns(10);
		txtFirstName.setBounds(114, 151, 185, 26);
		contentPane.add(txtFirstName);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		lblFirstName.setBounds(10, 151, 88, 26);
		contentPane.add(lblFirstName);
		
		JLabel lblMiddleInitial = new JLabel("Middle Initial:");
		lblMiddleInitial.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		lblMiddleInitial.setBounds(10, 188, 99, 26);
		contentPane.add(lblMiddleInitial);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		lblLastName.setBounds(10, 225, 88, 26);
		contentPane.add(lblLastName);
		
		txtLastName = new JTextField();
		txtLastName.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		txtLastName.setColumns(10);
		txtLastName.setBounds(114, 225, 185, 26);
		contentPane.add(txtLastName);
		
		cbMiddleInitial = new JComboBox();
		cbMiddleInitial.setEditable(true);
		cbMiddleInitial.setModel(new DefaultComboBoxModel(new String[] {"(No Initial)", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"}));
		cbMiddleInitial.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		cbMiddleInitial.setBounds(114, 188, 111, 27);
		contentPane.add(cbMiddleInitial);
		
		JLabel lblSsn = new JLabel("SSN:");
		lblSsn.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		lblSsn.setBounds(10, 337, 88, 26);
		contentPane.add(lblSsn);
		
		JLabel lblInsuranceId = new JLabel("Insurance ID:");
		lblInsuranceId.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		lblInsuranceId.setBounds(10, 300, 99, 26);
		contentPane.add(lblInsuranceId);
		
		txtInsuranceID = new JTextField();
		txtInsuranceID.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		txtInsuranceID.setColumns(10);
		txtInsuranceID.setBounds(114, 300, 185, 26);
		contentPane.add(txtInsuranceID);
		
		txtSSN = new JTextField();
		txtSSN.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		txtSSN.setColumns(10);
		txtSSN.setBounds(114, 337, 185, 26);
		contentPane.add(txtSSN);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		lblGender.setBounds(10, 262, 88, 26);
		contentPane.add(lblGender);
		
		cbGender = new JComboBox();
		cbGender.setEditable(true);
		cbGender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		cbGender.setToolTipText("gender");
		cbGender.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		cbGender.setBounds(114, 262, 82, 27);
		contentPane.add(cbGender);
		
		lblEditExistingPatients = new JLabel("EDIT EXISTING PATIENTS");
		lblEditExistingPatients.setFont(new Font("CMU Serif", Font.BOLD, 18));
		lblEditExistingPatients.setBounds(178, 11, 276, 25);
		contentPane.add(lblEditExistingPatients);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setHorizontalAlignment(SwingConstants.LEFT);
		lblAddress.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		lblAddress.setBounds(10, 382, 76, 26);
		contentPane.add(lblAddress);
		
		txtAddress = new JTextField();
		txtAddress.setToolTipText("Address");
		txtAddress.setHorizontalAlignment(SwingConstants.LEFT);
		txtAddress.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		txtAddress.setColumns(10);
		txtAddress.setBounds(114, 382, 185, 73);
		contentPane.add(txtAddress);
		
		JLabel lblBirthday = new JLabel("Birthday:");
		lblBirthday.setHorizontalAlignment(SwingConstants.LEFT);
		lblBirthday.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		lblBirthday.setBounds(353, 151, 88, 26);
		contentPane.add(lblBirthday);
		
		dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().setFont(new Font("CMU Serif", Font.PLAIN, 16));
		dateChooser.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		dateChooser.setDateFormatString("MM/dd/yyyy");
		dateChooser.setBounds(429, 151, 144, 27);
		contentPane.add(dateChooser);
		
		btnSave = new JButton("Save");
		
		btnSave.setFont(new Font("CMU Serif", Font.BOLD, 18));
		btnSave.setBounds(520, 300, 93, 66);
		contentPane.add(btnSave);
		
		btnBack = new JButton("Back");
		
		btnBack.setFont(new Font("CMU Serif", Font.BOLD, 18));
		btnBack.setBounds(520, 385, 93, 66);
		contentPane.add(btnBack);
	}
	
	/**
	 * Event handling
	 */
	
	private void create_events() {
		
		// Searches Database
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display_info(txtSearch.getText());	
			}
		});
		
		// Edits user inputted fields
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				edit_info(txtSearch.getText());
			}
		});
		
		// Returns to Patient Frame
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame_Patient frame_p = new Frame_Patient();
				frame_p.setVisible(true);
				dispose();
			}
		});
	}
	
	
	// Searches database using ssn
	private void display_info(String ssn) {
		try {
			String query = "SELECT * FROM patients WHERE patients.ssn = ?";
			PreparedStatement pStmt = connection.prepareStatement(query);
			pStmt.setString(1, ssn);
			ResultSet rs = pStmt.executeQuery();
			
			while (rs.next()) {
				
				txtFirstName.setText(rs.getString(1));
				cbMiddleInitial.getEditor().setItem(rs.getString(2));
				txtLastName.setText(rs.getString(3));
				
				// bday issue bc it was originally a string and needs to be of 'Date' type for the calendar
				String dateValue = rs.getString(4);
				java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateValue);
				dateChooser.setDate(date);
				
				txtInsuranceID.setText(rs.getString(5));
				
				if (rs.getString(6) == "M") {
					cbGender.getEditor().setItem("Male");
				} else {
					cbGender.getEditor().setItem("Female");
				}
				
				txtSSN.setText(rs.getString(7));
				txtAddress.setText(rs.getString(8));
				pStmt.close();
			}
		} catch (Exception e1) {
			
		}
	}
	
	private void edit_info (String ssn) {
		String query = "UPDATE patients SET pfname=?, pminit=?, plname=?, bdate=TO_DATE(?, 'MM DD YYYY'), insuranceid=?, sex=?, ssn=?, address=? WHERE ssn=?";
		PreparedStatement pStmt;
		
		while (verify_string(txtFirstName) == true && verify_string(txtLastName) == true 
				&& verify_int(txtSSN) == true && verify_int(txtInsuranceID) == true) {
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
				pStmt.setString(8, txtAddress.getText());
				
				pStmt.setString(9, ssn);
				
				pStmt.executeQuery();
				JOptionPane.showMessageDialog(null, "Patient Updated");
				break;
			} catch (java.sql.SQLException e2) {
				e2.printStackTrace();
				JOptionPane.showMessageDialog(null, "Something went bonked");
				break;
			}
		}
	}
	
	/**
	 * Formats the date to usable form yes
	 * @return
	 */
	private String format_bday() {
		java.util.Date test = dateChooser.getDate();
		String input = test.toString();
		
		String bday = "";
		DateFormat inputFormatter = new SimpleDateFormat("EE MMM dd HH:mm:ss zzz yyyy");
		
		try {
			java.util.Date date = inputFormatter.parse(input);
			DateFormat outputFormatter = new SimpleDateFormat("MM dd yyyy");
			bday = outputFormatter.format(date);
	
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return bday;
	}
	
	// checks if string contains integers FALSE = INTEGERS PRESENT
	private boolean verify_string(JComponent input) {
        String text = ((JTextField) input).getText();
        try {
			Integer.parseInt(text);
			JOptionPane.showMessageDialog(null, "Numerical values in names are not allowed");
			return false;
		} catch (NumberFormatException e) {
			return true;
		}  
    }
	
	// checks if int contains char FALSE = STRING PRESENT
	private boolean verify_int(JComponent input) {
        String text = ((JTextField) input).getText();
        try {
			Integer.parseInt(text);
			return true;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Invalid SSN / InsuranceID");
			return false;
		}  
    }
	
}
