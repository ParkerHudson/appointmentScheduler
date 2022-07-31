package project.views;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import javax.swing.text.DateFormatter;

import net.proteanit.sql.DbUtils;
import oracle.jdbc.OracleTypes;
import project.common.jdbc_connection;

import javax.swing.JCheckBox;
import javax.swing.JButton;
import com.github.lgooddatepicker.components.DatePicker;
import com.toedter.calendar.JDateChooser;
import com.toedter.components.JSpinField;

public class Frame_AppointmentCreate extends JFrame {
	private JTextField doctorsID_textField;
	private JTextField roomNum_textField;
	private JTextField patientSSN_textField;
	private JButton btnBack;
	private JButton btnCreate;
	private JSpinner spinner;
	private JDateChooser dateChooser;
	private JCheckBox chckbxCheckup;
	private JCheckBox chckbxImmunizations;
	private JCheckBox chckbxConsultation;
	private JCheckBox chckbxPrescription;
	Connection connection = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame_AppointmentCreate frame = new Frame_AppointmentCreate();
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
	public Frame_AppointmentCreate() {
		setTitle("Big Bob's Band-aids & More");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Frame_AppointmentCreate.class.getResource("/project/resources/icon.png")));
		init_components();
		create_events();

	}
	
	private void init_components() {
		connection = jdbc_connection.dbConnection();
		setBounds(100, 100, 733, 466);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// CENTERS THE THINGY
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Create New Appointment");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitle.setBounds(233, 11, 239, 40);
		getContentPane().add(lblTitle);
		
		doctorsID_textField = new JTextField();
		doctorsID_textField.setBounds(149, 206, 130, 20);
		getContentPane().add(doctorsID_textField);
		doctorsID_textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Patient SSN:");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(10, 77, 103, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblRoom = new JLabel("Room #:");
		lblRoom.setFont(new Font("Dialog", Font.BOLD, 16));
		lblRoom.setHorizontalAlignment(SwingConstants.LEFT);
		lblRoom.setBounds(10, 108, 91, 14);
		getContentPane().add(lblRoom);
		
		JLabel lblAppointmentTime = new JLabel("Appt. Date:");
		lblAppointmentTime.setFont(new Font("Dialog", Font.BOLD, 16));
		lblAppointmentTime.setHorizontalAlignment(SwingConstants.LEFT);
		lblAppointmentTime.setBounds(10, 133, 91, 25);
		getContentPane().add(lblAppointmentTime);
		
		JLabel lblDoctorName = new JLabel("Doctor's ID:");
		lblDoctorName.setFont(new Font("Dialog", Font.BOLD, 16));
		lblDoctorName.setHorizontalAlignment(SwingConstants.LEFT);
		lblDoctorName.setBounds(10, 203, 129, 20);
		getContentPane().add(lblDoctorName);
		
		JLabel lblNewLabel_1 = new JLabel("Procedures");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(375, 68, 97, 32);
		getContentPane().add(lblNewLabel_1);
		
		chckbxCheckup = new JCheckBox("Checkup");
		chckbxCheckup.setFont(new Font("Dialog", Font.PLAIN, 12));
		chckbxCheckup.setBounds(375, 110, 97, 23);
		getContentPane().add(chckbxCheckup);
		
		chckbxImmunizations = new JCheckBox("Immunizations");
		chckbxImmunizations.setFont(new Font("Dialog", Font.PLAIN, 12));
		chckbxImmunizations.setBounds(375, 136, 113, 23);
		getContentPane().add(chckbxImmunizations);
		
		chckbxPrescription = new JCheckBox("Prescription");
		chckbxPrescription.setFont(new Font("Dialog", Font.PLAIN, 12));
		chckbxPrescription.setBounds(375, 161, 97, 23);
		getContentPane().add(chckbxPrescription);
		
		chckbxConsultation = new JCheckBox("Consultation");
		chckbxConsultation.setFont(new Font("Dialog", Font.PLAIN, 12));
		chckbxConsultation.setBounds(375, 189, 97, 23);
		getContentPane().add(chckbxConsultation);
		
		JLabel lblApptTime = new JLabel("Appt Time: ");
		lblApptTime.setHorizontalAlignment(SwingConstants.LEFT);
		lblApptTime.setFont(new Font("Dialog", Font.BOLD, 16));
		lblApptTime.setBounds(10, 169, 91, 23);
		getContentPane().add(lblApptTime);
		
		roomNum_textField = new JTextField();
		roomNum_textField.setColumns(10);
		roomNum_textField.setBounds(149, 108, 130, 20);
		getContentPane().add(roomNum_textField);
		
		patientSSN_textField = new JTextField();
		patientSSN_textField.setColumns(10);
		patientSSN_textField.setBounds(149, 77, 130, 20);
		getContentPane().add(patientSSN_textField);
		
		btnCreate = new JButton("Create");
		btnCreate.setFont(new Font("Dialog", Font.BOLD, 18));
		btnCreate.setBounds(375, 275, 97, 66);
		getContentPane().add(btnCreate);
		
		btnBack = new JButton("Back");
		btnBack.setFont(new Font("Dialog", Font.BOLD, 18));
		btnBack.setBounds(188, 275, 91, 66);
		getContentPane().add(btnBack);
		
		
		spinner = new JSpinner();
		spinner.setLocation(149, 173);
		spinner.setSize(130, 20);
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
		dateChooser.setLocation(149, 138);
		dateChooser.setSize(130, 20);
		dateChooser.setDateFormatString("MM/dd/yyyy");
		dateChooser.getCalendarButton().setFont(new Font("Dialog", Font.PLAIN, 16));
		dateChooser.setFont(new Font("Dialog", Font.PLAIN, 16));
		getContentPane().add(dateChooser);
		
		
	}
	
	
	private void create_events() {
	
	// returns to Frame_Apointment
	btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame_Appointment frame = new Frame_Appointment();
				frame.setVisible(true);
				dispose(); 
			}
		});
	
	//Create appointment and bill when create button is pressed
	btnCreate.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			
			try {
				
				//Convert apptDate and apptTime to timestamp format
				java.util.Date d = (java.util.Date) spinner.getValue();
				java.sql.Timestamp sd = new java.sql.Timestamp(d.getTime());
				
				java.util.Date utilDate = (java.util.Date) dateChooser.getDate();
				java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
				
				String patientSSN = patientSSN_textField.getText();
				
				String query = "INSERT INTO appointments VALUES (apptnum.nextval, ?, ?, ?, ?, ?)"; //RETURN apptnum into : ?
				PreparedStatement pStmt;
				pStmt = connection.prepareStatement(query, new String[] {"APPTNUM"} ); //   Statement.RETURN_GENERATED_KEYS
				
				pStmt.setString(1, roomNum_textField.getText());
				pStmt.setDate(2,  sqlDate);
				pStmt.setString(3, doctorsID_textField.getText());
				pStmt.setString(4, patientSSN_textField.getText());
				pStmt.setTimestamp(5, sd);
				//pStmt.setString(6, "response");
				pStmt.executeQuery();
				
				 ResultSet rs = pStmt.getGeneratedKeys();  
				 String generatedApptNum = null;
				 	if(rs.isBeforeFirst()){
				 		rs.next();
				 		//Get apptNum
			             generatedApptNum = rs.getString(1);
			        }
				
				
				JOptionPane.showMessageDialog(null, "Appointment Created");
				pStmt.close();
				
				
				
				
				
				
				//Create Bill
				query = "INSERT INTO bills VALUES (?, ?, billnumber.nextval, ?, ?, ?, ?, ?, ?)";
				pStmt = connection.prepareStatement(query);
				
				
				//Add patientSSN
				pStmt.setString(5, patientSSN);
				
				int immunization = 125;
				int checkup = 250;
				int prescription = 40;
				int consultation = 200;
				double totalCharge = 0;
				String services = "";
				
				if(chckbxConsultation.isSelected()) {
					//increase totalCharge by 200
					totalCharge+=consultation;
					//add consultation to services
					services = services + "consultation,";
				}
				if(chckbxPrescription.isSelected()) {
					//increase totalCharge by 40
					totalCharge+=prescription;
					//add prescription to services
					services = services + "prescription,";
				}
				if(chckbxCheckup.isSelected()) {
					totalCharge+=checkup;
					services = services + "checkup,";
					
				}
				if(chckbxImmunizations.isSelected()) {
					totalCharge+=immunization;
					services = services + "immunizations,";
				}
				
				
				pStmt.setDouble(1, totalCharge);
				pStmt.setDouble(2, totalCharge);
				pStmt.setInt(3, 0);
				pStmt.setInt(4,0);
				pStmt.setString(6, generatedApptNum);
				pStmt.setString(7,doctorsID_textField.getText());
				pStmt.setString(8, services);
				
				pStmt.executeQuery();
				pStmt.close();
				
				
			}catch (java.sql.SQLIntegrityConstraintViolationException e1) {
				JOptionPane.showMessageDialog(null, "Cannot be created due to an existing Patient SSN" + e1);
			} catch (SQLException e2) {
				e2.printStackTrace();
				JOptionPane.showMessageDialog(null, "Cannot insert NULL into one or more fields");
				
			}
				
			
		}
	});
		
		
	}
}
