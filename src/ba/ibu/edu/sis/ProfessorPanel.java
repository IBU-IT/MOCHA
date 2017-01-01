package ba.ibu.edu.sis;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ba.ibu.edu.sis.SIS.Admin;
import ba.ibu.edu.sis.SIS.Professor;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class ProfessorPanel extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

	}

	/**
	 * Create the frame.
	 */
	public ProfessorPanel(Admin a, Professor profa) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 511);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblProfessorName = new JLabel("Professor Name:        " + profa.getName());
		lblProfessorName.setForeground(Color.WHITE);
		lblProfessorName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblProfessorName.setBounds(135, 56, 400, 43);
		contentPane.add(lblProfessorName);

		JLabel label = new JLabel("Professor Surname:    " + profa.getSurname());
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(135, 76, 400, 43);
		contentPane.add(label);

		JLabel label_1 = new JLabel("Professor ID:            " + profa.getId());
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_1.setBounds(135, 96, 400, 43);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("Professor Email:        " + profa.getEmail());
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_2.setBounds(135, 116, 400, 43);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("Professor Phone:       " + profa.getPhone());
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_3.setBounds(135, 136, 400, 43);
		contentPane.add(label_3);

	}
}
