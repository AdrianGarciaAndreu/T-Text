package graficos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class Menu {

	private JPanel contentPane;
	private funcionamiento func = new funcionamiento();
	private JFrame Menu = new JFrame();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	
	/**
	 * constructor que crea el Frame de esta clase
	 */
	public Menu() {
		
		
		
		Menu.setAlwaysOnTop(true);
		Menu.setBackground(Color.LIGHT_GRAY);
		Menu.setResizable(false);
		
		Menu.setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/images/iconoTT.png")));
		
		Menu.setTitle("TText v1.0");
		Menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Menu.setBounds(100, 100, 405, 293);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		Menu.setContentPane(contentPane);
		
		JPanel panel = new JPanel();	
		panel.setBackground(Color.DARK_GRAY);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnNewFile = new JButton("");
		btnNewFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				func.NewFile(Menu);
			}
		});
		
		btnNewFile.setToolTipText("New file...");
		btnNewFile.setIcon(new ImageIcon(Menu.class.getResource("/images/new_document.png")));
		btnNewFile.setBounds(72, 35, 42, 51);
		panel.add(btnNewFile);
		
		JButton Button_OpenFile = new JButton("");
		Button_OpenFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				func.OpenFileIni(Menu);
			}
		});
		Button_OpenFile.setToolTipText("Open file...");
		Button_OpenFile.setIcon(new ImageIcon(Menu.class.getResource("/images/open_document.png")));
		Button_OpenFile.setBounds(276, 35, 62, 51);
		panel.add(Button_OpenFile);
		
		JLabel label = new JLabel("");
		label.setToolTipText("Menu");
		label.setBounds(0, 0, 389, 255);
		label.setIcon(new ImageIcon(Menu.class.getResource("/images/home.png")));
		panel.add(label);
		
		ImageIcon background = new ImageIcon(Menu.class.getResource("/images/home.png"));
		
		Menu.setVisible(true);
	}
	
	
	public JFrame getFrame() {
		return (this.Menu);
	}
}



