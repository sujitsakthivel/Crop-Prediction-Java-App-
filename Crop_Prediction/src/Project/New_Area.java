package Project;
import java.sql.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;

public class New_Area extends JFrame {

	private JPanel contentPane;
	private JTextField ID;
	private JTextField name;
	private JTextField pin;

	/**
	 * Launch the application.
	 */
	String Farmer_id;
	private JTextField c;
	private JTextField n;
	private JTextField p;
	private JTextField ph;
	private JTextField php;
	private JTextField Type;
	private JTextField soil_id;
	public static void newArea(String id, Farmer f) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					New_Area frame = new New_Area(id,f);
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
	public New_Area(String id, Farmer f) {
		Farmer_id = id;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New Area");
		lblNewLabel.setBounds(190, 10, 45, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Area ID");
		lblNewLabel_1.setBounds(24, 40, 96, 13);
		contentPane.add(lblNewLabel_1);
		
		ID = new JTextField();
		ID.setBounds(24, 63, 96, 19);
		contentPane.add(ID);
		ID.setColumns(10);
		
		name = new JTextField();
		name.setBounds(24, 115, 96, 19);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setBounds(24, 92, 96, 13);
		contentPane.add(lblNewLabel_2);
		
		pin = new JTextField();
		pin.setBounds(24, 163, 96, 19);
		contentPane.add(pin);
		pin.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("PINCODE");
		lblNewLabel_3.setBounds(24, 140, 96, 13);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crop","root","");
					Statement stmt = con.createStatement();
					
					String sql = "Insert Into Areas Values('"+ID.getText()+"', '"+name.getText()+"', '"+pin.getText()+"' ,'"+Farmer_id+"')";
					stmt.executeUpdate(sql);
					sql = "Insert Into soil Values('"+soil_id.getText()+"', '"+Type.getText()+"','"+Double.parseDouble(c.getText())+"', '"+Double.parseDouble(n.getText())+"' ,'"+Double.parseDouble(p.getText())+"','"+Double.parseDouble(ph.getText())+"' , '"+Double.parseDouble(php.getText())+"','"+ID.getText()+"')";
					stmt.executeUpdate(sql);
					dispose();
					Home h = new Home(Farmer_id,f);
					h.home(Farmer_id,f);
					con.close();
						
				}
				catch(Exception e) {System.out.print(e);}
			}
			
			});
		btnNewButton.setBounds(24, 251, 85, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("Carbon Amount");
		lblNewLabel_4.setBounds(177, 40, 78, 13);
		contentPane.add(lblNewLabel_4);
		
		c = new JTextField();
		c.setBounds(279, 37, 96, 19);
		contentPane.add(c);
		c.setColumns(10);
		
		n = new JTextField();
		n.setBounds(279, 63, 96, 19);
		contentPane.add(n);
		n.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Nitrogen Amount");
		lblNewLabel_5.setBounds(177, 66, 78, 13);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Phosphorus");
		lblNewLabel_6.setBounds(177, 92, 78, 13);
		contentPane.add(lblNewLabel_6);
		
		p = new JTextField();
		p.setBounds(279, 89, 96, 19);
		contentPane.add(p);
		p.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("PH Amount");
		lblNewLabel_7.setBounds(177, 118, 78, 13);
		contentPane.add(lblNewLabel_7);
		
		ph = new JTextField();
		ph.setBounds(279, 115, 96, 19);
		contentPane.add(ph);
		ph.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("PHP Amount");
		lblNewLabel_8.setBounds(177, 141, 78, 13);
		contentPane.add(lblNewLabel_8);
		
		php = new JTextField();
		php.setBounds(279, 144, 96, 19);
		contentPane.add(php);
		php.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Type");
		lblNewLabel_9.setBounds(177, 166, 45, 13);
		contentPane.add(lblNewLabel_9);
		
		Type = new JTextField();
		Type.setBounds(279, 173, 96, 19);
		contentPane.add(Type);
		Type.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Soil ID");
		lblNewLabel_10.setBounds(24, 192, 45, 13);
		contentPane.add(lblNewLabel_10);
		
		soil_id = new JTextField();
		soil_id.setBounds(24, 215, 96, 19);
		contentPane.add(soil_id);
		soil_id.setColumns(10);
		
		

	}
}
