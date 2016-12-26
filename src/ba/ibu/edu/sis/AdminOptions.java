package ba.ibu.edu.sis;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class AdminOptions extends JFrame {

	public void setPozadina(JFrame frejm) {
		JLabel pozadina = new JLabel("");
		pozadina.setBounds(0, 0, 684, 473);
		pozadina.setIcon(new ImageIcon("burch2.jpg"));
		frejm.getContentPane().add(pozadina);
	}

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminOptions frame = new AdminOptions();
					frame.setPozadina(frame);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public AdminOptions() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 511);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
	}

}
