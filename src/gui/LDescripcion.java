package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")

public class LDescripcion extends JLabel{

	public LDescripcion(String texto, int posX, int posY, JPanel panel) {
		setText(texto);
		setFont(new Font("High Tower Text", Font.BOLD, 15));
		setForeground(new Color(245, 245, 220));
		setHorizontalAlignment(SwingConstants.CENTER);
		
		GridBagConstraints gbc = new GridBagConstraints();
		//gbc.weightx = 0.2;								//Espacio que se agrega a la derecha de la componente 
		gbc.anchor = GridBagConstraints.LINE_START;		//Alineacion del componente
		gbc.gridx = posX;								//Numero de columna donde se inserta la componente.
		gbc.gridy = posY;								//Numero de fila donde se inserta la componente.
		panel.add(this, gbc);
	}
}
