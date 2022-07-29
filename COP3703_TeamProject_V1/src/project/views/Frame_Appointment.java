package project.views;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;
import project.common.jdbc_connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.sql.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.Component;
import java.awt.Rectangle;
import javax.swing.SwingConstants;

import project.models.*;

public class Frame_Appointment extends JFrame {

	private JPanel contentPane;
	private JButton btnEdit;
	private JButton btnBack;
	private JScrollPane scrollPane;
	private JTable table;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame_Appointment frame = new Frame_Appointment();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection = null; // connection var
	private JButton btnCreate;
	private JButton btnBillAppt;
	private JTable table_1;

	/**
	 * Creates the frame.
	 */
	public Frame_Appointment() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Frame_Doctor.class.getResource("/project/resources/icon.png")));
		setTitle("Big Bob's Band-aids & More");
		init_components();
		create_events();
	}
	
	private void init_components() {
		connection = jdbc_connection.dbConnection(); //db connection
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 905, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		// Centers the Jframe
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		setContentPane(contentPane);
		
		btnEdit = new JButton("Edit");
		
		btnEdit.setFont(new Font("CMU Serif", Font.PLAIN, 25));
		
		btnBack = new JButton("Back");
		
		btnBack.setFont(new Font("CMU Serif", Font.PLAIN, 25));
		
		scrollPane = new JScrollPane();
		
		JLabel lblAppointments = new JLabel("Appointments");
		lblAppointments.setHorizontalAlignment(SwingConstants.CENTER);
		lblAppointments.setFont(new Font("CMU Serif", Font.BOLD, 24));
		
		btnCreate = new JButton("Create");
		btnCreate.setFont(new Font("CMU Serif", Font.PLAIN, 25));
		
		btnBillAppt = new JButton("Bill Appt");
		btnBillAppt.setFont(new Font("Dialog", Font.PLAIN, 25));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addComponent(btnCreate, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
							.addComponent(lblAppointments, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
							.addComponent(btnEdit, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
							.addComponent(btnBack, GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))
						.addComponent(btnBillAppt, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(29)
							.addComponent(lblAppointments, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
							.addComponent(btnCreate, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnEdit, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnBillAppt, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
							.addGap(5))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 335, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Appt #", "Room #", "Appt Date", "Doctor ID", "Patient SSN", "Appt Time"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table_1);
		
		table = new JTable();
		table.setColumnSelectionAllowed(true);
		
		contentPane.setLayout(gl_contentPane);
		
		
		try {
			String query = "SELECT * FROM appointments";
			PreparedStatement pStmt = connection.prepareStatement(query);
			ResultSet rs = pStmt.executeQuery();
			//table.setModel(DbUtils.resultSetToTableModel(rs));
			
			//Date dates;
			//dates = rs.getDate(3);
			SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");
			SimpleDateFormat aptDay = new SimpleDateFormat("MMM d, yyyy");
			List<Appointment> apptEntities = new ArrayList<>();
			
			while(rs.next()) {
				Appointment appt = new Appointment(
						rs.getString(1),
						rs.getString(2),
						aptDay.format(rs.getDate(3)),
						rs.getString(4),
						rs.getString(5),
						sdf.format(rs.getDate(6))
						);
				apptEntities.add(appt);
				
			}
			
			int i = 0;
			DefaultTableModel defModel = (DefaultTableModel) table_1.getModel();
			for (Appointment temp : apptEntities) {
				defModel.addRow(new Object[] {apptEntities.get(i).apptNum,apptEntities.get(i).roomNum,apptEntities.get(i).apptDate,apptEntities.get(i).doctorID,apptEntities.get(i).patientSSN,apptEntities.get(i).apptTime});
		       
		        i++;
		      }
			table.setModel(defModel);
			JScrollPane newScrollPane = new JScrollPane();
			newScrollPane.setViewportView(table);
			
			
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
	
	//////////////////////////////////////////////////////////
	// EVENT HANDLING
	//////////////////////////////////////////////////////////

	private void create_events() {
		
		
		// Switches to the Create appointment frame
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame_AppointmentCreate createAppt;
				try {
					createAppt = new Frame_AppointmentCreate();
					createAppt.setVisible(true);
					dispose();
				} catch (Error e1) {
					e1.printStackTrace();
				}
			}
		});
		
		// Switches to the Edit Appt Frame
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame_AppointmentEdit editAppt = new Frame_AppointmentEdit();
				editAppt.setVisible(true);
				dispose();
			}
		});
		
		//Switch to billing frame
		btnBillAppt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame_BillAppointment billAppt = new Frame_BillAppointment();
				billAppt.setVisible(true);
				dispose();
			}
		});
		
		// Switches to the Frame1 (main menu frame)
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				dispose();
				Frame1.main(null);
			}
		});
	}
}
