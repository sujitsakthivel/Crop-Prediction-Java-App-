package Project;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class Home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	String Farmer_id;
	public static void home(String id, Farmer f) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home(id , f);
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
	public Home(String id, Farmer f) {
		Farmer user = f;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Home");
		lblNewLabel.setBounds(193, 10, 45, 13);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Add new Area");
		btnNewButton.setBounds(154, 75, 114, 21);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
						dispose();	
						New_Area n = new New_Area(f.id,f);
						n.newArea(f.id,f);
			}
		});

		JLabel lblNewLabel_1 = new JLabel("Welcome!" +  f.id);
		lblNewLabel_1.setBounds(181, 33, 114, 13);
		contentPane.add(lblNewLabel_1);
		int invi[] = {0,0,0,0,0};
		String name[] = {"","","","",""};
		int count ;
		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crop","root","");
		Statement stmt = con.createStatement();
		String sql = "Select Count(ID) from Areas where farmer_id='"+f.id+"' ";
		ResultSet rs=stmt.executeQuery(sql);
		rs.next();
		count = rs.getInt(1);
		for(int i=0;i<count;i++)
		{
			String sql1 = "Select * from Areas where farmer_id='"+f.id+"' ";
			ResultSet rs1=stmt.executeQuery(sql1);
			rs1.next();
			String d = rs1.getString("ID");
			String na = rs1.getString("name");
			String p= rs1.getString(3);
			
		String sql2 = "Select * from Soil where AREA_ID ='"+d+"' ";
			ResultSet rs2=stmt.executeQuery(sql2);
			rs2.next();	
			
			
			Area a1 = new Area(d,na,p,f.id,rs2.getString("ID"),rs2.getString("type"),rs2.getDouble("C_AMT"),rs2.getDouble("N_AMT"),rs2.getDouble("P_AMT"),rs2.getDouble("PH_AMT"),rs2.getDouble("PHP_AMT"));
			f.a[i] = a1;
			invi[i] = 1;
			name[i] = na;
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		JLabel lblNewLabel_2 = new JLabel("Areas");
		lblNewLabel_2.setBounds(28, 134, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		if(invi[0] == 1)
		{
		JButton one = new JButton(name[0]);
		one.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();	
				Area_Page w = new Area_Page(f.a[0]);
				w.area_win(f.a[0]);
				
			}
		});
		one.setBounds(28, 157, 85, 21);
		contentPane.add(one);
		}
		
		if(invi[1] == 1)
		{
		JButton two = new JButton("name[1]");
		two.setBounds(142, 157, 85, 21);
		contentPane.add(two);
		}
		
		if(invi[2] == 1)
		{
		JButton three = new JButton("name[2]");
		three.setBounds(272, 157, 85, 21);
		contentPane.add(three);
		}
		
		if(invi[3] == 1)
		{
		JButton four = new JButton("name[3]");
		four.setBounds(89, 200, 85, 21);
		contentPane.add(four);
		}
		
		if(invi[4] == 1)
		{
		JButton five = new JButton("name[4]");
		five.setBounds(210, 200, 85, 21);
		contentPane.add(five);
		}
		
		
		
		
	}
}
