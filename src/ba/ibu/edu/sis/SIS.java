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
import java.awt.Graphics;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import java.io.*;

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

	public void prof_menu(JFrame nFrame, Professor pr, Admin a) {
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
				sis.init(pr, a);

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

		Course findCourse(String id) {

			for (Course course : Courses) {
				if (course.getCourseName().equals(id)) {
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
		/**
		 * 
		 */
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
		private int grades[];

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

		public int[] getGrades() {
			return grades;
		}

		public void setGrades(int[] grades) {
			this.grades = grades;
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
		login = new JFrame();
		login.setVisible(true);
		login.setBounds(100, 100, 700, 511);
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login.getContentPane().setLayout(null);

		JPasswordField pwdEnterYourPassword = new JPasswordField();
		pwdEnterYourPassword.setBounds(190, 255, 300, 40);
		pwdEnterYourPassword.setHorizontalAlignment(SwingConstants.CENTER);
		login.getContentPane().add(pwdEnterYourPassword);
		pwdEnterYourPassword.setBorder(BorderFactory.createMatteBorder(1, 3, 1, 1, new Color(118, 173, 224)));
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
					AdminOptions AdminOptions;
					AdminOptions = new AdminOptions(a, lista);
					AdminOptions.setVisible(true);
					AdminOptions.setPowered(AdminOptions);
					homeButton(AdminOptions, 0);
					AdminOptions.setLogo2(AdminOptions);
					AdminOptions.setPozadina(AdminOptions);

				} else {
					JOptionPane.showMessageDialog(null, "ne moze");
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
		adminPage.setBounds(100, 100, 700, 511);
		adminPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		adminPage.getContentPane().setLayout(null);
		homeButton(adminPage, 45);

		JLabel lblStudentName = new JLabel("Student Name");
		lblStudentName.setFont(new Font("TAHOMA", Font.PLAIN, 14));
		lblStudentName.setForeground(Color.WHITE);
		lblStudentName.setBounds(23, 30, 106, 25);
		adminPage.getContentPane().add(lblStudentName);

		JLabel lblStudentSurname = new JLabel("Student Surname");
		lblStudentSurname.setBounds(23, 73, 126, 25);
		lblStudentSurname.setFont(new Font("TAHOMA", Font.PLAIN, 14));
		lblStudentSurname.setForeground(Color.WHITE);
		adminPage.getContentPane().add(lblStudentSurname);

		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setBounds(23, 122, 106, 25);
		lblStudentId.setFont(new Font("TAHOMA", Font.PLAIN, 14));
		lblStudentId.setForeground(Color.WHITE);
		adminPage.getContentPane().add(lblStudentId);

		JLabel lblStudentAge = new JLabel("Student Date of Birth");
		lblStudentAge.setBounds(23, 171, 146, 25);
		lblStudentAge.setFont(new Font("TAHOMA", Font.PLAIN, 14));
		lblStudentAge.setForeground(Color.WHITE);
		adminPage.getContentPane().add(lblStudentAge);

		JLabel lblStudentYear = new JLabel("Student Year");
		lblStudentYear.setBounds(23, 220, 106, 25);
		lblStudentYear.setFont(new Font("TAHOMA", Font.PLAIN, 14));
		lblStudentYear.setForeground(Color.WHITE);
		adminPage.getContentPane().add(lblStudentYear);

		JLabel lblStudentNationality = new JLabel("Student Nationality");
		lblStudentNationality.setBounds(23, 318, 126, 25);
		lblStudentNationality.setFont(new Font("TAHOMA", Font.PLAIN, 14));
		lblStudentNationality.setForeground(Color.WHITE);
		adminPage.getContentPane().add(lblStudentNationality);

		JLabel lblStudentPassword = new JLabel("Student Password");
		lblStudentPassword.setBounds(23, 416, 126, 25);
		lblStudentPassword.setFont(new Font("TAHOMA", Font.PLAIN, 14));
		lblStudentPassword.setForeground(Color.WHITE);
		adminPage.getContentPane().add(lblStudentPassword);

		JTextField textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(155, 416, 137, 25);
		adminPage.getContentPane().add(textField_8);

		JTextField textField = new JTextField();
		textField.setBounds(155, 25, 137, 25);
		adminPage.getContentPane().add(textField);
		textField.setColumns(10);

		JTextField textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(155, 75, 137, 25);
		adminPage.getContentPane().add(textField_1);

		JTextField textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(155, 125, 137, 25);
		adminPage.getContentPane().add(textField_2);

		JTextField textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(155, 175, 137, 25);
		adminPage.getContentPane().add(textField_3);

		JTextField textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(155, 318, 137, 25);
		adminPage.getContentPane().add(textField_4);

		JTextField textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(155, 367, 137, 25);
		adminPage.getContentPane().add(textField_5);

		JTextField textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(155, 225, 137, 25);
		adminPage.getContentPane().add(textField_7);

		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setFont(new Font("TAHOMA", Font.BOLD, 12));
		rdbtnMale.setForeground(Color.BLACK);
		rdbtnMale.setBounds(155, 275, 66, 23);
		adminPage.getContentPane().add(rdbtnMale);

		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setFont(new Font("TAHOMA", Font.BOLD, 12));
		rdbtnFemale.setForeground(Color.BLACK);
		rdbtnFemale.setBounds(223, 275, 66, 23);
		adminPage.getContentPane().add(rdbtnFemale);

		ButtonGroup gender = new ButtonGroup();// so that only one button can be
												// selected
		gender.add(rdbtnFemale);
		gender.add(rdbtnMale);

		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				adminPage.dispose();
				SIS prozor = new SIS();
				prozor.initOptions(a, lista);
			}
		});
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setContentAreaFilled(false);
		btnLogout.setBounds(590, 102, 110, 23);
		btnLogout.setFont(new Font("TAHOMA", Font.BOLD, 11));
		btnLogout.setBorder(null);
		adminPage.getContentPane().add(btnLogout);

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
		btnNewButton.setBounds(319, 330, 140, 40);
		adminPage.getContentPane().add(btnNewButton);

		JTextField textField_6 = new JTextField();
		textField_6.setBounds(486, 17, 129, 40);
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
		btnDeleteStudent.setBounds(486, 330, 140, 40);
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
		btnNewButton_1.setBounds(370, 381, 207, 65);
		adminPage.getContentPane().add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("Search by Student ID");
		lblNewLabel.setFont(new Font("TAHOMA", Font.PLAIN, 14));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(344, 22, 159, 31);
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
		btnNewButton_2.setBounds(622, 17, 52, 40);
		adminPage.getContentPane().add(btnNewButton_2);

		JLabel lblStudentEmail = new JLabel("Student Email");
		lblStudentEmail.setFont(new Font("TAHOMA", Font.PLAIN, 14));
		lblStudentEmail.setForeground(Color.WHITE);
		lblStudentEmail.setBounds(23, 367, 106, 25);
		adminPage.getContentPane().add(lblStudentEmail);

		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("TAHOMA", Font.PLAIN, 14));
		lblGender.setForeground(Color.WHITE);
		lblGender.setBounds(23, 269, 106, 25);
		adminPage.getContentPane().add(lblGender);
		setPowered(adminPage);
		setPozadina(adminPage);

		a.saveS();
	}

	public void init(Professor pr, Admin a) {
		Course c = new Course();
		JFrame loginProf = new JFrame();
		loginProf.setVisible(true);
		loginProf.setBounds(100, 100, 700, 511);
		loginProf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		loginProf.getContentPane().setLayout(null);
		JTextField textField = new JTextField();
		textField.setBounds(240, 220, 200, 35);
		loginProf.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.grabFocus();

		JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(240, 300, 200, 35);
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		loginProf.getContentPane().add(passwordField);

		JLabel lblWelcome = new JLabel("Welcome to professor panel. Please, enter your ID and password below");
		lblWelcome.setFont(new Font("TAHOMA", Font.BOLD, 14));
		lblWelcome.setForeground(Color.WHITE);
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setBounds(65, 142, 560, 56);
		loginProf.getContentPane().add(lblWelcome);
		setLogo2(loginProf);
		homeButton(loginProf, 0);

		JLabel lblId = new JLabel("ID number");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setBounds(220, 195, 100, 25);
		lblId.setForeground(Color.WHITE);
		loginProf.getContentPane().add(lblId);

		JLabel lblPw = new JLabel("Password");
		lblPw.setHorizontalAlignment(SwingConstants.CENTER);
		lblPw.setBounds(220, 275, 100, 25);
		lblPw.setForeground(Color.WHITE);
		loginProf.getContentPane().add(lblPw);

		JButton button = new JButton("Log In");

		button.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				Professor profa = a.findProfessor(textField.getText());
				if (passwordField.getText().equals(profa.getPassword())) {
					loginProf.dispose();

					ProfessorPanel loginProfPage = new ProfessorPanel(a, profa);
					loginProfPage.setVisible(true);
					loginProfPage.setBounds(100, 100, 700, 511);
					loginProfPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					loginProfPage.getContentPane().setLayout(null);
					prof_menu(loginProfPage, profa, a);

					if (profa.MyCourses.size() > 0) {
						JButton btnAddNewCourse = new JButton(profa.getMyCourses().get(0).getCourseName());
						btnAddNewCourse.setBounds(40, 250, 180, 80);
						btnAddNewCourse.setBackground(SystemColor.inactiveCaptionBorder);
						btnAddNewCourse.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								loginProfPage.dispose();
								c.course_inf(profa, a);
							}

						});
						loginProfPage.getContentPane().add(btnAddNewCourse);
					}
					if (profa.MyCourses.size() > 1) {
						JButton btnAddNewCourse = new JButton(profa.getMyCourses().get(1).getCourseName());
						btnAddNewCourse.setBounds(250, 250, 180, 80);
						btnAddNewCourse.setBackground(SystemColor.inactiveCaptionBorder);
						btnAddNewCourse.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								loginProfPage.dispose();
								c.course_inf(profa, a);
							}

						});
						loginProfPage.getContentPane().add(btnAddNewCourse);
					}
					if (profa.MyCourses.size() > 2) {
						JButton btnAddNewCourse = new JButton(profa.getMyCourses().get(2).getCourseName());
						btnAddNewCourse.setBounds(460, 250, 180, 80);
						btnAddNewCourse.setBackground(SystemColor.inactiveCaptionBorder);
						btnAddNewCourse.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								loginProfPage.dispose();
								c.course_inf(profa, a);
							}

						});
						loginProfPage.getContentPane().add(btnAddNewCourse);
					}
					if (profa.MyCourses.size() > 3) {
						JButton btnAddNewCourse = new JButton(profa.getMyCourses().get(3).getCourseName());
						btnAddNewCourse.setBounds(40, 360, 180, 80);
						btnAddNewCourse.setBackground(SystemColor.inactiveCaptionBorder);
						btnAddNewCourse.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								loginProfPage.dispose();
								c.course_inf(profa, a);
							}

						});
						loginProfPage.getContentPane().add(btnAddNewCourse);
					}
					if (profa.MyCourses.size() > 4) {
						JButton btnAddNewCourse = new JButton(profa.getMyCourses().get(4).getCourseName());
						btnAddNewCourse.setBounds(250, 360, 180, 80);
						btnAddNewCourse.setBackground(SystemColor.inactiveCaptionBorder);
						btnAddNewCourse.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								loginProfPage.dispose();
								c.course_inf(profa, a);
							}

						});
						loginProfPage.getContentPane().add(btnAddNewCourse);
					}
					if (profa.MyCourses.size() > 5) {
						JButton btnAddNewCourse = new JButton(profa.getMyCourses().get(5).getCourseName());
						btnAddNewCourse.setBounds(460, 360, 180, 80);
						btnAddNewCourse.setBackground(SystemColor.inactiveCaptionBorder);
						btnAddNewCourse.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								loginProfPage.dispose();
								c.course_inf(profa, a);
							}

						});
						loginProfPage.getContentPane().add(btnAddNewCourse);
					}

					setLogo(loginProfPage);
					setPowered(loginProfPage);
					setPozadina(loginProfPage);
				} else

				{
					JOptionPane.showMessageDialog(null, "Wrong password or ID. Please try again.");
				}
				passwordField.setText("");
				textField.setText("");
			}
		});
		button.setBounds(290, 350, 100, 35);
		loginProf.getContentPane().add(button);
		loginProf.getRootPane().setDefaultButton(button);
		setPowered(loginProf);
		setPozadina(loginProf);
	}

	private void init_stud(Admin a) {

		JFrame loginStudent = new JFrame();
		loginStudent.setVisible(true);
		loginStudent.setBounds(100, 100, 700, 511);
		loginStudent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginStudent.getContentPane().setLayout(null);
		setLogo2(loginStudent);
		homeButton(loginStudent, 0);

		JLabel label = new JLabel("Welcome to student panel. Please, enter you ID and password bellow");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setForeground(Color.white);
		label.setBounds(65, 142, 560, 56);
		loginStudent.getContentPane().add(label);

		JTextField textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(240, 220, 200, 35);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		loginStudent.getContentPane().add(textField);

		JPasswordField passwordField = new JPasswordField(16);
		passwordField.setBounds(240, 300, 200, 35);
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		loginStudent.getContentPane().add(passwordField);

		JLabel label_1 = new JLabel("ID number");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(200, 195, 100, 25);
		label_1.setForeground(Color.white);
		loginStudent.getContentPane().add(label_1);

		JLabel label_2 = new JLabel("Password");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(200, 275, 100, 25);
		label_2.setForeground(Color.white);
		loginStudent.getContentPane().add(label_2);

		JButton button = new JButton("Log In");
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
					setLogo2(stdLogIn);

					JButton btnEdit = new JButton("Edit my profile");
					btnEdit.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							stdLogIn.dispose();
							JFrame editProfile = new JFrame();
							editProfile.setVisible(true);
							editProfile.setBounds(100, 100, 700, 511);
							editProfile.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							editProfile.getContentPane().setLayout(null);

							JLabel lblStudentName = new JLabel("Student Name");
							lblStudentName.setFont(new Font("TAHOMA", Font.PLAIN, 14));
							lblStudentName.setForeground(Color.WHITE);
							lblStudentName.setBounds(23, 30, 106, 25);
							editProfile.getContentPane().add(lblStudentName);

							JLabel lblStudentSurname = new JLabel("Student Surname");
							lblStudentSurname.setBounds(23, 73, 106, 25);
							lblStudentSurname.setFont(new Font("TAHOMA", Font.PLAIN, 14));
							lblStudentSurname.setForeground(Color.WHITE);
							editProfile.getContentPane().add(lblStudentSurname);

							JLabel lblStudentId = new JLabel("Student ID");
							lblStudentId.setBounds(23, 122, 106, 25);
							lblStudentId.setFont(new Font("TAHOMA", Font.PLAIN, 14));
							lblStudentId.setForeground(Color.WHITE);
							editProfile.getContentPane().add(lblStudentId);

							JLabel lblStudentAge = new JLabel("Student Date of Birth");
							lblStudentAge.setBounds(23, 171, 106, 25);
							lblStudentAge.setFont(new Font("TAHOMA", Font.PLAIN, 14));
							lblStudentAge.setForeground(Color.WHITE);
							editProfile.getContentPane().add(lblStudentAge);

							JLabel lblStudentYear = new JLabel("Student Year");
							lblStudentYear.setBounds(23, 220, 106, 25);
							lblStudentYear.setFont(new Font("TAHOMA", Font.PLAIN, 14));
							lblStudentYear.setForeground(Color.WHITE);
							editProfile.getContentPane().add(lblStudentYear);

							JLabel lblGender = new JLabel("Gender");
							lblGender.setFont(new Font("TAHOMA", Font.PLAIN, 14));
							lblGender.setForeground(Color.WHITE);
							lblGender.setBounds(23, 269, 106, 25);
							editProfile.getContentPane().add(lblGender);

							JLabel lblStudentNationality = new JLabel("Student Nationality");
							lblStudentNationality.setBounds(23, 318, 106, 25);
							lblStudentNationality.setFont(new Font("TAHOMA", Font.PLAIN, 14));
							lblStudentNationality.setForeground(Color.WHITE);
							editProfile.getContentPane().add(lblStudentNationality);

							JLabel lblStudentEmail = new JLabel("Student Email");
							lblStudentEmail.setFont(new Font("TAHOMA", Font.PLAIN, 14));
							lblStudentEmail.setForeground(Color.WHITE);
							lblStudentEmail.setBounds(23, 367, 106, 25);
							editProfile.getContentPane().add(lblStudentEmail);

							JLabel lblStudentPassword = new JLabel("Student Password");
							lblStudentPassword.setBounds(23, 416, 106, 25);
							lblStudentPassword.setFont(new Font("TAHOMA", Font.PLAIN, 14));
							lblStudentPassword.setForeground(Color.WHITE);
							editProfile.getContentPane().add(lblStudentPassword);

							JTextField textField = new JTextField();
							textField.setBounds(139, 25, 117, 25);
							textField.setColumns(10);
							textField.setText(xStudent.getName());
							editProfile.getContentPane().add(textField);

							JTextField textField_1 = new JTextField();
							textField_1.setColumns(10);
							textField_1.setBounds(139, 75, 117, 25);
							textField_1.setText(xStudent.getSurname());
							editProfile.getContentPane().add(textField_1);

							JTextField textField_2 = new JTextField();
							textField_2.setColumns(10);
							textField_2.setBounds(139, 125, 117, 25);
							textField_2.setText(xStudent.getId());
							editProfile.getContentPane().add(textField_2);

							JTextField textField_3 = new JTextField();
							textField_3.setColumns(10);
							textField_3.setBounds(139, 175, 117, 25);
							textField_3.setText(xStudent.getDateOfBirth());
							editProfile.getContentPane().add(textField_3);

							JTextField textField_4 = new JTextField();
							textField_4.setColumns(10);
							textField_4.setBounds(139, 318, 117, 25);
							textField_4.setText(xStudent.getNationality());
							editProfile.getContentPane().add(textField_4);

							JTextField textField_5 = new JTextField();
							textField_5.setColumns(10);
							textField_5.setBounds(139, 367, 117, 25);
							textField_5.setText(xStudent.getEmail());
							editProfile.getContentPane().add(textField_5);

							JTextField textField_6 = new JTextField();
							textField_6.setColumns(10);
							textField_6.setBounds(139, 225, 117, 25);
							textField_6.setText(xStudent.getYear());
							editProfile.getContentPane().add(textField_6);

							JTextField textField_7 = new JTextField();
							textField_7.setColumns(10);
							textField_7.setBounds(139, 416, 117, 25);
							textField_7.setText(xStudent.getPassword());
							editProfile.getContentPane().add(textField_7);

							JRadioButton rdbtnMale = new JRadioButton("Male");
							rdbtnMale.setFont(new Font("TAHOMA", Font.PLAIN, 14));
							rdbtnMale.setForeground(Color.BLACK);
							rdbtnMale.setBounds(139, 275, 66, 23);
							editProfile.getContentPane().add(rdbtnMale);

							JRadioButton rdbtnFemale = new JRadioButton("Female");
							rdbtnFemale.setFont(new Font("TAHOMA", Font.PLAIN, 14));
							rdbtnFemale.setForeground(Color.BLACK);
							rdbtnFemale.setBounds(207, 275, 66, 23);
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

							editProfile.getContentPane().add(btnUpdate);
							btnUpdate.setBounds(400, 200, 200, 50);

							ImageIcon back = new ImageIcon("back.png");
							JButton btnBack = new JButton(back);
							btnBack.addActionListener(new ActionListener() {

								public void actionPerformed(ActionEvent e) {
									editProfile.dispose();
									stdLogIn.setVisible(true);
								}
							});

							btnBack.setBounds(340, 200, 50, 50);
							editProfile.getContentPane().add(btnBack);
							setPozadina(editProfile);
							setPowered(editProfile);

						}
					});
					btnEdit.setForeground(Color.WHITE);
					btnEdit.setBounds(540, 22, 150, 23);
					btnEdit.setFont(new Font("TAHOMA", Font.BOLD, 11));
					btnEdit.setContentAreaFilled(false);
					btnEdit.setBorder(null);

					stdLogIn.getContentPane().add(btnEdit);

					JButton btnLogOut = new JButton("Logout");
					btnLogOut.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							stdLogIn.dispose();
							init_stud(a);
						}
					});
					btnLogOut.setForeground(Color.WHITE);
					btnLogOut.setContentAreaFilled(false);
					btnLogOut.setBounds(470, 22, 110, 23);
					btnLogOut.setFont(new Font("TAHOMA", Font.BOLD, 11));
					btnLogOut.setBorder(null);
					stdLogIn.getContentPane().add(btnLogOut);

					ImageIcon gradesI = new ImageIcon("grades.png");
					JButton grades = new JButton("Grades", gradesI);
					grades.setBackground(SystemColor.inactiveCaptionBorder);
					grades.setBounds(50, 180, 150, 90);
					stdLogIn.getContentPane().add(grades);
					grades.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							stdLogIn.dispose();
							JFrame gradesF = new JFrame("Welcome " + xStudent.name);
							gradesF.setVisible(true);
							gradesF.setBounds(100, 100, 700, 511);
							gradesF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							gradesF.getContentPane().setLayout(null);
							setLogo2(gradesF);
							setPowered(gradesF);
							setPozadina(gradesF);

						}
					});
					setPowered(stdLogIn);
					setPozadina(stdLogIn);
				} else {
					JOptionPane.showMessageDialog(null, "Wrong password ");
					textField.grabFocus();
				}

				textField.setText("");
				passwordField.setText("");

			}
		});
		textField.grabFocus();
		button.setBackground(SystemColor.inactiveCaptionBorder);
		button.setBounds(290, 350, 100, 35);
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
		JButton button = new JButton(homeIcon);

		button.setBackground(SystemColor.inactiveCaptionBorder);
		button.setBounds(32, 230, 185, 140);
		button.setContentAreaFilled(false);
		button.setBorder(null);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				SIS studentWindow = new SIS();
				studentWindow.init_stud(a);
			}
		});
		frame.getContentPane().add(button);

		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lblWelcomeToStudent);

		ImageIcon homeIcon2 = new ImageIcon("button-admin.png");
		JButton button_1 = new JButton(homeIcon2);
		button_1.setBackground(SystemColor.inactiveCaptionBorder);
		button_1.setContentAreaFilled(false);
		button_1.setBorder(null);
		button_1.setBounds(466, 230, 185, 140);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				SIS prozor = new SIS();
				prozor.initOptions(a, lista);
			}
		});
		frame.getContentPane().add(button_1);

		ImageIcon homeIcon3 = new ImageIcon("button-prof.png");
		JButton button_2 = new JButton(homeIcon3);
		button_2.setForeground(Color.WHITE);
		button_2.setContentAreaFilled(false);
		button_2.setBorder(null);
		button_2.setBounds(248, 230, 185, 140);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				SIS prof = new SIS();
				prof.init(pr, a);
			}
		});

		frame.getContentPane().add(button_2);

		setLogo2(frame);
		setPowered(frame);
		setPozadina(frame);

	}

}
