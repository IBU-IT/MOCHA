package ba.ibu.edu.sis;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ba.ibu.edu.sis.SIS.Admin;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

public class AdminOptions extends JFrame {

	public void setPozadina(JFrame frejm) {
		JLabel pozadina = new JLabel("");
		pozadina.setBounds(0, 0, 684, 473);
		pozadina.setIcon(new ImageIcon("burch2.jpg"));
		frejm.getContentPane().add(pozadina);
	}
	
	public void setLogo2(JFrame logo2Frame) {
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("logo_sis.png"));
		lblNewLabel_1.setBounds(274, 11, 268, 173);
		logo2Frame.getContentPane().add(lblNewLabel_1);
	}
	public void setPowered(JFrame pFrame) {
		JLabel lblNewLabel_2 = new JLabel("Powered by MOCHA");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(276, 445, 128, 21);
		pFrame.getContentPane().add(lblNewLabel_2);
	}

	public void homeButton(JFrame hFrame, int shift) {
		ImageIcon homeIcon=new ImageIcon("home_icon.png");
		JButton btnHome = new JButton(homeIcon);
		btnHome.setForeground(Color.WHITE);
		
		btnHome.setBounds(635, 20+shift, 30, 30);
		btnHome.setFont(new Font("TAHOMA", Font.BOLD, 13));
		btnHome.setContentAreaFilled(false);
		btnHome.setBorder(null);
		hFrame.getContentPane().add(btnHome);
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				hFrame.dispose();
				main(null);
			}
		});
	}

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
	
	}


	public AdminOptions(Admin a) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 511);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAddStudent = new JButton("Add Student");
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				SIS blabla = new SIS();
				blabla.init(a);	
				
			}
		});
		btnAddStudent.setBounds(268, 269, 144, 56);
		contentPane.add(btnAddStudent);
		
		JButton btnAddProfessor = new JButton("Add Professor");
		btnAddProfessor.setBounds(268, 190, 144, 56);
		contentPane.add(btnAddProfessor);
		
		JButton btnAddCourse = new JButton("Add Course");
		btnAddCourse.setBounds(268, 348, 144, 56);
		contentPane.add(btnAddCourse);
		
	}
}
