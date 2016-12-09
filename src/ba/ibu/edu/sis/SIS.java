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

public class SIS {

	private JFrame frame;
	private JFrame login;
	private JFrame adminPage;

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

		private String Id;
		private String name;
		private String surname;
		private String email;
		private String phone;
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

	public static void main(String[] args) {

		Admin admin = new Admin();
		Student magarac = new Student();
		Professor dino = new Professor();
		dino.setName("Dino Keco");
		dino.setId("120");
		admin.Professors.add(dino);
		magarac.setName("magarac");
		magarac.setId("1");
		admin.Students.add(magarac);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SIS window = new SIS(admin);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public SIS(Admin a) {
		initialize(a);
	}

	public SIS(int i, Admin a) {
		init(a);
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
					lblStudentName.setBounds(23, 30, 106, 25);
					adminPage.getContentPane().add(lblStudentName);

					JLabel lblStudentSurname = new JLabel("Student Surname");
					lblStudentSurname.setBounds(23, 85, 106, 25);
					adminPage.getContentPane().add(lblStudentSurname);

					JLabel lblStudentId = new JLabel("Student ID");
					lblStudentId.setBounds(23, 140, 106, 25);
					adminPage.getContentPane().add(lblStudentId);

					JLabel lblStudentAge = new JLabel("Student Date of Birth");
					lblStudentAge.setBounds(23, 195, 106, 25);
					adminPage.getContentPane().add(lblStudentAge);

					JLabel lblStudentYear = new JLabel("Student Year");
					lblStudentYear.setBounds(23, 250, 106, 25);
					adminPage.getContentPane().add(lblStudentYear);

					JLabel lblStudentNationality = new JLabel("Student Nationality");
					lblStudentNationality.setBounds(23, 360, 106, 25);
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
					rdbtnMale.setBounds(139, 303, 66, 23);
					adminPage.getContentPane().add(rdbtnMale);

					JRadioButton rdbtnFemale = new JRadioButton("Female");
					rdbtnFemale.setBounds(207, 303, 66, 23);
					adminPage.getContentPane().add(rdbtnFemale);

					JButton btnNewButton = new JButton("Add Student");
					btnNewButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
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
							Student todelete = a.findStudent(textField_6.getText());
							a.Students.remove(todelete);
						}
					});
					btnDeleteStudent.setBounds(486, 330, 140, 40);
					adminPage.getContentPane().add(btnDeleteStudent);

					JButton btnNewButton_1 = new JButton("Update Student Information");
					btnNewButton_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							Student kreten = a.findStudent(textField_6.getText());
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
						}
					});
					btnNewButton_1.setBounds(370, 381, 207, 65);
					adminPage.getContentPane().add(btnNewButton_1);

					JLabel lblNewLabel = new JLabel("Search by Student ID");
					lblNewLabel.setBounds(354, 22, 129, 31);
					adminPage.getContentPane().add(lblNewLabel);

					JButton btnNewButton_2 = new JButton("Go");
					btnNewButton_2.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							Student wanted = a.findStudent(textField_6.getText());
							textField.setText(wanted.getName());
							textField_1.setText(wanted.getSurname());
							textField_2.setText(wanted.getId());
							textField_3.setText(wanted.getDateOfBirth());
							textField_4.setText(wanted.getNationality());
							textField_7.setText(wanted.getYear());
							textField_5.setText(wanted.getEmail());
							if(wanted.getGender()=="Male"){
								rdbtnMale.setSelected(true);
							}
							else{
								rdbtnFemale.setSelected(true);
							}
							textField_6.setText(null);
						}
					});
					btnNewButton_2.setBounds(622, 17, 52, 40);
					adminPage.getContentPane().add(btnNewButton_2);

					JLabel lblStudentEmail = new JLabel("Student Email");
					lblStudentEmail.setBounds(23, 415, 106, 25);
					adminPage.getContentPane().add(lblStudentEmail);

					JLabel lblGender = new JLabel("Gender");
					lblGender.setBounds(23, 305, 106, 25);
					adminPage.getContentPane().add(lblGender);

				} else {
					JOptionPane.showMessageDialog(null, "ne moze");
				}
				pwdEnterYourPassword.setText("");
			}
		});
		btnLogIn.setBounds(300, 264, 89, 23);
		login.getContentPane().add(btnLogIn);

	}

	private void initialize(Admin a) {

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

		JButton btnLogInAs = new JButton("Login as Professor");
		btnLogInAs.setBackground(SystemColor.inactiveCaptionBorder);
		btnLogInAs.setBounds(250, 274, 185, 99);
		btnLogInAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
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
				loginProf.getContentPane().add(passwordField);

				JLabel lblWelcomeL = new JLabel("Hi professor. Take some operations..");
				lblWelcomeL.setFont(new Font("Sylfaen", Font.PLAIN, 18));
				lblWelcomeL.setHorizontalAlignment(SwingConstants.CENTER);
				lblWelcomeL.setBounds(65, 122, 540, 56);

				JButton button = new JButton("LogIn");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Professor p = a.findProfessor(textField.getText());
						frame.dispose();
						JFrame loginProf = new JFrame();
						loginProf.setVisible(true);
						loginProf.setBounds(100, 100, 700, 511);
						loginProf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						loginProf.getContentPane().setLayout(null);
						loginProf.getContentPane().add(lblWelcomeL);
					}
				});
				button.setBounds(296, 281, 89, 23);
				loginProf.getContentPane().add(button);

				JLabel lblWelcome = new JLabel(
						"Welcome to proffesor panel. Please, enter your ID and password bellow!");
				lblWelcome.setFont(new Font("Sylfaen", Font.PLAIN, 18));
				lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
				lblWelcome.setBounds(85, 122, 560, 56);
				loginProf.getContentPane().add(lblWelcome);

				JLabel lblId = new JLabel("ID");
				lblId.setHorizontalAlignment(SwingConstants.RIGHT);
				lblId.setBounds(231, 195, 46, 14);
				loginProf.getContentPane().add(lblId);

				JLabel lblPw = new JLabel("PW");
				lblPw.setHorizontalAlignment(SwingConstants.RIGHT);
				lblPw.setBounds(231, 233, 46, 14);
				loginProf.getContentPane().add(lblPw);

			}
		});
		frame.getContentPane().add(btnLogInAs);
		frame.getContentPane().add(button);

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

		JLabel lblNewLabel_2 = new JLabel("Powered by MOCHA");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(276, 440, 128, 21);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("logo_sis.png"));
		lblNewLabel_1.setBounds(274, 11, 268, 173);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel label = new JLabel("");
		label.setBounds(0, 0, 684, 473);
		label.setIcon(new ImageIcon("burch2.jpg"));
		frame.getContentPane().add(label);

	}

}
