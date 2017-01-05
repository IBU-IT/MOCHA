package ba.ibu.edu.sis;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ba.ibu.edu.sis.SIS.Admin;
import ba.ibu.edu.sis.SIS.Professor;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class AddProfessor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField profname;
	private JTextField profsurname;
	private JTextField profid;
	private JTextField profemail;
	private JTextField phone;
	private JTextField profpassword;
	private JTextField textField;

	public static void main(String[] args) {
	}

	public AddProfessor(Admin a, List<Course> lista) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 511);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblProfessorName = new JLabel("Name");
		lblProfessorName.setForeground(new Color(32, 35, 86));
		lblProfessorName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblProfessorName.setBounds(23, 110, 137, 30);
		contentPane.add(lblProfessorName);

		JLabel lblProfessorSurname = new JLabel("Surname");
		lblProfessorSurname.setForeground(new Color(32, 35, 86));
		lblProfessorSurname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblProfessorSurname.setBounds(23, 150, 137, 30);
		contentPane.add(lblProfessorSurname);

		JLabel lblProfessorId = new JLabel("ID number");
		lblProfessorId.setForeground(new Color(32, 35, 86));
		lblProfessorId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblProfessorId.setBounds(23, 190, 137, 30);
		contentPane.add(lblProfessorId);

		JLabel lblProfessorEmail = new JLabel("E-mail");
		lblProfessorEmail.setForeground(new Color(32, 35, 86));
		lblProfessorEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblProfessorEmail.setBounds(23, 230, 137, 30);
		contentPane.add(lblProfessorEmail);

		JLabel lblProfessorPhone = new JLabel("Phone");
		lblProfessorPhone.setForeground(new Color(32, 35, 86));
		lblProfessorPhone.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblProfessorPhone.setBounds(23, 270, 137, 30);
		contentPane.add(lblProfessorPhone);

		JLabel lblProfessorPassword = new JLabel("Password");
		lblProfessorPassword.setForeground(new Color(32, 35, 86));
		lblProfessorPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblProfessorPassword.setBounds(23, 310, 137, 30);
		contentPane.add(lblProfessorPassword);

		profname = new JTextField();
		profname.setBounds(110, 110, 160, 30);
		profname.setBorder(BorderFactory.createMatteBorder(1, 3, 1, 1, new Color(118, 173, 224)));
		contentPane.add(profname);
		profname.setColumns(10);

		profsurname = new JTextField();
		profsurname.setColumns(10);
		profsurname.setBorder(BorderFactory.createMatteBorder(1, 3, 1, 1, new Color(118, 173, 224)));
		profsurname.setBounds(110, 150, 160, 30);
		contentPane.add(profsurname);

		profid = new JTextField();
		profid.setColumns(10);
		profid.setBorder(BorderFactory.createMatteBorder(1, 3, 1, 1, new Color(118, 173, 224)));
		profid.setBounds(110, 190, 160, 30);
		contentPane.add(profid);

		profemail = new JTextField();
		profemail.setColumns(10);
		profemail.setBorder(BorderFactory.createMatteBorder(1, 3, 1, 1, new Color(118, 173, 224)));
		profemail.setBounds(110, 230, 160, 30);
		contentPane.add(profemail);

		phone = new JTextField();
		phone.setColumns(10);
		phone.setBorder(BorderFactory.createMatteBorder(1, 3, 1, 1, new Color(118, 173, 224)));
		phone.setBounds(110, 270, 160, 30);
		contentPane.add(phone);

		profpassword = new JTextField();
		profpassword.setColumns(10);
		profpassword.setBorder(BorderFactory.createMatteBorder(1, 3, 1, 1, new Color(118, 173, 224)));
		profpassword.setBounds(110, 310, 160, 30);
		contentPane.add(profpassword);


		JButton btnDeleteProfessor = new JButton("Delete");
		btnDeleteProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Professor todelete = a.findProfessor(textField.getText());
				a.Professors.remove(todelete);
				profname.setText(null);
				profsurname.setText(null);
				profemail.setText(null);
				profid.setText(null);
				profpassword.setText(null);
				phone.setText(null);
				JOptionPane.showMessageDialog(null, "Professor deleted!");

			}
		});
		btnDeleteProfessor.setBounds(150, 370, 120, 40);
		btnDeleteProfessor.setFont(new Font("TAHOMA", Font.PLAIN, 14));
		btnDeleteProfessor.setForeground(new Color(255, 255, 255));
		btnDeleteProfessor.setBackground(new Color(12, 68, 126));
		contentPane.add(btnDeleteProfessor);

		JLabel lblAssignCourses = new JLabel("Assign Courses:");
		lblAssignCourses.setForeground(new Color(12, 68, 126));
		lblAssignCourses.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAssignCourses.setBounds(310, 75, 137, 35);
		contentPane.add(lblAssignCourses);
		
		JLabel lblAddProf = new JLabel("Add new professor:");
		lblAddProf.setForeground(new Color(12, 68, 126));
		lblAddProf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAddProf.setBounds(23, 75, 250, 35);
		contentPane.add(lblAddProf);

		JList<String> list = new JList<String>();
		list.setBounds(310, 110, 137, 230);
		list.setBorder(BorderFactory.createMatteBorder(1, 1, 4, 1, new Color(118, 173, 224)));
		contentPane.add(list);
		DefaultListModel<String> DLM = new DefaultListModel<String>();
		for (int i = 0; i < lista.size(); i++) {
			DLM.addElement(lista.get(i).getCourseName());
		}
		list.setModel(DLM);

		JList<String> dodaj = new JList<String>();
		dodaj.setBounds(530, 110, 137, 230);
		dodaj.setBorder(BorderFactory.createMatteBorder(1, 1, 4, 1, new Color(118, 173, 224)));
		contentPane.add(dodaj);

		DefaultListModel<String> DLM1 = new DefaultListModel<String>();
		JButton btnAdd = new JButton("Add > ");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DLM1.addElement(list.getSelectedValue());
				DLM.removeElement(list.getSelectedValue());
				dodaj.setModel(DLM1);
			}
		});

		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAdd.setBounds(440, 115, 92, 23);
		btnAdd.setForeground(new Color(255, 255, 255));
		btnAdd.setBackground(new Color(12, 68, 126));
		btnAdd.setBounds(457, 120, 65, 40);
		btnAdd.setBorder(null);
		contentPane.add(btnAdd);

		JButton btnRemove = new JButton(" < Remove ");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DLM.addElement(dodaj.getSelectedValue());
				DLM1.removeElement(dodaj.getSelectedValue());
				list.setModel(DLM);
			}
		});
		btnRemove.setFont(new Font("TAHOMA", Font.PLAIN, 12));
		btnRemove.setForeground(new Color(255, 255, 255));
		btnRemove.setBackground(new Color(12, 68, 126));
		btnRemove.setBounds(457, 170, 65, 40);
		btnRemove.setBorder(null);
		contentPane.add(btnRemove);

		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DLM1.clear();
				dodaj.setModel(DLM1);
			}
		});
		
		btnClear.setFont(new Font("TAHOMA", Font.PLAIN, 12));
		btnClear.setForeground(new Color(255, 255, 255));
		btnClear.setBackground(new Color(12, 68, 126));
		btnClear.setBounds(457, 240, 65, 40);
		btnClear.setBorder(null);
		contentPane.add(btnClear);
		
		JLabel lblSearchProfessorBy = new JLabel("Search Professor by ID:");
		lblSearchProfessorBy.setForeground(new Color(12, 68, 126));
		lblSearchProfessorBy.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSearchProfessorBy.setBounds(310, 340, 186, 40);
		contentPane.add(lblSearchProfessorBy);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBorder(BorderFactory.createMatteBorder(1, 3, 1, 1, new Color(118, 173, 224)));
		textField.setBounds(310, 371, 280, 40);
		contentPane.add(textField);

		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (a.findProfessor(profid.getText()) != null) {
					JOptionPane.showMessageDialog(null, "This ID is already taken. Please enter another ID.");
				} else {
					Professor p = new Professor();
					p.setName(profname.getText());
					p.setSurname(profsurname.getText());
					p.setEmail(profemail.getText());
					p.setId(profid.getText());
					p.setPassword(profpassword.getText());
					p.setPhone(phone.getText());
					List<Course> CoursesToAdd = new ArrayList<Course>();
					for (int i = 0; i < DLM1.size(); i++) {
						CoursesToAdd.add(a.findCourse(DLM1.getElementAt(i)));
					}
					p.setMyCourses(CoursesToAdd);
					a.Professors.add(p);
					a.saveP();
					profname.setText(null);
					profsurname.setText(null);
					profemail.setText(null);
					profid.setText(null);
					profpassword.setText(null);
					phone.setText(null);
					JOptionPane.showMessageDialog(null, "Professor successfully added!");
				}

			}
		});
		btnNewButton.setBounds(23, 370, 120, 40);
		btnNewButton.setFont(new Font("TAHOMA", Font.PLAIN, 14));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(12, 68, 126));
		btnNewButton.setBorder(null);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Go");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (a.findProfessor(textField.getText()) == null) {
					JOptionPane.showMessageDialog(null, "Professor not found.");
					textField.setText(null);
				} else {
					Professor wanted = a.findProfessor(textField.getText());
					profname.setText(wanted.getName());
					profsurname.setText(wanted.getSurname());
					profemail.setText(wanted.getEmail());
					profid.setText(wanted.getId());
					profpassword.setText(wanted.getPassword());
					phone.setText(wanted.getPhone());
					textField.setText(null);
					DLM1.clear();
					for (int i = 0; i < wanted.getMyCourses().size(); i++) {
						DLM1.addElement(wanted.getMyCourses().get(i).getCourseName());
					}
					dodaj.setModel(DLM1);
				}
				DLM.clear();
				for (int i = 0; i < lista.size(); i++) {
					DLM.addElement(lista.get(i).getCourseName());
				}
				list.setModel(DLM);
			}
		});
		btnNewButton_1.setBounds(610, 370, 55, 40);
		btnNewButton_1.setFont(new Font("TAHOMA", Font.PLAIN, 13));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(12, 68, 126));
		btnNewButton_1.setBorder(null);
		contentPane.add(btnNewButton_1);

	}
}
