package project.common;

import java.sql.*;
import javax.swing.*;

public class jdbc_connection {
	
	public static Connection dbConnection() {
		
		String url = "jdbc:oracle:thin:@cisvm-oracle.unfcsd.unf.edu:1521:orcl";
		String user = "T8";
		String pwd = "garbage1";
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection conn = DriverManager.getConnection(url, user, pwd);
//			JOptionPane.showMessageDialog(null, "Connection Successful!");
			
			return conn;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
			
			
			
		}
	}

}
