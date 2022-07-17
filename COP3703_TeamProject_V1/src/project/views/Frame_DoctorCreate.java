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

public class Frame_DoctorCreate extends JFrame {

	private JPanel contentPane;
	private JTextField txtLastName;
	private JLabel lblFirstName;
	private JLabel lblMiddleInitial;
	private JTextField txtFirstName;
	private JComboBox cbMiddleInitial;
	private JLabel lbl;
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
	private JTextField txtDoctorID;
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
		
		lbl = new JLabel("Doctor ID:");
		lbl.setFont(new Font("CMU Serif", Font.BOLD, 16));
		
		lblTitle = new JLabel("ADD NEW DOCTORS");
		lblTitle.setFont(new Font("CMU Serif", Font.BOLD, 18));
		
		btnCreate = new JButton("Create");
		
		
		btnCreate.setFont(new Font("CMU Serif", Font.BOLD, 18));
		
		btnBack = new JButton("Back");
		
		btnBack.setFont(new Font("CMU Serif", Font.BOLD, 18));
		
		lblSpecialization = new JLabel("Specialization: ");
		lblSpecialization.setFont(new Font("CMU Serif", Font.BOLD, 16));
		
		txtDoctorID = new JTextField();
		txtDoctorID.setToolTipText("Doctor ID");
		txtDoctorID.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		txtDoctorID.setColumns(10);
		
		txtSpecialization = new JTextField();
		txtSpecialization.setToolTipText("Specialization");
		txtSpecialization.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		txtSpecialization.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(10, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(157)
							.addComponent(lblTitle))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblName)
							.addGap(52)
							.addComponent(txtLastName, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblFirstName, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(txtFirstName, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lbl, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblSpecialization)))
								.addComponent(lblMiddleInitial))
							.addGap(29)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(txtDoctorID, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtSpecialization, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)
								.addComponent(cbMiddleInitial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
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
								.addComponent(txtFirstName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblFirstName))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(cbMiddleInitial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMiddleInitial))
							.addGap(55)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lbl)
								.addComponent(txtDoctorID, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
							.addGap(13)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblSpecialization, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtSpecialization, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(111, Short.MAX_VALUE))
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
				
				String query = "INSERT INTO doctors VALUES (?, ?, ?, ?, ?)";
				PreparedStatement pStmt;
				
				while (verify_string(txtFirstName) == true && verify_string(txtLastName) == true 
						&& verify_int(txtDoctorID) == true && verify_string(txtSpecialization) == true) {
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
						
						pStmt.setString(4, txtDoctorID.getText());	
						pStmt.setString(5, txtSpecialization.getText());	
											
						pStmt.executeQuery();
						JOptionPane.showMessageDialog(null, "Doctor Created");
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
	
	// checks if string contains integers FALSE = INTEGERS PRESENT
	private boolean verify_string(JComponent input) {
        String text = ((JTextField) input).getText();
        try {
			Integer.parseInt(text);
			JOptionPane.showMessageDialog(null, "Numerical values in select fields are not allowed");
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
			JOptionPane.showMessageDialog(null, "Invalid DoctorID / Specialization");
			return false;
		}  
    }
}
