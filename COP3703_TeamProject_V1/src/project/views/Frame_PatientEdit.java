package project.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import project.common.input_verify;
import project.common.jdbc_connection;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
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
	private JButton btnDelete;
	
	private void init_components() {
		connection = jdbc_connection.dbConnection(); //db connection
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 648, 508);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		// CENTERS THE THINGY
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		contentPane.setLayout(null);
		
		txtSearch = new JTextField();
		txtSearch.setBounds(10, 69, 185, 26);
		txtSearch.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		JLabel lblSSN = new JLabel("ENTER SSN:");
		lblSSN.setBounds(10, 38, 132, 26);
		lblSSN.setFont(new Font("CMU Serif", Font.BOLD, 16));
		contentPane.add(lblSSN);
		
		btnLoad = new JButton("Load");
		btnLoad.setBounds(205, 69, 94, 25);
		
		btnLoad.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		contentPane.add(btnLoad);
		
		txtFirstName = new JTextField();
		txtFirstName.setBounds(114, 151, 185, 26);
		txtFirstName.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		txtFirstName.setColumns(10);
		contentPane.add(txtFirstName);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(10, 151, 88, 26);
		lblFirstName.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		contentPane.add(lblFirstName);
		
		JLabel lblMiddleInitial = new JLabel("Middle Initial:");
		lblMiddleInitial.setBounds(10, 188, 99, 26);
		lblMiddleInitial.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		contentPane.add(lblMiddleInitial);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(10, 225, 88, 26);
		lblLastName.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		contentPane.add(lblLastName);
		
		txtLastName = new JTextField();
		txtLastName.setBounds(114, 225, 185, 26);
		txtLastName.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		txtLastName.setColumns(10);
		contentPane.add(txtLastName);
		
		cbMiddleInitial = new JComboBox();
		cbMiddleInitial.setBounds(114, 188, 111, 27);
		cbMiddleInitial.setEditable(true);
		cbMiddleInitial.setModel(new DefaultComboBoxModel(new String[] {"(No Initial)", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"}));
		cbMiddleInitial.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		contentPane.add(cbMiddleInitial);
		
		JLabel lblSsn = new JLabel("SSN:");
		lblSsn.setBounds(10, 337, 88, 26);
		lblSsn.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		contentPane.add(lblSsn);
		
		JLabel lblInsuranceId = new JLabel("Insurance ID:");
		lblInsuranceId.setBounds(10, 300, 99, 26);
		lblInsuranceId.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		contentPane.add(lblInsuranceId);
		
		txtInsuranceID = new JTextField();
		txtInsuranceID.setBounds(114, 300, 185, 26);
		txtInsuranceID.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		txtInsuranceID.setColumns(10);
		contentPane.add(txtInsuranceID);
		
		txtSSN = new JTextField();
		txtSSN.setBounds(114, 337, 185, 26);
		txtSSN.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		txtSSN.setColumns(10);
		contentPane.add(txtSSN);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setBounds(10, 262, 88, 26);
		lblGender.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		contentPane.add(lblGender);
		
		cbGender = new JComboBox();
		cbGender.setBounds(114, 262, 82, 27);
		cbGender.setEditable(true);
		cbGender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		cbGender.setToolTipText("gender");
		cbGender.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		contentPane.add(cbGender);
		
		lblEditExistingPatients = new JLabel("EDIT EXISTING PATIENTS");
		lblEditExistingPatients.setBounds(178, 11, 276, 25);
		lblEditExistingPatients.setFont(new Font("CMU Serif", Font.BOLD, 18));
		contentPane.add(lblEditExistingPatients);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(10, 382, 76, 26);
		lblAddress.setHorizontalAlignment(SwingConstants.LEFT);
		lblAddress.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		contentPane.add(lblAddress);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(114, 382, 185, 73);
		txtAddress.setToolTipText("Address");
		txtAddress.setHorizontalAlignment(SwingConstants.LEFT);
		txtAddress.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		txtAddress.setColumns(10);
		contentPane.add(txtAddress);
		
		JLabel lblBirthday = new JLabel("Birthday:");
		lblBirthday.setBounds(353, 151, 88, 26);
		lblBirthday.setHorizontalAlignment(SwingConstants.LEFT);
		lblBirthday.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		contentPane.add(lblBirthday);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(429, 151, 144, 27);
		dateChooser.getCalendarButton().setFont(new Font("CMU Serif", Font.PLAIN, 16));
		dateChooser.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		dateChooser.setDateFormatString("MM/dd/yyyy");
		contentPane.add(dateChooser);
		
		btnSave = new JButton("Save");
		btnSave.setBounds(520, 300, 93, 66);
		
		btnSave.setFont(new Font("CMU Serif", Font.BOLD, 18));
		contentPane.add(btnSave);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(520, 385, 93, 66);
		
		btnBack.setFont(new Font("CMU Serif", Font.BOLD, 18));
		contentPane.add(btnBack);
		
		btnDelete = new JButton("Delete");
		
		btnDelete.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		btnDelete.setBounds(313, 69, 94, 25);
		contentPane.add(btnDelete);
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
		
		// Delete's patient info
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int action = JOptionPane.showConfirmDialog(null, "Do you really want to delete?","Choose an option",JOptionPane.YES_NO_OPTION);
				if (action == 0) {
					info_delete(txtSearch.getText());
				}
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
		input_verify input_verify = new input_verify(); // check project.common/input_verify.java
		String query = "UPDATE patients SET pfname=?, pminit=?, plname=?, bdate=TO_DATE(?, 'MM DD YYYY'), insuranceid=?, sex=?, ssn=?, address=? WHERE ssn=?";
		PreparedStatement pStmt;
		
		while (input_verify.verify(txtFirstName) == true && input_verify.verify(txtLastName) == true 
				&& input_verify.verify_int(txtSSN) == true) {
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
				pStmt.close();
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
	
	private void info_delete(String ssn) {
		String query = "DELETE FROM patients WHERE ssn=?";
		try {
			PreparedStatement pStmt = connection.prepareStatement(query);
			pStmt.setString(1, ssn);	
			pStmt.executeQuery();
			JOptionPane.showMessageDialog(null, "Patient Deleted");
			pStmt.close();

		} catch (java.sql.SQLException e1) {
			e1.printStackTrace();
		}
	}
}
