package ba.ibu.edu.sis;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


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

public class SIS implements Serializable {

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JFrame login;
	private JFrame adminPage;

	private void setLogo2(JFrame logo2Frame) {
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("logo_sis.png"));
		lblNewLabel_1.setBounds(274, 11, 268, 173);
		logo2Frame.getContentPane().add(lblNewLabel_1);
	}

	private void setLogo(JFrame frejm) {
		JLabel lblNewLabel_logo = new JLabel("");
		lblNewLabel_logo.setIcon(new ImageIcon("logo_sis.png"));
		lblNewLabel_logo.setBounds(14, 5, 168, 83);
		frejm.getContentPane().add(lblNewLabel_logo);
	}

	private void setPozadina(JFrame frejm) {
		JLabel pozadina = new JLabel("");
		pozadina.setBounds(0, 0, 684, 473);
		pozadina.setIcon(new ImageIcon("burch2.jpg"));
		frejm.getContentPane().add(pozadina);
	}

	private void setPowered(JFrame pFrame) {
		JLabel lblNewLabel_2 = new JLabel("Powered by MOCHA");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(276, 445, 128, 21);
		pFrame.getContentPane().add(lblNewLabel_2);
	}

	private void homeButton(JFrame hFrame) {
		ImageIcon homeIcon=new ImageIcon("home_icon.png");
		JButton btnHome = new JButton(homeIcon);
		btnHome.setForeground(Color.WHITE);
		
		btnHome.setBounds(635, 20, 30, 30);
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

	public SIS() {

	}

	static class Admin {
		public List<Student> Students = new ArrayList<Student>();
		private List<Professor> Professors = new ArrayList<Professor>();

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

		Professor findProfessor(String id) {

			for (Professor p : Professors) {
				if (p.getId().equals(id)) {
					return p;
				}
			}
			return null;
		}
		
		@SuppressWarnings("unchecked")
		public void restore() {
			try {
				ObjectInputStream in = new ObjectInputStream(new FileInputStream("students_ob.txt"));
				Students = (List<Student>) in.readObject();
				in.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		
		public void save() {
			try {
				ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("students_ob.txt"));
				out.writeObject(Students);
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	static class Professor {

		Course c = new Course();

		Course findCourse(String id) {

			for (Course course : c.a) {
				if (course.getCourseID().equals(id)) {
					return course;
				}
			}
			return null;
		}

		public String getId() {
			return Id;
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

		String strDirectoy = "course";
		boolean success = (new File(strDirectoy)).mkdir();
		if (success) {
			System.out.println("Directory: " + strDirectoy + " created");
		}
		Admin admin = new Admin();
		Professor dino = new Professor();
		admin.restore();
		dino.setName("Dino Keco");
		dino.setId("1");
		dino.setPassword("1");
		admin.Professors.add(dino);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SIS window = new SIS(admin, dino);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SIS(Admin a, Professor pr) {
		initialize(a, pr);
	}

	interface Faculty {
		String name = " ";
		String Id = " ";

		void display_details();

		void conduct_session();
	}

	private void init(Admin a) {

		login = new JFrame();
		login.setVisible(true);
		login.setBounds(100, 100, 700, 511);
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login.getContentPane().setLayout(null);

		JPasswordField pwdEnterYourPassword = new JPasswordField();
		pwdEnterYourPassword.setBounds(240, 260, 200, 35);
		pwdEnterYourPassword.setHorizontalAlignment(SwingConstants.CENTER);
		login.getContentPane().add(pwdEnterYourPassword);
		pwdEnterYourPassword.grabFocus();

		JLabel lblNewLabel = new JLabel("Welcome to admin panel. Please enter your password bellow");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("TAHOMA", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setToolTipText("");
		lblNewLabel.setBounds(65, 190, 560, 56);
		login.getContentPane().add(lblNewLabel);
		setLogo2(login);
		homeButton(login);

		JButton btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if (pwdEnterYourPassword.getText().equals(a.getPassword())) {
					login.dispose();
					adminPage = new JFrame();
					adminPage.setVisible(true);
					adminPage.setBounds(100, 100, 700, 511);
					adminPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					adminPage.getContentPane().setLayout(null);
					
					JLabel lblStudentName = new JLabel("Student Name");
					lblStudentName.setFont(new Font("TAHOMA", Font.PLAIN, 14));
					lblStudentName.setForeground(Color.WHITE);
					lblStudentName.setBounds(23, 30, 106, 25);
					adminPage.getContentPane().add(lblStudentName);

					JLabel lblStudentSurname = new JLabel("Student Surname");
					lblStudentSurname.setBounds(23, 73, 106, 25);
					lblStudentSurname.setFont(new Font("TAHOMA", Font.PLAIN, 14));
					lblStudentSurname.setForeground(Color.WHITE);
					adminPage.getContentPane().add(lblStudentSurname);

					JLabel lblStudentId = new JLabel("Student ID");
					lblStudentId.setBounds(23, 122, 106, 25);
					lblStudentId.setFont(new Font("TAHOMA", Font.PLAIN, 14));
					lblStudentId.setForeground(Color.WHITE);
					adminPage.getContentPane().add(lblStudentId);

					JLabel lblStudentAge = new JLabel("Student Date of Birth");
					lblStudentAge.setBounds(23, 171, 106, 25);
					lblStudentAge.setFont(new Font("TAHOMA", Font.PLAIN, 14));
					lblStudentAge.setForeground(Color.WHITE);
					adminPage.getContentPane().add(lblStudentAge);

					JLabel lblStudentYear = new JLabel("Student Year");
					lblStudentYear.setBounds(23, 220, 106, 25);
					lblStudentYear.setFont(new Font("TAHOMA", Font.PLAIN, 14));
					lblStudentYear.setForeground(Color.WHITE);
					adminPage.getContentPane().add(lblStudentYear);

					JLabel lblStudentNationality = new JLabel("Student Nationality");
					lblStudentNationality.setBounds(23, 318, 106, 25);
					lblStudentNationality.setFont(new Font("TAHOMA", Font.PLAIN, 14));
					lblStudentNationality.setForeground(Color.WHITE);
					adminPage.getContentPane().add(lblStudentNationality);
					
					JLabel lblStudentPassword = new JLabel("Student Password");
					lblStudentPassword.setBounds(23, 416, 106, 25);
					lblStudentPassword.setFont(new Font("TAHOMA", Font.PLAIN, 14));
					lblStudentPassword.setForeground(Color.WHITE);
					adminPage.getContentPane().add(lblStudentPassword);
					
					JTextField textField_8 = new JTextField();
					textField_8.setColumns(10);
					textField_8.setBounds(139, 416, 117, 25);
					adminPage.getContentPane().add(textField_8);
					
					JTextField textField = new JTextField();
					textField.setBounds(139, 25, 117, 25);
					adminPage.getContentPane().add(textField);
					textField.setColumns(10);

					JTextField textField_1 = new JTextField();
					textField_1.setColumns(10);
					textField_1.setBounds(139, 75, 117, 25);
					adminPage.getContentPane().add(textField_1);

					JTextField textField_2 = new JTextField();
					textField_2.setColumns(10);
					textField_2.setBounds(139, 125, 117, 25);
					adminPage.getContentPane().add(textField_2);

					JTextField textField_3 = new JTextField();
					textField_3.setColumns(10);
					textField_3.setBounds(139, 175, 117, 25);
					adminPage.getContentPane().add(textField_3);

					JTextField textField_4 = new JTextField();
					textField_4.setColumns(10);
					textField_4.setBounds(139, 318, 117, 25);
					adminPage.getContentPane().add(textField_4);

					JTextField textField_5 = new JTextField();
					textField_5.setColumns(10);
					textField_5.setBounds(139, 367, 117, 25);
					adminPage.getContentPane().add(textField_5);

					JTextField textField_7 = new JTextField();
					textField_7.setColumns(10);
					textField_7.setBounds(139, 225, 117, 25);
					adminPage.getContentPane().add(textField_7);

					JRadioButton rdbtnMale = new JRadioButton("Male");
					rdbtnMale.setFont(new Font("TAHOMA", Font.PLAIN, 14));
					rdbtnMale.setForeground(Color.BLACK);
					rdbtnMale.setBounds(139, 275, 66, 23);
					adminPage.getContentPane().add(rdbtnMale);

					JRadioButton rdbtnFemale = new JRadioButton("Female");
					rdbtnFemale.setFont(new Font("TAHOMA", Font.PLAIN, 14));
					rdbtnFemale.setForeground(Color.BLACK);
					rdbtnFemale.setBounds(207, 275, 66, 23);
					adminPage.getContentPane().add(rdbtnFemale);
					
					ButtonGroup gender=new ButtonGroup();//so that only one button can be selected
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
							if(a.findStudent(textField_2.getText())!=null){
								JOptionPane.showMessageDialog(null, "This ID is already taken. Please enter another ID.");
							}
							else{
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
							a.save();
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
							a.save();
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
							a.save();
						}
					});
					btnNewButton_1.setBounds(370, 381, 207, 65);
					adminPage.getContentPane().add(btnNewButton_1);

					JLabel lblNewLabel = new JLabel("Search by Student ID");
					lblNewLabel.setFont(new Font("TAHOMA", Font.PLAIN, 14));
					lblNewLabel.setForeground(Color.WHITE);
					lblNewLabel.setBounds(354, 22, 129, 31);
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

				} else {
					JOptionPane.showMessageDialog(null, "ne moze");
				}
				pwdEnterYourPassword.setText("");
			}
		});
		btnLogIn.setBounds(290, 320, 100, 35);
		login.getContentPane().add(btnLogIn);
		login.getRootPane().setDefaultButton(btnLogIn);
		setPowered(login);
		setPozadina(login);
		a.save();
	}

	private void init(Professor pr) {
		SIS sis = new SIS();
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
		textField.grabFocus();

		JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(240, 300, 200, 35);
		passwordField.setHorizontalAlignment(SwingConstants.LEFT);
		loginProf.getContentPane().add(passwordField);

		JLabel lblWelcome = new JLabel("Welcome to professor panel. Please, enter your ID and password below");
		lblWelcome.setFont(new Font("TAHOMA", Font.BOLD, 14));
		lblWelcome.setForeground(Color.WHITE);
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setBounds(65, 142, 560, 56);
		loginProf.getContentPane().add(lblWelcome);
		setLogo2(loginProf);
		homeButton(loginProf);

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
				if (passwordField.getText().equals(pr.getPassword()) && textField.getText().equals(pr.getId())) {
					loginProf.dispose();
					JFrame loginProfPage = new JFrame();
					loginProfPage.setVisible(true);
					loginProfPage.setBounds(100, 100, 700, 511);
					loginProfPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					loginProfPage.getContentPane().setLayout(null);

					JButton btnEditMyProfile = new JButton("Edit my profile");
					btnEditMyProfile.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
						}
					});
					btnEditMyProfile.setForeground(Color.WHITE);
					btnEditMyProfile.setBounds(540, 22, 150, 23);
					btnEditMyProfile.setFont(new Font("TAHOMA", Font.BOLD, 11));
					btnEditMyProfile.setContentAreaFilled(false);
					btnEditMyProfile.setBorder(null);

					loginProfPage.getContentPane().add(btnEditMyProfile);

					JButton btnLogout = new JButton("Logout");
					btnLogout.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							loginProfPage.dispose();
							sis.init(pr);
						}
					});
					btnLogout.setForeground(Color.WHITE);
					btnLogout.setContentAreaFilled(false);
					btnLogout.setBounds(470, 22, 110, 23);
					btnLogout.setFont(new Font("TAHOMA", Font.BOLD, 11));
					btnLogout.setBorder(null);
					loginProfPage.getContentPane().add(btnLogout);

					JTextField txtCourseSection = new JTextField();
					txtCourseSection.setFont(new Font("Tahoma", Font.BOLD, 13));
					txtCourseSection.setForeground(Color.WHITE);
					txtCourseSection.setText("Course section");
					txtCourseSection.setBounds(10, 120, 674, 20);
					txtCourseSection.setOpaque(false);
					txtCourseSection.setBorder(null);
					loginProfPage.getContentPane().add(txtCourseSection);
					txtCourseSection.setColumns(10);

					JTextField txtSearchCourse = new JTextField();
					txtSearchCourse.setFont(new Font("Tahoma", Font.BOLD, 13));
					txtSearchCourse.setForeground(Color.WHITE);
					txtSearchCourse.setText("Search course");
					txtSearchCourse.setBounds(36, 157, 100, 40);
					txtSearchCourse.setOpaque(false);
					txtSearchCourse.setBorder(null);
					loginProfPage.getContentPane().add(txtSearchCourse);
					txtSearchCourse.setColumns(10);

					JTextField textField = new JTextField();
					textField.setBounds(155, 157, 442, 40);
					loginProfPage.getContentPane().add(textField);
					textField.setColumns(10);

					JButton btnGo = new JButton("GO");
					btnGo.setBounds(605, 157, 52, 40);

					btnGo.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							if (pr.findCourse(textField.getText()) == null) {
								JOptionPane.showMessageDialog(null, "Course not found.");
								JOptionPane.showMessageDialog(null, textField.getText());
								textField.setText(null);
							} else {
								JOptionPane.showMessageDialog(null, "OKE");
							}
						}
					});

					loginProfPage.getContentPane().add(btnGo);

					JButton btnAddNewCourse = new JButton("Add new course");
					btnAddNewCourse.setBounds(36, 228, 139, 34);
					btnAddNewCourse.setBackground(SystemColor.inactiveCaptionBorder);

					btnAddNewCourse.addActionListener(new ActionListener() {

						public void actionPerformed(ActionEvent e) {
							loginProfPage.dispose();
							c.add(c);
						}

					});
					loginProfPage.getContentPane().add(btnAddNewCourse);

					JButton btnDisplayCourse = new JButton("Display Courses");
					btnDisplayCourse.setBounds(277, 228, 139, 39);
					btnDisplayCourse.setBackground(SystemColor.inactiveCaptionBorder);
					btnDisplayCourse.addActionListener(new ActionListener() {

						public void actionPerformed(ActionEvent e) {
							loginProfPage.dispose();
							c.displaycourseinf();
						}

					});
					loginProfPage.getContentPane().add(btnDisplayCourse);
					JButton btnUpdateCourse = new JButton("Update course students");
					btnUpdateCourse.setBounds(518, 228, 139, 39);
					loginProfPage.getContentPane().add(btnUpdateCourse);
					/*
					 * { try { BufferedReader read = new BufferedReader(new
					 * InputStreamReader(System.in)); Scanner s = new
					 * Scanner(System.in); int nos;
					 * System.out.print("Enter course ID you want to update\t:"
					 * ); String up = read.readLine();
					 * System.out.print("Enter how many number of student\t:");
					 * nos = s.nextInt(); /* c.update(up,nos); }
					 * 
					 * catch (Exception k) { System.out.println(k); } }
					 */
					JTextField txtStudentSection = new JTextField();
					txtStudentSection.setText("Student section");
					txtStudentSection.setOpaque(false);
					txtStudentSection.setForeground(Color.WHITE);
					txtStudentSection.setFont(new Font("Tahoma", Font.BOLD, 13));
					txtStudentSection.setColumns(10);
					txtStudentSection.setBorder(null);
					txtStudentSection.setBounds(10, 303, 674, 20);
					loginProfPage.getContentPane().add(txtStudentSection);

					JTextField txtSearchStudent = new JTextField();
					txtSearchStudent.setFont(new Font("Tahoma", Font.BOLD, 13));
					txtSearchStudent.setForeground(Color.WHITE);
					txtSearchStudent.setText("Search student");
					txtSearchStudent.setBounds(36, 340, 100, 40);
					txtSearchStudent.setOpaque(false);
					txtSearchStudent.setBorder(null);
					loginProfPage.getContentPane().add(txtSearchStudent);
					txtSearchStudent.setColumns(10);

					JTextField textField_2 = new JTextField();
					textField_2.setBounds(155, 340, 442, 40);
					loginProfPage.getContentPane().add(textField_2);
					textField_2.setColumns(10);

					JButton btnGo_2 = new JButton("GO");
					btnGo_2.setBounds(605, 340, 52, 40);
					loginProfPage.getContentPane().add(btnGo_2);

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
		homeButton(loginStudent);
		
		JLabel label = new JLabel("Welcome to student panel. Please, enter you ID and password bellow");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setForeground(Color.white);
		label.setBounds(65, 142, 560, 56);
		loginStudent.getContentPane().add(label);

		JTextField textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(240, 220, 200, 35);
		loginStudent.getContentPane().add(textField);

		JPasswordField passwordField = new JPasswordField(16);
		passwordField.setBounds(240, 300, 200, 35);
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
							JFrame editProfile=new JFrame();
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
							
							ButtonGroup gender=new ButtonGroup();//so that only one button can be selected
							gender.add(rdbtnFemale);
							gender.add(rdbtnMale);
							
							if(xStudent.getGender()=="Male"){
								rdbtnMale.setSelected(true);
							}
							else{
								rdbtnFemale.setSelected(true);
							}
							
							JButton btnUpdate= new JButton("Update student information");
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
								
									if(rdbtnMale.isSelected()){
										xStudent.setGender("Male");
									}
									else{
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
									
									a.save();
									
								}
							});
							
							editProfile.getContentPane().add(btnUpdate);
							btnUpdate.setBounds(400, 200, 200, 50);
							
							ImageIcon back= new ImageIcon("back.png");
							JButton btnBack=new JButton(back);
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
					
					ImageIcon gradesI=new ImageIcon("grades.png");
					JButton grades = new JButton("Grades",gradesI);
					grades.setBackground(SystemColor.inactiveCaptionBorder);
					grades.setBounds(50, 180,150, 90);
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

	private void initialize(Admin a, Professor pr) {

		frame = new JFrame();
		frame.setBounds(100, 100, 700, 511);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblWelcomeToStudent = new JLabel("Welcome to Student Information System!");
		lblWelcomeToStudent.setBounds(65, 142, 560, 56);
		lblWelcomeToStudent.setForeground(new Color(255, 255, 255));
		lblWelcomeToStudent.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblWelcomeToStudent.setHorizontalAlignment(SwingConstants.CENTER);

		JButton button = new JButton("Log in as Student");
		button.setBackground(SystemColor.inactiveCaptionBorder);
		button.setBounds(32, 274, 185, 99);
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

		JButton button_1 = new JButton("Log in as Admin");
		button_1.setBackground(SystemColor.inactiveCaptionBorder);
		button_1.setBounds(466, 274, 185, 99);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				SIS prozor = new SIS();
				prozor.init(a);
			}
		});
		frame.getContentPane().add(button_1);

		JButton button_2 = new JButton("Log in as Professor");
		button_2.setBackground(SystemColor.inactiveCaptionBorder);
		button_2.setBounds(248, 274, 185, 99);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				SIS prof = new SIS();
				prof.init(pr);
			}
		});

		frame.getContentPane().add(button_2);

		setLogo2(frame);
		setPowered(frame);
		setPozadina(frame);

	}

}
