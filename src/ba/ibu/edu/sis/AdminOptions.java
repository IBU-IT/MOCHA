package ba.ibu.edu.sis;


import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import ba.ibu.edu.sis.Course;
import ba.ibu.edu.sis.SIS.Admin;
import ba.ibu.edu.sis.AddProfessor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import ba.ibu.edu.sis.SIS;

public class AdminOptions extends JFrame {

	public void setPozadina(JFrame frejm, Admin a,List<Course> lista) {
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("logo_sis_small.png"));
		lblNewLabel_1.setBounds(40, 11, 100, 50);
		frejm.getContentPane().add(lblNewLabel_1);
		
		JLabel pozadina1 = new JLabel("");
		pozadina1.setIcon(new ImageIcon("header-back.png"));
		pozadina1.setBounds(20, 0, 100, 70);
		frejm.getContentPane().add(pozadina1);
		
		JLabel lblNewLabel_2 = new JLabel("Powered by MOCHA");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(276, 440, 128, 21);
		frejm.getContentPane().add(lblNewLabel_2);

		JLabel pozadina2 = new JLabel("");
		pozadina2.setIcon(new ImageIcon("header-back.png"));
		pozadina2.setBounds(0, 430, 684, 50);
		frejm.getContentPane().add(pozadina2);
		
		ImageIcon homeIcon=new ImageIcon("home_icon.png");
		JButton btnHome = new JButton(homeIcon);
		btnHome.setForeground(Color.WHITE);
		
		btnHome.setBounds(635, 20, 30, 30);
		btnHome.setFont(new Font("TAHOMA", Font.BOLD, 13));
		btnHome.setContentAreaFilled(false);
		btnHome.setBorder(null);
		frejm.getContentPane().add(btnHome);
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frejm.dispose();
				SIS.main(null);
			}
		});
		
		ImageIcon logoutIcon=new ImageIcon("logout.png");
		JButton btnLogout = new JButton(logoutIcon);	
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frejm.dispose();
				SIS prozor = new SIS();
				SIS.main(null);
			}
		});
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setContentAreaFilled(false);
		btnLogout.setBounds(580, 20, 29, 30);
		btnLogout.setFont(new Font("TAHOMA", Font.BOLD, 11));
		btnLogout.setBorder(null);
		frejm.add(btnLogout);
		
		
		JLabel pozadina = new JLabel("");
		pozadina.setIcon(new ImageIcon("background.jpg"));
		pozadina.setBounds(0, 0, 684, 473);
		pozadina.setBackground(Color.WHITE);
		frejm.getContentPane().add(pozadina);
	}
	
	public void setHowdy(JFrame frejm, Admin a,List<Course> lista) {
		JLabel lblNewLabel_4 = new JLabel("Howdy, Admin");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(300, 0, 300, 30);
		frejm.add(lblNewLabel_4);

		JLabel pozadina4 = new JLabel("");
		pozadina4.setIcon(new ImageIcon("header-back.png"));
		pozadina4.setBounds(200, 0, 300, 30);
		frejm.add(pozadina4);
		
	}
	
	public void setHowdyPr(JFrame frejm, Admin a,List<Course> lista) {
		JLabel lblNewLabel_4 = new JLabel("Howdy, Professor");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(300, 0, 300, 30);
		frejm.add(lblNewLabel_4);

		JLabel pozadina4 = new JLabel("");
		pozadina4.setIcon(new ImageIcon("header-back.png"));
		pozadina4.setBounds(200, 0, 300, 30);
		frejm.add(pozadina4);
		
	}
	
	public void setHowdyStd(JFrame frejm, Admin a,List<Course> lista) {
		JLabel lblNewLabel_4 = new JLabel("Howdy, Student");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(300, 0, 300, 30);
		frejm.add(lblNewLabel_4);

		JLabel pozadina4 = new JLabel("");
		pozadina4.setIcon(new ImageIcon("header-back.png"));
		pozadina4.setBounds(200, 0, 300, 30);
		frejm.add(pozadina4);
		
	}
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
	
	}


	public AdminOptions(Admin a,List<Course> lista) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 511);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		JButton btnAddStudent = new JButton("Add Student");
		btnAddStudent.setBounds(32, 180, 185, 100);
		btnAddStudent.setFont(new Font("TAHOMA", Font.PLAIN, 14));
		btnAddStudent.setForeground(new Color(255, 255, 255));
		btnAddStudent.setBackground(new Color(12, 68, 126));
		btnAddStudent.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, new Color(118, 173, 224)));
		contentPane.add(btnAddStudent);
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				SIS blabla = new SIS();
				blabla.init(a, lista);	
				
			}
		});
		
		JButton btnAddProfessor = new JButton("Add Professor");
		btnAddProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				AddProfessor AddProfessor;
				AddProfessor = new AddProfessor(a,lista);
				AddProfessor.setVisible(true);
				setHowdy(AddProfessor,a,lista);
				setPozadina(AddProfessor,a,lista);
				
			}
		});
		btnAddProfessor.setBounds(248, 180, 185, 100);
		btnAddProfessor.setFont(new Font("TAHOMA", Font.PLAIN, 14));
		btnAddProfessor.setForeground(new Color(255, 255, 255));
		btnAddProfessor.setBackground(new Color(12, 68, 126));
		btnAddProfessor.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, new Color(118, 173, 224)));
		contentPane.add(btnAddProfessor);
		
		
		JButton btnAddCourse = new JButton("Add Course");
		btnAddCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Course c = new Course();
				c.blabla(a, a.Courses);
				
			}
		});
		btnAddCourse.setBounds(466, 180, 185, 100);
		btnAddCourse.setFont(new Font("TAHOMA", Font.PLAIN, 14));
		btnAddCourse.setForeground(new Color(255, 255, 255));
		btnAddCourse.setBackground(new Color(12, 68, 126));
		btnAddCourse.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, new Color(118, 173, 224)));
		contentPane.add(btnAddCourse);
		
	}
}
