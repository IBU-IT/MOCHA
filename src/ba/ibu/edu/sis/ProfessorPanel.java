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

		JLabel lblProfessorName = new JLabel("Name:        " + profa.getName());
		lblProfessorName.setForeground(new Color(32, 35, 86));
		lblProfessorName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProfessorName.setBounds(23, 90, 200, 35);
		contentPane.add(lblProfessorName);

		JLabel label = new JLabel("Surname:    " + profa.getSurname());
		label.setForeground(new Color(32, 35, 86));
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(23, 120, 200, 35);
		contentPane.add(label);

		JLabel label_1 = new JLabel("ID:            " + profa.getId());
		label_1.setForeground(new Color(32, 35, 86));
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(280, 90, 200, 35);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("Email:        " + profa.getEmail());
		label_2.setForeground(new Color(32, 35, 86));
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(280, 120, 200, 35);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("Phone:       " + profa.getPhone());
		label_3.setForeground(new Color(32, 35, 86));
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(520, 90, 200, 35);
		contentPane.add(label_3);

	}
}
