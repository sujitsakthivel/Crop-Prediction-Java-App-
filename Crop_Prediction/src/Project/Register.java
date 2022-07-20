package Project;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JTextField name;
	private JTextField dob;
	private JTextField ph;
	private JPasswordField pass;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void newWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 305, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Register");
		lblNewLabel.setBounds(22, 35, 154, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("User Name");
		lblNewLabel_1.setBounds(22, 70, 96, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setBounds(22, 122, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		user = new JTextField();
		user.setBounds(22, 93, 96, 19);
		contentPane.add(user);
		user.setColumns(10);
		
		name = new JTextField();
		name.setBounds(22, 145, 96, 19);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setBounds(22, 174, 96, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Date of Birth");
		lblNewLabel_4.setBounds(22, 226, 96, 13);
		contentPane.add(lblNewLabel_4);
		
		dob = new JTextField();
		dob.setBounds(22, 249, 96, 19);
		contentPane.add(dob);
		dob.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Phone Number");
		lblNewLabel_5.setBounds(22, 278, 96, 13);
		contentPane.add(lblNewLabel_5);
		
		ph = new JTextField();
		ph.setBounds(22, 300, 96, 19);
		contentPane.add(ph);
		ph.setColumns(10);
		
		pass = new JPasswordField();
		pass.setBounds(22, 197, 101, 19);
		contentPane.add(pass);
		
		btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crop","root","");
					Statement stmt = con.createStatement();
					
					String sql = "Insert Into Farmer Values('"+name.getText()+"', '"+dob.getText()+"', '"+ph.getText()+"' ,'"+user.getText()+"','"+pass.getText()+"' )";
					stmt.executeUpdate(sql);
					dispose();
					Login l = new Login();
					l.main(null);
					con.close();
						
				}
				catch(Exception e) {System.out.print(e);}
			}
			
			});
		btnNewButton.setBounds(10, 342, 85, 21);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Sign In");
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login l = new Login();
				l.main(null);
			}
		});
		
		btnNewButton_1.setBounds(129, 342, 85, 21);
		contentPane.add(btnNewButton_1);
	}

}
