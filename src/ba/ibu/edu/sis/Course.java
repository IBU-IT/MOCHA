package ba.ibu.edu.sis;

import java.util.ArrayList;

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
}

