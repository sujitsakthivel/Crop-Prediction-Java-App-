package Project;

import java.awt.BorderLayout;

import java.awt.EventQueue;
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

import java.math.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Result extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void res(Area a) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Result frame = new Result( a);
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
	
	double in[] = new double[6];
	int j=0;
	public boolean result_check(Area a , crops_props c)
	{
			double cd = Math.abs(a.s.C_amt - c.C_req);
			double nd = Math.abs(a.s.N_amt - c.N_req);
			double pd = Math.abs(a.s.P_amt - c.P_req);
			double phd =Math.abs( a.s.PH_amt - c.Ph_req);
			double phpd = Math.abs(a.s.PHP_amt - c.Php_req);
		//	double tempd = Math.abs(a.w.temp_amt - c[i-1].temp_req;
			//double waterd =Math.abs( a.w.moisture_amt - c[i-1].water_req;
			
			if(  cd <= 5 && nd <= 5 && pd <= 5 && phd <= 1 && phpd <= 5 )
			{
				
				in[j++] = (cd+nd+pd+phd+phpd)/5;
				return true;
			}
			else
				return false;
		}
	
	
	
	public Result(Area a) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		crops_props c[] = new crops_props[6];
		for(int i=1;i<=6;i++)
		{			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crop","root","");
				Statement stmt = con.createStatement();
				String sql = "Select * from Crops where ID='"+i+"'";
				ResultSet rs=stmt.executeQuery(sql);
				rs=stmt.executeQuery(sql);
				rs.next();
				c[i-1] = new crops_props(rs.getString("id"), rs.getString("name"), rs.getString("type"), Double.parseDouble(rs.getString("C_REQ")), Double.parseDouble(rs.getString("N_REQ")), Double.parseDouble(rs.getString("P_REQ")), Double.parseDouble(rs.getString("PH_REQ")), Double.parseDouble(rs.getString("PHP_REQ")), Double.parseDouble(rs.getString("TEMP_REQ")), Double.parseDouble(rs.getString("WATER_REQ")));
								
			}
			catch(Exception e) {System.out.print(e);}
		}
		
		JLabel lblNewLabel = new JLabel("Result");
		lblNewLabel.setBounds(179, 21, 45, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Best Suitable Crops :");
		lblNewLabel_1.setBounds(38, 57, 103, 13);
		contentPane.add(lblNewLabel_1);
		
		
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(52, 98, 85, 21);
		
		JButton  btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(267, 98, 85, 21);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(74, 129, 45, 13);
		
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(291, 129, 45, 13);
		
		JButton  btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(52, 172, 85, 21);
	
		
		JButton  btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBounds(267, 172, 85, 21);
		
		
		JButton  btnNewButton_4 = new JButton("New button");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setBounds(52, 240, 85, 21);
		
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(74, 203, 45, 13);
	
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(291, 203, 45, 13);
		
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setBounds(74, 271, 45, 13);
	
		
		JButton btnNewButton_5 = new JButton("New button");
		btnNewButton_5.setBounds(267, 238, 85, 21);
		
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setBounds(291, 271, 45, 13);
		
		
		for(int i=1;i<=6;i++)
		{
			if(result_check(a , c[i-1]))
			{
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crop","root","");
					Statement stmt = con.createStatement();
					String sql = "Insert into result values('"+a.s.Soil_id+"' ,'"+c[i-1].crop_id+"', '"+in[i-1]+"'   )" ;
					stmt.executeUpdate(sql);						
				}
				catch(Exception e) {System.out.print(e);}
				
				if(i==1)
				{
					btnNewButton.setText(c[i-1].crop_name);
					contentPane.add(btnNewButton);
					lblNewLabel_2.setText(""+in[i-1]);;
					contentPane.add(lblNewLabel_2);
				}
				else if(i==2)
				{
					btnNewButton_1.setText(c[i-1].crop_name);
					contentPane.add(btnNewButton_1);
					
					lblNewLabel_3.setText(""+in[i-1]);;
					contentPane.add(lblNewLabel_3);
				
				}
				else if(i==3)
				{
					btnNewButton_2.setText(c[i-1].crop_name);
					contentPane.add(btnNewButton_2);
					
					lblNewLabel_4.setText(""+in[i-1]);;
					contentPane.add(lblNewLabel_4);
				}
				else if(i==4)
				{
					btnNewButton_3.setText(c[i-1].crop_name);
					contentPane.add(btnNewButton_3);
					
					lblNewLabel_5.setText(""+in[i-1]);;
					contentPane.add(lblNewLabel_5);
				}
				else if(i==5)
				{
					btnNewButton_4.setText(c[i-1].crop_name);
					contentPane.add(btnNewButton_4);
					
					lblNewLabel_6.setText(""+in[i-1]);;
					contentPane.add(lblNewLabel_6);
				}
				else if(i==6)
				{
					btnNewButton_5.setText(c[i-1].crop_name);
					contentPane.add(btnNewButton_5);
					
					lblNewLabel_7.setText(""+in[i-1]);;
					contentPane.add(lblNewLabel_7);
				}
			}
			
		}
	}

}
