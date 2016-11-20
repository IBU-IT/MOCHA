package ba.ibu.edu.sis;

import java.awt.EventQueue;
import java.util.ArrayList;
import javax.swing.JFrame;
import java.awt.Color;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import ba.ibu.edu.sis.Course;
import java.io.*;
import java.util.Scanner;

public class StudentInformationSystem {
	

	private JFrame frame;

	static class Student {
		private String id;
		private String name;
		private String surname;
		private int age;
		private int year;
		private int grades[];
		
		public String getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		public String getSurname() {
			return surname;
		}

		public int getAge() {
			return age;
		}

		public int getYear() {
			return year;
		}

		
		
	}


	public static void main(String[] args) {
		String strDirectoy ="course";
		Course c=new Course();
		boolean success = (new File(strDirectoy)).mkdir();
		if(success) 
		{
			System.out.println("Directory: " + strDirectoy + " created");
		}   
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentInformationSystem window = new StudentInformationSystem();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public StudentInformationSystem() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		
		JLabel lblWelcome = new JLabel("Welcome to Student Information System (SIS)");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblWelcome, BorderLayout.NORTH);
		frame.setSize(750, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setResizable(false);
	}

}
