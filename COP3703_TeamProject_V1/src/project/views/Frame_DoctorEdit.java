package project.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import project.common.jdbc_connection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class Frame_DoctorEdit extends JFrame {

	private JPanel contentPane;
	private JTextField txtSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame_DoctorEdit frame = new Frame_DoctorEdit();
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
	public Frame_DoctorEdit() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Frame_DoctorEdit.class.getResource("/project/resources/icon.png")));
		setTitle("Big Bob's Band-aid & More");
		init_components();
		create_events();
	}
	
	
	Connection connection = null;
	private JButton btnLoad;
	private JComboBox cbMiddleInitial;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtDoctorID;
	private JTextField txtSpecialization;
	private JButton btnBack;
	private JButton btnSave;
	/**
	 * initialize components
	 */
	private void init_components() {
		connection = jdbc_connection.dbConnection(); //db connection
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 705, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// CENTERS THE THINGY
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		JLabel lblEditExistingDoctors = new JLabel("EDIT EXISTING DOCTORS");
		lblEditExistingDoctors.setFont(new Font("CMU Serif", Font.BOLD, 18));
		lblEditExistingDoctors.setBounds(203, 11, 276, 25);
		contentPane.add(lblEditExistingDoctors);
		
		JLabel lblID = new JLabel("ENTER DOCTOR ID:");
		lblID.setFont(new Font("CMU Serif", Font.BOLD, 16));
		lblID.setBounds(10, 33, 196, 26);
		contentPane.add(lblID);
		
		txtSearch = new JTextField();
		txtSearch.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		txtSearch.setColumns(10);
		txtSearch.setBounds(10, 58, 185, 26);
		contentPane.add(txtSearch);
		
		btnLoad = new JButton("Load");
		
		btnLoad.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		btnLoad.setBounds(203, 59, 94, 25);
		contentPane.add(btnLoad);
		
		btnSave = new JButton("Save");
		
		btnSave.setFont(new Font("CMU Serif", Font.BOLD, 18));
		btnSave.setBounds(586, 195, 93, 66);
		contentPane.add(btnSave);
		
		btnBack = new JButton("Back");
		
		btnBack.setFont(new Font("CMU Serif", Font.BOLD, 18));
		btnBack.setBounds(586, 272, 93, 66);
		contentPane.add(btnBack);
		
		JLabel lblFirstName = new JLabel("First Name :");
		lblFirstName.setFont(new Font("CMU Serif", Font.BOLD, 16));
		lblFirstName.setBounds(10, 142, 121, 22);
		contentPane.add(lblFirstName);
		
		txtFirstName = new JTextField();
		txtFirstName.setToolTipText("First name");
		txtFirstName.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		txtFirstName.setColumns(10);
		txtFirstName.setBounds(141, 139, 244, 27);
		contentPane.add(txtFirstName);
		
		JLabel lblName = new JLabel("Last Name :");
		lblName.setFont(new Font("CMU Serif", Font.BOLD, 16));
		lblName.setBounds(10, 218, 97, 22);
		contentPane.add(lblName);
		
		JLabel lblMiddleInitial = new JLabel("Middle Initial :");
		lblMiddleInitial.setFont(new Font("CMU Serif", Font.BOLD, 16));
		lblMiddleInitial.setBounds(10, 180, 120, 22);
		contentPane.add(lblMiddleInitial);
		
		cbMiddleInitial = new JComboBox();
		cbMiddleInitial.setEditable(true);
		cbMiddleInitial.setModel(new DefaultComboBoxModel(new String[] {"(No Initial)", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"}));
		cbMiddleInitial.setToolTipText("Middle Initial");
		cbMiddleInitial.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		cbMiddleInitial.setBounds(141, 177, 111, 27);
		contentPane.add(cbMiddleInitial);
		
		txtLastName = new JTextField();
		txtLastName.setToolTipText("Last name");
		txtLastName.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		txtLastName.setColumns(10);
		txtLastName.setBounds(141, 215, 244, 27);
		contentPane.add(txtLastName);
		
		JLabel lbl = new JLabel("Doctor ID:");
		lbl.setFont(new Font("CMU Serif", Font.BOLD, 16));
		lbl.setBounds(10, 256, 113, 22);
		contentPane.add(lbl);
		
		txtDoctorID = new JTextField();
		txtDoctorID.setToolTipText("Doctor ID");
		txtDoctorID.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		txtDoctorID.setColumns(10);
		txtDoctorID.setBounds(141, 253, 244, 27);
		contentPane.add(txtDoctorID);
		
		JLabel lblSpecialization = new JLabel("Specialization: ");
		lblSpecialization.setFont(new Font("CMU Serif", Font.BOLD, 16));
		lblSpecialization.setBounds(10, 291, 119, 22);
		contentPane.add(lblSpecialization);
		
		txtSpecialization = new JTextField();
		txtSpecialization.setToolTipText("Specialization");
		txtSpecialization.setFont(new Font("CMU Serif", Font.PLAIN, 16));
		txtSpecialization.setColumns(10);
		txtSpecialization.setBounds(141, 291, 244, 27);
		contentPane.add(txtSpecialization);
	}
	
	/**
	 * event handling
	 */
	private void create_events() {
		
		// saves the user edited fields
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				edit_info(txtSearch.getText());
			}
		});
		
		// loads all the fields for searched doctor
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display_info(txtSearch.getText());
			}
		});
		
		
		
		// returns to doctor screen
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame_Doctor frame_doc = new Frame_Doctor();
				frame_doc.setVisible(true);
				dispose();
			}
		});
		
	}
	
	PreparedStatement pStmt;
	
	//displays all the information on searched doctor
	private void display_info(String id) {
		try {
			String query = "SELECT * FROM doctors WHERE doctorid = '" + id + "'";
			pStmt = connection.prepareStatement(query);
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				txtFirstName.setText(rs.getString(1));
				cbMiddleInitial.getEditor().setItem(rs.getString(2));
				txtLastName.setText(rs.getString(3));
				txtDoctorID.setText(rs.getString(4));
				txtSpecialization.setText(rs.getString(5));
			}	
			
			pStmt.close();
		} catch (SQLException e1) {	
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "Uhhh something got bonked..");
		}
	}
	
	// edits doctor information
	private void edit_info(String id) {
		
		while (verify_string(txtFirstName) == true && verify_string(txtLastName) == true 
				&& verify_int(txtDoctorID) == true && verify_string(txtSpecialization) == true) {
			try {
				
				String query = "UPDATE doctors SET dfname=?, dminit=?, dlname=?, doctorid=?, specilization=? WHERE doctorid=?";
				pStmt = connection.prepareStatement(query);
				pStmt.setString(1, txtFirstName.getText());	
				pStmt.setString(2, cbMiddleInitial.getSelectedItem().toString());	
				pStmt.setString(3, txtLastName.getText());
				pStmt.setString(4, txtDoctorID.getText());
				pStmt.setString(5, txtSpecialization.getText());
				pStmt.setString(6, id);
				pStmt.execute();
				JOptionPane.showMessageDialog(null, "Doctor Updated");	
				pStmt.close();
				break;
			} catch (SQLException e) {
				e.printStackTrace();
				break;
			}
		}
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
