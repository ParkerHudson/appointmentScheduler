package project.views;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import javax.swing.text.DateFormatter;

import net.proteanit.sql.DbUtils;
import project.common.input_verify;
import project.common.jdbc_connection;

import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JSpinner;
import com.toedter.calendar.JDateChooser;

public class Frame_AppointmentEdit extends JFrame {
	private JTextField searchField;
	private JTextField docIDField;
	private JTextField roomNumField;
	private JTextField patientSSNField;
	private JDateChooser dateChooser;
	private JSpinner spinner;
	private JButton btnBack;
	private JButton btnSave;
	private JButton btnLoad;
	private JButton btnDelete;
	Connection connection = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame_AppointmentEdit frame = new Frame_AppointmentEdit();
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
	public Frame_AppointmentEdit() {
		setTitle("Big Bob's Band-aids & More");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Frame_AppointmentEdit.class.getResource("/project/resources/icon.png")));
		init_components();
		create_events();

	}
	
	private void init_components() {
		connection = jdbc_connection.dbConnection(); //db connection
	
		setBounds(100, 100, 733, 466);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// CENTERS THE THINGY
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Edit Appointment");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitle.setBounds(262, 11, 291, 40);
		getContentPane().add(lblTitle);
		
		JLabel lblEnterAppointment = new JLabel("Enter Appointment #:");
		lblEnterAppointment.setFont(new Font("Dialog", Font.BOLD, 16));
		lblEnterAppointment.setBounds(10, 71, 196, 26);
		getContentPane().add(lblEnterAppointment);
		
		searchField = new JTextField();
		searchField.setFont(new Font("Dialog", Font.PLAIN, 16));
		searchField.setColumns(10);
		searchField.setBounds(10, 96, 185, 26);
		getContentPane().add(searchField);
		
		btnLoad = new JButton("Load");
		btnLoad.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnLoad.setBounds(203, 97, 94, 25);
		getContentPane().add(btnLoad);
		
		btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnDelete.setBounds(307, 97, 94, 25);
		getContentPane().add(btnDelete);
		
		JLabel lblNewLabel = new JLabel("Patient SSN:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel.setBounds(97, 183, 103, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblRoom = new JLabel("Room #:");
		lblRoom.setHorizontalAlignment(SwingConstants.LEFT);
		lblRoom.setFont(new Font("Dialog", Font.BOLD, 16));
		lblRoom.setBounds(97, 214, 91, 14);
		getContentPane().add(lblRoom);
		
		JLabel lblAppointmentTime = new JLabel("Appt. Date:");
		lblAppointmentTime.setHorizontalAlignment(SwingConstants.LEFT);
		lblAppointmentTime.setFont(new Font("Dialog", Font.BOLD, 16));
		lblAppointmentTime.setBounds(97, 239, 91, 25);
		getContentPane().add(lblAppointmentTime);
		
		JLabel lblApptTime = new JLabel("Appt Time: ");
		lblApptTime.setHorizontalAlignment(SwingConstants.LEFT);
		lblApptTime.setFont(new Font("Dialog", Font.BOLD, 16));
		lblApptTime.setBounds(97, 275, 91, 23);
		getContentPane().add(lblApptTime);
		
		JLabel lblDoctorName = new JLabel("Doctor's ID:");
		lblDoctorName.setHorizontalAlignment(SwingConstants.LEFT);
		lblDoctorName.setFont(new Font("Dialog", Font.BOLD, 16));
		lblDoctorName.setBounds(97, 309, 129, 20);
		getContentPane().add(lblDoctorName);
		
		docIDField = new JTextField();
		docIDField.setColumns(10);
		docIDField.setBounds(236, 312, 130, 20);
		getContentPane().add(docIDField);
		
		spinner = new JSpinner();
		spinner.setBounds(236, 279, 130, 20);
		getContentPane().add(spinner);
		
		SpinnerDateModel spinnermodel = new SpinnerDateModel();
		spinnermodel.setCalendarField(Calendar.MINUTE);
		spinner.setModel(spinnermodel);
		getContentPane().add(spinner);
		
		JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner, "hh:mm a");
		DateFormatter formatter = (DateFormatter)editor.getTextField().getFormatter();
		formatter.setAllowsInvalid(false); 
		formatter.setOverwriteMode(true);
		spinner.setEditor(editor);
		
		dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().setFont(new Font("Dialog", Font.PLAIN, 16));
		dateChooser.setFont(new Font("Dialog", Font.PLAIN, 16));
		dateChooser.setDateFormatString("MM/dd/yyyy");
		dateChooser.setBounds(236, 244, 130, 20);
		getContentPane().add(dateChooser);
		
		roomNumField = new JTextField();
		roomNumField.setColumns(10);
		roomNumField.setBounds(236, 214, 130, 20);
		getContentPane().add(roomNumField);
		
		patientSSNField = new JTextField();
		patientSSNField.setColumns(10);
		patientSSNField.setBounds(236, 183, 130, 20);
		getContentPane().add(patientSSNField);
		
		btnBack = new JButton("Back");
		btnBack.setFont(new Font("Dialog", Font.BOLD, 18));
		btnBack.setBounds(601, 336, 93, 66);
		getContentPane().add(btnBack);
		
		btnSave = new JButton("Save");
		btnSave.setFont(new Font("Dialog", Font.BOLD, 18));
		btnSave.setBounds(601, 259, 93, 66);
		getContentPane().add(btnSave);
		
		
		
		
		
	}
	
	private void create_events() {
		// saves the user edited fields
				btnSave.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						edit_info(searchField.getText());
					}
				}); 
				
				// loads all the fields for searched appt
				btnLoad.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						display_info(searchField.getText());
					}
				});
				
				// deletes
				btnDelete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int action = JOptionPane.showConfirmDialog(null, "Do you really want to delete?","Choose an option",JOptionPane.YES_NO_OPTION);
						if (action == 0) {
							info_delete(searchField.getText());
						}
					}
				});
				
				
				// returns to appt screen
				btnBack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Frame_Appointment frame_appt = new Frame_Appointment();
						frame_appt.setVisible(true);
						dispose();
					}
				});
	}
		
		PreparedStatement pStmt;
		
		//displays all the information on searched appt
		private void display_info(String id) {
			try {
				String query = "SELECT * FROM appointments WHERE APPTNUM = '" + id + "'";
				pStmt = connection.prepareStatement(query);
				ResultSet rs = pStmt.executeQuery();
				while (rs.next()) {
					patientSSNField.setText(rs.getString(5));
					roomNumField.setText(rs.getString(2));
					dateChooser.setDate(rs.getDate(3));
					spinner.setValue(rs.getTimestamp(6));
					docIDField.setText(rs.getString(4));
				}	
				pStmt.close();
			} catch (SQLException e1) {	
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Uhhh something broke..");
			}
		}
		
		// edits doctor information
		private void edit_info(String id) {
			
			
				try {
					
					java.util.Date d = (java.util.Date) spinner.getValue();
					java.sql.Timestamp sd = new java.sql.Timestamp(d.getTime());
					
					java.util.Date utilDate = (java.util.Date) dateChooser.getDate();
					java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
					
					String query = "UPDATE appointments SET patients_ssn=?, roomnum=?, appt_date=?, appt_time=?, doctors_doctorid=? WHERE apptnum=?";
					pStmt = connection.prepareStatement(query);
					pStmt.setString(1, patientSSNField.getText());	
					pStmt.setString(2, roomNumField.getText());	
					pStmt.setDate(3, sqlDate);
					pStmt.setTimestamp(4, sd);
					pStmt.setString(5, docIDField.getText());
					pStmt.setString(6, id);
					pStmt.execute();
					JOptionPane.showMessageDialog(null, "Appointment Updated");	
					pStmt.close();
					
				} catch (SQLException e) {
					e.printStackTrace();
					
				}
			
		
	}
		
		private void info_delete(String num) {
			String query = "DELETE FROM bills WHERE visit_charged=?";
			try {
				PreparedStatement pStmt = connection.prepareStatement(query);
				pStmt.setString(1, num);	
				pStmt.executeQuery();
				//JOptionPane.showMessageDialog(null, "Appointment Deleted");
				pStmt.close();
			} catch (java.sql.SQLException e1) {
				e1.printStackTrace();
			}
			
			query = "DELETE FROM appointments WHERE apptnum=?";
			try {
				PreparedStatement pStmt = connection.prepareStatement(query);
				pStmt.setString(1, num);	
				pStmt.executeQuery();
				JOptionPane.showMessageDialog(null, "Appointment and associated bill Deleted");
				pStmt.close();
			} catch (java.sql.SQLException e1) {
				e1.printStackTrace();
			}
		}
}
