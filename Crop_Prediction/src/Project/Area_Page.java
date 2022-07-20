package Project;
import java.sql.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class Area_Page extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void area_win(Area a) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Area_Page frame = new Area_Page(a);
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
	public Area_Page(Area a) {
		Area b =a;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(a.name);
		lblNewLabel.setBounds(166, 22, 45, 13);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Manage Area");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				update u =new update(b);
				u.up(b);
			}
		});
		btnNewButton.setBounds(295, 62, 107, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Find Crops");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Result r = new Result(b);
				r.res(b);
			}
		});
		btnNewButton_1.setBounds(31, 62, 101, 21);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(166, 122, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(166, 145, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(166, 168, 45, 13);
		contentPane.add(lblNewLabel_3);
	}

}
