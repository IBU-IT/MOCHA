package ba.ibu.edu.sis;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ba.ibu.edu.sis.SIS.Admin;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminOptions extends JFrame {

	public void setPozadina(JFrame frejm) {
		JLabel pozadina = new JLabel("");
		pozadina.setBounds(0, 0, 684, 473);
		pozadina.setIcon(new ImageIcon("burch2.jpg"));
		frejm.getContentPane().add(pozadina);
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
		btnAddStudent.setBounds(278, 270, 144, 56);
		contentPane.add(btnAddStudent);
		
		JButton btnAddProfessor = new JButton("Add Professor");
		btnAddProfessor.setBounds(278, 191, 144, 56);
		contentPane.add(btnAddProfessor);
		
		JButton btnAddCourse = new JButton("Add Course");
		btnAddCourse.setBounds(278, 349, 144, 56);
		contentPane.add(btnAddCourse);
		
	}
}
