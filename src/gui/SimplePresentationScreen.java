package gui;

import entities.Student;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SuppressWarnings({"serial", "unused"})
/* Añadi suprimir las alertas del compilador para variables declaradas sin utilizar porque marcaba las etiquetas 
(y como consecuencia no generaba el .jar correctamente) */

public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	Student studentData;
	
	public SimplePresentationScreen(Student studentData) {
		this.studentData = studentData;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBackground(new Color(139, 0, 0));
		
		setTitle("TdP-DCIC-UNS 2021 :: Pantalla de presentación");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(615, 250));
		setResizable(false);
		setVisible(true);
		setContentPane(contentPane);
		
		//Se cambia el icono de la ventana por el de TDP
		setIconImage(Toolkit.getDefaultToolkit().getImage(SimplePresentationScreen.class.getResource("/images/tdp.png")));
		
		init();
	}
	
	private void init() {
		
													//Panel con informacion del alumno
		JPanel tabInformation = new JPanel();
		tabInformation.setPreferredSize(new Dimension(425, 275));
		tabInformation.setBackground(new Color(205, 92, 92));
		tabInformation.setForeground(new Color(0,0,0));
		
		/* Se usa el GridBagLayout para el panel con los datos del alumno que, ademas de especificar valores para las filas y columnas,
		 * permite personalizar cada componente con GridBagConstraints.
		 * 
		 * Como en este caso los dos tipos de etiquetas definidas poseen valores generalizables excepto por gridX y gridY, se los pasa
		 * por parametro cuando se crean las etiquetas para que la misma clase cree el componente asociado y luego inserte la etiqueta
		 * con ese layout en el panel.
		 */
				
		GridBagLayout gbl_tabInformation = new GridBagLayout();
		gbl_tabInformation.columnWidths = new int[] {20, 200, 200};
		gbl_tabInformation.rowHeights = new int[] {30, 30, 30, 30, 30, 30, 30};
		gbl_tabInformation.columnWeights = new double[]{0.0, 0.0, 0.0};
		gbl_tabInformation.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		tabInformation.setLayout(gbl_tabInformation);
		
		//Etiquetas que describen los datos presentados
		LDescripcion LLegajoUniversitario = new LDescripcion("Legajo Universitario:", 1, 1, tabInformation);
		LDescripcion LApellidoyNombre = new LDescripcion("Apellido y Nombre", 1, 2, tabInformation);
		LDescripcion LMail = new LDescripcion("Correo Electronico:", 1, 3, tabInformation);
		LDescripcion LGithub = new LDescripcion("GitHub:", 1, 4, tabInformation);
		
		//Etiquetas con los datos del alumno
		LInfoAlumno LU = new LInfoAlumno(String.valueOf(studentData.getId()), 2, 1, tabInformation);
		LInfoAlumno ApellidoNombre = new LInfoAlumno(studentData.getFirstName() + " " + studentData.getLastName(), 2,2,tabInformation);
		LInfoAlumno Mail = new LInfoAlumno(studentData.getMail(), 2, 3, tabInformation);
		LInfoAlumno URL = new LInfoAlumno(studentData.getGithubURL(), 2,4,tabInformation);
		
		
											//Panel con pestaña que contiene al panel de la informacion del alumno
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setEnabled(false);
		tabbedPane.addTab("Información del alumno", null, tabInformation, "Muestra la información declarada por el alumno");
		tabbedPane.setBackground(new Color(210, 105, 30));
		
											//Panel con la foto que cargo el alumno
		JPanel panelImagen = new JPanel();
		panelImagen.setPreferredSize(new Dimension(160, 160));
		panelImagen.setBackground(new Color(139, 0, 0));
		
		GridBagLayout gbl_panelImagen = new GridBagLayout();
		gbl_panelImagen.columnWidths = new int[] {250, 0};
		gbl_panelImagen.rowHeights = new int[] {60, 150, 40};
		gbl_panelImagen.columnWeights = new double[]{0.0, 0.0};
		gbl_panelImagen.rowWeights = new double[]{0.0, 0.0, 0.0};
		panelImagen.setLayout(gbl_panelImagen);
		
		JLabel LImagen = new JLabel("");
		LImagen.setIcon(new ImageIcon(SimplePresentationScreen.class.getResource("/images/master Stack Overflow.png")));
		//NOTA: La foto no se lee pero no cambie los valores preestablecidos de las ventanas en caso de que hubiera que respetarlos
		
		GridBagConstraints gbc_LImagen = new GridBagConstraints();
		gbc_LImagen.fill = GridBagConstraints.HORIZONTAL;
		gbc_LImagen.gridx = 0;
		gbc_LImagen.gridy = 1;
		panelImagen.add(LImagen, gbc_LImagen);
										
										//Etiqueta con la fecha y hora
		LocalDateTime ahora = LocalDateTime.now();
		DateTimeFormatter formatoDia = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter formatoTiempo = DateTimeFormatter.ofPattern("HH:mm:ss");
		
		JLabel LfechaYhora = new JLabel("Esta ventana fue generada el " + ahora.format(formatoDia) + " a las " + ahora.format(formatoTiempo));
		LfechaYhora.setForeground(new Color(255, 255, 240));
		LfechaYhora.setFont(new Font("High Tower Text", Font.PLAIN, 17));
		

		//Se agregan todos los componenetes al contentPane
		contentPane.add(tabbedPane, BorderLayout.WEST);
		contentPane.add(panelImagen, BorderLayout.EAST);
		contentPane.add(LfechaYhora, BorderLayout.AFTER_LAST_LINE);
	}
}
