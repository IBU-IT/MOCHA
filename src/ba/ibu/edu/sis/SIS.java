package ba.ibu.edu.sis;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import ba.ibu.edu.sis.AdminOptions;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;
import java.io.*;
import java.awt.Graphics;
import javax.swing.border.Border;
import javax.swing.BorderFactory;

public class SIS implements Serializable {

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	public JFrame login;
	private JFrame adminPage;

	private void setLogo2(JFrame logo2Frame) {
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("logo_sis.png"));
		lblNewLabel_1.setBounds(274, 11, 268, 90);
		logo2Frame.getContentPane().add(lblNewLabel_1);

		JLabel pozadina = new JLabel("");
		pozadina.setIcon(new ImageIcon("header-back.png"));
		pozadina.setBounds(0, 0, 684, 120);
		logo2Frame.getContentPane().add(pozadina);

	}

	private void setLogo(JFrame frejm) {
		JLabel lblNewLabel_logo = new JLabel("");
		lblNewLabel_logo.setIcon(new ImageIcon("logo_sis.png"));
		lblNewLabel_logo.setBounds(14, 5, 168, 83);
		frejm.getContentPane().add(lblNewLabel_logo);
	}

	private void setPozadina(JFrame frejm) {
		JLabel pozadina = new JLabel("");
		pozadina.setIcon(new ImageIcon("background.jpg"));
		pozadina.setBounds(0, 0, 684, 473);
		pozadina.setBackground(Color.WHITE);
		frejm.getContentPane().add(pozadina);
	}

	private void setPowered(JFrame pFrame) {
		JLabel lblNewLabel_2 = new JLabel("Powered by MOCHA");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(276, 440, 128, 21);
		pFrame.getContentPane().add(lblNewLabel_2);

		JLabel pozadina = new JLabel("");
		pozadina.setIcon(new ImageIcon("header-back.png"));
		pozadina.setBounds(0, 430, 684, 50);
		pFrame.getContentPane().add(pozadina);
	}

	private void homeButton(JFrame hFrame, int shift) {
		ImageIcon homeIcon = new ImageIcon("home_icon.png");
		JButton btnHome = new JButton(homeIcon);
		btnHome.setForeground(Color.WHITE);

		btnHome.setBounds(635, 20 + shift, 30, 30);
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


	public void prof_menu(JFrame nFrame, Professor pr, Admin a, JFrame frejm,  List<Course> lista) {
		SIS sis = new SIS();
		JButton btnEditMyProfile = new JButton("Edit my profile");
		btnEditMyProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEditMyProfile.setForeground(Color.WHITE);
		btnEditMyProfile.setBounds(470, 22, 150, 23);
		btnEditMyProfile.setFont(new Font("TAHOMA", Font.BOLD, 11));
		btnEditMyProfile.setContentAreaFilled(false);
		btnEditMyProfile.setBorder(null);

		nFrame.getContentPane().add(btnEditMyProfile);

		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nFrame.dispose();
				sis.init(pr, a,lista);

			}
		});
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setContentAreaFilled(false);
		btnLogout.setBounds(570, 22, 110, 23);
		btnLogout.setFont(new Font("TAHOMA", Font.BOLD, 11));
		btnLogout.setBorder(null);
		nFrame.getContentPane().add(btnLogout);

		JButton btnmess = new JButton("Messages");
		btnmess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnmess.setForeground(Color.WHITE);
		btnmess.setContentAreaFilled(false);
		btnmess.setBounds(400, 22, 110, 23);
		btnmess.setFont(new Font("TAHOMA", Font.BOLD, 11));
		btnmess.setBorder(null);
		nFrame.getContentPane().add(btnmess);
	}

	public SIS() {

	}

	static class Admin {
		public List<Student> Students = new ArrayList<Student>();
		public List<Professor> Professors = new ArrayList<Professor>();
		public List<Course> Courses = new ArrayList<Course>();

		private String password = "password";

		public String getPassword() {
			return password;
		}

		Student findStudent(String id) {

			for (Student c : Students) {
				if (c.getId().equals(id)) {
					return c;
				}
			}
			return null;
		}

		Student findStudent_name(String id) {

			for (Student c : Students) {
				if (c.getName().equals(id)) {
					return c;
				}
			}
			return null;
		}

		Course findCourse(String id) {

			for (Course course : Courses) {
				if (course.getCourseName().equals(id)) {
					return course;
				}
			}
			return null;
		}

		Course findCourse_id(String id) {

			for (Course course : Courses) {
				if (course.getCourseID().equals(id)) {
					return course;
				}
			}
			return null;
		}

		Professor findProfessor(String id) {

			for (Professor p : Professors) {
				if (p.getId().equals(id)) {
					return p;
				}
			}
			return null;
		}

		@SuppressWarnings("unchecked")
		public void restoreS() {
			try {
				ObjectInputStream in = new ObjectInputStream(new FileInputStream("students_ob.txt"));
				Students = (List<Student>) in.readObject();
				in.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		public void saveS() {
			try {
				ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("students_ob.txt"));
				out.writeObject(Students);
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		@SuppressWarnings("unchecked")
		public void restoreC() {
			try {
				ObjectInputStream in = new ObjectInputStream(new FileInputStream("courses_ob.txt"));
				Courses = (List<Course>) in.readObject();
				in.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		public void saveC() {
			try {
				ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("courses_ob.txt"));
				out.writeObject(Courses);
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		@SuppressWarnings("unchecked")
		public void restoreP() {
			try {
				ObjectInputStream in = new ObjectInputStream(new FileInputStream("professors_ob.txt"));
				Professors = (List<Professor>) in.readObject();
				in.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		public void saveP() {
			try {
				ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("professors_ob.txt"));
				out.writeObject(Professors);
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	static class Professor implements Serializable {

		private static final long serialVersionUID = 1L;

		public String getId() {
			return Id;
		}

		public String toString() {
			String output = "Professor name: " + getName() + "\n" + "Professor surname: " + getSurname()
					+ "\nProfessor ID: " + getId() + "\nProfessor email: " + getEmail() + "\nProfessor phone: "
					+ getPhone();
			return output;
		}

		public void setId(String id) {
			Id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getSurname() {
			return surname;
		}

		public void setSurname(String surname) {
			this.surname = surname;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getPassword() {
			return password;
		}

		private List<Course> MyCourses = new ArrayList<Course>();

		public List<Course> getMyCourses() {
			return MyCourses;
		}

		public void setMyCourses(List<Course> myCourses) {
			MyCourses = myCourses;
		}

		private String Id;
		private String name;
		private String surname;
		private String email;
		private String phone;
		private String password;
	}

	static class Student implements Serializable {

		private static final long serialVersionUID = 1L;
		private String id;
		private String email;
		private String nationality;
		private String password;

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getNationality() {
			return nationality;
		}

		public void setNationality(String nationality) {
			this.nationality = nationality;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getDateOfBirth() {
			return dateOfBirth;
		}

		public void setDateOfBirth(String dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}

		private String name;
		private String gender;
		private String surname;
		private String year;
		private String dateOfBirth;
		public int counter = 0;
		public double grades[] = new double[1000];
		public String korses[] = new String[100];
		private boolean hasCourse[] = new boolean[100];

		public boolean getHasCourse(int i) {
			return hasCourse[i];
		}

		public void setHasCourse(int i, boolean h) {
			hasCourse[i] = h;
		}

		public String getKorses(int i) {
			return korses[i];
		}

		public void setKorses(int i, String s) {
			korses[i] = s;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getSurname() {
			return surname;
		}

		public void setSurname(String surname) {
			this.surname = surname;
		}

		public String getYear() {
			return year;
		}

		public void setYear(String year) {
			this.year = year;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

	}

	public static void main(String[] args) {

		Admin admin = new Admin();
		admin.restoreC();
		admin.restoreP();
		admin.restoreS();
		Professor dino = new Professor();
		dino.setName("Dino Keco");
		dino.setId("1");
		dino.setPassword("1");
		admin.Professors.add(dino);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SIS window = new SIS(admin, dino, admin.Courses);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SIS(Admin a, Professor pr, List<Course> lista) {
		initialize(a, pr, lista);
	}

	interface Faculty {
		String name = " ";
		String Id = " ";

		void display_details();

		void conduct_session();
	}

	public void initOptions(Admin a, List<Course> lista) {
		AdminOptions AdminOptions;
		AdminOptions = new AdminOptions(a, lista);
		
		login = new JFrame();
		login.setVisible(true);
		login.setBounds(100, 100, 700, 511);
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login.getContentPane().setLayout(null);

		JPasswordField pwdEnterYourPassword = new JPasswordField();
		pwdEnterYourPassword.setBounds(190, 255, 300, 40);
		pwdEnterYourPassword.setBorder(BorderFactory.createMatteBorder(1, 3, 1, 1, new Color(118, 173, 224)));
		pwdEnterYourPassword.setHorizontalAlignment(SwingConstants.CENTER);
		login.getContentPane().add(pwdEnterYourPassword);
		pwdEnterYourPassword.grabFocus();

		JLabel lblNewLabel = new JLabel("Welcome to admin panel. Please enter your password bellow.");
		lblNewLabel.setForeground(new Color(32, 35, 86));
		lblNewLabel.setFont(new Font("TAHOMA", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setToolTipText("");
		lblNewLabel.setBounds(65, 190, 560, 56);
		login.getContentPane().add(lblNewLabel);
		setLogo2(login);
		homeButton(login, 0);

		JButton btnLogIn = new JButton("LOG IN");
		btnLogIn.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if (pwdEnterYourPassword.getText().equals(a.getPassword())) {
					login.dispose();
					
					AdminOptions.setVisible(true);
					
					AdminOptions.setHowdy(AdminOptions, a, lista);
					AdminOptions.setPozadina(AdminOptions, a, lista);

				} else {
					JOptionPane.showMessageDialog(null, "Wrong ID or password.");
				}
				pwdEnterYourPassword.setText("");
			}
		});
		btnLogIn.setBounds(240, 320, 200, 40);
		btnLogIn.setFont(new Font("TAHOMA", Font.PLAIN, 14));
		btnLogIn.setForeground(new Color(255, 255, 255));
		btnLogIn.setBackground(new Color(12, 68, 126));
		btnLogIn.setBorder(null);
		login.getContentPane().add(btnLogIn);
		login.getRootPane().setDefaultButton(btnLogIn);
		setPowered(login);
		setPozadina(login);
	}

	public void init(Admin a, List<Course> lista) {

		adminPage = new JFrame();
		adminPage.setVisible(true);
		AdminOptions AdminOptions;
		AdminOptions = new AdminOptions(a, lista);
		adminPage.setBounds(100, 100, 700, 511);
		adminPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		adminPage.getContentPane().setLayout(null);
		homeButton(adminPage, 45);

		JLabel lblStudentName = new JLabel("Student Name");
		lblStudentName.setFont(new Font("TAHOMA", Font.PLAIN, 12));
		lblStudentName.setForeground(new Color(32, 35, 86));
		lblStudentName.setBounds(23, 160, 137, 30);
		adminPage.getContentPane().add(lblStudentName);

		JLabel lblStudentSurname = new JLabel("Student Surname");
		lblStudentSurname.setBounds(23, 200, 137, 30);
		lblStudentSurname.setFont(new Font("TAHOMA", Font.PLAIN, 12));
		lblStudentSurname.setForeground(new Color(32, 35, 86));
		adminPage.getContentPane().add(lblStudentSurname);

		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setBounds(23, 240, 137, 30);
		lblStudentId.setFont(new Font("TAHOMA", Font.PLAIN, 12));
		lblStudentId.setForeground(new Color(32, 35, 86));
		adminPage.getContentPane().add(lblStudentId);

		JLabel lblStudentAge = new JLabel("Student Date of Birth");
		lblStudentAge.setBounds(23, 280, 137, 30);
		lblStudentAge.setFont(new Font("TAHOMA", Font.PLAIN, 12));
		lblStudentAge.setForeground(new Color(32, 35, 86));
		adminPage.getContentPane().add(lblStudentAge);

		JLabel lblStudentYear = new JLabel("Student Year");
		lblStudentYear.setBounds(340, 160, 137, 30);
		lblStudentYear.setFont(new Font("TAHOMA", Font.PLAIN, 12));
		lblStudentYear.setForeground(new Color(32, 35, 86));
		adminPage.getContentPane().add(lblStudentYear);

		JLabel lblStudentNationality = new JLabel("Student Nationality");
		lblStudentNationality.setBounds(340, 200, 137, 30);
		lblStudentNationality.setFont(new Font("TAHOMA", Font.PLAIN, 12));
		lblStudentNationality.setForeground(new Color(32, 35, 86));
		adminPage.getContentPane().add(lblStudentNationality);

		JLabel lblStudentPassword = new JLabel("Student Password");
		lblStudentPassword.setBounds(340, 240, 137, 30);
		lblStudentPassword.setFont(new Font("TAHOMA", Font.PLAIN, 12));
		lblStudentPassword.setForeground(new Color(32, 35, 86));
		adminPage.getContentPane().add(lblStudentPassword);

		JTextField textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(470, 240, 160, 30);
		textField_8.setBorder(BorderFactory.createMatteBorder(1, 3, 1, 1, new Color(118, 173, 224)));
		adminPage.getContentPane().add(textField_8);

		JTextField textField = new JTextField();
		textField.setBounds(155, 160, 160, 30);
		textField.setBorder(BorderFactory.createMatteBorder(1, 3, 1, 1, new Color(118, 173, 224)));
		adminPage.getContentPane().add(textField);
		textField.setColumns(10);

		JTextField textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(155, 200, 160, 30);
		textField_1.setBorder(BorderFactory.createMatteBorder(1, 3, 1, 1, new Color(118, 173, 224)));
		adminPage.getContentPane().add(textField_1);

		JTextField textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(155, 240, 160, 30);
		textField_2.setBorder(BorderFactory.createMatteBorder(1, 3, 1, 1, new Color(118, 173, 224)));
		adminPage.getContentPane().add(textField_2);

		JTextField textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(155, 280, 160, 30);
		textField_3.setBorder(BorderFactory.createMatteBorder(1, 3, 1, 1, new Color(118, 173, 224)));
		adminPage.getContentPane().add(textField_3);

		JTextField textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(470, 200, 160, 30);
		textField_4.setBorder(BorderFactory.createMatteBorder(1, 3, 1, 1, new Color(118, 173, 224)));
		adminPage.getContentPane().add(textField_4);

		JTextField textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(470, 280, 160, 30);
		textField_5.setBorder(BorderFactory.createMatteBorder(1, 3, 1, 1, new Color(118, 173, 224)));
		adminPage.getContentPane().add(textField_5);

		JTextField textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(470, 160, 160, 30);
		textField_7.setBorder(BorderFactory.createMatteBorder(1, 3, 1, 1, new Color(118, 173, 224)));
		adminPage.getContentPane().add(textField_7);

		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setFont(new Font("TAHOMA", Font.PLAIN, 12));
		rdbtnMale.setForeground(new Color(32, 35, 86));
		rdbtnMale.setBounds(155, 320, 66, 23);
		adminPage.getContentPane().add(rdbtnMale);

		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setFont(new Font("TAHOMA", Font.PLAIN, 12));
		rdbtnFemale.setForeground(new Color(32, 35, 86));
		rdbtnFemale.setBounds(223, 320, 66, 23);
		adminPage.getContentPane().add(rdbtnFemale);

		JLabel lblStudentEmail = new JLabel("Student Email");
		lblStudentEmail.setFont(new Font("TAHOMA", Font.PLAIN, 12));
		lblStudentEmail.setForeground(new Color(32, 35, 86));
		lblStudentEmail.setBounds(340, 280, 106, 25);
		adminPage.getContentPane().add(lblStudentEmail);

		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("TAHOMA", Font.PLAIN, 12));
		lblGender.setForeground(new Color(32, 35, 86));
		lblGender.setBounds(23, 320, 106, 25);
		adminPage.getContentPane().add(lblGender);

		
		ButtonGroup gender = new ButtonGroup();// so that only one button can be
												// selected
		gender.add(rdbtnFemale);
		gender.add(rdbtnMale);

		JButton btnNewButton = new JButton("Add Student");
		btnNewButton.addActionListener(new ActionListener() {
			private PrintStream q;

			public void actionPerformed(ActionEvent e) {
				try {
					FileOutputStream buf = new FileOutputStream("students.txt", true);
					q = new PrintStream(buf);
					q.print(textField.getText());
					q.print(",");
					q.print(textField_1.getText());
					q.print(",");
					q.print(textField_2.getText());
					q.print(",");
					q.print(textField_3.getText());
					q.print(",");
					q.print(textField_4.getText());
					q.print(",");
					q.print(textField_7.getText());
					q.print(",");
					q.print(textField_5.getText());
					q.print(",");

					if (rdbtnMale.isSelected()) {
						q.print("Male");
						q.print(",");
					} else {
						q.print("Female");
						q.print(",");
					}
				} catch (Exception a) {
					System.out.println(a);
				}
				if (a.findStudent(textField_2.getText()) != null) {
					JOptionPane.showMessageDialog(null, "This ID is already taken. Please enter another ID.");
				} else {
					Student kreten = new Student();
					kreten.setName(textField.getText());
					kreten.setSurname(textField_1.getText());
					kreten.setId(textField_2.getText());
					kreten.setDateOfBirth(textField_3.getText());
					kreten.setNationality(textField_4.getText());
					kreten.setYear(textField_7.getText());
					kreten.setEmail(textField_5.getText());
					kreten.setPassword(textField_8.getText());
					if (rdbtnMale.isSelected()) {
						kreten.setGender("Male");

					} else {
						kreten.setGender("Female");
					}
					a.Students.add(kreten);
					textField.setText(null);
					textField_1.setText(null);
					textField_2.setText(null);
					textField_3.setText(null);
					textField_4.setText(null);
					textField_7.setText(null);
					textField_5.setText(null);
					textField_8.setText(null);
					rdbtnMale.setSelected(false);
					rdbtnFemale.setSelected(false);
					JOptionPane.showMessageDialog(null, "Student successfully added!");
					a.saveS();
				}
			}
		});
		btnNewButton.setBounds(32, 370, 185, 40);
		btnNewButton.setFont(new Font("TAHOMA", Font.PLAIN, 12));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(12, 68, 126));
		btnNewButton.setBorder(null);
		adminPage.getContentPane().add(btnNewButton);

		JTextField textField_6 = new JTextField();
		textField_6.setBorder(BorderFactory.createMatteBorder(1, 3, 1, 1, new Color(118, 173, 224)));
		textField_6.setBounds(23, 110, 380, 30);
		adminPage.getContentPane().add(textField_6);
		textField_6.setColumns(10);

		JButton btnDeleteStudent = new JButton("Delete Student");
		btnDeleteStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Student todelete = a.findStudent(textField_2.getText());
				a.Students.remove(todelete);
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				textField_4.setText(null);
				textField_7.setText(null);
				textField_5.setText(null);
				textField_8.setText(null);
				rdbtnMale.setSelected(false);
				rdbtnFemale.setSelected(false);
				JOptionPane.showMessageDialog(null, "Student deleted.");
				a.saveS();
			}
		});
		btnDeleteStudent.setBounds(248, 370, 185, 40);
		btnDeleteStudent.setFont(new Font("TAHOMA", Font.PLAIN, 12));
		btnDeleteStudent.setForeground(new Color(255, 255, 255));
		btnDeleteStudent.setBackground(new Color(12, 68, 126));
		btnDeleteStudent.setBorder(null);
		adminPage.getContentPane().add(btnDeleteStudent);

		JButton btnNewButton_1 = new JButton("Update Student Information");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Student kreten = a.findStudent(textField_2.getText());
				kreten.setName(textField.getText());
				kreten.setSurname(textField_1.getText());
				kreten.setId(textField_2.getText());
				kreten.setDateOfBirth(textField_3.getText());
				kreten.setNationality(textField_4.getText());
				kreten.setYear(textField_7.getText());
				kreten.setPassword(textField_8.getText());
				kreten.setEmail(textField_5.getText());
				if (rdbtnMale.isSelected()) {
					kreten.setGender("Male");
				} else {
					kreten.setGender("Female");
				}
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				textField_4.setText(null);
				textField_7.setText(null);
				textField_8.setText(null);
				textField_5.setText(null);
				rdbtnMale.setSelected(false);
				rdbtnFemale.setSelected(false);
				JOptionPane.showMessageDialog(null, "Information updated.");
				a.saveS();
			}
		});
		btnNewButton_1.setBounds(466, 370, 185, 40);
		btnNewButton_1.setFont(new Font("TAHOMA", Font.PLAIN, 12));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(12, 68, 126));
		btnNewButton_1.setBorder(null);
		adminPage.getContentPane().add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("Search by Student ID");
		lblNewLabel.setForeground(new Color(12, 68, 126));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(23, 80, 186, 40);
		adminPage.getContentPane().add(lblNewLabel);

		JButton btnNewButton_2 = new JButton("Go");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Student wanted = a.findStudent(textField_6.getText());
				if (a.findStudent(textField_6.getText()) == null) {
					JOptionPane.showMessageDialog(null, "Student not found.");
					textField_6.setText(null);
				} else {
					textField.setText(wanted.getName());
					textField_1.setText(wanted.getSurname());
					textField_2.setText(wanted.getId());
					textField_3.setText(wanted.getDateOfBirth());
					textField_4.setText(wanted.getNationality());
					textField_7.setText(wanted.getYear());
					textField_5.setText(wanted.getEmail());
					textField_8.setText(wanted.getPassword());
					if (wanted.getGender() == "Male") {
						rdbtnMale.setSelected(true);
					} else {
						rdbtnFemale.setSelected(true);
					}
					textField_6.setText(null);
				}
			}
		});
		btnNewButton_2.setBounds(420, 110, 52, 30);
		btnNewButton_2.setFont(new Font("TAHOMA", Font.PLAIN, 13));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(12, 68, 126));
		btnNewButton_2.setBorder(null);
		adminPage.getContentPane().add(btnNewButton_2);
		
		AdminOptions.setHowdy(adminPage, a, lista);
		AdminOptions.setPozadina(adminPage, a, lista);
		
		a.saveS();
	}

	public void init(Professor pr, Admin a,List<Course> lista) {
		Course c = new Course();
		JFrame loginProf = new JFrame();
		loginProf.setVisible(true);
		loginProf.setBounds(100, 100, 700, 511);
		loginProf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		loginProf.getContentPane().setLayout(null);
		JTextField textField = new JTextField();
		textField.setBounds(190, 220, 300, 40);
		loginProf.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setBorder(BorderFactory.createMatteBorder(1, 3, 1, 1, new Color(118, 173, 224)));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.grabFocus();

		JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(190, 300, 300, 40);
		passwordField.setBorder(BorderFactory.createMatteBorder(1, 3, 1, 1, new Color(118, 173, 224)));
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		loginProf.getContentPane().add(passwordField);

		JLabel lblWelcome = new JLabel("Welcome to professor panel. Please, enter your ID and password below.");
		lblWelcome.setFont(new Font("TAHOMA", Font.PLAIN, 14));
		lblWelcome.setForeground(new Color(32, 35, 86));
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setBounds(65, 142, 560, 56);
		loginProf.getContentPane().add(lblWelcome);
		setLogo2(loginProf);
		homeButton(loginProf, 0);

		JLabel lblId = new JLabel("ID number");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setBounds(170, 195, 100, 25);
		lblId.setForeground(new Color(32, 35, 86));
		loginProf.getContentPane().add(lblId);

		JLabel lblPw = new JLabel("Password");
		lblPw.setHorizontalAlignment(SwingConstants.CENTER);
		lblPw.setBounds(170, 275, 100, 25);
		lblPw.setForeground(new Color(32, 35, 86));
		loginProf.getContentPane().add(lblPw);

		JButton button = new JButton("LOG IN");
		button.setBounds(240, 370, 200, 40);
		button.setFont(new Font("TAHOMA", Font.PLAIN, 14));
		button.setForeground(new Color(255, 255, 255));
		button.setBackground(new Color(12, 68, 126));
		button.setBorder(null);

		button.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				Professor profa = a.findProfessor(textField.getText());
				if (passwordField.getText().equals(profa.getPassword())) {
					AdminOptions AdminOptions;
					AdminOptions = new AdminOptions(a, lista);
					loginProf.dispose();

					ProfessorPanel loginProfPage = new ProfessorPanel(a, profa);
					loginProfPage.setVisible(true);
					loginProfPage.setBounds(100, 100, 700, 511);
					loginProfPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					loginProfPage.getContentPane().setLayout(null);
					
					
					JLabel lblNewLabel_2 = new JLabel("");
					lblNewLabel_2.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(12, 68, 126)));
					lblNewLabel_2.setBounds(23, 50, 635, 100);
					loginProfPage.getContentPane().add(lblNewLabel_2);

					if (profa.MyCourses.size() > 0) {
						JButton btnAddNewCourse = new JButton(profa.getMyCourses().get(0).getCourseName());
						btnAddNewCourse.setBounds(32, 180, 185, 90);
						btnAddNewCourse.setFont(new Font("TAHOMA", Font.PLAIN, 14));
						btnAddNewCourse.setForeground(new Color(255, 255, 255));
						btnAddNewCourse.setBackground(new Color(12, 68, 126));
						btnAddNewCourse.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, new Color(118, 173, 224)));
						btnAddNewCourse.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								loginProfPage.setVisible(false);
								c.course_inf(profa, a, a.findCourse(profa.getMyCourses().get(0).getCourseName()),
										loginProfPage,lista);
							}

						});
						loginProfPage.getContentPane().add(btnAddNewCourse);
					}
					if (profa.MyCourses.size() > 1) {
						JButton btnAddNewCourse = new JButton(profa.getMyCourses().get(1).getCourseName());
						btnAddNewCourse.setBounds(248, 180, 185, 90);
						btnAddNewCourse.setFont(new Font("TAHOMA", Font.PLAIN, 14));
						btnAddNewCourse.setForeground(new Color(255, 255, 255));
						btnAddNewCourse.setBackground(new Color(12, 68, 126));
						btnAddNewCourse.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, new Color(118, 173, 224)));
						btnAddNewCourse.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								loginProfPage.setVisible(false);
								c.course_inf(profa, a, a.findCourse(profa.getMyCourses().get(1).getCourseName()),
										loginProfPage,lista);
							}

						});
						loginProfPage.getContentPane().add(btnAddNewCourse);
					}
					if (profa.MyCourses.size() > 2) {
						JButton btnAddNewCourse = new JButton(profa.getMyCourses().get(2).getCourseName());
						btnAddNewCourse.setBounds(466, 180, 185, 90);
						btnAddNewCourse.setFont(new Font("TAHOMA", Font.PLAIN, 14));
						btnAddNewCourse.setForeground(new Color(255, 255, 255));
						btnAddNewCourse.setBackground(new Color(12, 68, 126));
						btnAddNewCourse.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, new Color(118, 173, 224)));
						btnAddNewCourse.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								loginProfPage.setVisible(false);
								c.course_inf(profa, a, a.findCourse(profa.getMyCourses().get(2).getCourseName()),
										loginProfPage,lista);
							}

						});
						loginProfPage.getContentPane().add(btnAddNewCourse);
					}
					if (profa.MyCourses.size() > 3) {
						JButton btnAddNewCourse = new JButton(profa.getMyCourses().get(3).getCourseName());
						btnAddNewCourse.setBounds(32, 300, 185, 90);
						btnAddNewCourse.setFont(new Font("TAHOMA", Font.PLAIN, 14));
						btnAddNewCourse.setForeground(new Color(255, 255, 255));
						btnAddNewCourse.setBackground(new Color(12, 68, 126));
						btnAddNewCourse.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, new Color(118, 173, 224)));
						btnAddNewCourse.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								loginProfPage.setVisible(false);
								c.course_inf(profa, a, a.findCourse(profa.getMyCourses().get(3).getCourseName()),
										loginProfPage,lista);
							}

						});
						loginProfPage.getContentPane().add(btnAddNewCourse);
					}
					if (profa.MyCourses.size() > 4) {
						JButton btnAddNewCourse = new JButton(profa.getMyCourses().get(4).getCourseName());
						btnAddNewCourse.setBounds(248, 300, 185, 90);
						btnAddNewCourse.setFont(new Font("TAHOMA", Font.PLAIN, 14));
						btnAddNewCourse.setForeground(new Color(255, 255, 255));
						btnAddNewCourse.setBackground(new Color(12, 68, 126));
						btnAddNewCourse.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, new Color(118, 173, 224)));
						btnAddNewCourse.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								loginProfPage.setVisible(false);
								c.course_inf(profa, a, a.findCourse(profa.getMyCourses().get(4).getCourseName()),
										loginProfPage,lista);
							}

						});
						loginProfPage.getContentPane().add(btnAddNewCourse);
					}
					if (profa.MyCourses.size() > 5) {
						JButton btnAddNewCourse = new JButton(profa.getMyCourses().get(5).getCourseName());
						btnAddNewCourse.setBounds(466, 300, 185, 90);
						btnAddNewCourse.setFont(new Font("TAHOMA", Font.PLAIN, 14));
						btnAddNewCourse.setForeground(new Color(255, 255, 255));
						btnAddNewCourse.setBackground(new Color(12, 68, 126));
						btnAddNewCourse.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, new Color(118, 173, 224)));
						btnAddNewCourse.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								loginProfPage.setVisible(false);
								c.course_inf(profa, a, a.findCourse(profa.getMyCourses().get(5).getCourseName()),
										loginProfPage,lista);
							}

						});
						loginProfPage.getContentPane().add(btnAddNewCourse);
					}

					AdminOptions.setHowdyPr(loginProfPage, a, lista);
					AdminOptions.setPozadina(loginProfPage, a, lista);
				} else

				{
					JOptionPane.showMessageDialog(null, "Wrong password or ID. Please try again.");
				}
				passwordField.setText("");
				textField.setText("");
			}
		});
		
		loginProf.getContentPane().add(button);
		loginProf.getRootPane().setDefaultButton(button);
		setPowered(loginProf);
		setPozadina(loginProf);
	}

	private void init_stud(Admin a, List<Course> lista) {
		AdminOptions AdminOptions;
		AdminOptions = new AdminOptions(a, lista);
		JFrame loginStudent = new JFrame();
		loginStudent.setVisible(true);
		loginStudent.setBounds(100, 100, 700, 511);
		loginStudent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginStudent.getContentPane().setLayout(null);
		setLogo2(loginStudent);
		homeButton(loginStudent, 0);

		JLabel label = new JLabel("Welcome to student panel. Please, enter you ID and password bellow.");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setForeground(new Color(32, 35, 86));
		label.setBounds(65, 142, 560, 56);
		loginStudent.getContentPane().add(label);

		JTextField textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(190, 220, 300, 40);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBorder(BorderFactory.createMatteBorder(1, 3, 1, 1, new Color(118, 173, 224)));
		loginStudent.getContentPane().add(textField);

		JPasswordField passwordField = new JPasswordField(16);
		passwordField.setBounds(190, 300, 300, 40);
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBorder(BorderFactory.createMatteBorder(1, 3, 1, 1, new Color(118, 173, 224)));
		loginStudent.getContentPane().add(passwordField);

		JLabel label_1 = new JLabel("ID number");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(150, 195, 100, 25);
		label_1.setForeground(new Color(32, 35, 86));
		loginStudent.getContentPane().add(label_1);

		JLabel label_2 = new JLabel("Password");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(150, 275, 100, 25);
		label_2.setForeground(new Color(32, 35, 86));
		loginStudent.getContentPane().add(label_2);


		JButton button = new JButton("LOG IN");
		button.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				Student xStudent = a.findStudent(textField.getText());

				if (xStudent == null) {
					JOptionPane.showMessageDialog(null, "Wrong ID");

				} else if (xStudent.getPassword().equals(passwordField.getText())) {
					loginStudent.dispose();
					JFrame stdLogIn = new JFrame("Welcome " + xStudent.name);
					stdLogIn.setVisible(true);
					stdLogIn.setBounds(100, 100, 700, 511);
					stdLogIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					stdLogIn.getContentPane().setLayout(null);
					
					ImageIcon logoutIcon=new ImageIcon("settings.png");
					JButton btnEdit = new JButton(logoutIcon);
					btnEdit.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							stdLogIn.dispose();
							JFrame editProfile = new JFrame();
							editProfile.setVisible(true);
							editProfile.setBounds(100, 100, 700, 511);
							editProfile.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							editProfile.getContentPane().setLayout(null);

							JLabel lblStudentName = new JLabel("Student Name");
							lblStudentName.setFont(new Font("TAHOMA", Font.PLAIN, 12));
							lblStudentName.setForeground(new Color(32, 35, 86));
							lblStudentName.setBounds(23, 110, 137, 30);
							editProfile.getContentPane().add(lblStudentName);

							JLabel lblStudentSurname = new JLabel("Student Surname");
							lblStudentSurname.setFont(new Font("TAHOMA", Font.PLAIN, 12));
							lblStudentSurname.setForeground(new Color(32, 35, 86));
							lblStudentSurname.setBounds(23, 150, 137, 30);
							editProfile.getContentPane().add(lblStudentSurname);

							JLabel lblStudentId = new JLabel("Student ID");
							lblStudentId.setFont(new Font("TAHOMA", Font.PLAIN, 12));
							lblStudentId.setForeground(new Color(32, 35, 86));
							lblStudentId.setBounds(23, 190, 137, 30);
							editProfile.getContentPane().add(lblStudentId);

							JLabel lblStudentAge = new JLabel("Student Date of Birth");
							lblStudentAge.setFont(new Font("TAHOMA", Font.PLAIN, 12));
							lblStudentAge.setForeground(new Color(32, 35, 86));
							lblStudentAge.setBounds(23, 230, 137, 30);
							editProfile.getContentPane().add(lblStudentAge);

							JLabel lblStudentYear = new JLabel("Student Year");
							lblStudentYear.setFont(new Font("TAHOMA", Font.PLAIN, 12));
							lblStudentYear.setForeground(new Color(32, 35, 86));
							lblStudentYear.setBounds(23, 270, 137, 30);
							editProfile.getContentPane().add(lblStudentYear);

							JLabel lblGender = new JLabel("Gender");
							lblGender.setFont(new Font("TAHOMA", Font.PLAIN, 12));
							lblGender.setForeground(new Color(32, 35, 86));
							lblGender.setBounds(23, 310, 137, 30);
							editProfile.getContentPane().add(lblGender);

							JLabel lblStudentNationality = new JLabel("Student Nationality");
							lblStudentNationality.setFont(new Font("TAHOMA", Font.PLAIN, 12));
							lblStudentNationality.setForeground(new Color(32, 35, 86));
							lblStudentNationality.setBounds(340, 110, 137, 30);
							editProfile.getContentPane().add(lblStudentNationality);

							JLabel lblStudentEmail = new JLabel("Student Email");
							lblStudentEmail.setFont(new Font("TAHOMA", Font.PLAIN, 12));
							lblStudentEmail.setForeground(new Color(32, 35, 86));
							lblStudentEmail.setBounds(340, 150, 137, 30);
							editProfile.getContentPane().add(lblStudentEmail);

							JLabel lblStudentPassword = new JLabel("Student Password");
							lblStudentPassword.setFont(new Font("TAHOMA", Font.PLAIN, 12));
							lblStudentPassword.setForeground(new Color(32, 35, 86));
							lblStudentPassword.setBounds(340, 190, 137, 30);
							editProfile.getContentPane().add(lblStudentPassword);

							JTextField textField = new JTextField();
							textField.setBounds(155, 110, 160, 30);
							textField.setBorder(BorderFactory.createMatteBorder(1, 3, 1, 1, new Color(118, 173, 224)));
							textField.setColumns(10);
							textField.setText(xStudent.getName());
							editProfile.getContentPane().add(textField);

							JTextField textField_1 = new JTextField();
							textField_1.setBounds(155, 150, 160, 30);
							textField_1.setBorder(BorderFactory.createMatteBorder(1, 3, 1, 1, new Color(118, 173, 224)));
							textField_1.setText(xStudent.getSurname());
							editProfile.getContentPane().add(textField_1);

							JTextField textField_2 = new JTextField();
							textField_2.setColumns(10);
							textField_2.setBounds(155, 190, 160, 30);
							textField_2.setBorder(BorderFactory.createMatteBorder(1, 3, 1, 1, new Color(118, 173, 224)));
							textField_2.setText(xStudent.getId());
							editProfile.getContentPane().add(textField_2);

							JTextField textField_3 = new JTextField();
							textField_3.setColumns(10);
							textField_3.setBounds(155, 230, 160, 30);
							textField_3.setBorder(BorderFactory.createMatteBorder(1, 3, 1, 1, new Color(118, 173, 224)));
							textField_3.setText(xStudent.getDateOfBirth());
							editProfile.getContentPane().add(textField_3);

							JTextField textField_4 = new JTextField();
							textField_4.setColumns(10);
							textField_4.setBounds(155, 270, 160, 30);
							textField_4.setBorder(BorderFactory.createMatteBorder(1, 3, 1, 1, new Color(118, 173, 224)));
							textField_4.setText(xStudent.getNationality());
							editProfile.getContentPane().add(textField_4);

							JTextField textField_5 = new JTextField();
							textField_5.setColumns(10);
							textField_5.setBounds(470, 110, 160, 30);
							textField_5.setBorder(BorderFactory.createMatteBorder(1, 3, 1, 1, new Color(118, 173, 224)));
							textField_5.setText(xStudent.getEmail());
							editProfile.getContentPane().add(textField_5);

							JTextField textField_6 = new JTextField();
							textField_6.setColumns(10);
							textField_6.setBounds(470, 150, 160, 30);
							textField_6.setBorder(BorderFactory.createMatteBorder(1, 3, 1, 1, new Color(118, 173, 224)));
							textField_6.setText(xStudent.getYear());
							editProfile.getContentPane().add(textField_6);

							JTextField textField_7 = new JTextField();
							textField_7.setColumns(10);
							textField_7.setBounds(470, 190, 160, 30);
							textField_7.setBorder(BorderFactory.createMatteBorder(1, 3, 1, 1, new Color(118, 173, 224)));
							textField_7.setText(xStudent.getPassword());
							editProfile.getContentPane().add(textField_7);

							JRadioButton rdbtnMale = new JRadioButton("Male");
							rdbtnMale.setFont(new Font("TAHOMA", Font.PLAIN, 12));
							rdbtnMale.setForeground(new Color(32, 35, 86));
							rdbtnMale.setBounds(155, 310, 66, 23);
							editProfile.getContentPane().add(rdbtnMale);

							JRadioButton rdbtnFemale = new JRadioButton("Female");
							rdbtnFemale.setFont(new Font("TAHOMA", Font.PLAIN, 12));
							rdbtnFemale.setForeground(new Color(32, 35, 86));
							rdbtnFemale.setBounds(223, 310, 66, 23);
							editProfile.getContentPane().add(rdbtnFemale);

							ButtonGroup gender = new ButtonGroup();// so that
																	// only one
																	// button
																	// can be
																	// selected
							gender.add(rdbtnFemale);
							gender.add(rdbtnMale);

							if (xStudent.getGender() == "Male") {
								rdbtnMale.setSelected(true);
							} else {
								rdbtnFemale.setSelected(true);
							}

							JButton btnUpdate = new JButton("Update student information");
							btnUpdate.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent arg0) {
									xStudent.setName(textField.getText());
									xStudent.setSurname(textField_1.getText());
									xStudent.setId(textField_2.getText());
									xStudent.setDateOfBirth(textField_3.getText());
									xStudent.setYear(textField_6.getText());
									xStudent.setNationality(textField_4.getText());
									xStudent.setEmail(textField_5.getText());
									xStudent.setPassword(textField_7.getText());

									if (rdbtnMale.isSelected()) {
										xStudent.setGender("Male");
									} else {
										xStudent.setGender("Female");
									}
									JOptionPane.showMessageDialog(null, "Information updated.");

									textField.setText(null);
									textField_1.setText(null);
									textField_2.setText(null);
									textField_3.setText(null);
									textField_4.setText(null);
									textField_5.setText(null);
									textField_6.setText(null);
									textField_7.setText(null);
									rdbtnMale.setSelected(false);
									rdbtnFemale.setSelected(false);

									a.saveS();

								}
							});
							btnUpdate.setBounds(340, 290, 290, 40);
							btnUpdate.setFont(new Font("TAHOMA", Font.PLAIN, 14));
							btnUpdate.setForeground(new Color(255, 255, 255));
							btnUpdate.setBorder(null);
							btnUpdate.setBackground(new Color(12, 68, 126));
							editProfile.getContentPane().add(btnUpdate);
							

						
							ImageIcon backIcon=new ImageIcon("back_icon.png");
							JButton btnBack = new JButton(backIcon);;
							btnBack.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent arg0) {
									editProfile.dispose();
									stdLogIn.setVisible(true);
								}
							});
							btnBack.setForeground(Color.WHITE);
							btnBack.setContentAreaFilled(false);
							btnBack.setBounds(518, 20, 37, 30);
							btnBack.setFont(new Font("TAHOMA", Font.BOLD, 11));
							btnBack.setBorder(null);
							editProfile.getContentPane().add(btnBack);

							
						
							AdminOptions.setHowdyStd(editProfile, a, lista);
							AdminOptions.setPozadina(editProfile, a, lista);

						}
					});
					btnEdit.setForeground(Color.WHITE);
					btnEdit.setContentAreaFilled(false);
					btnEdit.setBounds(525, 20, 30, 30);
					btnEdit.setFont(new Font("TAHOMA", Font.BOLD, 11));
					btnEdit.setBorder(null);
					stdLogIn.getContentPane().add(btnEdit);

					
					
					int kanter = 0;
					for (int i = 0; i < 100; i++) {
						if (xStudent.getHasCourse(i)==true) {
							kanter++;
							}
						}
					//JOptionPane.showMessageDialog(null, kanter);
					
							/*for (int i = 0; i < 100; i++) {
								if (xStudent.getHasCourse(i)==true) {
									for(int j=0;j<5;j++){
										JOptionPane.showMessageDialog(null, xStudent.grades[j]);
									}
									JOptionPane.showMessageDialog(null,xStudent.korses[i]);
								}
							}*/

							//stdLogIn.dispose();
					
							JFrame gradesF = new JFrame("Welcome " + xStudent.name);
							gradesF.setVisible(false);
							gradesF.setBounds(100, 100, 700, 511);
							gradesF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							gradesF.getContentPane().setLayout(null);
							AdminOptions.setHowdyStd(AdminOptions, a, lista);
							AdminOptions.setPozadina(gradesF, a, lista);
							
							

			
					if(kanter>0){
						JButton btnAddNewCourse = new JButton(xStudent.korses[0]);
						btnAddNewCourse.setBounds(32, 180, 185, 90);
						btnAddNewCourse.setFont(new Font("TAHOMA", Font.PLAIN, 14));
						btnAddNewCourse.setForeground(new Color(255, 255, 255));
						btnAddNewCourse.setBackground(new Color(12, 68, 126));
						btnAddNewCourse.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, new Color(118, 173, 224)));
						btnAddNewCourse.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								stdLogIn.setVisible(false);
								gradess gradess = new gradess(stdLogIn, xStudent, a.findCourse(xStudent.korses[0]),0);
								gradess.setVisible(true);
								AdminOptions.setHowdyStd(gradess, a, lista);
								AdminOptions.setPozadina(gradess, a, lista);
								
							}

						});
						stdLogIn.getContentPane().add(btnAddNewCourse);
					}
					if(kanter>1){
						JButton btnAddNewCourse = new JButton(xStudent.korses[5]);
						btnAddNewCourse.setBounds(248, 180, 185, 90);
						btnAddNewCourse.setFont(new Font("TAHOMA", Font.PLAIN, 14));
						btnAddNewCourse.setForeground(new Color(255, 255, 255));
						btnAddNewCourse.setBackground(new Color(12, 68, 126));
						btnAddNewCourse.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, new Color(118, 173, 224)));
						btnAddNewCourse.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								gradess gradess = new gradess(stdLogIn, xStudent, a.findCourse(xStudent.korses[5]),5);
								gradess.setVisible(true);
								AdminOptions.setHowdyStd(gradess, a, lista);
								AdminOptions.setPozadina(gradess, a, lista);
							}

						});
						stdLogIn.getContentPane().add(btnAddNewCourse);
					}
					if(kanter>2){
						JButton btnAddNewCourse = new JButton(xStudent.korses[10]);
						btnAddNewCourse.setBounds(466, 180, 185, 90);
						btnAddNewCourse.setFont(new Font("TAHOMA", Font.PLAIN, 14));
						btnAddNewCourse.setForeground(new Color(255, 255, 255));
						btnAddNewCourse.setBackground(new Color(12, 68, 126));
						btnAddNewCourse.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, new Color(118, 173, 224)));
						btnAddNewCourse.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								gradess gradess = new gradess(stdLogIn, xStudent, a.findCourse(xStudent.korses[10]),10);
								gradess.setVisible(true);
								AdminOptions.setHowdyStd(gradess, a, lista);
								AdminOptions.setPozadina(gradess, a, lista);
							}

						});
						stdLogIn.getContentPane().add(btnAddNewCourse);
					}
					if(kanter>3){
						JButton btnAddNewCourse = new JButton(xStudent.korses[15]);
						btnAddNewCourse.setBounds(32, 300, 185, 90);
						btnAddNewCourse.setFont(new Font("TAHOMA", Font.PLAIN, 14));
						btnAddNewCourse.setForeground(new Color(255, 255, 255));
						btnAddNewCourse.setBackground(new Color(12, 68, 126));
						btnAddNewCourse.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, new Color(118, 173, 224)));
						btnAddNewCourse.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								gradess gradess = new gradess(stdLogIn, xStudent, a.findCourse(xStudent.korses[15]),15);
								gradess.setVisible(true);
								AdminOptions.setHowdyStd(gradess, a, lista);
								AdminOptions.setPozadina(gradess, a, lista);
							}

						});
						stdLogIn.getContentPane().add(btnAddNewCourse);
					}
					if(kanter>4){
						JButton btnAddNewCourse = new JButton(xStudent.korses[20]);
						btnAddNewCourse.setBounds(248, 300, 185, 90);
						btnAddNewCourse.setFont(new Font("TAHOMA", Font.PLAIN, 14));
						btnAddNewCourse.setForeground(new Color(255, 255, 255));
						btnAddNewCourse.setBackground(new Color(12, 68, 126));
						btnAddNewCourse.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, new Color(118, 173, 224)));
						btnAddNewCourse.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								gradess gradess = new gradess(stdLogIn, xStudent, a.findCourse(xStudent.korses[20]),20);
								gradess.setVisible(true);
								AdminOptions.setHowdyStd(gradess, a, lista);
								AdminOptions.setPozadina(gradess, a, lista);
							}

						});
						stdLogIn.getContentPane().add(btnAddNewCourse);
					}
					if(kanter>5){
						JButton btnAddNewCourse = new JButton(xStudent.korses[25]);
						btnAddNewCourse.setBounds(466, 300, 185, 90);
						btnAddNewCourse.setFont(new Font("TAHOMA", Font.PLAIN, 14));
						btnAddNewCourse.setForeground(new Color(255, 255, 255));
						btnAddNewCourse.setBackground(new Color(12, 68, 126));
						btnAddNewCourse.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, new Color(118, 173, 224)));
						btnAddNewCourse.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								gradess gradess = new gradess(stdLogIn, xStudent, a.findCourse(xStudent.korses[25]),25);
								gradess.setVisible(true);
								AdminOptions.setHowdyStd(gradess, a, lista);
								AdminOptions.setPozadina(gradess, a, lista);
							}

						});
						stdLogIn.getContentPane().add(btnAddNewCourse);
					}
					AdminOptions.setHowdyStd(stdLogIn, a, lista);
					AdminOptions.setPozadina(stdLogIn, a, lista);
				} else {
					JOptionPane.showMessageDialog(null, "Wrong password ");
					textField.grabFocus();
				}

				textField.setText("");
				passwordField.setText("");

			}
		});
		textField.grabFocus();
		button.setBackground(new Color(12, 68, 126));
		button.setFont(new Font("TAHOMA", Font.PLAIN, 14));
		button.setForeground(new Color(255, 255, 255));
		button.setBounds(240, 360, 200, 40);
		button.setBorder(null);
		loginStudent.getContentPane().add(button);
		loginStudent.getRootPane().setDefaultButton(button);
		setPozadina(loginStudent);
		setPowered(loginStudent);
	}

	private void initialize(Admin a, Professor pr, List<Course> lista) {

		frame = new JFrame();
		frame.setBounds(100, 100, 700, 511);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblWelcomeToStudent = new JLabel("WELCOME TO MOCHA | SIS");
		lblWelcomeToStudent.setBounds(60, 142, 560, 56);
		lblWelcomeToStudent.setForeground(new Color(32, 35, 86));
		lblWelcomeToStudent.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblWelcomeToStudent.setHorizontalAlignment(SwingConstants.CENTER);

		ImageIcon homeIcon = new ImageIcon("button-student.png");
		JButton button = new JButton("Login as student");
		button.setFont(new Font("TAHOMA", Font.PLAIN, 14));
		button.setForeground(new Color(255, 255, 255));
		button.setBackground(new Color(12, 68, 126));
		button.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, new Color(118, 173, 224)));
		button.setBounds(32, 230, 185, 100);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				SIS studentWindow = new SIS();
				studentWindow.init_stud(a,lista);
			}
		});
		frame.getContentPane().add(button);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lblWelcomeToStudent);

		ImageIcon homeIcon2 = new ImageIcon("LOGIN AS ADMIN");
		JButton button_1 = new JButton("Login as admin");
		button_1.setBounds(466, 230, 185, 100);
		button_1.setFont(new Font("TAHOMA", Font.PLAIN, 14));
		button_1.setForeground(new Color(255, 255, 255));
		button_1.setBackground(new Color(12, 68, 126));
		button_1.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, new Color(118, 173, 224)));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				SIS prozor = new SIS();
				prozor.initOptions(a, lista);
			}
		});
		frame.getContentPane().add(button_1);

		ImageIcon homeIcon3 = new ImageIcon("button-prof.png");
		JButton button_2 = new JButton("Login as professor");
		button_2.setForeground(new Color(255, 255, 255));
		button_2.setFont(new Font("TAHOMA", Font.PLAIN, 14));
		button_2.setBackground(new Color(12, 68, 126));
		button_2.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, new Color(118, 173, 224)));
		button_2.setBounds(248, 230, 185, 100);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				SIS prof = new SIS();
				prof.init(pr, a,lista);
			}
		});

		frame.getContentPane().add(button_2);

		setLogo2(frame);
		setPowered(frame);
		setPozadina(frame);

	}

}
