package project.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
		setBounds(100, 100, 578, 704);
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
		
		lblGender = new JLabel("Gender :");
		lblGender.setFont(new Font("CMU Serif", Font.BOLD, 16));
		
		cbGender = new JComboBox();
		cbGender.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		cbGender.setToolTipText("gender");
		cbGender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		
		cbMiddleInitial = new JComboBox();
		cbMiddleInitial.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		cbMiddleInitial.setModel(new DefaultComboBoxModel(new String[] {"(No Initial)", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"}));
		
		lblDateOfBirth = new JLabel("Date of Birth:");
		lblDateOfBirth.setFont(new Font("CMU Serif", Font.BOLD, 16));
		
		lblInsuranceId = new JLabel("Insurance ID:");
		lblInsuranceId.setFont(new Font("CMU Serif", Font.BOLD, 16));
		
		txtInsuranceID = new JTextField();
		txtInsuranceID.setToolTipText("First name");
		txtInsuranceID.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		txtInsuranceID.setColumns(10);
		
		lblSsn = new JLabel("SSN:");
		lblSsn.setFont(new Font("CMU Serif", Font.BOLD, 16));
		
		txtSSN = new JTextField();
		txtSSN.setToolTipText("First name");
		txtSSN.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		txtSSN.setColumns(10);
		
		lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("CMU Serif", Font.BOLD, 16));
		
		txtStreet = new JTextField();
		txtStreet.setToolTipText("First name");
		txtStreet.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		txtStreet.setColumns(10);
		
		lblStreet = new JLabel("Street");
		lblStreet.setFont(new Font("CMU Serif", Font.BOLD, 16));
		
		lblCity = new JLabel("City");
		lblCity.setFont(new Font("CMU Serif", Font.BOLD, 16));
		
		txtCity = new JTextField();
		txtCity.setToolTipText("First name");
		txtCity.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		txtCity.setColumns(10);
		
		lblState = new JLabel("State");
		lblState.setFont(new Font("CMU Serif", Font.BOLD, 16));
		
		txtState = new JTextField();
		txtState.setToolTipText("First name");
		txtState.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		txtState.setColumns(10);
		
		lblCountry = new JLabel("Country");
		lblCountry.setFont(new Font("CMU Serif", Font.BOLD, 16));
		
		txtCountry = new JTextField();
		txtCountry.setToolTipText("First name");
		txtCountry.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		txtCountry.setColumns(10);
		
		lblTitle = new JLabel("ADD NEW PATIENTS");
		lblTitle.setFont(new Font("CMU Serif", Font.BOLD, 18));
		
		lblZipcode = new JLabel("Zipcode");
		lblZipcode.setFont(new Font("CMU Serif", Font.BOLD, 16));
		
		txtZipcode = new JTextField();
		txtZipcode.setToolTipText("First name");
		txtZipcode.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		txtZipcode.setColumns(10);
		
		btnCreate = new JButton("Create");
		
		
		btnCreate.setFont(new Font("CMU Serif", Font.BOLD, 18));
		
		btnBack = new JButton("Back");
		
		btnBack.setFont(new Font("CMU Serif", Font.BOLD, 18));
		
		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("MM/dd/yyyy");
		dateChooser.getCalendarButton().setFont(new Font("CMU Serif", Font.PLAIN, 16));
		dateChooser.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(157)
							.addComponent(lblTitle))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(lblName)
							.addGap(42)
							.addComponent(txtLastName, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(lblFirstName, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtFirstName, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(lblMiddleInitial)
							.addGap(19)
							.addComponent(cbMiddleInitial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(lblGender)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(cbGender, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(lblDateOfBirth)
							.addGap(18)
							.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(lblInsuranceId, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtInsuranceID, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(lblSsn, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtSSN, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(lblAddress, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(61)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblStreet)
								.addComponent(lblCity, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
							.addGap(55)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(txtStreet, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtCity, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE))
							.addGap(41)
							.addComponent(btnCreate))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(61)
							.addComponent(lblState)
							.addGap(62)
							.addComponent(txtState, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(61)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCountry, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblZipcode, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
							.addGap(4)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(txtCountry, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtZipcode, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
							.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTitle)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(5)
									.addComponent(lblName))
								.addComponent(txtLastName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(5)
									.addComponent(lblFirstName))
								.addComponent(txtFirstName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(3)
									.addComponent(lblMiddleInitial))
								.addComponent(cbMiddleInitial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(39)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblGender)
								.addComponent(cbGender, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(44)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDateOfBirth)
								.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
							.addGap(50)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(3)
									.addComponent(lblInsuranceId))
								.addComponent(txtInsuranceID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(3)
									.addComponent(lblSsn))
								.addComponent(txtSSN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(34)
							.addComponent(lblAddress)
							.addGap(9)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(5)
									.addComponent(lblStreet)
									.addGap(16)
									.addComponent(lblCity))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(2)
									.addComponent(txtStreet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(11)
									.addComponent(txtCity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addComponent(btnCreate, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblState))
						.addComponent(txtState, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(8)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(lblCountry)
							.addGap(11)
							.addComponent(lblZipcode))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(txtCountry, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGap(9)
								.addComponent(txtZipcode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
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
				
				String query = "INSERT INTO patients VALUES (?, ?, ?, TO_DATE(?, 'MM DD YYYY'), ?, ?, ?, ?)";
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
						pStmt.setString(8, concat_address());
						
						pStmt.executeQuery();
						JOptionPane.showMessageDialog(null, "Patient Created");
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
