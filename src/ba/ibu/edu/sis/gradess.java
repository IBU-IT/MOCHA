package ba.ibu.edu.sis;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ba.ibu.edu.sis.SIS.Student;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class gradess extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public gradess(JFrame frejm, Student s,Course c,int i) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 511);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCourseName = new JLabel("Course Name: "+ c.getCourseName());
		lblCourseName.setBounds(59, 94, 180, 28);
		lblCourseName.setFont(new Font("TAHOMA", Font.PLAIN, 14));
		lblCourseName.setForeground(Color.WHITE);
		contentPane.add(lblCourseName);
		
		JLabel lblQuiz = new JLabel("Quiz: " + s.grades[i]);
		lblQuiz.setBounds(59, 155, 180, 28);
		lblQuiz.setFont(new Font("TAHOMA", Font.PLAIN, 14));
		lblQuiz.setForeground(Color.WHITE);
		contentPane.add(lblQuiz);
		
		JLabel lblOmework = new JLabel("Homework: " + s.grades[i+1]);
		lblOmework.setBounds(59, 216, 180, 28);
		lblOmework.setFont(new Font("TAHOMA", Font.PLAIN, 14));
		lblOmework.setForeground(Color.WHITE);
		contentPane.add(lblOmework);
		
		JLabel lblFinal = new JLabel("Final: "+ s.grades[i+2]);
		lblFinal.setBounds(59, 277, 180, 28);
		lblFinal.setFont(new Font("TAHOMA", Font.PLAIN, 14));
		lblFinal.setForeground(Color.WHITE);
		contentPane.add(lblFinal);
		
		JLabel lblMidtherm = new JLabel("Midtherm: "+ s.grades[i+3]);
		lblMidtherm.setBounds(59, 338, 180, 28);
		lblMidtherm.setFont(new Font("TAHOMA", Font.PLAIN, 14));
		lblMidtherm.setForeground(Color.WHITE);
		contentPane.add(lblMidtherm);
		
		JLabel lblAttendance = new JLabel("Attendance: "+ + s.grades[i+4]+ "%");
		lblAttendance.setBounds(59, 399, 180, 28);
		lblAttendance.setFont(new Font("TAHOMA", Font.PLAIN, 14));
		lblAttendance.setForeground(Color.WHITE);
		contentPane.add(lblAttendance);
		
		
		JButton lblLogout = new JButton("Back");
		lblLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				frejm.setVisible(true);
			}
		});
		lblLogout.setForeground(Color.BLACK);
		lblLogout.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLogout.setBounds(530, 42, 120, 28);
		contentPane.add(lblLogout);
	}
}
