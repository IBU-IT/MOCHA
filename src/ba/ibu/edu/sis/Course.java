package ba.ibu.edu.sis;

import java.util.ArrayList;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Scanner;
import java.io.Serializable;
import javax.swing.JOptionPane;
import ba.ibu.edu.sis.StudentInformationSystem;

public class Course implements Serializable {
	
		String CourseID,CourseName,ProfessorName;
		int numOfCredits,numOfStudents;
		ArrayList<Course> a = new ArrayList();
		Course()
		{
			this.CourseID=CourseID;
			this.CourseName=CourseName;
			this.ProfessorName=ProfessorName;
			this.numOfCredits=numOfCredits;
			this.numOfStudents=numOfStudents;
		}
		
		public void add(Course c){
			String ptr,ch;
			ObjectOutputStream outputStream = null;
			try
			{
				a.add(c);
				FileOutputStream buff=new FileOutputStream("information.txt",true);
				PrintStream p = new PrintStream(buff);
				FileOutputStream buf=new FileOutputStream("course.txt",true);
				PrintStream q = new PrintStream(buf);
				p.print(CourseID);
				p.print(",");
				p.print(CourseName);
				p.print(",");
				p.print(numOfCredits);
				p.print(",");
				p.print(numOfStudents);
				p.println();
				q.print(CourseName);
				q.print(",");
				q.print(CourseID);
				q.println();
				ch=".txt";
				ptr=CourseID+ch;
				FileOutputStream b=new FileOutputStream(ptr);
				b.close();
				buf.close();
				buff.close();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		
		public void displaycourseinf()
		{
			try
			{
				String str;
				FileInputStream fstream=new FileInputStream("information.txt");
				DataInputStream in=new DataInputStream(fstream);
				while(in.available()!=0)
				/*{
					str=in.readLine();
					StringTokenizer st = new StringTokenizer(str,",");
					CourseID = st.nextToken();
					System.out.println("Course ID\t:"+CourseID);
					CourseName= st.nextToken();
					System.out.println("Course name\t:"+CourseName);
					numOfCredits = Integer.parseInt(st.nextToken());
					System.out.println("No of credits\t:"+numOfCredits);
					numOfStudents = Integer.parseInt(st.nextToken());
					System.out.println("No of Students\t:"+numOfStudents);
					System.out.println("---------------------------------------------------------");
				}*/
				in.close();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		
		void update(String s,int no)
		{
			try
			{
				String str;
				FileInputStream fstream=new FileInputStream("information.txt");
				DataInputStream in=new DataInputStream(fstream);
				File f = new File("hello1.txt");
				f.delete();
				while(in.available()!=0)
				{
					str=in.readLine();
					StringTokenizer st = new StringTokenizer(str,",");
					CourseID = st.nextToken();
					CourseName= st.nextToken();
					numOfCredits = Integer.parseInt(st.nextToken());
					if(CourseID.equals(s))
					{
						System.out.println("Entered Course ID is found");
						FileOutputStream buff=new FileOutputStream("hello1.txt",true);
						PrintStream p= new PrintStream(buff);
						p.print(CourseID);
						p.print(",");
						p.print(CourseName);
						p.print(",");
						p.print(numOfCredits);
						p.print(",");
						numOfStudents=no;
						p.print(numOfStudents);
						p.println();
						buff.close();
					}
					else
					{
						FileOutputStream buf=new FileOutputStream("hello1.txt",true);
						PrintStream q= new PrintStream(buf);
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
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			try
			{
				File f1 = new File("hello1.txt");
				File f2 = new File("information.txt");
				InputStream in1 = new FileInputStream(f1);
				OutputStream out1 = new FileOutputStream(f2);
				byte[] bu = new byte[1024];
				int len;
				while ((len=in1.read(bu))>0)
				{
					out1.write(bu,0,len);
				}
				FileOutputStream buff=new FileOutputStream("hello1.txt");
				in1.close();
				out1.close();
			}	
			catch(FileNotFoundException ex)
			{
				System.out.println(ex.getMessage() + " in the specified directory.");
			}
			catch(IOException e)
			{
				System.out.println(e.getMessage());  
			}
		}
	
		
		double presentationPoints,midtermExam, finalExam; //No need to calculate percentage here cause points are always out of 100
		int numOfHomeworks;
		int numOfQuizzes;
		int numOfLectures;
		double homework[]=new double[numOfHomeworks];
		double quizzes[]=new double[numOfQuizzes];
		double attendence[]=new double[numOfLectures];
		double obtainedHwPoints,obtainedQzPoints,obtainedAttendence;
		
		public void setNumOfHw(int numOfHw){
			this.numOfHomeworks=numOfHw;
		}
		
		public void setNumOfQuizzes(int numOfQz){
			this.numOfQuizzes=numOfQz;
		}
		
		public void setNumOfLectures(int numOfLectures){
			this.numOfLectures=numOfLectures;
		}
		
		public void showStudentsGrades(){
			
			//to get percentage of homework points
			obtainedHwPoints=calculatePercentage(homework, numOfHomeworks);
			//to get percentage of quizzes points
			obtainedQzPoints=calculatePercentage(quizzes, numOfQuizzes);
			//to get percentage of attendence
			obtainedAttendence=calculatePercentage(attendence, numOfLectures);
			
			JOptionPane.showMessageDialog(null, "Presentation:" + presentationPoints + "%" + "\n" + "Midterm: " + midtermExam + "%" + "\n" + "Final: " + finalExam + "%" + "\n" + "Homework: " + obtainedHwPoints + "%" + "\n" + "Quizzes: " + obtainedQzPoints + "%" + "\n" + "Attendence: " + obtainedAttendence + "%");
		
		}
		
		private double calculatePercentage(double particle[], int numOfParticles)
		{
			double result = 0,obtainedPoints;
			int maximumPoints;
			
			for(int i=0;i<numOfParticles;i++)
			{
				result+=particle[i];	
			}
			maximumPoints=100*numOfParticles;
			obtainedPoints=result/maximumPoints*100;
			
			return obtainedPoints;
			
		}
		
		public void setHomeworkResult(int numOfHw, double numOfPoints){
			this.homework[numOfHw-1]=numOfPoints;
		}
		
		public void setQuizResult(int numOfQz, double numOfPoints){
			this.quizzes[numOfQz-1]=numOfPoints;
		}
		
		public void setAttendence(int numOfLecture){
			this.attendence[numOfLecture]=100;
		}
}

