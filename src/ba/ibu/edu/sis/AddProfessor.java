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

		JLabel lblProfessorName = new JLabel("Professor Name");
		lblProfessorName.setForeground(Color.WHITE);
		lblProfessorName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProfessorName.setBounds(21, 26, 137, 49);
		contentPane.add(lblProfessorName);

		JLabel lblProfessorSurname = new JLabel("Professor Surname");
		lblProfessorSurname.setForeground(Color.WHITE);
		lblProfessorSurname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProfessorSurname.setBounds(21, 100, 137, 49);
		contentPane.add(lblProfessorSurname);

		JLabel lblProfessorId = new JLabel("Professor ID");
		lblProfessorId.setForeground(Color.WHITE);
		lblProfessorId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProfessorId.setBounds(21, 174, 137, 49);
		contentPane.add(lblProfessorId);

		JLabel lblProfessorEmail = new JLabel("Professor E-mail");
		lblProfessorEmail.setForeground(Color.WHITE);
		lblProfessorEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProfessorEmail.setBounds(21, 248, 137, 49);
		contentPane.add(lblProfessorEmail);

		JLabel lblProfessorPhone = new JLabel("Professor Phone");
		lblProfessorPhone.setForeground(Color.WHITE);
		lblProfessorPhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProfessorPhone.setBounds(21, 322, 137, 49);
		contentPane.add(lblProfessorPhone);

		JLabel lblProfessorPassword = new JLabel("Professor Password");
		lblProfessorPassword.setForeground(Color.WHITE);
		lblProfessorPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProfessorPassword.setBounds(21, 396, 137, 49);
		contentPane.add(lblProfessorPassword);

		profname = new JTextField();
		profname.setBounds(168, 39, 110, 27);
		contentPane.add(profname);
		profname.setColumns(10);

		profsurname = new JTextField();
		profsurname.setColumns(10);
		profsurname.setBounds(168, 113, 110, 27);
		contentPane.add(profsurname);

		profid = new JTextField();
		profid.setColumns(10);
		profid.setBounds(168, 187, 110, 27);
		contentPane.add(profid);

		profemail = new JTextField();
		profemail.setColumns(10);
		profemail.setBounds(168, 261, 110, 27);
		contentPane.add(profemail);

		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(168, 335, 110, 27);
		contentPane.add(phone);

		profpassword = new JTextField();
		profpassword.setColumns(10);
		profpassword.setBounds(168, 409, 110, 27);
		contentPane.add(profpassword);

		JButton btnDeleteProfessor = new JButton("Delete Professor");
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
		btnDeleteProfessor.setBounds(502, 396, 150, 49);
		contentPane.add(btnDeleteProfessor);

		JLabel lblAssignCourses = new JLabel("Assign Courses:");
		lblAssignCourses.setForeground(Color.WHITE);
		lblAssignCourses.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAssignCourses.setBounds(417, 26, 137, 49);
		contentPane.add(lblAssignCourses);

		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				SIS prozor = new SIS();
				prozor.initOptions(a, lista);
			}
		});
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setContentAreaFilled(false);
		btnLogout.setBounds(590, 62, 110, 23);
		btnLogout.setFont(new Font("TAHOMA", Font.BOLD, 11));
		btnLogout.setBorder(null);
		contentPane.add(btnLogout);

		JList<String> list = new JList<String>();
		list.setBounds(299, 89, 137, 224);
		contentPane.add(list);
		DefaultListModel<String> DLM = new DefaultListModel<String>();
		for (int i = 0; i < lista.size(); i++) {
			DLM.addElement(lista.get(i).getCourseName());
		}
		list.setModel(DLM);

		JList<String> dodaj = new JList<String>();
		dodaj.setBounds(537, 89, 137, 224);
		contentPane.add(dodaj);

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
		btnAdd.setBounds(440, 115, 92, 23);
		contentPane.add(btnAdd);

		JButton btnRemove = new JButton("<<Remove ");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DLM.addElement(dodaj.getSelectedValue());
				DLM1.removeElement(dodaj.getSelectedValue());
				list.setModel(DLM);
			}
		});
		btnRemove.setFont(new Font("Tahoma", Font.ITALIC, 10));
		btnRemove.setBounds(440, 149, 92, 23);
		contentPane.add(btnRemove);

		JLabel lblSearchProfessorBy = new JLabel("Search Professor by ID:");
		lblSearchProfessorBy.setForeground(Color.WHITE);
		lblSearchProfessorBy.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSearchProfessorBy.setBounds(295, 335, 186, 49);
		contentPane.add(lblSearchProfessorBy);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(452, 343, 80, 38);
		contentPane.add(textField);

		JButton btnNewButton = new JButton("Add Professor");
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
		btnNewButton.setBounds(342, 396, 150, 49);
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
		btnNewButton_1.setBounds(541, 343, 59, 38);
		contentPane.add(btnNewButton_1);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DLM1.clear();
				dodaj.setModel(DLM1);
			}
		});
		btnClear.setBounds(563, 316, 89, 23);
		contentPane.add(btnClear);
	}
}
