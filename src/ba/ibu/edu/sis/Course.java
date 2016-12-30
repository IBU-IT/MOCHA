package ba.ibu.edu.sis;

//import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ba.ibu.edu.sis.SIS.Admin;
import ba.ibu.edu.sis.SIS.Professor;

public class Course implements Serializable {

	private static final long serialVersionUID = 1L;
	private String CourseID, CourseName;
	int numOfCredits, numOfStudents;
	//public ArrayList<Course> a = new ArrayList<Course>();

	

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
	
	public Course(){
	}
	
	public void homeButton(JFrame hFrame, int shift) {
		ImageIcon homeIcon=new ImageIcon("home_icon.png");
		JButton btnHome = new JButton(homeIcon);
		btnHome.setForeground(Color.WHITE);
		
		btnHome.setBounds(635, 20+shift, 30, 30);
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
	
	public  void blabla (Admin a,List<Course> lista){
		
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
		btnLogout.setBounds(590, 62, 110, 23);
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

	
		JButton addCBtn = new JButton("Add Course");
		addCBtn.addActionListener(new ActionListener() {
			public  void actionPerformed(ActionEvent e) {
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
		});
		addCBtn.setBounds(403, 400, 150, 35);
		addCourse.getContentPane().add(addCBtn);

		
		
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
			BufferedReader br = new BufferedReader(new FileReader("course.txt"));
			String line;
			while ((line = br.readLine()) != null) {
				JLabel addLe = new JLabel(line);
				addLe.setFont(new Font("TAHOMA", Font.PLAIN, 14));
				addLe.setForeground(Color.WHITE);
				addLe.setBounds(23, 50, 500, 35);
				displayCourse.getContentPane().add(addLe);

			}
			br.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		setPowered(displayCourse);
		setPozadina(displayCourse);
	}

	void searchCo() {

	}

	@SuppressWarnings("deprecation")
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
	
	public void course_inf(Professor pr, Admin a){
		SIS sis = new SIS();
		JFrame courseInf = new JFrame();
		courseInf.setVisible(true);
		courseInf.setBounds(100, 100, 700, 511);
		courseInf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		courseInf.getContentPane().setLayout(null);
		
		JTextField txtCourseSection = new JTextField();
		txtCourseSection.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtCourseSection.setForeground(Color.WHITE);
		txtCourseSection.setText("COURSE DETAILS");
		txtCourseSection.setBounds(25, 120, 674, 20);
		txtCourseSection.setOpaque(false);
		txtCourseSection.setBorder(null);
		courseInf.getContentPane().add(txtCourseSection);
		txtCourseSection.setColumns(10);
		
		JTextField txtCourseName = new JTextField();
		txtCourseName.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtCourseName.setForeground(Color.WHITE);
		txtCourseName.setText("Course name: ");
		txtCourseName.setBounds(25, 150, 674, 20);
		txtCourseName.setOpaque(false);
		txtCourseName.setBorder(null);
		courseInf.getContentPane().add(txtCourseName);
		txtCourseName.setColumns(10);
		
		JTextField txtCourseCode = new JTextField();
		txtCourseCode.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtCourseCode.setForeground(Color.WHITE);
		txtCourseCode.setText("Course code: ");
		txtCourseCode.setBounds(25, 180, 674, 20);
		txtCourseCode.setOpaque(false);
		txtCourseCode.setBorder(null);
		courseInf.getContentPane().add(txtCourseCode);
		txtCourseCode.setColumns(10);
		
		JTextField txtCourseNumOfStd = new JTextField();
		txtCourseNumOfStd.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtCourseNumOfStd.setForeground(Color.WHITE);
		txtCourseNumOfStd.setText("Number of students: ");
		txtCourseNumOfStd.setBounds(25, 210, 674, 20);
		txtCourseNumOfStd.setOpaque(false);
		txtCourseNumOfStd.setBorder(null);
		courseInf.getContentPane().add(txtCourseNumOfStd);
		txtCourseNumOfStd.setColumns(10);
		
		JTextField txtCourseNumOfCr = new JTextField();
		txtCourseNumOfCr.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtCourseNumOfCr.setForeground(Color.WHITE);
		txtCourseNumOfCr.setText("Number of credits: ");
		txtCourseNumOfCr.setBounds(25, 240, 674, 20);
		txtCourseNumOfCr.setOpaque(false);
		txtCourseNumOfCr.setBorder(null);
		courseInf.getContentPane().add(txtCourseNumOfCr);
		txtCourseNumOfCr.setColumns(10);
		
		JButton btneditDet = new JButton("Edit course details");
		btneditDet.setBounds(25, 300, 200, 40);
		courseInf.getContentPane().add(btneditDet);
		
		JButton btneditStd = new JButton("Edit student list");
		btneditStd.setBounds(25, 360, 200, 40);
		courseInf.getContentPane().add(btneditStd);
		btneditStd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				courseInf.dispose();
				student_list(pr,a);
			}
		});
		
