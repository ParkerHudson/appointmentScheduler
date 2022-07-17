package project.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import projects.common.jdbc_connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class Frame_PatientCreate extends JFrame {

	private JPanel contentPane;
	private JTextField txtLastName;
	private JLabel lblFirstName;
	private JLabel lblMiddleInitial;
	private JTextField txtFirstName;
	private JLabel lblGender;
	private JComboBox cbMiddleInitial;
	private JLabel lblDateOfBirth;
	private JComboBox cbYear;
	private JLabel lblMonth;
	private JLabel lblMonth_1;
	private JComboBox cbMonth;
	private JLabel lblDay;
	private JComboBox cbDay;
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
		setBounds(100, 100, 576, 704);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
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
		
		cbYear = new JComboBox();
		cbYear.setModel(new DefaultComboBoxModel(new String[] {"2023", "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969"}));
		cbYear.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		
		lblMonth = new JLabel("Year");
		lblMonth.setFont(new Font("CMU Serif", Font.BOLD, 16));
		
		lblMonth_1 = new JLabel("Month");
		lblMonth_1.setFont(new Font("CMU Serif", Font.BOLD, 16));
		
		cbMonth = new JComboBox();
		cbMonth.setModel(new DefaultComboBoxModel(new String[] {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}));
		cbMonth.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		
		lblDay = new JLabel("Day");
		lblDay.setFont(new Font("CMU Serif", Font.BOLD, 16));
		
		cbDay = new JComboBox();
		cbDay.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		cbDay.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		
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
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblName)
									.addGap(42)
									.addComponent(txtLastName, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblMiddleInitial)
									.addGap(19)
									.addComponent(cbMiddleInitial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblGender)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(cbGender, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblFirstName, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(txtFirstName, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblDateOfBirth))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(30)
							.addComponent(lblMonth)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(cbYear, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblMonth_1, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(cbMonth, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblDay, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cbDay, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblInsuranceId, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtInsuranceID, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(61)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblCountry, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
												.addComponent(lblState)
												.addComponent(lblCity, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblZipcode, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
											.addPreferredGap(ComponentPlacement.RELATED))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblStreet)
											.addGap(55)))
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(txtStreet, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtCountry, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtState, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtCity, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtZipcode, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addContainerGap()
									.addComponent(lblSsn, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(txtSSN, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
							.addComponent(btnCreate))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblAddress, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnCreate, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
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
							.addGap(36)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblGender)
								.addComponent(cbGender, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(28)
							.addComponent(lblDateOfBirth)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblMonth, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(cbYear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMonth_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(cbMonth, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDay, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(cbDay, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
							.addGap(29)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblInsuranceId, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtInsuranceID, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSsn, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtSSN, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
							.addGap(34)
							.addComponent(lblAddress, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblStreet, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtStreet, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtCity, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCity, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
							.addGap(9)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtState, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblState, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtCountry, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCountry, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
							.addGap(9)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblZipcode, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
									.addGap(5))
								.addComponent(txtZipcode, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))))
					.addGap(39))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	//////////////////////////////////////////////////////////
	// EVENT HANDLING
	//////////////////////////////////////////////////////////
	
	public void create_events() {
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String middle = "(No Initial)";
				
				String query = "INSERT INTO patients VALUES (?, ?, ?, TO_DATE(?, 'MM DD YYYY'), ?, ?, ?, ?)";
				PreparedStatement pStmt;
				try {
					pStmt = connection.prepareStatement(query);
					
					pStmt.setString(1, txtFirstName.getText());	
					
					// checks for null middle initial
					if (cbMiddleInitial.getSelectedItem().toString() == middle) {
						pStmt.setString(2, null);
					} else {
						pStmt.setString(2, cbMiddleInitial.getSelectedItem().toString());
					}
					
					pStmt.setString(3, txtLastName.getText());	
					pStmt.setString(4, concat_bday());	
					pStmt.setString(5, txtInsuranceID.getText());
					
					// checks for null middle initial
					if (cbGender.getSelectedItem().toString() == "Male") {
						pStmt.setString(6, "M");
					} else {
						pStmt.setString(6, "F");
					}
					
					pStmt.setString(7, txtSSN.getText());
					pStmt.setString(8, concat_address());
					
					
					
					
					pStmt.executeQuery();
					JOptionPane.showMessageDialog(null, "Patient Created");
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
	}
	
	private String concat_address() { 
		String address = "";
		address = txtStreet.getText() + ", " + txtCity.getText()+ " " + txtState.getText() 
			+ ", " + txtCountry.getText() + ", " + txtZipcode.getText();
		return address;
	}
	
	private String concat_bday() {
		String bday = cbMonth.getSelectedItem().toString() + " " + cbDay.getSelectedItem().toString() 
					+ " " + cbYear.getSelectedItem().toString();
		return bday;
		
	}
}
