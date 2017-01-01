package ba.ibu.edu.sis;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
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
		
		JLabel lblCourseName = new JLabel("COURSE NAME: "+ c.getCourseName());
		lblCourseName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCourseName.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(12, 68, 126)));
		lblCourseName.setForeground(new Color(12, 68, 126));
		lblCourseName.setBounds(25, 100, 200, 30);
		contentPane.add(lblCourseName);
		
		JLabel lblQuiz = new JLabel("Quiz: " + s.grades[i]);
		lblQuiz.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblQuiz.setForeground(new Color(12, 68, 126));
		lblQuiz.setBounds(25, 150, 200, 30);
		contentPane.add(lblQuiz);
		
		JLabel lblOmework = new JLabel("Homework: " + s.grades[i+1]);
		lblOmework.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblOmework.setForeground(new Color(12, 68, 126));
		lblOmework.setBounds(25, 185, 200, 30);
		contentPane.add(lblOmework);
		
		JLabel lblFinal = new JLabel("Final: "+ s.grades[i+2]);
		lblFinal.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFinal.setForeground(new Color(12, 68, 126));
		lblFinal.setBounds(25, 220, 200, 30);
		contentPane.add(lblFinal);
		
		JLabel lblMidtherm = new JLabel("Midtherm: "+ s.grades[i+3]);
		lblMidtherm.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMidtherm.setForeground(new Color(12, 68, 126));
		lblMidtherm.setBounds(25, 255, 200, 30);
		contentPane.add(lblMidtherm);
		
		JLabel lblAttendance = new JLabel("Attendance: "+ + s.grades[i+4]+ "%");
		lblAttendance.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAttendance.setForeground(new Color(12, 68, 126));
		lblAttendance.setBounds(25, 290, 200, 30);
		contentPane.add(lblAttendance);
	
		
		ImageIcon backIcon=new ImageIcon("back_icon.png");
		JButton lblLogout = new JButton(backIcon);;
		lblLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				frejm.setVisible(true);
			}
		});
		lblLogout.setForeground(Color.WHITE);
		lblLogout.setContentAreaFilled(false);
		lblLogout.setBounds(518, 20, 37, 30);
		lblLogout.setFont(new Font("TAHOMA", Font.BOLD, 11));
		lblLogout.setBorder(null);
		contentPane.add(lblLogout);
	}
}
