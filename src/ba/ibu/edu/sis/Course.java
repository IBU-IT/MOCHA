package ba.ibu.edu.sis;

//import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.StringTokenizer;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ba.ibu.edu.sis.SIS.Admin;
import ba.ibu.edu.sis.SIS.Professor;
import ba.ibu.edu.sis.SIS.Student;

public class Course implements Serializable {

	private static final long serialVersionUID = 1L;
	private String CourseID, CourseName;
	int numOfCredits, numOfStudents;
	// public ArrayList<Course> a = new ArrayList<Course>();
	ArrayList<Student> StudentsEnroled = new ArrayList<Student>();

	public ArrayList<Student> getStudentsEnroled() {
		return StudentsEnroled;
	}

	public void setStudentsEnroled(ArrayList<Student> studentsEnroled) {
		StudentsEnroled = studentsEnroled;
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

	public String getCourseID() {
		return CourseID;
	}

	public void setCourseID(String courseID) {
		CourseID = courseID;
	}

	public String getCourseName() {
		return CourseName;
	}

	public void setCourseName(String courseName) {
		CourseName = courseName;
	}

	public int getNumOfCredits() {
		return numOfCredits;
	}

	public void setNumOfCredits(int numOfCredits) {
		this.numOfCredits = numOfCredits;
	}

	public int getNumOfStudents() {
		return numOfStudents;
	}

	public void setNumOfStudents(int numOfStudents) {
		this.numOfStudents = numOfStudents;
	}

	JTextField addCtextField, addCtextField_1, addCtextField_2, addCtextField_3, addCtextField_4, addCtextField_5,
			addCtextField_6;

	public Course() {
	}

	public void homeButton(JFrame hFrame, int shift) {
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
				SIS.main(null);
			}
		});
	}

	public void blabla(Admin a, List<Course> lista) {

		JFrame addCourse = new JFrame();
		addCourse.setVisible(true);
		addCourse.setBounds(100, 100, 700, 511);
		addCourse.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addCourse.getContentPane().setLayout(null);

		homeButton(addCourse, 0);

		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addCourse.dispose();
				SIS prozor = new SIS();
				prozor.initOptions(a, lista);
			}
		});
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setContentAreaFilled(false);
		btnLogout.setBounds(593, 55, 110, 23);
		btnLogout.setFont(new Font("TAHOMA", Font.BOLD, 11));
		btnLogout.setBorder(null);
		addCourse.add(btnLogout);

		JLabel addCoID = new JLabel("Course ID");
		addCoID.setFont(new Font("TAHOMA", Font.PLAIN, 13));
		addCoID.setForeground(Color.WHITE);
		addCoID.setBounds(23, 120, 146, 35);
		addCourse.getContentPane().add(addCoID);

		JLabel addCoName = new JLabel("Course name");
		addCoName.setFont(new Font("TAHOMA", Font.PLAIN, 13));
		addCoName.setForeground(Color.WHITE);
		addCoName.setBounds(23, 200, 146, 35);
		addCourse.getContentPane().add(addCoName);

		JLabel addCrNum = new JLabel("Number of credits");
		addCrNum.setFont(new Font("TAHOMA", Font.PLAIN, 13));
		addCrNum.setForeground(Color.WHITE);
		addCrNum.setBounds(23, 280, 146, 35);
		addCourse.getContentPane().add(addCrNum);

		JLabel addStNum = new JLabel("Number of Students");
		addStNum.setFont(new Font("TAHOMA", Font.PLAIN, 13));
		addStNum.setForeground(Color.WHITE);
		addStNum.setBounds(23, 360, 146, 35);
		addCourse.getContentPane().add(addStNum);

		JLabel addQu = new JLabel("Number of Quizes");
		addQu.setFont(new Font("TAHOMA", Font.PLAIN, 13));
		addQu.setForeground(Color.WHITE);
		addQu.setBounds(350, 120, 146, 35);
		addCourse.getContentPane().add(addQu);

		JLabel addHo = new JLabel("Number of Homework");
		addHo.setFont(new Font("TAHOMA", Font.PLAIN, 13));
		addHo.setForeground(Color.WHITE);
		addHo.setBounds(350, 200, 146, 35);
		addCourse.getContentPane().add(addHo);

		JLabel addLe = new JLabel("Number of Lectures");
		addLe.setFont(new Font("TAHOMA", Font.PLAIN, 13));
		addLe.setForeground(Color.WHITE);
		addLe.setBounds(350, 280, 146, 35);
		addCourse.getContentPane().add(addLe);

		addCtextField = new JTextField();
		addCtextField.setBounds(23, 155, 200, 35);
		addCourse.getContentPane().add(addCtextField);
		addCtextField.setColumns(10);

		addCtextField_1 = new JTextField();
		addCtextField_1.setColumns(10);
		addCtextField_1.setBounds(23, 235, 200, 35);
		addCourse.getContentPane().add(addCtextField_1);

		addCtextField_2 = new JTextField();
		addCtextField_2.setColumns(10);
		addCtextField_2.setBounds(23, 315, 200, 35);
		addCourse.getContentPane().add(addCtextField_2);

		addCtextField_3 = new JTextField();
		addCtextField_3.setColumns(10);
		addCtextField_3.setBounds(23, 395, 200, 35);
		addCourse.getContentPane().add(addCtextField_3);

		addCtextField_4 = new JTextField();
		addCtextField_4.setColumns(10);
		addCtextField_4.setBounds(350, 155, 200, 35);
		addCourse.getContentPane().add(addCtextField_4);

		addCtextField_5 = new JTextField();
		addCtextField_5.setColumns(10);
		addCtextField_5.setBounds(350, 235, 200, 35);
		addCourse.getContentPane().add(addCtextField_5);

		addCtextField_6 = new JTextField();
		addCtextField_6.setColumns(10);
		addCtextField_6.setBounds(350, 315, 200, 35);
		addCourse.getContentPane().add(addCtextField_6);

		JLabel lblNewLabel = new JLabel("Search by Course Name:");
		lblNewLabel.setFont(new Font("TAHOMA", Font.PLAIN, 14));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(344, 22, 159, 31);
		addCourse.getContentPane().add(lblNewLabel);

		JTextField search = new JTextField();
		search.setBounds(344, 50, 159, 31);
		addCourse.getContentPane().add(search);

		JButton go = new JButton("Search");
		go.setFont(new Font("TAHOMA", Font.PLAIN, 14));
		go.setBounds(514, 50, 100, 31);
		go.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (a.findCourse(search.getText()) == null) {
					JOptionPane.showMessageDialog(null, "Course not found.");
					search.setText(null);
				} else {
					Course wanted = a.findCourse(search.getText());
					addCtextField.setText(wanted.getCourseID());
					addCtextField_1.setText(wanted.getCourseName());
					String s = "";
					s += wanted.getNumOfCredits();
					addCtextField_2.setText(s);
					s = "";
					s += wanted.getNumOfStudents();
					addCtextField_3.setText(s);
					s = "";
					s += wanted.getNumOfQuizzes();
					addCtextField_4.setText(s);
					s = "";
					s += wanted.getNumOfHomeworks();
					addCtextField_5.setText(s);
					s = "";
					s += wanted.getNumOfLectures();
					addCtextField_6.setText(s);
				}
			}
		});
		addCourse.getContentPane().add(go);

		JButton editCourse = new JButton("Update Course Information");
		editCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Course toedit = a.findCourse(addCtextField_1.getText());
				toedit.setCourseName(addCtextField_1.getText());
				toedit.setNumOfCredits(Integer.parseInt(addCtextField_2.getText()));
				toedit.setNumOfStudents(Integer.parseInt(addCtextField_3.getText()));
				toedit.setNumOfQuizzes(Integer.parseInt(addCtextField_4.getText()));
				toedit.setNumOfHw(Integer.parseInt(addCtextField_5.getText()));
				toedit.setNumOfLectures(Integer.parseInt(addCtextField_6.getText()));

				addCtextField.setText(null);
				addCtextField_1.setText(null);
				addCtextField_2.setText(null);
				addCtextField_3.setText(null);
				addCtextField_4.setText(null);
				addCtextField_5.setText(null);
				addCtextField_6.setText(null);
				JOptionPane.showMessageDialog(null, "Course updated.");
				a.saveC();
			}
		});
		editCourse.setBounds(352, 400, 200, 35);
		addCourse.getContentPane().add(editCourse);

		JButton delete = new JButton("Delete Course");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Course todelet = a.findCourse(addCtextField_1.getText());
				a.Courses.remove(todelet);
				JOptionPane.showMessageDialog(null, "Course deleted.");
				addCtextField.setText(null);
				addCtextField_1.setText(null);
				addCtextField_2.setText(null);
				addCtextField_3.setText(null);
				addCtextField_4.setText(null);
				addCtextField_5.setText(null);
				addCtextField_6.setText(null);
				search.setText(null);
				a.saveC();
			}
		});
		delete.setBounds(300, 360, 150, 35);
		addCourse.getContentPane().add(delete);

		JButton addCBtn = new JButton("Add Course");
		addCBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (a.findCourse_id(addCtextField.getText()) != null) {
					JOptionPane.showMessageDialog(null, "ID already taken.");
					addCtextField.setText(null);
					addCtextField_1.setText(null);
					addCtextField_2.setText(null);
					addCtextField_3.setText(null);
					addCtextField_4.setText(null);
					addCtextField_5.setText(null);
					addCtextField_6.setText(null);
				} else {
					Course co = new Course();
					co.setCourseID(addCtextField.getText());
					co.setCourseName(addCtextField_1.getText());
					co.setNumOfCredits(Integer.parseInt(addCtextField_2.getText()));
					co.setNumOfStudents(Integer.parseInt(addCtextField_3.getText()));
					co.setNumOfQuizzes(Integer.parseInt(addCtextField_4.getText()));
					co.setNumOfHw(Integer.parseInt(addCtextField_5.getText()));
					co.setNumOfLectures(Integer.parseInt(addCtextField_6.getText()));

					addCtextField.setText(null);
					addCtextField_1.setText(null);
					addCtextField_2.setText(null);
					addCtextField_3.setText(null);
					addCtextField_4.setText(null);
					addCtextField_5.setText(null);
					addCtextField_6.setText(null);
					lista.add(co);
					a.saveC();
					JOptionPane.showMessageDialog(null, "Course successfully added!");
				}
			}
		});
		addCBtn.setBounds(453, 360, 150, 35);
		addCourse.getContentPane().add(addCBtn);

		setLogo(addCourse);
		setPowered(addCourse);
		setPozadina(addCourse);

	}

	double presentationPoints, midtermExam, finalExam; // No need to calculate
														// percentage here cause
														// points are always out
														// of 100
	int numOfHomeworks;

	public int getNumOfHomeworks() {
		return numOfHomeworks;
	}

	public void setNumOfHomeworks(int numOfHomeworks) {
		this.numOfHomeworks = numOfHomeworks;
	}

	public int getNumOfQuizzes() {
		return numOfQuizzes;
	}

	public int getNumOfLectures() {
		return numOfLectures;
	}

	int numOfQuizzes;
	int numOfLectures;
	double homework[] = new double[numOfHomeworks];
	double quizzes[] = new double[numOfQuizzes];
	double attendence[] = new double[numOfLectures];
	double obtainedHwPoints, obtainedQzPoints, obtainedAttendence;

	public void setNumOfHw(int numOfHw) {
		numOfHomeworks = numOfHw;
	}

	public void setNumOfQuizzes(int numOfQz) {
		numOfQuizzes = numOfQz;
	}

	public void setNumOfLectures(int numOfLectures) {
		this.numOfLectures = numOfLectures;
	}

	public void showStudentsGrades() {

		// to get percentage of homework points
		obtainedHwPoints = calculatePercentage(homework, numOfHomeworks);
		// to get percentage of quizzes points
		obtainedQzPoints = calculatePercentage(quizzes, numOfQuizzes);
		// to get percentage of attendence
		obtainedAttendence = calculatePercentage(attendence, numOfLectures);

		JOptionPane.showMessageDialog(null,
				"Presentation:" + presentationPoints + "%" + "\n" + "Midterm: " + midtermExam + "%" + "\n" + "Final: "
						+ finalExam + "%" + "\n" + "Homework: " + obtainedHwPoints + "%" + "\n" + "Quizzes: "
						+ obtainedQzPoints + "%" + "\n" + "Attendence: " + obtainedAttendence + "%");

	}

	private double calculatePercentage(double particle[], int numOfParticles) {
		double result = 0, obtainedPoints;
		int maximumPoints;

		for (int i = 0; i < numOfParticles; i++) {
			result += particle[i];
		}
		maximumPoints = 100 * numOfParticles;
		obtainedPoints = result / maximumPoints * 100;

		return obtainedPoints;

	}

	public void setHomeworkResult(int numOfHw, double numOfPoints) {
		this.homework[numOfHw - 1] = numOfPoints;
	}

	public void setQuizResult(int numOfQz, double numOfPoints) {
		quizzes[numOfQz] = numOfPoints;
	}

	public void setAttendence(int numOfLecture) {
		this.attendence[numOfLecture] = 100;
	}

	public void course_inf(Professor pr, Admin a, Course c, JFrame frejm) {
		SIS sis = new SIS();
		JFrame courseInf = new JFrame();
		courseInf.setVisible(true);
		courseInf.setBounds(100, 100, 700, 511);
		courseInf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		courseInf.getContentPane().setLayout(null);

		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				courseInf.dispose();
				frejm.setVisible(true);
			}
		});
		back.setForeground(Color.WHITE);
		back.setContentAreaFilled(false);
		back.setBounds(570, 50, 110, 23);
		back.setFont(new Font("TAHOMA", Font.BOLD, 11));
		back.setBorder(null);
		courseInf.getContentPane().add(back);

		JLabel courseDetails = new JLabel("COURSE DETAILS");
		courseDetails.setFont(new Font("Tahoma", Font.BOLD, 13));
		courseDetails.setForeground(Color.WHITE);
		courseDetails.setBounds(25, 120, 674, 20);
		courseInf.getContentPane().add(courseDetails);

		JLabel courseName = new JLabel("Course Name: " + c.getCourseName());
		courseName.setFont(new Font("Tahoma", Font.BOLD, 13));
		courseName.setForeground(Color.WHITE);
		courseName.setBounds(25, 150, 674, 20);
		courseInf.getContentPane().add(courseName);

		JLabel courseCode = new JLabel("Course code: " + c.getCourseID());
		courseCode.setFont(new Font("Tahoma", Font.BOLD, 13));
		courseCode.setForeground(Color.WHITE);
		courseCode.setBounds(25, 180, 674, 20);
		courseInf.getContentPane().add(courseCode);

		JLabel numberOfStudent = new JLabel("Number of students: " + c.getNumOfStudents());
		numberOfStudent.setFont(new Font("Tahoma", Font.BOLD, 13));
		numberOfStudent.setForeground(Color.WHITE);
		numberOfStudent.setBounds(25, 210, 674, 20);
		courseInf.getContentPane().add(numberOfStudent);

		JLabel numberOfCredits = new JLabel("Number of credits: " + c.getNumOfCredits());
		numberOfCredits.setFont(new Font("Tahoma", Font.BOLD, 13));
		numberOfCredits.setForeground(Color.WHITE);
		numberOfCredits.setBounds(25, 240, 674, 20);
		courseInf.getContentPane().add(numberOfCredits);

		JButton btneditStd = new JButton("Edit student information");
		btneditStd.setBounds(25, 329, 200, 40);
		courseInf.getContentPane().add(btneditStd);
		btneditStd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				courseInf.setVisible(false);
				student_list(pr, a, courseInf, c);
			}
		});

		JList<String> list = new JList<String>();
		list.setBounds(279, 89, 130, 280);
		courseInf.getContentPane().add(list);
		DefaultListModel<String> DLM = new DefaultListModel<String>();
		for (int i = 0; i < a.Students.size(); i++) {
			DLM.addElement(a.Students.get(i).getName());
		}
		list.setModel(DLM);

		JList<String> dodaj = new JList<String>();
		dodaj.setBounds(520, 89, 130, 280);
		courseInf.getContentPane().add(dodaj);

		DefaultListModel<String> DLM1 = new DefaultListModel<String>();
		JButton btnAdd = new JButton("Add >>");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DLM1.addElement(list.getSelectedValue());
				DLM.removeElement(list.getSelectedValue());
				dodaj.setModel(DLM1);
			}
		});

		btnAdd.setFont(new Font("Tahoma", Font.ITALIC, 10));
		btnAdd.setBounds(417, 115, 95, 23);
		courseInf.getContentPane().add(btnAdd);

		JButton btnRemove = new JButton("<<Remove ");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DLM.addElement(dodaj.getSelectedValue());
				DLM1.removeElement(dodaj.getSelectedValue());
				list.setModel(DLM);
			}
		});

		btnRemove.setFont(new Font("Tahoma", Font.ITALIC, 10));
		btnRemove.setBounds(417, 149, 95, 23);
		courseInf.getContentPane().add(btnRemove);

		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DLM1.clear();
				dodaj.setModel(DLM1);
				DLM.clear();
				for (int i = 0; i < a.Students.size(); i++) {
					DLM.addElement(a.Students.get(i).getName());
				}
				list.setModel(DLM);
			}
		});
		btnClear.setBounds(539, 390, 89, 23);
		courseInf.getContentPane().add(btnClear);

		JButton addToCourse = new JButton("Add to Course");
		addToCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Student> toAdd = new ArrayList<Student>();
				for (int i = 0; i < DLM1.size(); i++) {
					toAdd.add(a.findStudent_name(DLM1.getElementAt(i)));
				}
				c.setStudentsEnroled(toAdd);
				c.setNumOfStudents(DLM1.size());
				a.saveC();
				JOptionPane.showMessageDialog(null, "Students succesfully enroled.");
				DLM1.clear();
				dodaj.setModel(DLM1);
				DLM.clear();
				for (int i = 0; i < a.Students.size(); i++) {
					DLM.addElement(a.Students.get(i).getName());
				}
				list.setModel(DLM);
			}
		});
		addToCourse.setBounds(285, 390, 120, 23);
		courseInf.getContentPane().add(addToCourse);

		sis.prof_menu(courseInf, pr, a, courseInf);
		setLogo(courseInf);
		setPowered(courseInf);
		setPozadina(courseInf);
	}

	public void student_list(Professor pr, Admin a, JFrame frejm, Course c) {
		SIS sis = new SIS();
		JFrame std_coPanel = new JFrame();
		std_coPanel.setVisible(true);
		std_coPanel.setBounds(100, 100, 700, 511);
		std_coPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		std_coPanel.getContentPane().setLayout(null);

		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				std_coPanel.dispose();
				frejm.setVisible(true);
			}
		});
		back.setForeground(Color.WHITE);
		back.setContentAreaFilled(false);
		back.setBounds(570, 50, 110, 23);
		back.setFont(new Font("TAHOMA", Font.BOLD, 11));
		back.setBorder(null);
		std_coPanel.getContentPane().add(back);

		JTextField txtCourseSection = new JTextField();
		txtCourseSection.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtCourseSection.setForeground(Color.WHITE);
		txtCourseSection.setText("LIST OF STUDENTS");
		txtCourseSection.setBounds(25, 120, 674, 20);
		txtCourseSection.setOpaque(false);
		txtCourseSection.setBorder(null);
		std_coPanel.getContentPane().add(txtCourseSection);

		JTextArea std[] = new JTextArea[c.StudentsEnroled.size()];
		int shift = 170, shift2 = 163;
		JButton btnUpdateStd[] = new JButton[c.StudentsEnroled.size()];
		for (int i = 0; i < c.StudentsEnroled.size(); i++) {
			std[i] = new JTextArea();
			std[i].setFont(new Font("Tahoma", Font.BOLD, 13));
			std[i].setForeground(Color.WHITE);
			std[i].setBounds(25, shift, 200, 30);
			std[i].setText(
					(i + 1) + ". " + c.StudentsEnroled.get(i).getName() + " " + c.StudentsEnroled.get(i).getSurname());
			std[i].setOpaque(false);
			std[i].setBorder(null);
			std_coPanel.getContentPane().add(std[i], BorderLayout.WEST);

			final String id = c.StudentsEnroled.get(i).getId();

			btnUpdateStd[i] = new JButton("UPDATE");
			btnUpdateStd[i].setForeground(Color.WHITE);
			btnUpdateStd[i].setFont(new Font("TAHOMA", Font.BOLD, 12));
			btnUpdateStd[i].setBounds(200, shift2, 100, 30);
			btnUpdateStd[i].setContentAreaFilled(false);
			btnUpdateStd[i].setBorder(null);
			btnUpdateStd[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					std_coPanel.setVisible(false);
					updateStd(pr, a, std_coPanel, id, c);
				}
			});
			std_coPanel.getContentPane().add(btnUpdateStd[i]);
			shift += 20;
			shift2 += 20;
		}

		sis.prof_menu(std_coPanel, pr, a, std_coPanel);
		setLogo(std_coPanel);
		setPowered(std_coPanel);
		setPozadina(std_coPanel);
	}

	public void updateStd(Professor pr, Admin a, JFrame frejm, String id, Course c) {
		SIS sis = new SIS();
		JFrame std_updPanel = new JFrame();
		std_updPanel.setVisible(true);
		std_updPanel.setBounds(100, 100, 700, 511);
		std_updPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		std_updPanel.getContentPane().setLayout(null);

		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				std_updPanel.dispose();
				frejm.setVisible(true);
			}
		});
		back.setForeground(Color.WHITE);
		back.setContentAreaFilled(false);
		back.setBounds(570, 50, 110, 23);
		back.setFont(new Font("TAHOMA", Font.BOLD, 11));
		back.setBorder(null);
		std_updPanel.getContentPane().add(back);

		JTextField stdID = new JTextField();
		stdID.setFont(new Font("Tahoma", Font.BOLD, 13));
		stdID.setForeground(Color.WHITE);
		stdID.setText("Student ID: " + a.findStudent(id).getId());
		stdID.setBounds(25, 110, 200, 30);
		stdID.setOpaque(false);
		stdID.setBorder(null);
		std_updPanel.getContentPane().add(stdID);

		JTextField stdname = new JTextField();
		stdname.setFont(new Font("Tahoma", Font.BOLD, 13));
		stdname.setForeground(Color.WHITE);
		stdname.setText("Student Name: " + a.findStudent(id).getName());
		stdname.setBounds(170, 110, 200, 30);
		stdname.setOpaque(false);
		stdname.setBorder(null);
		std_updPanel.getContentPane().add(stdname);

		JLabel updQuiz = new JLabel("Quiz grade");
		updQuiz.setFont(new Font("TAHOMA", Font.PLAIN, 14));
		updQuiz.setForeground(Color.WHITE);
		updQuiz.setBounds(25, 160, 130, 25);
		std_updPanel.getContentPane().add(updQuiz);

		JLabel updMid = new JLabel("Midterm grade");
		updMid.setFont(new Font("TAHOMA", Font.PLAIN, 14));
		updMid.setForeground(Color.WHITE);
		updMid.setBounds(25, 210, 130, 25);
		std_updPanel.getContentPane().add(updMid);

		JLabel updFin = new JLabel("Final grade");
		updFin.setFont(new Font("TAHOMA", Font.PLAIN, 14));
		updFin.setForeground(Color.WHITE);
		updFin.setBounds(25, 260, 130, 25);
		std_updPanel.getContentPane().add(updFin);

		JLabel updHome = new JLabel("Assignment grade");
		updHome.setFont(new Font("TAHOMA", Font.PLAIN, 14));
		updHome.setForeground(Color.WHITE);
		updHome.setBounds(25, 310, 130, 25);
		std_updPanel.getContentPane().add(updHome);

		JLabel updAtt = new JLabel("Attendance");
		updAtt.setFont(new Font("TAHOMA", Font.PLAIN, 14));
		updAtt.setForeground(Color.WHITE);
		updAtt.setBounds(25, 360, 130, 25);
		std_updPanel.getContentPane().add(updAtt);

		JTextField textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(160, 160, 150, 25);
		std_updPanel.getContentPane().add(textField_1);

		JTextField textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(160, 210, 150, 25);
		std_updPanel.getContentPane().add(textField_2);

		JTextField textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(160, 260, 150, 25);
		std_updPanel.getContentPane().add(textField_3);

		JTextField textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(160, 310, 150, 25);
		std_updPanel.getContentPane().add(textField_4);

		JTextField textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(160, 360, 150, 25);
		std_updPanel.getContentPane().add(textField_5);

		JButton btnUpdateStd = new JButton("UPDATE");
		btnUpdateStd.setFont(new Font("TAHOMA", Font.BOLD, 11));
		btnUpdateStd.setBounds(25, 400, 100, 35);
		btnUpdateStd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, Integer.parseInt(id));
				c.setQuizResult(Integer.parseInt(id), Double.parseDouble(textField_1.getText()));

				a.saveC();
			}
		});
		std_updPanel.getContentPane().add(btnUpdateStd);

		sis.prof_menu(std_updPanel, pr, a, std_updPanel);
		setLogo(std_updPanel);
		setPowered(std_updPanel);
		setPozadina(std_updPanel);

	}
}