		JTextField txtCourseStu = new JTextField();
		txtCourseStu.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtCourseStu.setForeground(Color.WHITE);
		txtCourseStu.setText("ADD STUDENTS TO COURSE");
		txtCourseStu.setBounds(350, 120, 200, 20);
		txtCourseStu.setOpaque(false);
		txtCourseStu.setBorder(null);
		courseInf.getContentPane().add(txtCourseStu);
		txtCourseStu.setColumns(10);
		
		
		JTextField txtSearchCourse = new JTextField();
		txtSearchCourse.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtSearchCourse.setForeground(Color.WHITE);
		txtSearchCourse.setText("Search student");
		txtSearchCourse.setBounds(350, 150, 100, 20);
		txtSearchCourse.setOpaque(false);
		txtSearchCourse.setBorder(null);
		courseInf.getContentPane().add(txtSearchCourse);
		txtSearchCourse.setColumns(10);

		JTextField textField = new JTextField();
		textField.setBounds(350, 180, 250, 40);
		courseInf.getContentPane().add(textField);
		textField.setColumns(10);
		JButton btnGo = new JButton("GO");
		btnGo.setBounds(605, 180, 52, 40);
		courseInf.getContentPane().add(btnGo);
		
		JTextArea txTemp = new JTextArea();
		txTemp.setFont(new Font("Tahoma", Font.BOLD, 14));
		txTemp.setForeground(Color.WHITE);
		txTemp.setText("1. Huso Cubarkapa");
		txTemp.setBounds(350, 260, 300, 50);
		txTemp.setOpaque(false);
		txTemp.setBorder(null);
		courseInf.add(txTemp, BorderLayout.WEST);

		JButton btnUpdateStd = new JButton("ADD TO COURSE");
		btnUpdateStd.setForeground(Color.WHITE);
		btnUpdateStd.setFont(new Font("TAHOMA", Font.BOLD, 12));
		btnUpdateStd.setBounds(550, 255, 100, 30);
		courseInf.getContentPane().add(btnUpdateStd);
		btnUpdateStd.setContentAreaFilled(false);
		btnUpdateStd.setBorder(null);
		
		backPrPn(courseInf,pr);
		sis.prof_menu(courseInf, pr,a);
		setLogo(courseInf);
		setPowered(courseInf);
		setPozadina(courseInf);
	}
	
	public void backPrPn(JFrame nFrame,Professor pr){
		JButton backPrPn = new JButton("ALL COURSE");
		backPrPn.setBounds(25, 420, 120, 30);	
		nFrame.getContentPane().add(backPrPn);
		backPrPn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
			}
		});
	}
	
	public void student_list(Professor pr,Admin a){
		SIS sis = new SIS();
		JFrame std_coPanel = new JFrame();
		std_coPanel.setVisible(true);
		std_coPanel.setBounds(100, 100, 700, 511);
		std_coPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		std_coPanel.getContentPane().setLayout(null);
		
		JTextField txtCourseSection = new JTextField();
		txtCourseSection.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtCourseSection.setForeground(Color.WHITE);
		txtCourseSection.setText("LIST OF STUDENTS");
		txtCourseSection.setBounds(25, 120, 674, 20);
		txtCourseSection.setOpaque(false);
		txtCourseSection.setBorder(null);
		std_coPanel.getContentPane().add(txtCourseSection);
		
		JTextArea txTemp = new JTextArea();
		txTemp.setFont(new Font("Tahoma", Font.BOLD, 13));
		txTemp.setForeground(Color.WHITE);
		txTemp.setText("1. Huso Cubarkapa");
		txTemp.setBounds(25, 170, 200, 30);
		txTemp.setOpaque(false);
		txTemp.setBorder(null);
		std_coPanel.add(txTemp, BorderLayout.WEST);
		
		JButton btnUpdateStd = new JButton("UPDATE");
		btnUpdateStd.setForeground(Color.WHITE);
		btnUpdateStd.setFont(new Font("TAHOMA", Font.BOLD, 12));
		btnUpdateStd.setBounds(250, 160, 100, 30);
		std_coPanel.getContentPane().add(btnUpdateStd);
		btnUpdateStd.setContentAreaFilled(false);
		btnUpdateStd.setBorder(null);
		btnUpdateStd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				std_coPanel.dispose();
				updateStd(pr,a);
			}
		});
		
		backPrPn(std_coPanel,pr);
		sis.prof_menu(std_coPanel, pr,a);
		setLogo(std_coPanel);
		setPowered(std_coPanel);
		setPozadina(std_coPanel);
	}
	
	public void updateStd(Professor pr, Admin a){
		SIS sis = new SIS();
		JFrame std_updPanel = new JFrame();
		std_updPanel.setVisible(true);
		std_updPanel.setBounds(100, 100, 700, 511);
		std_updPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		std_updPanel.getContentPane().setLayout(null);
	
	JTextField stdID = new JTextField();
	stdID.setFont(new Font("Tahoma", Font.BOLD, 13));
	stdID.setForeground(Color.WHITE);
	stdID.setText("Student ID:");
	stdID.setBounds(25, 110, 200, 30);
	stdID.setOpaque(false);
	stdID.setBorder(null);
	std_updPanel.getContentPane().add(stdID);
	
	JTextField stdname = new JTextField();
	stdname.setFont(new Font("Tahoma", Font.BOLD, 13));
	stdname.setForeground(Color.WHITE);
	stdname.setText("Student Name:");
	stdname.setBounds(200, 110, 200, 30);
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
	std_updPanel.getContentPane().add(btnUpdateStd);
	
	
	sis.prof_menu(std_updPanel, pr,a);
	setLogo(std_updPanel);
	setPowered(std_updPanel);
	setPozadina(std_updPanel);

	}
}
