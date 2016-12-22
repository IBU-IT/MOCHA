package ba.ibu.edu.sis;

import java.util.ArrayList;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ba.ibu.edu.sis.StudentInformationSystem;
import ba.ibu.edu.sis.SIS.Admin;
import ba.ibu.edu.sis.SIS.Student;

public class Course implements Serializable {

	String CourseID, CourseName, ProfessorName;
	int numOfCredits, numOfStudents;
	ArrayList<Course> a = new ArrayList();

	/**
	 * @wbp.parser.entryPoint
	 */
	Course() {
		this.CourseID = CourseID;
		this.CourseName = CourseName;
		this.ProfessorName = ProfessorName;
		this.numOfCredits = numOfCredits;
		this.numOfStudents = numOfStudents;
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

	public void add(Course c) {

		JFrame addCourse = new JFrame();
		addCourse.setVisible(true);
		addCourse.setBounds(100, 100, 700, 511);
		addCourse.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addCourse.getContentPane().setLayout(null);

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

		JTextField addCtextField = new JTextField();
		addCtextField.setBounds(23, 155, 200, 35);
		addCourse.getContentPane().add(addCtextField);
		addCtextField.setColumns(10);

		JTextField addCtextField_1 = new JTextField();
		addCtextField_1.setColumns(10);
		addCtextField_1.setBounds(23, 235, 200, 35);
		addCourse.getContentPane().add(addCtextField_1);

		JTextField addCtextField_2 = new JTextField();
		addCtextField_2.setColumns(10);
		addCtextField_2.setBounds(23, 315, 200, 35);
		addCourse.getContentPane().add(addCtextField_2);

		JTextField addCtextField_3 = new JTextField();
		addCtextField_3.setColumns(10);
		addCtextField_3.setBounds(23, 395, 200, 35);
		addCourse.getContentPane().add(addCtextField_3);

		JTextField addCtextField_4 = new JTextField();
		addCtextField_4.setColumns(10);
		addCtextField_4.setBounds(350, 155, 200, 35);
		addCourse.getContentPane().add(addCtextField_4);

		JTextField addCtextField_5 = new JTextField();
		addCtextField_5.setColumns(10);
		addCtextField_5.setBounds(350, 235, 200, 35);
		addCourse.getContentPane().add(addCtextField_5);

		JTextField addCtextField_6 = new JTextField();
		addCtextField_6.setColumns(10);
		addCtextField_6.setBounds(350, 315, 200, 35);
		addCourse.getContentPane().add(addCtextField_6);

		JButton addCBtn = new JButton("Add Course");
		addCBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ObjectOutputStream outputStream = null;
				try {
					a.add(c);
					FileOutputStream buff = new FileOutputStream("information.txt", true);
					PrintStream p = new PrintStream(buff);
					FileOutputStream buf = new FileOutputStream("course.txt", true);
					PrintStream q = new PrintStream(buf);

					q.print(addCtextField.getText());
					q.print(",");
					q.print(addCtextField_1.getText());
					q.print(",");
					q.print(addCtextField_2.getText());
					q.print(",");
					q.print(addCtextField_3.getText());
					q.print(",");
					q.print(addCtextField_4.getText());
					q.print(",");
					q.print(addCtextField_5.getText());
					q.print(",");
					q.print(addCtextField_6.getText());

				} catch (Exception a) {
					System.out.println(a);
				}
				Course co = new Course();
				co.setCourseID(addCtextField.getText());
				co.setCourseName(addCtextField_1.getText());
				co.setNumOfCredits(Integer.parseInt(addCtextField_2.getText()));
				co.setNumOfStudents(Integer.parseInt(addCtextField_3.getText()));
				co.setNumOfQuizzes(Integer.parseInt(addCtextField_4.getText()));
				co.setNumOfHw(Integer.parseInt(addCtextField_5.getText()));
				co.setNumOfLectures(Integer.parseInt(addCtextField_6.getText()));

				a.add(co);
				addCtextField.setText(null);
				addCtextField_1.setText(null);
				addCtextField_2.setText(null);
				addCtextField_3.setText(null);
				addCtextField_4.setText(null);
				addCtextField_5.setText(null);
				addCtextField_6.setText(null);

				JOptionPane.showMessageDialog(null, "Course successfully added!");
			}
		});
		addCBtn.setBounds(403, 400, 150, 35);
		addCourse.getContentPane().add(addCBtn);

		String ptr, ch;

		setLogo(addCourse);
		setPowered(addCourse);
		setPozadina(addCourse);
	}

	public void displaycourseinf() {

		JFrame displayCourse = new JFrame();
		displayCourse.setVisible(true);
		displayCourse.setBounds(100, 100, 700, 511);
		displayCourse.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		displayCourse.getContentPane().setLayout(null);

		try {
			String str;
			FileInputStream fstream = new FileInputStream("information.txt");
			DataInputStream in = new DataInputStream(fstream);

			FileOutputStream buf = new FileOutputStream("course.txt", true);
			PrintStream q = new PrintStream(buf);
			while (in.available() != 0) {
				str = in.readLine();
				StringTokenizer st = new StringTokenizer(str, ",");

			}
			in.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		setPowered(displayCourse);
		setPozadina(displayCourse);
	}

	Course findCourse(String id) {

		for (Course c : a) {
			if (c.getCourseID().equals(id)) {
				return c;
			}
		}
		return null;
	}

	void searchCo() {

	}

	void update(String s, int no) {
		try {
			String str;
			FileInputStream fstream = new FileInputStream("information.txt");
			DataInputStream in = new DataInputStream(fstream);
			File f = new File("hello1.txt");
			f.delete();
			while (in.available() != 0) {
				str = in.readLine();
				StringTokenizer st = new StringTokenizer(str, ",");
				CourseID = st.nextToken();
				CourseName = st.nextToken();
				numOfCredits = Integer.parseInt(st.nextToken());
				if (CourseID.equals(s)) {
					System.out.println("Entered Course ID is found");
					FileOutputStream buff = new FileOutputStream("hello1.txt", true);
					PrintStream p = new PrintStream(buff);
					p.print(CourseID);
					p.print(",");
					p.print(CourseName);
					p.print(",");
					p.print(numOfCredits);
					p.print(",");
					numOfStudents = no;
					p.print(numOfStudents);
					p.println();
					buff.close();
				} else {
					FileOutputStream buf = new FileOutputStream("hello1.txt", true);
					PrintStream q = new PrintStream(buf);
					q.print(CourseID);
					q.print(",");
					q.print(CourseName);
					q.print(",");
					q.print(numOfCredits);
					q.print(",");
					q.print(numOfStudents);
					q.println();
					buf.close();
				}
			}
			in.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			File f1 = new File("hello1.txt");
			File f2 = new File("information.txt");
			InputStream in1 = new FileInputStream(f1);
			OutputStream out1 = new FileOutputStream(f2);
			byte[] bu = new byte[1024];
			int len;
			while ((len = in1.read(bu)) > 0) {
				out1.write(bu, 0, len);
			}
			FileOutputStream buff = new FileOutputStream("hello1.txt");
			in1.close();
			out1.close();
		} catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage() + " in the specified directory.");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	double presentationPoints, midtermExam, finalExam; // No need to calculate
														// percentage here cause
														// points are always out
														// of 100
	int numOfHomeworks;
	int numOfQuizzes;
	int numOfLectures;
	double homework[] = new double[numOfHomeworks];
	double quizzes[] = new double[numOfQuizzes];
	double attendence[] = new double[numOfLectures];
	double obtainedHwPoints, obtainedQzPoints, obtainedAttendence;

	public void setNumOfHw(int numOfHw) {
		this.numOfHomeworks = numOfHw;
	}

	public void setNumOfQuizzes(int numOfQz) {
		this.numOfQuizzes = numOfQz;
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
		this.quizzes[numOfQz - 1] = numOfPoints;
	}

	public void setAttendence(int numOfLecture) {
		this.attendence[numOfLecture] = 100;
	}
}
