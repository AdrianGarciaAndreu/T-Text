package graficos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextPane;

public class funcionamiento {
	
	
	
	/**
	 * método para Abrir un fichero de texto en el editor
	 */
	public void OpenFile(JFrame f, JTextPane p) {
		
	 BufferedReader lector = null;
		
		JFileChooser reader = new JFileChooser();
		reader.setApproveButtonText("Open it");
		reader.setVisible(true);
		int actionDialog = reader.showOpenDialog(f);
		
		File fileName = new File(reader.getSelectedFile().toString());
		
		try {
			
			lector = new BufferedReader(new FileReader(fileName));
				
			try {
					p.read(lector, null);
				
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	
	public void OpenFileIni (JFrame f) {	
		 BufferedReader lector = null;
			
			JFileChooser reader = new JFileChooser();
			reader.setApproveButtonText("Open it");
			reader.setVisible(true);
			int actionDialog = reader.showOpenDialog(f);
			
			ventanas v = new ventanas();
			v.VentanaPrincipal();
			
			File fileName = new File(reader.getSelectedFile().toString());
			
			try {
				
				lector = new BufferedReader(new FileReader(fileName));
					
				try {
						v.getTextArea().read(lector, null); //obtiene el area de texto de la ventana
					
					} catch (IOException e) {
						
						e.printStackTrace();
					}
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			f.dispose();
			
		}
	
	
	/**
	 * método para guardar lo escrito en el panel como texto 
	 */
	public void SaveAs(JFrame f, JTextPane p) {
	
	 BufferedWriter outFile = null;
		
		JFileChooser chooser = new JFileChooser();
		chooser.setApproveButtonText("Save it");
		chooser.setVisible(true);
		int actionDialog = chooser.showOpenDialog(f);
		
		File fileName = new File(chooser.getSelectedFile().toString());
		try {
		  
			if (fileName !=null) {
			outFile = new BufferedWriter( new FileWriter(fileName));
			p.write(outFile); 
			}
			else { outFile.close(); }
		
		}
		catch(IOException e){
			e.printStackTrace();
		}
		finally{
			if (outFile != null) {
				try {
					outFile.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}


	/**
	 * método para abrir un fichero en blanco.
	 * @param f
	 */
	public void NewFile (JFrame f) {
		ventanas v = new ventanas();
		v.VentanaPrincipal();
		f.dispose();
	}
	
}

