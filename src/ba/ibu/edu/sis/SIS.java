package ba.ibu.edu.sis;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


import java.awt.Font;

import javax.swing.JButton;

import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SIS {

	private JFrame frame;
	private JFrame login;
	private JFrame adminPage;
	
	static class Admin {
		private String password ="password";
		public String getPassword() {
			return password;
		}

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
		public int getDateOfBirth() {
			return dateOfBirth;
		}
		public void setDateOfBirth(int dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}
		private String name;
		private String gender;
		private String surname;
		private int year;
		private int dateOfBirth;
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
		public int getYear() {
			return year;
		}
		public void setYear(int year) {
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
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SIS window = new SIS();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
	}

	public SIS() {
		initialize();
	}
	public SIS(int i){
		init();
	}
	private void init(){


		Admin admin = new Admin();
		
		
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
				if(pwdEnterYourPassword.getText().equals(admin.getPassword())){
					login.dispose();
					adminPage = new JFrame();
					adminPage.setVisible(true);
					adminPage.setBounds(100, 100, 700, 511);
					adminPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					adminPage.getContentPane().setLayout(null);
					JLabel lblStudentName = new JLabel("Student Name");
					lblStudentName.setBounds(23, 46, 106, 25);
					adminPage.getContentPane().add(lblStudentName);
					
					JLabel lblStudentSurname = new JLabel("Student Surname");
					lblStudentSurname.setBounds(23, 117, 106, 25);
					adminPage.getContentPane().add(lblStudentSurname);
					
					JLabel lblStudentId = new JLabel("Student ID");
					lblStudentId.setBounds(23, 188, 106, 25);
					adminPage.getContentPane().add(lblStudentId);
					
					JLabel lblStudentAge = new JLabel("Student Age");
					lblStudentAge.setBounds(23, 259, 106, 25);
					adminPage.getContentPane().add(lblStudentAge);
					
					JLabel lblStudentYear = new JLabel("Student Year");
					lblStudentYear.setBounds(23, 330, 106, 25);
					adminPage.getContentPane().add(lblStudentYear);
					
					JLabel lblStudentNationality = new JLabel("Student Nationality");
					lblStudentNationality.setBounds(23, 401, 106, 25);
					adminPage.getContentPane().add(lblStudentNationality);
					
					JTextField textField = new JTextField();
					textField.setBounds(139, 46, 117, 25);
					adminPage.getContentPane().add(textField);
					textField.setColumns(10);
					
					JTextField textField_1 = new JTextField();
					textField_1.setColumns(10);
					textField_1.setBounds(139, 117, 117, 25);
					adminPage.getContentPane().add(textField_1);
					
					JTextField textField_2 = new JTextField();
					textField_2.setColumns(10);
					textField_2.setBounds(139, 188, 117, 25);
					adminPage.getContentPane().add(textField_2);
					
					JTextField textField_3 = new JTextField();
					textField_3.setColumns(10);
					textField_3.setBounds(139, 259, 117, 25);
					adminPage.getContentPane().add(textField_3);
					
					JTextField textField_4 = new JTextField();
					textField_4.setColumns(10);
					textField_4.setBounds(139, 330, 117, 25);
					adminPage.getContentPane().add(textField_4);
					
					JTextField textField_5 = new JTextField();
					textField_5.setColumns(10);
					textField_5.setBounds(139, 401, 117, 25);
					adminPage.getContentPane().add(textField_5);
					
					JButton btnNewButton = new JButton("Add Student");
					btnNewButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String iName,iSurname,iID,iGender,iEmail,iNationality;
							int iDate,iYear;
							iName=textField.getText();
							Student kreten = new Student();
							kreten.setName(iName);
							JOptionPane.showMessageDialog(null, kreten.getName());
						}
					});
					btnNewButton.setBounds(319, 330, 140, 40);
					adminPage.getContentPane().add(btnNewButton);
					
					JButton btnDeleteStudent = new JButton("Delete Student");
					btnDeleteStudent.setBounds(486, 330, 140, 40);
					adminPage.getContentPane().add(btnDeleteStudent);
					
					JButton btnNewButton_1 = new JButton("Update Student Information");
					btnNewButton_1.setBounds(376, 385, 177, 56);
					adminPage.getContentPane().add(btnNewButton_1);
					
					JTextField textField_6 = new JTextField();
					textField_6.setBounds(486, 17, 129, 40);
					adminPage.getContentPane().add(textField_6);
					textField_6.setColumns(10);
					
					JLabel lblNewLabel = new JLabel("Search by Student ID");
					lblNewLabel.setBounds(354, 22, 129, 31);
					adminPage.getContentPane().add(lblNewLabel);
					
					JButton btnNewButton_2 = new JButton("Go");
					btnNewButton_2.setBounds(622, 17, 52, 40);
					adminPage.getContentPane().add(btnNewButton_2);
				}
				else{
					JOptionPane.showMessageDialog(null, "ne moze");
				}
				pwdEnterYourPassword.setText("");
			}
		});
		btnLogIn.setBounds(300, 264, 89, 23);
		login.getContentPane().add(btnLogIn);
		
		
	}
	

	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 511);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblWelcomeToStudent = new JLabel("\r\n\r\n\r\nWelcome to Student Information System!");
		lblWelcomeToStudent.setBounds(81, 72, 521, 31);
		lblWelcomeToStudent.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblWelcomeToStudent.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton button = new JButton("Log in as Student");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
				button.setBounds(296, 281, 89, 23);
				loginStudent.getContentPane().add(button);
			}
		});
		button.setBounds(32, 274, 185, 99);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lblWelcomeToStudent);
		
		JButton btnLogInAs = new JButton("Log in as Professor");
		btnLogInAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				JFrame loginProf  = new JFrame();
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
				
				JButton btnNewButton = new JButton("Log In");
				btnNewButton.setBounds(297, 266, 89, 23);
				loginProf.getContentPane().add(btnNewButton);
				
				JLabel lblWelcome = new JLabel("Welcome!");
				lblWelcome.setFont(new Font("Sylfaen", Font.PLAIN, 18));
				lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
				lblWelcome.setBounds(272, 122, 140, 56);
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
		btnLogInAs.setBounds(249, 274, 185, 99);
		frame.getContentPane().add(btnLogInAs);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("Log in as Admin");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				SIS prozor = new SIS(1);
			}
		});
		button_1.setBounds(466, 274, 185, 99);
		frame.getContentPane().add(button_1);
	
		
	}
}
