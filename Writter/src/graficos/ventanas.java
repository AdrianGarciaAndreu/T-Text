package graficos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;




/**
 * Clase general version 1.1
 *  
 *  última revisión, correccion del guardado de archivos en caso de que sea "null" 
 *  la elección del "JFileChooser" al guardar.
 */
public class ventanas {

	private JPanel contentPane;
	private JTextPane Area = new JTextPane();
	private JFrame Principal = new JFrame();
	
	private funcionamiento func = new funcionamiento(); //Objeto de la clase funcionamiento (guardar y abrir)
		

	
	/**
	 * establece el gestor de graficos de la ventana
	 */
	public void setGraphicDetails() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * ventanaPrincipal
	 */
	public void VentanaPrincipal(){
		
		this.Principal.setTitle("TText v1.0");
		Principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Principal.setBounds(100, 100, 800, 600);
		
		JMenuBar menuBar = new JMenuBar();
		Principal.setJMenuBar(menuBar);
		
		JMenu Menu_File = new JMenu("File");
		Menu_File.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		menuBar.add(Menu_File);
		
		
	 // Acción del menú para guardar en un archivo todo lo escrito.
		JMenuItem MI_SaveFile = new JMenuItem("Save File...");
	
		
		MI_SaveFile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				func.SaveAs(Principal,Area);
				
			}
		});
		
		
	  // Acción del menú para salir del programa
		JMenuItem MI_Exit = new JMenuItem("Exit");
		
		MI_Exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		// Acción del menú para abrir un archivo
		
		JMenuItem MI_OpenFile = new JMenuItem("Open File...");
		
			MI_OpenFile.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {

					func.OpenFile(Principal, Area);
					
				}
			});
		
			
		Menu_File.add(MI_SaveFile);
		Menu_File.add(MI_OpenFile);
		Menu_File.add(MI_Exit);
		
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		Principal.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		JPanel panel_central = new JPanel();
		panel_central.setBackground(Color.GRAY);
		panel_central.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), Color.BLACK, Color.BLACK, Color.BLACK));
		contentPane.add(panel_central, BorderLayout.CENTER);
		panel_central.setLayout(new BoxLayout(panel_central, BoxLayout.X_AXIS));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_central.add(scrollPane);
		
		
		Area.setToolTipText("Campo de escritura o lectura");
		Area.setBackground(Color.LIGHT_GRAY);
		scrollPane.setViewportView(Area);
		
		
		JLabel lblTheidelTextEditor = new JLabel("Theidel Text Editor");
		lblTheidelTextEditor.setForeground(Color.WHITE);
		lblTheidelTextEditor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTheidelTextEditor.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTheidelTextEditor, BorderLayout.NORTH);
		
		
		Principal.setVisible(true);
		
	}

	
	/**
	 * método que retorna el Frame "Principal"
	 * @return
	 */
	public JFrame getFrame (){
		return (this.Principal);
	}
	
	public JTextPane getTextArea (){
		return (this.Area);
	}
	
}