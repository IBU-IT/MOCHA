package ba.ibu.edu.sis;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import ba.ibu.edu.sis.StudentInformationSystem;

public class Course {
	
		String CourseID,CourseName,ProfessorName,Starting_date,ending_date;
		int Duration_of_Course,numOfWeeks,numOfCredits,numOfStudents;
		ArrayList<Course> a = new ArrayList();
		Course()
		{
			this.CourseID=CourseID;
			this.CourseName=CourseName;
			this.ProfessorName=ProfessorName;
			this.Duration_of_Course=Duration_of_Course;
			this.Starting_date=Starting_date;
			this.ending_date=ending_date;
			this.numOfWeeks=numOfWeeks;
			this.numOfCredits=numOfCredits;
			this.numOfStudents=numOfStudents;
		}
		
		public void add(Course c){
			
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

