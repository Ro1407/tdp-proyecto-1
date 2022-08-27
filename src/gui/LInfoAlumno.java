package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")

public class LInfoAlumno extends JLabel{
	public LInfoAlumno(String texto, int posX, int posY, JPanel panel) {
		setText(texto);
		setForeground(new Color(255, 255, 240));
		setFont(new Font("High Tower Text", Font.PLAIN, 15));
		setHorizontalAlignment(SwingConstants.LEFT);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridx = posX;
		gbc.gridy = posY;
		panel.add(this, gbc);
	}
}
