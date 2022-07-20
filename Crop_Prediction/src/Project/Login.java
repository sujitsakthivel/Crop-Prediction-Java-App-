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
import java.awt.Font;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JLabel lblNewLabel_2;
	private JPasswordField pass;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(33, 10, 90, 47);
		contentPane.add(lblNewLabel);
		
		user = new JTextField();
		user.setBounds(33, 97, 96, 19);
		contentPane.add(user);
		user.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("UserName");
		lblNewLabel_1.setBounds(33, 78, 74, 13);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(33, 126, 94, 13);
		contentPane.add(lblNewLabel_2);
		
		pass = new JPasswordField();
		pass.setBounds(33, 146, 94, 19);
		contentPane.add(pass);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crop","root","");
					Statement stmt = con.createStatement();
					String sql = "Select ID,Password from Farmer where ID='"+user.getText()+"' and Password='"+pass.getText().toString()+"'";
					ResultSet rs=stmt.executeQuery(sql);
					if(rs.next())
					{
						dispose();			
						sql = "Select name,DOB,Phone,ID,Password from Farmer where ID='"+user.getText()+"' ";
						rs=stmt.executeQuery(sql);
						rs.next();
						Farmer f = new Farmer(rs.getString("name"),rs.getString("DOB"),rs.getString("Phone"),rs.getString("ID"),rs.getString("Password"));		
						Home h = new Home(user.getText(),f);
						h.home(user.getText(),f);
						
					}
					else
						JOptionPane.showMessageDialog(null, "Login Failed...");
					con.close();
						
				}
				catch(Exception e) {System.out.print(e);}
			}
		});
		btnNewButton.setBounds(37, 175, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.setBounds(141, 175, 85, 21);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Register r = new Register();
				r.newWindow();															
			}
		});
	}
}
