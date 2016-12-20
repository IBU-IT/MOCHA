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
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Scanner;
import java.io.Serializable;
import java.io.*;

public class SIS implements Serializable {

	private JFrame frame;
	private JFrame login;
	private JFrame adminPage;

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
	}

	static class Professor {
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

	static class Student {
		private String id;
		private String email;
		private String nationality;

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
	}

	public static void main(String[] args)  {
		
    	BufferedReader read= new BufferedReader(new InputStreamReader(System.in));
		String strDirectoy ="course";
		boolean success = (new File(strDirectoy)).mkdir();
		if(success) 
		{
			System.out.println("Directory: " + strDirectoy + " created");
		}   
		Admin admin = new Admin();
		Student magarac = new Student();
		Professor dino = new Professor();
		dino.setName("Dino Keco");
		dino.setId("1");
		dino.setPassword("1");
		admin.Professors.add(dino);
		magarac.setName("magarac");
		magarac.setId("1");
		admin.Students.add(magarac);
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

	public SIS(int i, Admin a) {
		init(a);
	}

	public SIS(int i, Professor pr) {
		init(pr);
	}
	
	interface Faculty
	{
		String name=" ";
		String Id=" ";
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
		pwdEnterYourPassword.setBounds(264, 233, 155, 20);
		pwdEnterYourPassword.setHorizontalAlignment(SwingConstants.CENTER);
		login.getContentPane().add(pwdEnterYourPassword);

		JLabel lblNewLabel = new JLabel("Enter password for Admin");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("TAHOMA", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setToolTipText("");
		lblNewLabel.setBounds(229, 208, 226, 14);
		login.getContentPane().add(lblNewLabel);

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
					lblStudentSurname.setBounds(23, 85, 106, 25);
					lblStudentSurname.setFont(new Font("TAHOMA", Font.PLAIN, 14));
					lblStudentSurname.setForeground(Color.WHITE);
					adminPage.getContentPane().add(lblStudentSurname);

					JLabel lblStudentId = new JLabel("Student ID");
					lblStudentId.setBounds(23, 140, 106, 25);
					lblStudentId.setFont(new Font("TAHOMA", Font.PLAIN, 14));
					lblStudentId.setForeground(Color.WHITE);
					adminPage.getContentPane().add(lblStudentId);

					JLabel lblStudentAge = new JLabel("Student Date of Birth");
					lblStudentAge.setBounds(23, 195, 106, 25);
					lblStudentAge.setFont(new Font("TAHOMA", Font.PLAIN, 14));
					lblStudentAge.setForeground(Color.WHITE);
					adminPage.getContentPane().add(lblStudentAge);

					JLabel lblStudentYear = new JLabel("Student Year");
					lblStudentYear.setBounds(23, 250, 106, 25);
					lblStudentYear.setFont(new Font("TAHOMA", Font.PLAIN, 14));
					lblStudentYear.setForeground(Color.WHITE);
					adminPage.getContentPane().add(lblStudentYear);

					JLabel lblStudentNationality = new JLabel("Student Nationality");
					lblStudentNationality.setBounds(23, 360, 106, 25);
					lblStudentNationality.setFont(new Font("TAHOMA", Font.PLAIN, 14));
					lblStudentNationality.setForeground(Color.WHITE);
					adminPage.getContentPane().add(lblStudentNationality);

					JTextField textField = new JTextField();
					textField.setBounds(139, 30, 117, 25);
					adminPage.getContentPane().add(textField);
					textField.setColumns(10);

					JTextField textField_1 = new JTextField();
					textField_1.setColumns(10);
					textField_1.setBounds(139, 85, 117, 25);
					adminPage.getContentPane().add(textField_1);

					JTextField textField_2 = new JTextField();
					textField_2.setColumns(10);
					textField_2.setBounds(139, 140, 117, 25);
					adminPage.getContentPane().add(textField_2);

					JTextField textField_3 = new JTextField();
					textField_3.setColumns(10);
					textField_3.setBounds(139, 195, 117, 25);
					adminPage.getContentPane().add(textField_3);

					JTextField textField_4 = new JTextField();
					textField_4.setColumns(10);
					textField_4.setBounds(139, 356, 117, 25);
					adminPage.getContentPane().add(textField_4);

					JTextField textField_5 = new JTextField();
					textField_5.setColumns(10);
					textField_5.setBounds(139, 411, 117, 25);
					adminPage.getContentPane().add(textField_5);

					JTextField textField_7 = new JTextField();
					textField_7.setColumns(10);
					textField_7.setBounds(139, 250, 117, 25);
					adminPage.getContentPane().add(textField_7);

					JRadioButton rdbtnMale = new JRadioButton("Male");
					rdbtnMale.setFont(new Font("TAHOMA", Font.PLAIN, 14));
					rdbtnMale.setForeground(Color.WHITE);
					rdbtnMale.setBounds(139, 303, 66, 23);
					adminPage.getContentPane().add(rdbtnMale);

					JRadioButton rdbtnFemale = new JRadioButton("Female");
					rdbtnFemale.setFont(new Font("TAHOMA", Font.PLAIN, 14));
					rdbtnFemale.setForeground(Color.WHITE);
					rdbtnFemale.setBounds(207, 303, 66, 23);
					adminPage.getContentPane().add(rdbtnFemale);

					JButton btnNewButton = new JButton("Add Student");
					btnNewButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							ObjectOutputStream outputStream = null;
							try{
							FileOutputStream buf=new FileOutputStream("students.txt",true);
							PrintStream q = new PrintStream(buf);
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
							}}
							catch(Exception a)
							{
								System.out.println(a);
							}
							Student kreten = new Student();							
							kreten.setName(textField.getText());
							kreten.setSurname(textField_1.getText());
							kreten.setId(textField_2.getText());
							kreten.setDateOfBirth(textField_3.getText());
							kreten.setNationality(textField_4.getText());
							kreten.setYear(textField_7.getText());
							kreten.setEmail(textField_5.getText());
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
							rdbtnMale.setSelected(false);
							rdbtnFemale.setSelected(false);
							JOptionPane.showMessageDialog(null, "Student successfully added!");
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
							rdbtnMale.setSelected(false);
							rdbtnFemale.setSelected(false);
							JOptionPane.showMessageDialog(null, "Student deleted.");
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
							textField_5.setText(null);
							rdbtnMale.setSelected(false);
							rdbtnFemale.setSelected(false);
							JOptionPane.showMessageDialog(null, "Information updated.");
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
					lblStudentEmail.setBounds(23, 415, 106, 25);
					adminPage.getContentPane().add(lblStudentEmail);

					JLabel lblGender = new JLabel("Gender");
					lblGender.setFont(new Font("TAHOMA", Font.PLAIN, 14));
					lblGender.setForeground(Color.WHITE);
					lblGender.setBounds(23, 305, 106, 25);
					adminPage.getContentPane().add(lblGender);
					setPowered(adminPage);
					setPozadina(adminPage);

				} else {
					JOptionPane.showMessageDialog(null, "ne moze");
				}
				pwdEnterYourPassword.setText("");
			}
		});
		btnLogIn.setBounds(300, 264, 89, 23);
		login.getContentPane().add(btnLogIn);
		setPowered(login);
		setPozadina(login);

	}

	private void init(Professor pr) {
		JFrame loginProf = new JFrame();
		loginProf.setVisible(true);
		loginProf.setBounds(100, 100, 700, 511);
		loginProf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginProf.getContentPane().setLayout(null);
		JTextField textField = new JTextField();
		textField.setBounds(287, 189, 110, 27);
		loginProf.getContentPane().add(textField);
		textField.setColumns(10);

		JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(287, 227, 110, 27);
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		loginProf.getContentPane().add(passwordField);

		JLabel lblWelcome = new JLabel("Welcome to proffesor panel. Please, enter your ID and password below!");
		lblWelcome.setFont(new Font("TAHOMA", Font.BOLD, 14));
		lblWelcome.setForeground(Color.WHITE);
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setBounds(85, 122, 560, 56);
		loginProf.getContentPane().add(lblWelcome);

		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setBounds(231, 195, 46, 14);
		lblId.setForeground(Color.WHITE);
		loginProf.getContentPane().add(lblId);

		JLabel lblPw = new JLabel("PW");
		lblPw.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPw.setBounds(231, 233, 46, 14);
		lblPw.setForeground(Color.WHITE);
		loginProf.getContentPane().add(lblPw);

		JButton button = new JButton("LogIn");
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

					loginProfPage.add(btnEditMyProfile);

					JButton btnLogout = new JButton("Logout");
					btnLogout.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
						}
					});
					btnLogout.setForeground(Color.WHITE);
					btnLogout.setContentAreaFilled(false);
					btnLogout.setBounds(470, 22, 110, 23);
					btnLogout.setFont(new Font("TAHOMA", Font.BOLD, 11));
					btnLogout.setBorder(null);
					loginProfPage.add(btnLogout);

					JTextField txtCourseSection = new JTextField();
					txtCourseSection.setFont(new Font("Tahoma", Font.BOLD, 13));
					txtCourseSection.setForeground(Color.WHITE);
					txtCourseSection.setText("Course section");
					txtCourseSection.setBounds(10, 120, 674, 20);
					txtCourseSection.setOpaque(false);
					txtCourseSection.setBorder(null);
					loginProfPage.add(txtCourseSection);
					txtCourseSection.setColumns(10);

					JTextField txtSearchCourse = new JTextField();
					txtSearchCourse.setFont(new Font("Tahoma", Font.BOLD, 13));
					txtSearchCourse.setForeground(Color.WHITE);
					txtSearchCourse.setText("Search course");
					txtSearchCourse.setBounds(36, 157, 100, 40);
					txtSearchCourse.setOpaque(false);
					txtSearchCourse.setBorder(null);
					loginProfPage.add(txtSearchCourse);
					txtSearchCourse.setColumns(10);

					JTextField textField = new JTextField();
					textField.setBounds(155, 157, 442, 40);
					loginProfPage.add(textField);
					textField.setColumns(10);

					JButton btnGo = new JButton("GO");
					btnGo.setBounds(605, 157, 52, 40);
					loginProfPage.add(btnGo);

					JButton btnAddNewCourse = new JButton("Add new course");
					btnAddNewCourse.setBounds(36, 228, 139, 39);
					loginProfPage.add(btnAddNewCourse);
					/*{	try{				Course c=new Course();
			    							BufferedReader read= new BufferedReader(new InputStreamReader(System.in));
			    							Scanner s=new Scanner(System.in);
											System.out.print("Enter Course id\t\t:");
											c.CourseID=read.readLine();
											System.out.print("Enter Course name\t:");
											c.CourseName=read.readLine();
											System.out.print("Enter number of credits\t:");
											c.numOfCredits=s.nextInt();
											System.out.print("Enter number of Students:");
											c.numOfStudents=s.nextInt();
											c.add(c);}
					catch(Exception p){
						System.out.println(p);

					}
					  }*/

					JButton btnDisplayCourse = new JButton("Display Courses");
					btnDisplayCourse.setBounds(277, 228, 139, 39);
					loginProfPage.add(btnDisplayCourse);
					/*{	
					 * 											c.displaycourseinf();

					 * }
					 */

					JButton btnUpdateCourse = new JButton("Update course students");
					btnUpdateCourse.setBounds(518, 228, 139, 39);
					loginProfPage.add(btnUpdateCourse);
					{	try{					BufferedReader read= new BufferedReader(new InputStreamReader(System.in));
											Scanner s=new Scanner(System.in);
											int nos;
											System.out.print("Enter course ID you want to update\t:");
											String up=read.readLine();
											System.out.print("Enter how many number of student\t:");
											nos=s.nextInt();
											/*c.update(up,nos);*/}
					  
					catch(Exception k){
						System.out.println(k);
					}
					}
					JTextField txtStudentSection = new JTextField();
					txtStudentSection.setText("Student section");
					txtStudentSection.setOpaque(false);
					txtStudentSection.setForeground(Color.WHITE);
					txtStudentSection.setFont(new Font("Tahoma", Font.BOLD, 13));
					txtStudentSection.setColumns(10);
					txtStudentSection.setBorder(null);
					txtStudentSection.setBounds(10, 303, 674, 20);
					loginProfPage.add(txtStudentSection);

					JTextField txtSearchStudent = new JTextField();
					txtSearchStudent.setFont(new Font("Tahoma", Font.BOLD, 13));
					txtSearchStudent.setForeground(Color.WHITE);
					txtSearchStudent.setText("Search student");
					txtSearchStudent.setBounds(36, 340, 100, 40);
					txtSearchStudent.setOpaque(false);
					txtSearchStudent.setBorder(null);
					loginProfPage.add(txtSearchStudent);
					txtSearchStudent.setColumns(10);

					JTextField textField_2 = new JTextField();
					textField_2.setBounds(155, 340, 442, 40);
					loginProfPage.add(textField_2);
					textField_2.setColumns(10);

					JButton btnGo_2 = new JButton("GO");
					btnGo_2.setBounds(605, 340, 52, 40);
					loginProfPage.add(btnGo_2);

					setLogo(loginProfPage);

					setPowered(loginProfPage);
					setPozadina(loginProfPage);
				} else {
					JOptionPane.showMessageDialog(null, "Wrong password or ID. Please try again.");
				}
				passwordField.setText("");
				textField.setText("");
			}
		});
		button.setBounds(296, 281, 89, 23);
		loginProf.getContentPane().add(button);
		setPowered(loginProf);
		setPozadina(loginProf);
	}

	private void initialize(Admin a, Professor pr) {

		frame = new JFrame();
		frame.setBounds(100, 100, 700, 511);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblWelcomeToStudent = new JLabel("\r\n\r\n\r\nWelcome to Student Information System!");
		lblWelcomeToStudent.setBounds(32, 184, 630, 31);
		lblWelcomeToStudent.setForeground(new Color(255, 255, 255));
		lblWelcomeToStudent.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblWelcomeToStudent.setHorizontalAlignment(SwingConstants.CENTER);

		JButton button = new JButton("Log in as Student");
		button.setBackground(SystemColor.inactiveCaptionBorder);
		button.setBounds(32, 274, 185, 99);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				JFrame loginStudent = new JFrame();
				loginStudent.setVisible(true);
				loginStudent.setBounds(100, 100, 700, 511);
				loginStudent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				loginStudent.getContentPane().setLayout(null);

				JLabel label = new JLabel("Welcome!");
				label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setFont(new Font("Sylfaen", Font.PLAIN, 18));
				label.setBounds(271, 137, 140, 56);
				loginStudent.getContentPane().add(label);

				JTextField textField = new JTextField();
				textField.setColumns(10);
				textField.setBounds(286, 204, 110, 27);
				loginStudent.getContentPane().add(textField);

				JPasswordField passwordField = new JPasswordField();
				passwordField.setBounds(286, 242, 110, 27);
				loginStudent.getContentPane().add(passwordField);

				JLabel label_1 = new JLabel("ID");
				label_1.setHorizontalAlignment(SwingConstants.RIGHT);
				label_1.setBounds(230, 210, 46, 14);
				loginStudent.getContentPane().add(label_1);

				JLabel label_2 = new JLabel("PW");
				label_2.setHorizontalAlignment(SwingConstants.RIGHT);
				label_2.setBounds(230, 248, 46, 14);
				loginStudent.getContentPane().add(label_2);

				JButton button = new JButton("Log In");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Student s = a.findStudent(textField.getText());
						JOptionPane.showMessageDialog(null, s.getName());
					}
				});
				button.setBounds(296, 281, 89, 23);
				loginStudent.getContentPane().add(button);

				// studentlogin2 m= new studentlogin2(a);

			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lblWelcomeToStudent);

		JButton button_1 = new JButton("Log in as Admin");
		button_1.setBackground(SystemColor.inactiveCaptionBorder);
		button_1.setBounds(466, 274, 185, 99);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				SIS prozor = new SIS(1, a);
			}
		});
		frame.getContentPane().add(button_1);

		JButton button_2 = new JButton("Log in as Professor");
		button_2.setBackground(SystemColor.inactiveCaptionBorder);
		button_2.setBounds(235, 274, 185, 99);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				SIS prof = new SIS(1, pr);
			}
		});

		frame.getContentPane().add(button_2);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("logo_sis.png"));
		lblNewLabel_1.setBounds(274, 11, 268, 173);
		frame.getContentPane().add(lblNewLabel_1);
		setPowered(frame);
		setPozadina(frame);

	}

}
