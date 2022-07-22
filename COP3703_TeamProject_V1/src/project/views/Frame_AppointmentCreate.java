package project.views;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

public class Frame_AppointmentCreate extends JFrame {

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
		init_components();
		create_events();

	}
	
	private void init_components() {
		setBounds(100, 100, 733, 466);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// CENTERS THE THINGY
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Create New Appointments");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(232, 11, 239, 40);
		getContentPane().add(lblNewLabel);
		
		
	}
	
	private void create_events() {
		
	}
}
