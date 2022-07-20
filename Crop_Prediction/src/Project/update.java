package Project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class update extends JFrame {

	private JPanel contentPane;
	private JTextField n;
	private JTextField p;
	private JTextField si;
	private JTextField c;
	private JTextField ni;
	private JTextField pho;
	private JTextField ph;
	private JTextField php;

	/**
	 * Launch the application.
	 */
	public static void up(Area a) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					update frame = new update(a);
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
	public update(Area a) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Modify Area");
		lblNewLabel.setBounds(177, 10, 45, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(177, 34, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		n = new JTextField();
		n.setText(a.name);
		n.setBounds(187, 57, 96, 19);
		contentPane.add(n);
		n.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setBounds(52, 60, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Pincode");
		lblNewLabel_3.setBounds(52, 87, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		p = new JTextField();
		p.setText(a.pincode);
		p.setBounds(187, 84, 96, 19);
		contentPane.add(p);
		p.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Soil Type");
		lblNewLabel_4.setBounds(52, 117, 45, 13);
		contentPane.add(lblNewLabel_4);
		
		si = new JTextField();
		si.setText(a.s.type);
		si.setBounds(187, 113, 96, 19);
		contentPane.add(si);
		si.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Carbon Amount");
		lblNewLabel_5.setBounds(52, 152, 111, 13);
		contentPane.add(lblNewLabel_5);
		
		c = new JTextField();
		c.setText(a.s.C_amt+"");
		c.setBounds(187, 149, 96, 19);
		contentPane.add(c);
		c.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Nitrogen Amount");
		lblNewLabel_6.setBounds(52, 181, 77, 13);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Phosphorous Amount");
		lblNewLabel_7.setBounds(52, 218, 119, 13);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Ph Amount");
		lblNewLabel_8.setBounds(52, 254, 96, 13);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Php Amount");
		lblNewLabel_9.setBounds(52, 283, 96, 13);
		contentPane.add(lblNewLabel_9);
		
		ni = new JTextField();
		ni.setText(a.s.N_amt+"");
		ni.setBounds(187, 178, 96, 19);
		contentPane.add(ni);
		ni.setColumns(10);
		
		pho = new JTextField();
		pho.setText(a.s.P_amt+"");
		pho.setBounds(187, 215, 96, 19);
		contentPane.add(pho);
		pho.setColumns(10);
		
		ph = new JTextField();
		ph.setText(a.s.PH_amt+"");
		ph.setBounds(187, 251, 96, 19);
		contentPane.add(ph);
		ph.setColumns(10);
		
		php = new JTextField();
		php.setText(a.s.PHP_amt+"");
		php.setBounds(187, 280, 96, 19);
		contentPane.add(php);
		php.setColumns(10);
		
		JButton btnNewButton = new JButton("Modify");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crop","root","");
					Statement stmt = con.createStatement();
					
					String sql = "Update Areas SET  name = '"+n.getText()+"', pincode = '"+p.getText()+"' Where ID = '"+a.Area_id+"'";
					stmt.executeUpdate(sql);
					sql =  "Update Soil SET  type = '"+si.getText()+"', C_AMT = '"+Double.parseDouble(c.getText())+"', N_AMT = '"+Double.parseDouble(ni.getText())+"' ,P_AMT = '"+Double.parseDouble(p.getText())+"',PH_AMT = '"+Double.parseDouble(ph.getText())+"' , PHP_AMT = '"+Double.parseDouble(php.getText())+"' Where ID = '"+a.s.Soil_id+"'";
					stmt.executeUpdate(sql);
					dispose();
					
					a.update(n.getText(),p.getText(),si.getText(),Double.parseDouble(c.getText()),Double.parseDouble(ni.getText()),Double.parseDouble(p.getText()),Double.parseDouble(ph.getText()),Double.parseDouble(php.getText()));
					Area_Page ap = new Area_Page(a);
					ap.area_win(a);
					con.close();
						
				}
				catch(Exception u) {System.out.print(u);}
			}
			
			});
		btnNewButton.setBounds(71, 324, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete Area");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crop","root","");
					Statement stmt = con.createStatement();
					
					String sql = "Drop * from Soil where ID='"+a.s.Soil_id +"'";
					stmt.executeUpdate(sql);
					sql =  "Drop * from Area where ID='"+a.Area_id+"'";
					stmt.executeUpdate(sql);
					dispose();
					Area_Page ap = new Area_Page(a);
					ap.area_win(a);
					con.close();
				}
				catch(Exception u) {System.out.print(u);}
			}
			});
		btnNewButton_1.setBounds(255, 324, 111, 21);
		contentPane.add(btnNewButton_1);
	}
}
